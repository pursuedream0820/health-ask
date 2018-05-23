package com.hebeu.ask.service.view;

import com.hebeu.ask.model.po.Doing;
import com.hebeu.ask.model.po.User;
import com.hebeu.ask.model.po.UserData;
import com.hebeu.ask.model.vo.UserTop;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/5/10 下午6:26
 * Desc   :
 **/
public interface UserService {

    /**
     * 用户排行榜
     * @param queryNum 查询数量
     * @param topType 排行榜类型
     * @return 返回用户排行榜
     */
    List<UserTop> queryUserTop(Integer queryNum, String topType);

    /**
     * 根据用户id查询动态信息
     * @param userId 用户id
     * @return 返回动态集合
     */
    List<Doing> queryDoingByUserId(Integer userId);

    /**
     * 根据用户id查询用户信息
     * @param userId 用户id
     * @return 返回用户信息
     */
    User queryUserById(Integer userId);

    /**
     * 根据用户id查询用户信息
     * @param userId 用户id
     * @return 返回用户数据
     */
    UserData queryUserDataByUserId(Integer userId);

    /**
     * 更新用户数据
     * @param userData
     */
    void updateUserData(UserData userData);

}
