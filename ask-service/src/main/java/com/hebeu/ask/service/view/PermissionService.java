package com.hebeu.ask.service.view;

import com.hebeu.ask.model.po.*;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/5/9 上午10:23
 * Desc   : 权限管理业务类
 **/
public interface PermissionService {

    /**
     * 通过用户昵称查询用户
     * @param userName 用户昵称
     * @return 返回用户对象
     */
    User queryUserByName(String userName);


    /**
     * 通过用户id查询用户角色集合
     * @return 返回用户角色集合
     */
    List<RoleUser> queryRoleUserByUserId(Integer id);

    /**
     * 通过角色id查询角色对象
     * @param id 角色id
     * @return 返回角色对象
     */
    Role queryRoleById(Integer id);

    /**
     * 通过角色id查询权限集合
     * @param roleIds 角色集合
     * @return 返回权限集合
     */
    List<PermissionRole> queryPermissionRoleByRoleIds(List<Integer> roleIds);

    /**
     * 根据id查询权限
     * @param id id
     * @return 返回权限对象
     */
    Permission queryPermissionById(Integer id);
}
