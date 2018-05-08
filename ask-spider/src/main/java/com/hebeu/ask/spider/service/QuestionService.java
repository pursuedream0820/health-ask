package com.hebeu.ask.spider.service;

import com.hebeu.ask.dao.QuestionMapper;
import com.hebeu.ask.model.po.Question;
import com.hebeu.ask.model.po.QuestionExample;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/4/22 下午12:13
 * Desc   :
 **/
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 通过文章标题判断是否存在文章
     *
     * @param title 文章标题
     * @return 返回是否存在布尔值
     */
    public Integer isExistQuestionByTitle(String title) {
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andTitleEqualTo(title);
        List<Question> questionList = questionMapper.selectByExample(questionExample);

        if (CollectionUtils.isEmpty(questionList)) {
            return null;
        }
        return questionList.get(0).getId();

    }


    /**
     * 保存问题
     *
     * @param title      标题
     * @param content    内容
     * @param answers    回答数
     * @param categoryId 分类id
     * @param price      积分
     * @param userId     用户id
     * @return 返回问题id
     */
    public Integer saveQuestion(String title, String content, String answers, Integer categoryId, String price, Integer userId) {
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(content);
        question.setCategoryId(categoryId);
        question.setAnswers(Integer.valueOf(answers));
        question.setPrice(Short.valueOf(price));
        question.setUserId(userId);
        questionMapper.insertSelective(question);

        return question.getId();
    }


}
