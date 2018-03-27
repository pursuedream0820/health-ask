package com.hebeu.ask.spider.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : chenDeHua
 * Time   : 2018/3/27 上午10:11
 * Desc   : 爬取状态枚举类
 **/
@Getter
@AllArgsConstructor
public enum CrawlStatusEnum {
    /**
     * 0没开始抓取，1正在抓取，2抓取完成，3抓取失败
     */
    NO_CRAWLED(0, "没开始抓取"),
    ING_CRAWLED(1, "正在抓取"),
    FINISHED_CRAWLED(2, "抓取完成"),
    FAIL_CRAWLED(3, "抓取失败");

    private int code;
    private String desc;

}
