package com.hebeu.ask.test;

import com.hebeu.ask.seo.index.Indexer;
import com.hebeu.ask.seo.search.Searcher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : chenDeHua
 * Time   : 2018/3/11 下午12:07
 * Desc   : 搜索服务测试
 **/
public class SearchTest extends BaseApplicationTest {

    @Autowired
    private Searcher searcher;

    @Autowired
    private Indexer indexer;

    @Test
    public void test(){
        indexer.createQuestionIndex();
        searcher.searchQuestion("怎么");
    }
}
