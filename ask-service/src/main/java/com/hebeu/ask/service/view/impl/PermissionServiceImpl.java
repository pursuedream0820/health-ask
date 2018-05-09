package com.hebeu.ask.service.view.impl;

import com.hebeu.ask.dao.*;
import com.hebeu.ask.model.po.*;
import com.hebeu.ask.service.view.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/5/9 上午10:24
 * Desc   : 权限管理业务实现类
 **/

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionRoleMapper permissionRoleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 通过用户昵称查询用户
     *
     * @param userName 用户昵称
     * @return 返回用户对象
     */
    @Override
    public User queryUserByName(String userName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo(userName);

        List<User> users = userMapper.selectByExampleWithBLOBs(userExample);

        return users.stream().findFirst().orElse(null);
    }

    /**
     * 通过用户id查询用户角色集合
     *
     * @param id
     * @return 返回用户角色集合
     */
    @Override
    public List<RoleUser> queryRoleUserByUserId(Integer id) {
        RoleUserExample roleUserExample = new RoleUserExample();
        RoleUserExample.Criteria criteria = roleUserExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        return roleUserMapper.selectByExample(roleUserExample);
    }

    /**
     * 通过角色id查询角色对象
     *
     * @param id 角色id
     * @return 返回角色对象
     */
    @Override
    public Role queryRoleById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过角色id查询权限集合
     *
     * @param roleIds 角色集合
     * @return 返回权限集合
     */
    @Override
    public List<PermissionRole> queryPermissionRoleByRoleIds(List<Integer> roleIds) {
        PermissionRoleExample permissionRoleExample = new PermissionRoleExample();
        PermissionRoleExample.Criteria criteria = permissionRoleExample.createCriteria();
        criteria.andRoleIdIn(roleIds);

        return permissionRoleMapper.selectByExample(permissionRoleExample);
    }

    /**
     * 根据id查询权限
     *
     * @param id id
     * @return 返回权限对象
     */
    @Override
    public Permission queryPermissionById(Integer id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

}
