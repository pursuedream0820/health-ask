package com.hebeu.ask.test;

import com.hebeu.ask.web.application.HealthAskApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : chenDeHua
 * Time   : 2018/3/11 下午12:01
 * Desc   : 测试基础类，用于指定springboot启动类
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HealthAskApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class BaseApplicationTest {
    private long startTime;

    @Before
    public void setUp() {
        log.info("测试开始---------------");
        startTime = System.currentTimeMillis();
    }
    @Test
    public void testNothing() {

    }

    @After
    public void tearDown() {
        log.info("测试结束---------------");
        log.info("耗时：{} s" , (System.currentTimeMillis() - startTime)/1000);
    }

}
