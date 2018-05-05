package com.hebeu.ask.spider.service;

import com.hebeu.ask.dao.AnswerMapper;
import com.hebeu.ask.model.po.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : chenDeHua
 * Time   : 2018/5/5 下午4:01
 * Desc   : 回答业务
 **/
@Service
public class AnswerService {

    @Autowired
    private AnswerMapper answerMapper;


    /**
     * 保存问题回答
     * @param answer 回答对象
     * @return 返回操作结果
     */
    public boolean saveAnswer(Answer answer) {
        return answerMapper.insertSelective(answer) > 0;
    }
}
