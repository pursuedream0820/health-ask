package com.hebeu.ask.web.controller;

import com.hebeu.ask.model.po.Question;
import com.hebeu.ask.model.vo.UserTop;
import com.hebeu.ask.service.view.QuestionService;
import com.hebeu.ask.service.view.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/3/10 下午1:44
 * Desc   :
 **/

@Controller
@RequestMapping(path = "/")
@Slf4j
public class IndexController {


    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    /**
     * 默认主页访问路径
     * @return 返回主页
     */
    @RequestMapping(path = "/")
    public String defaultIndexPath() {
        log.info("重定向到主页地址");
        return "redirect:/index";
    }

    @RequestMapping(path = "index")
    public String index(Model model){
        log.debug("开始访问主页");
        // TODO 获取主页信息

        List<Question> newQuestionList = questionService.queryNewQuestion(20);

        List<Question> awardQuestionList = questionService.queryAwardQuestion(20);

        List<UserTop> coinTopList = userService.queryUserTop(10, "coins");
        log.debug("coinTopList.size:{}", coinTopList.size());
        model.addAttribute("newQuestionList", newQuestionList);
        model.addAttribute("awardQuestionList", awardQuestionList);
        model.addAttribute("coinTopList", coinTopList);

        return "view/home/index";
    }
}
