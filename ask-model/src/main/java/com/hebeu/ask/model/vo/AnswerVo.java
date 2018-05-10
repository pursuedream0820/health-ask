package com.hebeu.ask.model.vo;

import com.hebeu.ask.model.po.Answer;
import com.hebeu.ask.model.po.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : chenDeHua
 * Time   : 2018/5/8 下午4:18
 * Desc   :
 **/

@Getter
@Setter
public class AnswerVo extends Answer {

    /**
     * 采纳时间
     */
    private String adoptedTime;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 用户名
     */
    private String username;

    /**
     * 回答用户
     */
    private User user;

    @Override
    public String toString() {
        return super.toString() + "AnswerVo{" +
                "adoptedTime='" + adoptedTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
