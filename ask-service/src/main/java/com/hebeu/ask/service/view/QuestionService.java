package com.hebeu.ask.service.view;

import com.hebeu.ask.model.po.Question;
import com.hebeu.ask.model.vo.QuestionVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/3/10 下午7:21
 * Desc   :
 **/
public interface QuestionService {

    /**
     * 查询所有的问题
     *
     * @return 返回所有的问题集合
     */
    List<Question> queryAllQuestion();

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
}
