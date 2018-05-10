package com.hebeu.ask.web.controller;

import com.hebeu.ask.model.po.Category;
import com.hebeu.ask.model.po.Question;
import com.hebeu.ask.model.po.User;
import com.hebeu.ask.service.view.AnswerService;
import com.hebeu.ask.service.view.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(path = "/question/save")
    public String saveQuestion(String title, String description, Integer categoryId, String price){
        // TODO 处理保存问题
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        Question question = new Question();
        question.setUserId(user.getId());
        question.setTitle(title);
        question.setDescription(description);
        question.setCategoryId(categoryId);
        question.setPrice(Short.valueOf(price));
        questionService.saveQuestion(question);

        return "redirect:/index";
    }

    /**
     * 跳转到提问页面
     * @return 返回到提问页面
     */
    @RequestMapping(path = "/question/create")
    public String createAsk(Model model){
        log.info("跳转到提问页面");
        // TODO 待添加提问页面问题分类数据
        List<Category> categoryList = questionService.queryCategory();
        log.info("categoryList.size:{}", categoryList.size());
        model.addAttribute("categoryList", categoryList);
        return "view/question/create";
    }
}
