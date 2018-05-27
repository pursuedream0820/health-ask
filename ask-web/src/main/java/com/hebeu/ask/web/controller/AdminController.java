package com.hebeu.ask.web.controller;

import com.hebeu.ask.model.enums.IndexPathEnum;
import com.hebeu.ask.model.enums.RedisKeyEnum;
import com.hebeu.ask.seo.index.Indexer;
import com.hebeu.ask.service.view.QuestionService;
import com.hebeu.ask.web.redis.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chenDeHua
 * Time   : 2018/5/27 下午1:46
 * Desc   :
 **/

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private Indexer indexer;


    /**
     * 清空索引
     *
     * @return 返回操作结果
     */
    @RequestMapping(path = "/clear/index")
    public String clearIndex() {
        log.info("开始清空搜索引擎索引库");
        try {
            indexer.clearIndex(IndexPathEnum.QUESTION_INDEX_PATH);
            questionService.updateIndexed(null);
        } catch (Exception e) {
            log.error("清空索引异常", e);
            return "false";
        }
        return "success";
    }

    /**
     * 清空Redis缓存
     * @return 返回操作结果
     */
    @RequestMapping(path = "/clear/cache")
    public String clearRedisCache(){
        log.info("开始清空Redis缓存");
        try {
            JedisUtil.del(RedisKeyEnum.NEW_QUESTION_LIST_KEY.getValue());
            JedisUtil.del(RedisKeyEnum.AWARD_QUESTION_LIST_KEY.getValue());
            JedisUtil.del(RedisKeyEnum.COIN_TOP_LIST_KEY.getValue());
            JedisUtil.del(RedisKeyEnum.CREDITS_TOP_LIST_KEY.getValue());
        } catch (Exception e) {
            log.error("清空Redis缓存失败",e);
            return "false";
        }
        return "success";
    }
}
