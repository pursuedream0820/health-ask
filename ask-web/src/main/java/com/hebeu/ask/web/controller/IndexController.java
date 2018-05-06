package com.hebeu.ask.web.controller;

import com.hebeu.ask.seo.index.Indexer;
import com.hebeu.ask.seo.search.Searcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private Searcher searcher;

    @Autowired
    private Indexer indexer;

    public String index(Model model){
        log.info("开始访问主页");
        log.info("开始创建索引");
        indexer.createQuestionIndex();
        searcher.searchQuestion("搜索引擎");
        model.addAttribute("hello","232323");
        return "view/layout/public";
    }

    @RequestMapping(path = "index")
    public String index(){

        return "view/home/index";
    }
}
