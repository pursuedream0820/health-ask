package com.hebeu.ask.web.controller;

import com.hebeu.ask.service.view.SearchEnginesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : chenDeHua
 * Time   : 2018/5/6 下午6:02
 * Desc   : 搜索控制器
 **/

@Controller
@Slf4j
@RequestMapping("/")
public class SearchController {


    @Autowired
    private SearchEnginesService searchEnginesService;

    @RequestMapping(path = "search")
    public String search(){


        return "view/";
    }


}
