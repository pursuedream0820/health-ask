package com.hebeu.ask.web.controller;

import lombok.extern.slf4j.Slf4j;
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

    @RequestMapping(path = "index")
    public String index() {

        return "view/home/index";
    }
}
