package com.hebeu.ask.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author : chenDeHua
 * Time   : 2018/3/10 下午3:41
 * Desc   : 任务工具类
 **/
@Service
public class TaskHelper {

    @Value("${task.switch:false}")
    private static boolean taskSwitch;

    /**
     * 任务开关
     * @return 返回任务开关状态
     */
    public static boolean taskSwitch(){

        return taskSwitch;
    }
}
