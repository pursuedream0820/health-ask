package com.hebeu.ask.web.controller;

import com.hebeu.ask.service.view.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : chenDeHua
 * Time   : 2018/3/10 下午1:44
 * Desc   :
 **/

@Controller
@RequestMapping(path = "/")
@Slf4j
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "index")
    public String index(){
        log.info("开始访问主页");
        log.info("查询数据库结果："+userService.getUser(1).getName());
        return "view/layout/public";
    }
}
