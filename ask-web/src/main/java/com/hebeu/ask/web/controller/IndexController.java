package com.hebeu.ask.web.controller;

import com.hebeu.ask.model.po.Question;
import com.hebeu.ask.model.vo.UserTop;
import com.hebeu.ask.service.view.QuestionService;
import com.hebeu.ask.service.view.UserService;
import com.hebeu.ask.web.redis.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
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

    private static final String NEW_QUESTION_LIST_KEY = "new:question:list";

    private static final String AWARD_QUESTION_LIST_KEY = "award:question:list";

    private static final String COIN_TOP_LIST_KEY = "coin:top:list";


    /**
     * 默认主页访问路径
     *
     * @return 返回主页
     */
    @RequestMapping(path = "/")
    public String defaultIndexPath() {
        log.info("重定向到主页地址");
        return "redirect:/index";
    }

    @RequestMapping(path = "index")
    public String index(Model model) {
        log.debug("开始访问主页");
        // TODO 获取主页信息

        // 从Redis缓存获取主页信息
        List<Question> newQuestionList = JedisUtil.getList(NEW_QUESTION_LIST_KEY, Question.class);
        List<Question> awardQuestionList = JedisUtil.getList(AWARD_QUESTION_LIST_KEY, Question.class);
        List<UserTop> coinTopList = JedisUtil.getList(COIN_TOP_LIST_KEY, UserTop.class);

        if (CollectionUtils.isEmpty(newQuestionList)) {
            log.info("设置最新问题");
            newQuestionList = questionService.queryNewQuestion(20);
            JedisUtil.setList(NEW_QUESTION_LIST_KEY, newQuestionList);
        }

        if (CollectionUtils.isEmpty(awardQuestionList)) {
            log.info("设置悬赏问题");
            awardQuestionList = questionService.queryAwardQuestion(20);
            JedisUtil.setList(AWARD_QUESTION_LIST_KEY, awardQuestionList);
        }
        if (CollectionUtils.isEmpty(coinTopList)) {
            log.info("设置财富排行榜");
            coinTopList = userService.queryUserTop(10, "coins");
            JedisUtil.setList(COIN_TOP_LIST_KEY, coinTopList);
        }

        model.addAttribute("newQuestionList", newQuestionList);
        model.addAttribute("awardQuestionList", awardQuestionList);
        model.addAttribute("coinTopList", coinTopList);

        return "view/home/index";
    }
}
