package com.hebeu.ask.test;

import com.hebeu.ask.model.enums.IndexPathEnum;
import com.hebeu.ask.seo.index.Indexer;
import com.hebeu.ask.seo.search.Searcher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : chenDeHua
 * Time   : 2018/3/11 下午12:07
 * Desc   : 搜索服务测试
 **/
@Slf4j
public class SearchTest extends BaseApplicationTest {

    @Autowired
    private Searcher searcher;

    @Autowired
    private Indexer indexer;


    @Test
    public void createIndex() {
        log.info("开始清空索引");
        indexer.clearIndex(IndexPathEnum.QUESTION_INDEX_PATH);
    }
}
