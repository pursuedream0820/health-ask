package com.hebeu.ask.web.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : chenDeHua
 * Time   : 2018/3/11 下午4:55
 * Desc   : 定时任务工具类
 **/
@Component
@Slf4j
public class TaskHelper {

    @Value("${task.switch:false}")
    private boolean taskSwitch;

    /**
     * 获取定时任务开关状态
     * @return 返回定时任务开关状态
     */
    public boolean taskSwitch(){
        log.warn("定时任务开关状态: {}", taskSwitch);
        return this.taskSwitch;
    }
}
