package com.hebeu.ask.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : chenDeHua
 * Time   : 2018/5/11 上午10:47
 * Desc   : 问题状态枚举
 **/

@Getter
@AllArgsConstructor
public enum  QuestionStatusEnum {

    UNSOLVED(0, "未解决问题"),
    SOLVED(2, "已解决问题"),
    REWARD(4, "悬赏问题");

    private int code;

    private String desc;

}
