package com.hebeu.ask.web.shiro;


import com.hebeu.ask.model.po.*;
import com.hebeu.ask.service.view.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/5/9 上午10:17
 * Desc   : 自定义Realm
 **/

@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private PermissionService permissionService;

    /**
     * 用户授权
     *
     * @param principalCollection 用户身份信息
     * @return 返回认证信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("doGetAuthorizationInfo+" + principalCollection.toString());
        String userName = (String) principalCollection.getPrimaryPrincipal();
        // 根据用户名得到用户信息
        User user = permissionService.queryUserByName(userName);

        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getId()), SecurityUtils.getSubject().getPrincipals());

        // 得到用户的角色集合
        List<RoleUser> roleUsers = permissionService.queryRoleUserByUserId(user.getId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //赋予角色
        for (RoleUser roleUser : roleUsers) {
            Role role = permissionService.queryRoleById(roleUser.getRoleId());
            info.addRole(role.getSlug());
        }
        List<Integer> roleIds = new ArrayList<>();
        roleUsers.iterator().forEachRemaining(roleUser -> roleIds.add(roleUser.getRoleId()));
        List<PermissionRole> permissionRoles = permissionService.queryPermissionRoleByRoleIds(roleIds);


        //赋予权限
        for (PermissionRole permissionRole : permissionRoles) {
            Permission permission = permissionService.queryPermissionById(permissionRole.getPermissionId());
            info.addStringPermission(permission.getName());
        }

        return info;
    }


    /**
     * 用户认证
     *
     * @param authenticationToken 用户认证信息
     * @return 返回授权信息
     * @throws AuthenticationException 授权异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.debug("开始进行身份认证");
        log.info("doGetAuthenticationInfo +" + authenticationToken.toString());

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        log.debug("用户名username:{}", token.getUsername());
        log.debug("密码password:{}", token.getPassword());

        User user = permissionService.queryUserByName(token.getUsername());
        if (user != null) {
            log.debug("查询到的用户信息：{}", user.toString());
            //设置用户session
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            session.setAttribute("authc", true);
            return new SimpleAuthenticationInfo(userName, user.getPassword(), getName());
        } else {
            return null;
        }
    }
}
