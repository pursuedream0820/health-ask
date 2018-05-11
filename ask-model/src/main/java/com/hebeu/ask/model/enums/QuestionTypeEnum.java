package com.hebeu.ask.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : chenDeHua
 * Time   : 2018/5/11 上午10:31
 * Desc   : 问题分类枚举
 **/

@Getter
@AllArgsConstructor
public enum  QuestionTypeEnum {

    NEWEST(1, "newest", "最新的"),
    HOTTEST(2, "hottest", "热门的"),
    REWARD(3, "reward", "悬赏的"),
    UNANSWERED(4, "unAnswered", "未回答的");

    private int code;

    private String slug;

    private String desc;
}
