package com.hebeu.ask.service.view;

import com.hebeu.ask.dao.AnswerMapper;
import com.hebeu.ask.dao.QuestionMapper;
import com.hebeu.ask.model.po.Answer;
import com.hebeu.ask.model.po.AnswerExample;
import com.hebeu.ask.model.po.Question;
import com.hebeu.ask.model.vo.AnswerVo;
import com.hebeu.ask.model.vo.QuestionVo;
import com.hebeu.ask.seo.search.Searcher;
import com.hebeu.ask.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : chenDeHua
 * Time   : 2018/5/6 下午5:46
 * Desc   : 搜索引擎业务
 **/

@Service
@Slf4j
public class SearchEnginesService {

    @Autowired
    private Searcher searcher;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AnswerMapper answerMapper;

    /**
     * 根据关键词检索
     *
     * @param keywords 关键词
     * @return 返回检索结果集合
     */
    public Pair<List<QuestionVo>, Integer> search(String keywords, Integer pageNum, Integer pageSize) {

        return searcher.searchQuestion(keywords, pageNum, pageSize);

    }


}
