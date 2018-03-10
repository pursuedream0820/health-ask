package com.hebeu.ask.service.view;

import com.hebeu.ask.model.po.Question;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/3/10 下午7:21
 * Desc   :
 **/
@Service
public interface QuestionService {

    /**
     * 查询所有的问题
     * @return 返回所有的问题集合
     */
    List<Question> queryAllQuestion();
}
