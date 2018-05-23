package com.hebeu.ask.model.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : chenDeHua
 * Time   : 2018/3/10 下午5:09
 * Desc   : Redis键名称枚举类
 **/
@Getter
@AllArgsConstructor
public enum RedisKeyEnum {

    /**
     * Redis键值枚举
     */
    NEW_QUESTION_LIST_KEY(1, "new:question:list"),
    AWARD_QUESTION_LIST_KEY(2, "award:question:list"),
    COIN_TOP_LIST_KEY(3, "coin:top:list"),
    CREDITS_TOP_LIST_KEY(4, "credits:top:list");

    private Integer code;
    private String value;

}
