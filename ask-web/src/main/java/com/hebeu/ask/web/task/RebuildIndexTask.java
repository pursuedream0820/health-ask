package com.hebeu.ask.web.task;

import com.hebeu.ask.seo.index.Indexer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author : chenDeHua
 * Time   : 2018/3/11 下午4:55
 * Desc   :
 **/
@Component
@Slf4j
public class RebuildIndexTask {

    @Autowired
    private TaskHelper taskHelper;

    @Autowired
    private Indexer indexer;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void rebuildIndex(){
        if (!taskHelper.taskSwitch()){
            return;
        }
        log.info("开始重建索引");
        indexer.createQuestionIndex();
    }
}
