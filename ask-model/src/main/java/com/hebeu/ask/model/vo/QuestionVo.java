package com.hebeu.ask.model.vo;

import com.hebeu.ask.model.po.Question;
import lombok.*;

/**
 * @author : chenDeHua
 * Time   : 2018/5/6 下午5:51
 * Desc   : 搜索结果值对象
 **/
@Setter
@Getter
@ToString
public class QuestionVo extends Question {

    /**
     * 标题高亮
     */
    private String titleHighlighter;

    /**
     * 问题描述高亮
     */
    private String descHighlighter;


    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 提问者昵称
     */
    private String userName;

}
