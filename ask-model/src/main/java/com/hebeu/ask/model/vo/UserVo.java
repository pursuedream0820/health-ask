package com.hebeu.ask.model.vo;

import com.hebeu.ask.model.po.User;
import com.hebeu.ask.model.po.UserData;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : chenDeHua
 * Time   : 2018/5/23 下午5:39
 * Desc   :
 **/

@Setter
@Getter
public class UserVo {

    private User user;

    /**
     * 注册时间
     */
    private String registerTime;

    private UserData userData;

}
