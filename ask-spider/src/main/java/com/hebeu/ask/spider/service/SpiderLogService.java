package com.hebeu.ask.spider.service;

import com.hebeu.ask.dao.SpiderLogMapper;
import com.hebeu.ask.model.po.SpiderLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : chenDeHua
 * Time   : 2018/5/4 下午4:45
 * Desc   :
 **/
@Service
@Slf4j
public class SpiderLogService {

    @Autowired
    private SpiderLogMapper spiderLogMapper;


    /**
     * 保存爬过的网址
     *
     * @param questionId  问题id
     * @param questionUrl 问题URL
     * @param source      问题来源
     */
    public void saveSpiderLog(Integer questionId, String questionUrl, String source) {
        SpiderLog spiderLog = new SpiderLog();
        spiderLog.setQuestionId(questionId);
        spiderLog.setUrl(questionUrl);
        spiderLog.setSource(source);
        spiderLogMapper.insertSelective(spiderLog);
    }

}
