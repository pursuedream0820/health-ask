package com.hebeu.ask.service.view;

import com.hebeu.ask.model.vo.SearchResultVo;
import com.hebeu.ask.seo.search.Searcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/5/6 下午5:46
 * Desc   : 搜索引擎业务
 **/

@Service
public class SearchEnginesService {

    @Autowired
    private Searcher searcher;

    /**
     * 根据关键词检索
     * @param keywords 关键词
     * @return 返回检索结果集合
     */
    public List<SearchResultVo>  search(String keywords){

        return searcher.searchQuestion(keywords);

    }




}
