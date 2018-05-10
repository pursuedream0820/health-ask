package com.hebeu.ask.service.view;

import com.hebeu.ask.model.po.Question;
import com.hebeu.ask.model.vo.QuestionVo;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/3/10 下午7:21
 * Desc   :
 **/
public interface QuestionService {

    /**
     * 查询最新问题
     *
     * @return 返回最新问题集合
     */
    List<Question> queryNewQuestion(Integer queryNum);

    /**
     * 查询悬赏问题
     *
     * @param queryNum 查询数量
     * @return 返回悬赏问题集合
     */
    List<Question> queryAwardQuestion(Integer queryNum);

    /**
     * 更新浏览次数
     *
     * @param id 问题id
     */
    void updateViews(Integer id, Question question);

    /**
     * 根据id查询问题详情
     *
     * @param id 问题id
     * @return 返回查询的问题详情
     */
    QuestionVo queryDetailById(Integer id);

    /**
     * 更新问题回答数
     *
     * @param id 问题id
     */
    void updateAnswers(Integer id);
}
