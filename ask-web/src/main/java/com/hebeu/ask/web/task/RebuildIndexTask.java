package com.hebeu.ask.web.task;

import com.github.pagehelper.PageHelper;
import com.hebeu.ask.model.po.Question;
import com.hebeu.ask.seo.index.Indexer;
import com.hebeu.ask.service.view.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/3/11 下午4:55
 * Desc   : 建立索引定时任务
 **/
@Component
@Slf4j
public class RebuildIndexTask {

    @Autowired
    private TaskHelper taskHelper;

    @Autowired
    private Indexer indexer;

    @Autowired
    private QuestionService questionService;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void rebuildIndex() {
        if (!taskHelper.taskSwitch()) {
            return;
        }
        log.info("开始执行建立索引定时任务");

        Integer pageNum = 1;
        Integer pageSize = 1000;
        Integer count = pageSize;

        while (count <= pageSize) {
            PageHelper.startPage(pageNum, pageSize);
            List<Question> questionList = questionService.queryUnIndexQuestion();
            if (CollectionUtils.isEmpty(questionList)) {
                break;
            }
            count = questionList.size();
            pageNum++;
            log.info("开始为{}条数据建立索引", questionList.size());
            indexer.createQuestionIndex(questionList);
            List<Integer> questionIdList = new ArrayList<>();
            questionList.iterator().forEachRemaining(question -> questionIdList.add(question.getId()));
            log.info("开始为{}条数据更新索引状态", questionIdList.size());
            questionService.updateIndexed(questionIdList);
        }
        log.info("建立索引定时任务结束");
    }
}
