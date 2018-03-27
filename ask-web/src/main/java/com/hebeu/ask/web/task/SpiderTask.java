package com.hebeu.ask.web.task;

import com.hebeu.ask.spider.processor.BaiduSpiderProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author : chenDeHua
 * Time   : 2018/3/12 下午2:21
 * Desc   : 爬虫定时任务
 **/
@Service
@Slf4j
public class SpiderTask {
    @Autowired
    private TaskHelper taskHelper;

    @Autowired
    private BaiduSpiderProcessor baiduSpiderProcessor;

    /**
     * 每天0点开始执行定时任务
     */
    @Scheduled(cron = "0 0 0 0/1 * ?")
    public void spider(){
        if (!taskHelper.taskSwitch()){
            return;
        }
        log.info("开始执行定时任务");
        baiduSpiderProcessor.doRun();
        log.info("执行定时任务结束");
    }
}
