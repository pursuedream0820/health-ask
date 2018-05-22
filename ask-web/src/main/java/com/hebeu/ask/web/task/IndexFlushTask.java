package com.hebeu.ask.web.task;

import com.hebeu.ask.service.view.QuestionService;
import com.hebeu.ask.service.view.UserService;
import com.hebeu.ask.web.redis.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author : chenDeHua
 * Time   : 2018/5/22 下午8:37
 * Desc   : 主页内容刷新定时任务
 **/

@Component
@Slf4j
public class IndexFlushTask {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;


    private static final String NEW_QUESTION_LIST_KEY = "new:question:list";

    private static final String AWARD_QUESTION_LIST_KEY = "award:question:list";

    private static final String COIN_TOP_LIST_KEY = "coin:top:list";

    /**
     * 每天零点更新主页内容
     */
    @Scheduled(cron = "0 0 0 0/1 * ?")
    public void indexFlush() {

        log.info("开始更新主页内容");

        JedisUtil.setList(NEW_QUESTION_LIST_KEY, questionService.queryNewQuestion(20));

        JedisUtil.setList(AWARD_QUESTION_LIST_KEY, questionService.queryAwardQuestion(20));

        JedisUtil.setList(COIN_TOP_LIST_KEY, userService.queryUserTop(10, "coins"));

        log.info("主页内容更新结束");

    }
}
