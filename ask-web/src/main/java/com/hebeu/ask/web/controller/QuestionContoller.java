package com.hebeu.ask.web.controller;

import com.hebeu.ask.model.po.User;
import com.hebeu.ask.service.view.AnswerService;
import com.hebeu.ask.service.view.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
