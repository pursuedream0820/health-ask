package com.hebeu.ask.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : chenDeHua
 * Time   : 2018/5/6 下午11:52
 * Desc   :
 **/

@Controller
@Slf4j
@RequestMapping("/")
public class TestController {

    @RequestMapping(path = "search")
    public String search(){

        return "view/search/index";
    }
}
