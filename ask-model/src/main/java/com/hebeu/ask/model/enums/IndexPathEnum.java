package com.hebeu.ask.model.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : chenDeHua
 * Time   : 2018/3/10 下午5:09
 * Desc   : 索引位置枚举类
 **/
@Getter
@AllArgsConstructor
public enum IndexPathEnum {

    QUESTION_INDEX_PATH(1,"/Users/chendehua/IdeaProjects/health-ask/ask-seo/src/main/resources/luence-db/question","问题索引地址"),
    ARTICLE_INDEX_PATH(2,"/Users/chendehua/IdeaProjects/health-ask/ask-seo/src/main/resources/luence-db/article","文章索引地址");

    private Integer code;
    private String path;
    private String desc;

}
