package com.hebeu.ask.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : chenDeHua
 * Time   : 2018/5/6 下午7:33
 * Desc   :
 **/
@Controller
@Slf4j
@RequestMapping("/")
public class TestController {

    @RequestMapping(path = "testFragment")
    public String testFragment(){

        return "view/home/test";
    }


    @RequestMapping(path = "index")
    public String home(){

        return "view/home/index";
    }
}
