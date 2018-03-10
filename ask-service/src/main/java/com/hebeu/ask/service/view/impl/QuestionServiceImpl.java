package com.hebeu.ask.service.view.impl;

import com.hebeu.ask.dao.QuestionMapper;
import com.hebeu.ask.model.po.Question;
import com.hebeu.ask.model.po.QuestionExample;
import com.hebeu.ask.service.view.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/3/10 下午7:22
 * Desc   :
 **/
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 查询所有的问题
     *
     * @return 返回所有的问题集合
     */
    @Override
    public List<Question> queryAllQuestion() {
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andIdIsNotNull();
        return questionMapper.selectByExample(questionExample);
    }
}
