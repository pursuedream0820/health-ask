package com.hebeu.ask.service.view;

import com.hebeu.ask.model.po.Answer;
import com.hebeu.ask.model.po.Category;
import com.hebeu.ask.model.vo.AnswerVo;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/5/8 下午7:35
 * Desc   :
 **/
public interface AnswerService {

    /**
     * 根据问题id查询对应的答案集合和最佳答案
     *
     * @param questionId 问题id
     * @return 返回答案集合
     */
     Pair<List<AnswerVo>, AnswerVo> queryAnswerListByQuestionId(Integer questionId);


    /**
     * 将answer对象转成answerVo 对象
     *
     * @param answer 回答对象
     * @return 返回vo对象
     */
    AnswerVo answerToAnswerVo(Answer answer);

    /**
     * 根据问题id查询分类
     * @param id 分类id
     * @return 返回分类对象
     */
    Category queryCategoryById(Integer id);

    /**
     * 保存回答
     * @param content 回答内容
     * @param questionId 问题id
     * @param userId 回答用户id
     * @return 返回操作结果
     */
    boolean saveAnswer(String content,Integer questionId, Integer userId);
}
