package com.hebeu.ask.model.vo;

import com.hebeu.ask.model.po.User;
import com.hebeu.ask.model.po.UserData;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : chenDeHua
 * Time   : 2018/5/10 下午6:36
 * Desc   : 财富榜
 **/

@Setter
@Getter
public class UserTop {

    /**
     * 用户数据
     */
    private UserData userData;

    /**
     * 用户对象
     */
    private User user;
}
