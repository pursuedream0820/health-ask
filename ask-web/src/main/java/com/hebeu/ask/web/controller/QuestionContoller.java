package com.hebeu.ask.web.controller;

import com.hebeu.ask.model.enums.QuestionStatusEnum;
import com.hebeu.ask.model.enums.QuestionTypeEnum;
import com.hebeu.ask.model.enums.RedisKeyEnum;
import com.hebeu.ask.model.po.Category;
import com.hebeu.ask.model.po.Question;
import com.hebeu.ask.model.po.User;
import com.hebeu.ask.model.vo.QuestionVo;
import com.hebeu.ask.model.vo.UserTop;
import com.hebeu.ask.service.view.AnswerService;
import com.hebeu.ask.service.view.QuestionService;
import com.hebeu.ask.service.view.UserService;
import com.hebeu.ask.util.PageUtil;
import com.hebeu.ask.web.redis.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/5/10 下午2:59
 * Desc   :
 **/

@Controller
@RequestMapping("/")
@Slf4j
public class QuestionContoller {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;


    /**
     * 保存回答
     *
     * @param content    问题内容
     * @param questionId 问题id
     * @return 返回问题详情页
     */
    @RequestMapping(path = "saveAnswer")
    public String saveAnswer(String content, Integer questionId) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        answerService.saveAnswer(content, questionId, user.getId());
        questionService.updateAnswers(questionId);
        return "redirect:/detail?id=" + questionId;
    }

    @RequestMapping(path = "question/save")
    public String saveQuestion(String title, String description, Integer categoryId, String price){
        // TODO 处理保存问题
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        Question question = new Question();
        question.setUserId(user.getId());
        question.setTitle(title);
        question.setDescription(description);
        question.setCategoryId(categoryId);
        question.setPrice(Short.valueOf(price));
        if (!"0".equals(price)){
            question.setStatus(QuestionStatusEnum.REWARD.getCode());
        }
        questionService.saveQuestion(question);

        return "redirect:/index";
    }

    /**
     * 跳转到提问页面
     * @return 返回到提问页面
     */
    @RequestMapping(path = "question/create")
    public String createAsk(Model model){
        log.info("跳转到提问页面");
        // TODO 待添加提问页面问题分类数据
        List<Category> categoryList = questionService.queryCategory();
        log.info("categoryList.size:{}", categoryList.size());
        model.addAttribute("categoryList", categoryList);
        return "view/question/create";
    }


    @RequestMapping(path = "questions")
    public String questions(String type,Integer categoryId,Integer pageNum, Integer pageSize, Model model){
        // 设置默认分类 和分页参数,
        // categoryId = 0 时表示查看全部问题
        categoryId = categoryId == null ? 0: categoryId;
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 20 :pageSize;
        // newest 最新的， hottest 热门的， reward 悬赏的， unAnswered 未回答的
        type = StringUtils.isEmpty(type) ? "newest" : type;

        // TODO 按不同类型查询问题
        List<Category> categoryList = questionService.queryCategory();
        log.info("categoryList.size:{}", categoryList.size());

        Pair<List<QuestionVo>, Integer> questionPair = questionService.queryByCondition(type, categoryId, pageNum, pageSize);
        List<UserTop> creditsTopList = JedisUtil.getList(RedisKeyEnum.CREDITS_TOP_LIST_KEY.getValue(),UserTop.class);

        if (CollectionUtils.isEmpty(creditsTopList)){
            log.info("开始设置活跃用户排行榜");
            creditsTopList =  userService.queryUserTop(10, "credits");
            JedisUtil.setList(RedisKeyEnum.CREDITS_TOP_LIST_KEY.getValue(), categoryList);
        }

        model.addAttribute("categoryId", categoryId);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("type",type);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("questionList",questionPair.getLeft());
        model.addAttribute("creditsTopList", creditsTopList);
        model.addAttribute("pageHtml", PageUtil.getPageHtml(pageNum, pageSize, questionPair.getRight(), "/questions?type="+ type +"&categoryId=" +categoryId));
        return "view/home/ask";
    }

    /**
     * 采纳回答
     * @param id 回答id
     * @return 返回详情页
     */
    @RequestMapping(path = "answer/adopt")
    public String adoptAnswer(Integer id){
        Integer questionId = questionService.adoptAnswer(id);
        return "redirect:/detail?id=" + questionId;
    }


    /**
     * 收藏问题
     * @param sourceId 问题id
     * @return 返回问题详情页
     */
    @RequestMapping(path = "question/collect")
    @ResponseBody
    public String collectionQuestion(Integer sourceId){
        log.info("关注问题，questionId:{}",sourceId);
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        questionService.collectionQuestion(sourceId,user.getId());
        return "collected";
    }

    /**
     * 关注问题
     * @param sourceId 问题id
     * @return
     */
    @RequestMapping(path = "question/follow")
    @ResponseBody
    public String followQuestion(Integer sourceId){
        log.info("关注问题，questionId:{}",sourceId);
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        questionService.followQuestion(sourceId,user.getId());
        return "followed";
    }

}
