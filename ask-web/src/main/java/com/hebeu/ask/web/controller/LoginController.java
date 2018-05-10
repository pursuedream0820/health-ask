package com.hebeu.ask.web.controller;


import com.hebeu.ask.model.po.User;
import com.hebeu.ask.service.view.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenDeHua
 * Time   : 2018/5/9 上午10:19
 * Desc   : 登录控制器
 **/
@Controller
@RequestMapping("/")
@Slf4j
public class LoginController {

    @Autowired
    private AccountService accountService;

    /**
     * 登录操作
     *
     * @param userName   用户名
     * @param password   密码
     * @param rememberMe 记住我
     * @return 登录成功后返回主页，失败返回登录页
     */
    @RequestMapping(path = "login.action", method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "username", required = true) String userName,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "rememberMe", required = true, defaultValue = "false") boolean rememberMe,
            Model model, ServletRequest request,
            String path) {

        log.info("登录参数username:{}, password:{},rememberMe:{},path:{}", userName, password, rememberMe, path);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(rememberMe);

        model.addAttribute("username", userName);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            log.warn("账号密码错误，username：{}，password：{}", userName, password);
            return "view/account/login";
        }

        if (StringUtils.isNotEmpty(path)) {
            log.info("重定向到上一个页面地址，path:{}", path);
            return "redirect:" + path;
        }

        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
        // 获取保存的URL
        if (savedRequest == null || savedRequest.getRequestUrl() == null) {
            return "redirect:/index";
        }
        log.info("上一个请求页面url:{}", savedRequest.getRequestUrl());
        return "redirect:" + savedRequest.getRequestUrl();
    }

    /**
     * 跳转到登录页面
     *
     * @return 跳转到登录页面
     */
    @RequestMapping(path = "login")
    public String toLogin(String path, Model model) {
        log.info("跳转登录页");
        log.info("上一个页面地址path:{}", path);
        model.addAttribute("path", path);
        return "view/account/login";
    }


    /**
     * 跳转到注册页面
     *
     * @return 返回注册页
     */
    @RequestMapping(path = "register")
    public String toRegister() {
        log.info("跳转注册页");
        return "view/account/register";
    }


    /**
     * 注册操作
     *
     * @return 成功返回到登录页面，失败返回注册页
     */
    @RequestMapping(path = "register.action")
    public String register(@RequestParam(value = "username", required = true) String username,
                           @RequestParam(value = "password", required = true) String password,
                           @RequestParam(value = "email", required = true) String email,
                           Model model) {

        // 将密码加密
        String md5Password = new Md5Hash(password, null, 2).toString();
        User user = new User();
        user.setName(username);
        user.setPassword(md5Password);
        user.setEmail(email);
        model.addAttribute("username", username);
        model.addAttribute("password", password);

        if (accountService.saveUser(user)) {
            return "redirect:/login";
        } else {
            return "view/account/register";
        }
    }

    /**
     * 退出登录
     *
     * @return 重定向到主页
     */
    @RequestMapping(path = "logout")
    public String logout() {
        log.info("退出登录");
        return "redirect:/index";
    }

}



