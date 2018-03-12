package com.hebeu.ask.spider.service;

import com.github.pagehelper.PageHelper;
import com.hebeu.ask.dao.SpiderKeywordMapper;
import com.hebeu.ask.model.po.SpiderKeyword;
import com.hebeu.ask.model.po.SpiderKeywordExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : chenDeHua
 * Time   : 2018/3/11 下午9:50
 * Desc   :
 **/
@Service
public class SpiderKeywordService {

    @Autowired
    private SpiderKeywordMapper spiderKeywordMapper;

    /**
     * 根据id更新状态值
     *
     * @param keywordId 关键词id
     * @param status    状态值
     */
    public void updateCrawlStatusById(Integer keywordId, Integer status) {
        SpiderKeyword spiderKeyword = new SpiderKeyword();
        spiderKeyword.setId(keywordId);
        spiderKeyword.setCrawlStatus(status);
        spiderKeywordMapper.updateByPrimaryKeySelective(spiderKeyword);
    }

    /**
     * 查询下一个未爬取得关键词
     *
     * @return 返回关键词对象
     */
    public SpiderKeyword findNextUnCrawled() {
        //只查满足条件的第一条
        PageHelper.startPage(0, 1);
        SpiderKeywordExample spiderKeywordExample = new SpiderKeywordExample();
        SpiderKeywordExample.Criteria criteria = spiderKeywordExample.createCriteria();
        criteria.andCrawlStatusEqualTo(0);
        return spiderKeywordMapper.selectByExample(spiderKeywordExample).get(0);

    }
}
