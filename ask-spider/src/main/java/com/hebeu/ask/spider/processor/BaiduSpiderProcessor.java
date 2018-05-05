package com.hebeu.ask.spider.processor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hebeu.ask.dao.*;
import com.hebeu.ask.model.po.Answer;
import com.hebeu.ask.model.po.SpiderKeyword;
import com.hebeu.ask.model.po.SpiderTag;
import com.hebeu.ask.model.po.User;
import com.hebeu.ask.spider.model.CrawlStatusEnum;
import com.hebeu.ask.spider.service.*;
import com.hebeu.ask.spider.util.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.*;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : chenDeHua
 * Time   : 2018/3/11 下午9:14
 * Desc   : 360问答processor
 **/
@Service
@Slf4j
public class BaiduSpiderProcessor implements PageProcessor {

    /**
     * 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
     */
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    /**
     * 网址根路径
     */
    private static final String ROOT = "https://zhidao.baidu.com";

    /**
     * 匿名网友昵称
     */
    private static final String ANONYMOUS_USER = "匿名网友";

    @Autowired
    private SpiderKeywordService spiderKeywordService;

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private SpiderLogService spiderLogService;

    @Autowired
    private AnswerService answerService;


    @Override
    public void process(Page page) {
        // 初始化service
        this.initService();

        // 得到爬取网页地址
        String pageUrl = page.getUrl().get();
        log.info("开始爬取网址 pageUrl:{}", pageUrl);

        // 问题列表URL
        String questionListUrl = "https://zhidao.baidu.com/search";
        // 问题详情URL
        String questionDetailUrl = "https://zhidao.baidu.com/question";

        // 分析问题列表页
        if (pageUrl.startsWith(questionListUrl)) {

            final Map<String, Object> extras = page.getRequest().getExtras();

            List<Selectable> questionList = page.getHtml().xpath("//*/dt[@class=\"dt mb-4 line\"]").nodes();

            log.info("questionList.size():{}", questionList.size());

            List<String> questionUrls = Lists.newLinkedList();
            if (!CollectionUtils.isEmpty(questionList)) {
                for (Selectable question : questionList) {
                    String url = question.xpath("//*/a/@href").get();
                    questionUrls.add(url);
                }
            }

            if (!CollectionUtils.isEmpty(questionUrls)) {
                questionUrls.forEach(url -> {
                    Request request = new Request(url.replaceAll("http", "https"));
                    request.setExtras(extras);
                    page.addTargetRequest(request);
                    log.debug("targetUrl:{}", request.getUrl());
                });
            }

            if (spiderKeywordService == null) {
                this.spiderKeywordService = ApplicationContextUtil.getBean(SpiderKeywordService.class);
            }
            //保证一定传递，忽略了检查
            int keywordId = (Integer) extras.get("keywordId");
            int categoryId = (Integer) extras.get("categoryId");
            String keyword = extras.get("keyword").toString();

            log.info("keyword:{};keywordId:{};categoryId:{}", keyword, keywordId, categoryId);
            int index = pageUrl.indexOf("pn=");

            // 最大页码值 TODO 后期再修改
            int maxPageNum = 10;
            if (index >= 0) {
                int pageNum = Integer.parseInt(pageUrl.substring(index + 3));
                if (pageNum == 0) {

                    spiderKeywordService.updateCrawlStatusById(keywordId, CrawlStatusEnum.ING_CRAWLED.getCode());
                    String url = "https://zhidao.baidu.com/search?word=" + keyword + "&pn=" + (pageNum + 1);
                    Request request = new Request(url);
                    request.setExtras(extras);
                    page.addTargetRequest(request);
                } else if (pageNum == maxPageNum) {
                    spiderKeywordService.updateCrawlStatusById(keywordId, CrawlStatusEnum.FINISHED_CRAWLED.getCode());

                    SpiderKeyword askSpiderKeyword = spiderKeywordService.findNextUnCrawled();
                    if (askSpiderKeyword == null) {
                        log.info("all keywords have been crawled");
                        return;
                    }

                    keyword = askSpiderKeyword.getKeyword();
                    Map<String, Object> data = Maps.newHashMap();
                    data.put("keyword", keyword);
                    data.put("keywordId", askSpiderKeyword.getId());
                    data.put("categoryId", askSpiderKeyword.getCategoryId());

                    String url = "https://zhidao.baidu.com/search?word=" + keyword + "&pn=0";
                    Request request = new Request(url);
                    request.setExtras(data);
                    page.addTargetRequest(request);
                } else {
                    String url = "https://zhidao.baidu.com/search?word=" + keyword + "&pn=" + (pageNum + 1);
                    Request request = new Request(url);
                    request.setExtras(extras);
                    page.addTargetRequest(request);
                }
            }
        } else if (pageUrl.startsWith(questionDetailUrl)) {
            //TODO 爬取详情页
            this.parseQuestionPage(page);
        }
    }


    @Override
    public Site getSite() {
        return site;
    }

    /**
     * 分析问题页
     *
     * @param page 问题页page
     */
    private void parseQuestionPage(Page page) {
        log.info("开始分析问题页,pageUrl :{}", page.getUrl());
        String keyword = page.getRequest().getExtra("keyword").toString();
        int categoryId = Integer.parseInt(page.getRequest().getExtra("categoryId").toString());

        Selectable selectable = page.getHtml();

        String title = selectable.xpath("//*/span[@class=\"ask-title\"]/text()").get();
        log.debug("问题title:{}", title);

        String author = selectable.xpath("//*/a[@alog-action=\"qb-ask-uname\"]/text()").get();
        author = StringUtils.isEmpty(author) ? ANONYMOUS_USER : author;
        log.debug("作者 author：{}", author);

        String answers = selectable.xpath("//*/div[@class=\"hd line other-hd\"]/h2/text()").get();
        answers = StringUtils.isEmpty(answers) ? "0" : "0";
        log.debug("回答数 answers:{}", answers);

        String content = selectable.xpath("//*/span[@class=\"con\"]/text()").get();
        content = StringUtils.isEmpty(content) ? "" : content;
        log.debug("问题content:{}", content);

        String price = selectable.xpath("//*/span[@class=\"ask-wealth\"]/em/text()").get();
        price = StringUtils.isEmpty(price) ? "0" : price;
        log.debug("问题积分：price:{}", price);


        // TODO 浏览次数获取不到，后期再研究原因
        String views = getViews(selectable.xpath("//*/span[contains(@class, \"browse-times\")]/text()").get());
        views = StringUtils.isEmpty(views) ? "0" : views;
        log.debug("问题浏览次数：views:{}", views);


        if (!StringUtils.isEmpty(author) && !StringUtils.isEmpty(content) && !StringUtils.isEmpty(title)) {

            //Step 1: 存用户信息，并拿到id
            Integer authorId = userService.insertOrUpdateUser(author);

            log.debug("保存的用户id：authorId:{}", authorId);
            //Step 2: 存文章信息并拿到id
            //先判断文章是否已经存在
            Integer questionId = questionService.isExistQuestionByTitle(title);

            log.debug("文章questionId：{}", questionId);
            boolean exists = questionId != null;
            if (!exists) {
                log.debug("开始保存问题，questionTitle：{}", title);
                questionId = questionService.saveQuestion(title, content, answers, categoryId, price, views);

                //向 ask_doing表插入数据
//                this.increaseQuestionCount(authorId);
            }
            // Step 3: 存文章——url——记录
            if (!exists) {
                spiderLogService.saveSpiderLog(questionId, page.getUrl().get(), "百度知道");
            }
//            //Step 4: 存文章--KEYWORD--对应关系 (一篇文章可能有多个keyword，后面可以洗keyword为tag)
//            this.saveQuestionKeywordRel(questionId, keyword);

            //Step 5: 存回答
            if (!exists) {
                this.saveAnswers(questionId, page);
            }
//
//            //Step 6: 存相关问题（文章ID对应title) 并继续爬取相关问题
//            this.saveRelatedQuestions(questionId, page);
//
//            //Step 7: 存文章id和tag的关系
//            this.saveQuestionTagRel(questionId, tags);

        }

        log.info("已完成爬取 url: " + page.getRequest().getUrl());
    }

    /**
     * 保存问题答案
     *
     * @param questionId 问题id
     * @param page       问题网页
     */
    private void saveAnswers(Integer questionId, Page page) {
        List<Selectable> selectables = page.getHtml().xpath("//*/div[contains(@class, \"bd answer\")]").nodes();
        if (CollectionUtils.isEmpty(selectables)) {
            return;
        }
        log.debug("回答数量为：{}", selectables.size());

        for (Selectable selectable : selectables) {
            String author = selectable.xpath("//*/div[contains(@class, \"user-name\")]/text()").toString();
            author = (author == null ? ANONYMOUS_USER : author);
            Integer authorId = userService.insertOrUpdateUser(author);
            log.debug("作者author：{}, authorId :{}", author, authorId);
            String content = selectable.xpath("//*/span[@class=\"con\"]/text()").get();
            log.debug("答案内容：content:{}", content);
            //只保存有内容的问题
            if (!StringUtils.isEmpty(author) && !StringUtils.isEmpty(content)) {
                String date = selectable.xpath("//*/span[contains(@class, \"pos-time\")]/text()").get();

                Answer answer = new Answer();
                answer.setAdoptedAt(parseDate(date, "yyyy-MM-dd", "发布于"));
                log.debug("发布时间：{}", answer.getAdoptedAt());
                answer.setQuestionId(questionId);
                answer.setUserId(authorId);
                answer.setContent(content);
                answerService.saveAnswer(answer);
            }
        }

    }


    /**
     * 初始化service
     */
    public void initService() {
        if (spiderKeywordService == null) {
            this.spiderKeywordService = ApplicationContextUtil.getBean(SpiderKeywordService.class);
        }
        if (questionService == null) {
            this.questionService = ApplicationContextUtil.getBean(QuestionService.class);
        }

        if (userService == null) {
            this.userService = ApplicationContextUtil.getBean(UserService.class);
        }

        if (spiderLogService == null) {
            this.spiderLogService = ApplicationContextUtil.getBean(SpiderLogService.class);
        }

        if (answerService == null){
            this.answerService = ApplicationContextUtil.getBean(AnswerService.class);
        }


    }


    public void doRun() {
        SpiderKeyword spiderKeyword = this.spiderKeywordService.findNextUnCrawled();
        if (spiderKeyword == null) {
            log.info("all keywords have been crawled");
            return;
        }

        String keyword = spiderKeyword.getKeyword();
        String url = "https://zhidao.baidu.com/search?word=" + keyword + "&pn=0";
        Request request = new Request(url);
        Map<String, Object> extras = Maps.newHashMap();
        extras.put("keyword", keyword);
        extras.put("keywordId", spiderKeyword.getId());
        extras.put("categoryId", spiderKeyword.getCategoryId());
        log.info("keyword:{};keywordId:{};categoryId:{}", keyword, spiderKeyword.getId(), spiderKeyword.getCategoryId());

        request.setExtras(extras);
        HttpClientDownloader downloader = new HttpClientDownloader();
        downloader.setThread(3);

        // 爬虫程序入口
        Spider.create(new BaiduSpiderProcessor())
                .setExitWhenComplete(true)
                .setUUID(UUID.randomUUID().toString())
                .setDownloader(downloader)
                .addRequest(request)
                .run();

    }

    /**
     * 得到浏览次数数值
     *
     * @param viewsStr 浏览次数字符串
     * @return 返回浏览次数数值
     */
    private String getViews(String viewsStr) {
        if (StringUtils.isEmpty(viewsStr)) {
            return "0";
        }
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(viewsStr);
        return m.replaceAll("").trim();
    }


    /**
     * 时间转换
     *
     * @param dateStr
     * @param pattern
     * @param replaceStr
     * @return
     * @throws ParseException
     */
    private Date parseDate(String dateStr, String pattern, String replaceStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return new Date();
        }
        dateStr = dateStr.replaceAll(replaceStr, "").trim();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            log.error("时间转换异常", e);
            return new Date();
        }
    }

}
