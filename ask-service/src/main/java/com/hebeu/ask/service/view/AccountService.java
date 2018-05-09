package com.hebeu.ask.service.view;

import com.hebeu.ask.model.po.User;

/**
 * @author : chenDeHua
 * Time   : 2018/5/9 下午3:37
 * Desc   : 用户系统业务
 **/
public interface AccountService {

    /**
     * 保存用户信息
     *
     * @param user 用户对象
     * @return 返回操作结果
     */
    boolean saveUser(User user);

    /**
     * 判断是否存在用户名
     *
     * @param username 用户名
     * @return 返回true表示存在 ，false表示不存在
     */
    boolean isExistUsername(String username);
}
