package com.hebeu.ask.test;

import com.hebeu.ask.dao.AnswerMapper;
import com.hebeu.ask.dao.QuestionMapper;
import com.hebeu.ask.dao.UserDataMapper;
import com.hebeu.ask.dao.UserMapper;
import com.hebeu.ask.model.po.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : chenDeHua
 * Time   : 2018/5/10 下午6:56
 * Desc   :
 **/
@Slf4j
public class DataFixTest extends BaseApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDataMapper userDataMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AnswerMapper answerMapper;

    @Test
    public void fixUserData() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdIsNotNull();
        List<User> userList = userMapper.selectByExample(userExample);

        userList.iterator().forEachRemaining(user -> {
            UserData userData = new UserData();
            userData.setUserId(user.getId());
            try {
                log.info("插入用户id，userId:{}", user.getId());
                userDataMapper.insertSelective(userData);
            } catch (Exception e) {
                log.error("插入数据异常", e);
            }
        });
    }

    @Test
    public void fixQuestionStatus(){

//        QuestionExample questionExample = new QuestionExample();
//        QuestionExample.Criteria criteria = questionExample.createCriteria();
//        criteria.andIdIsNotNull();
//        List<Question> questionList = questionMapper.selectByExample(questionExample);


        AnswerExample answerExample = new AnswerExample();
        AnswerExample.Criteria criteria1 = answerExample.createCriteria();
        criteria1.andIdIsNotNull();


        List<Answer> answerList = answerMapper.selectByExample(answerExample);

        log.info("查询数据完成");
        Map<Integer , Integer> countMap = new HashMap<>();
        answerList.iterator().forEachRemaining(answer -> {
            countMap.merge(answer.getQuestionId(), 1, (a, b) -> a + b);
        });

        for (Integer qid: countMap.keySet()){
            QuestionExample questionExample = new QuestionExample();
            QuestionExample.Criteria criteria = questionExample.createCriteria();
            criteria.andIdEqualTo(qid);
            Question question = new Question();
            question.setStatus(2);
            question.setAnswers(countMap.get(qid));
            questionMapper.updateByExampleSelective(question,questionExample);
        }
        log.info("数据修复完成");


    }
}
