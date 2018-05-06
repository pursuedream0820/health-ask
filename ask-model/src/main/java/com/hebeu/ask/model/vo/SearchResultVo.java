package com.hebeu.ask.model.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : chenDeHua
 * Time   : 2018/5/6 下午5:51
 * Desc   : 搜索结果值对象
 **/
@Setter
@Getter
@Builder
public class SearchResultVo {

    /** 问题id*/
    private Integer id;

    /** 问题标题 */
    private String title;

    /** 问题描述*/
    private String description;

    /** 标题高亮*/
    private String titleHighlighter;

}
