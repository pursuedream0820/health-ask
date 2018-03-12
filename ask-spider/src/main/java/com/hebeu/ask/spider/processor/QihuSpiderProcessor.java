package com.hebeu.ask.spider.processor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hebeu.ask.dao.SpiderKeywordMapper;
import com.hebeu.ask.model.po.SpiderKeyword;
import com.hebeu.ask.spider.service.SpiderKeywordService;
import com.hebeu.ask.spider.util.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author : chenDeHua
 * Time   : 2018/3/11 下午9:14
 * Desc   : 360问答processor
 **/
@Service
@Slf4j
public class QihuSpiderProcessor implements PageProcessor{

    protected ApplicationContext applicationContext;
    /**
     * 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
     */
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    /**
     * 网址根路径
     */
    private static final String ROOT = "http://wenda.so.com";

    /**
     * 匿名网友昵称
     */
    private static final String ANONYMOUS_USER = "匿名网友";

    @Autowired
    private SpiderKeywordService spiderKeywordService;


    @Override
    public void process(Page page) {
        String pageUrl = page.getUrl().get();
        //起始URL
        String startUrl = "http://wenda.so.com/search";
        if (pageUrl.startsWith(startUrl)) {
            final Map<String, Object> extras = page.getRequest().getExtras();

            List<Selectable> questionList = page.getHtml().xpath("//*/li[@class=\"g-card\"]").nodes();
            log.info("问题URL集合{}",questionList);
            List<String> questionUrls = Lists.newLinkedList();
            if (!CollectionUtils.isEmpty(questionList)) {
                for (Selectable question : questionList) {
                    String url = question.xpath("//*/a/@href").get();
                    questionUrls.add(url);
                }
            }

            if (!CollectionUtils.isEmpty(questionUrls)) {
                questionUrls.forEach(url -> {
                    Request request = new Request(ROOT + url);
                    request.setExtras(extras);
                    page.addTargetRequest(request);
                });
            }

            log.info("开始爬取网页");
            //保证一定传递，忽略了检查
            int keywordId = (Integer) extras.get("keywordId");
            int categoryId = (Integer) extras.get("categoryId");
            String keyword = extras.get("keyword").toString();
            log.info("keyword:{};keywordId:{};categoryId:{}", keyword, keywordId, categoryId);
            int index = pageUrl.indexOf("pn=");
            if (index >= 0) {
                int pageNum = Integer.parseInt(pageUrl.substring(index + 3));
                if (pageNum == 0) {
                    if(spiderKeywordService == null) {
                        this.spiderKeywordService = ApplicationContextUtil.getBean(SpiderKeywordService.class);
                    }
                    log.info("spiderKeywordService:{}",spiderKeywordService);
                    spiderKeywordService.updateCrawlStatusById(keywordId, 1);
                    String url = "http://wenda.so.com/search/?q=" + keyword + "&pn=" + (pageNum + 1);
                    Request request = new Request(url);
                    request.setExtras(extras);
                    page.addTargetRequest(request);
                } else if (pageNum == 99) {
                    spiderKeywordService.updateCrawlStatusById(keywordId, 2);

                    SpiderKeyword askSpiderKeyword = spiderKeywordService.findNextUnCrawled();
                    if (askSpiderKeyword == null) {
                        log.info("all keywords have been crawled");
                        return;
                    }

                    keyword = askSpiderKeyword.getKeyword();
                    String url = "http://wenda.so.com/search/?q=" + keyword + "&pn=0";
                    Request request = new Request(url);
                    Map<String, Object> data = Maps.newHashMap();
                    data.put("keyword", keyword);
                    data.put("keywordId", askSpiderKeyword.getId());
                    data.put("categoryId", askSpiderKeyword.getCategoryId());
                    request.setExtras(data);
                    page.addTargetRequest(request);
                } else {
                    String url = "http://wenda.so.com/search/?q=" + keyword + "&pn=" + (pageNum + 1);
                    Request request = new Request(url);
                    request.setExtras(extras);
                    page.addTargetRequest(request);
                }
            }
        } else if (pageUrl.startsWith("http://wenda.so.com/q")) {
            //TODO 爬取详情页
//            this.parseQuestionPage(page);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }


    public void doRun() {
        SpiderKeyword spiderKeyword = this.spiderKeywordService.findNextUnCrawled();
        if(spiderKeyword == null) {
            log.info("all keywords have been crawled");
            return;
        }

        String keyword = spiderKeyword.getKeyword();
        String url = "http://wenda.so.com/search/?q=" + keyword + "&pn=0";
        Request request = new Request(url);
        Map<String, Object> extras = Maps.newHashMap();
        extras.put("keyword", keyword);
        extras.put("keywordId", spiderKeyword.getId());
        extras.put("categoryId", spiderKeyword.getCategoryId());
        log.info("keyword:{};keywordId:{};categoryId:{}", keyword,  spiderKeyword.getId(), spiderKeyword.getCategoryId());
        request.setExtras(extras);

        HttpClientDownloader downloader = new HttpClientDownloader();
        downloader.setThread(3);

        // 爬虫程序入口
        Spider.create(new QihuSpiderProcessor())
                .setExitWhenComplete(true)
                .setUUID(UUID.randomUUID().toString())
                .setDownloader(downloader)
                .addRequest(request)
                .run();

    }

}
