package com.hebeu.ask.controller;

import com.hebeu.ask.dao.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : chenDeHua
 * @Time : 2018/3/6 下午5:46
 * @Desc : 测试controller
 **/
@Controller
@RequestMapping(path = "/")
@Slf4j
public class HelloController {

    /**
     * 从application中读取配置，如取不到默认值为hello jack
     */
    @Value("${application.hello:hello jack}")
    private String hello;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(path = "hello")
    public String hello( Model model){
        log.info("访问helloJSP控制器");
        model.addAttribute("test","你好"+userMapper.get(1).getName());
        return "hello";
    }
}
