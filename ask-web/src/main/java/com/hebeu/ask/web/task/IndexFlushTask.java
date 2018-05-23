package com.hebeu.ask.web.task;

import com.hebeu.ask.model.enums.RedisKeyEnum;
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

    /**
     * 每天零点更新主页内容
     */
    @Scheduled(cron = "0 0 0 0/1 * ?")
    public void indexFlush() {

        log.info("开始更新主页内容");

        JedisUtil.setList(RedisKeyEnum.NEW_QUESTION_LIST_KEY.getValue(), questionService.queryNewQuestion(20));

        JedisUtil.setList(RedisKeyEnum.AWARD_QUESTION_LIST_KEY.getValue(), questionService.queryAwardQuestion(20));

        JedisUtil.setList(RedisKeyEnum.COIN_TOP_LIST_KEY.getValue(), userService.queryUserTop(10, "coins"));

        JedisUtil.setList(RedisKeyEnum.CREDITS_TOP_LIST_KEY.getValue(), userService.queryUserTop(10, "credits"));
        log.info("主页内容更新结束");

    }
}
