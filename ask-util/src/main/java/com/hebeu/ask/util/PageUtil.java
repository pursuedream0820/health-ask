package com.hebeu.ask.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenDeHua
 * Time   : 2018/5/8 下午7:55
 * Desc   : 分页工具类
 **/
public class PageUtil {

    /**
     * 得到分页html
     *
     * @param pageNum  当前查看页码
     * @param pageSize 页码大小
     * @param count    总页码数
     * @param path     访问路径
     * @return 返回分页html
     */
    public static String getPageHtml(Integer pageNum, Integer pageSize, Integer count, String path) {
        if (count == 0) {
            return "";
        }
        String pageHtmlPre = "<div class=\"text-center\">\n<ul class=\"pagination\">\n";
        StringBuilder pageHtml = new StringBuilder();

        pageHtml.append(pageHtmlPre);
        // 总页码数
        Integer pageCount = (count + (pageSize - 1)) / pageSize;
        Integer prePage = pageNum - 1 > 1 ? pageNum - 1 : 1;
        Integer nextPage = pageNum + 1 > pageCount ? pageCount : pageNum + 1;

        if (pageNum == 1) {
            pageHtml.append("<li class=\"disabled\"><span>&laquo;</span></li>");
        } else {
            pageHtml.append("<li ><a href=\"").append(path).append("&pageNum=").append(prePage).append("\" rel=\"prev\">&laquo;</a></li>");
        }

        Map<String, Integer> indexMap = getStartAndEnd(pageNum, pageCount);
        Integer start = indexMap.get("start");
        Integer end = indexMap.get("end");
        for (int i = start; i <= end; i++) {
            if (pageNum == i) {
                pageHtml.append("<li class=\"active\"><span>").append(i).append("</span></li>");
            } else {
                pageHtml.append("<li><a href=\"").append(path).append("&pageNum=").append(i).append("\">").append(i).append("</a></li>");
            }
        }

        if (pageNum.equals(pageCount)) {
            pageHtml.append("<li class=\"disabled\"><span>&raquo;</span></li>");
        } else {
            pageHtml.append("<li ><a href=\"").append(path).append("&pageNum=").append(nextPage).append("\" rel=\"next\">&raquo;</a></li>");
        }
        String pageHtmlSuffix = "\n</ul>\n</div>";

        pageHtml.append(pageHtmlSuffix);
        return pageHtml.toString();
    }

    /**
     * @param pageNum 当前页码值
     * @param count   总页码数
     * @return 返回页码起始值和结束值
     */
    private static Map<String, Integer> getStartAndEnd(Integer pageNum, Integer count) {

        Map<String, Integer> indexMap = new HashMap<>();

        Integer startIndex = 1;
        Integer endIndex = 1;
        // 显示页码数 15个
        Integer totalPage = 15;

        Integer midle = totalPage / 2;
        if (pageNum < midle) {
            startIndex = (pageNum - midle) > 0 ? (pageNum - midle) : 1;
            endIndex = (totalPage + startIndex - 1) > count ? count : (totalPage + startIndex - 1);
        } else {
            endIndex = pageNum + midle > count ? count : (pageNum + midle);
            startIndex = (endIndex - totalPage + 1) > 0 ? (endIndex - totalPage + 1) : 1;
        }

        indexMap.put("start", startIndex);
        indexMap.put("end", endIndex);
        return indexMap;
    }


}
