package com.hebeu.ask.web.controller;

import com.hebeu.ask.model.enums.RedisKeyEnum;
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
        List<Question> newQuestionList = JedisUtil.getList(RedisKeyEnum.NEW_QUESTION_LIST_KEY.getValue(), Question.class);
        List<Question> awardQuestionList = JedisUtil.getList(RedisKeyEnum.AWARD_QUESTION_LIST_KEY.getValue(), Question.class);
        List<UserTop> coinTopList = JedisUtil.getList(RedisKeyEnum.COIN_TOP_LIST_KEY.getValue(), UserTop.class);

        List<Question> recommendQuestionList = JedisUtil.getList(RedisKeyEnum.RECOMMEND_QUESTION_KEY.getValue(), Question.class);

        if (CollectionUtils.isEmpty(recommendQuestionList)){
            log.info("设置推荐问题");
            recommendQuestionList = questionService.queryRecommendQuestion(8);
            JedisUtil.setList(RedisKeyEnum.RECOMMEND_QUESTION_KEY.getValue(), recommendQuestionList);
        }

        if (CollectionUtils.isEmpty(newQuestionList)) {
            log.info("设置最新问题");
            newQuestionList = questionService.queryNewQuestion(20);
            JedisUtil.setList(RedisKeyEnum.NEW_QUESTION_LIST_KEY.getValue(), newQuestionList);
        }

        if (CollectionUtils.isEmpty(awardQuestionList)) {
            log.info("设置悬赏问题");
            awardQuestionList = questionService.queryAwardQuestion(20);
            JedisUtil.setList(RedisKeyEnum.AWARD_QUESTION_LIST_KEY.getValue(), awardQuestionList);
        }
        if (CollectionUtils.isEmpty(coinTopList)) {
            log.info("设置财富排行榜");
            coinTopList = userService.queryUserTop(10, "coins");
            JedisUtil.setList(RedisKeyEnum.COIN_TOP_LIST_KEY.getValue(), coinTopList);
        }

        model.addAttribute("newQuestionList", newQuestionList);
        model.addAttribute("awardQuestionList", awardQuestionList);
        model.addAttribute("coinTopList", coinTopList);
        model.addAttribute("recommendQuestionList", recommendQuestionList);

        return "view/home/index";
    }
}
