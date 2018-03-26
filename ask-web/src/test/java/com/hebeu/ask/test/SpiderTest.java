package com.hebeu.ask.test;

import com.hebeu.ask.spider.processor.QihuSpiderProcessor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : chenDeHua
 * Time   : 2018/3/26 下午7:37
 * Desc   :
 **/
public class SpiderTest  extends BaseApplicationTest{

    @Autowired
    private QihuSpiderProcessor qihuSpiderProcessor;

    @Test
    public void test(){
        qihuSpiderProcessor.doRun();
    }
}
