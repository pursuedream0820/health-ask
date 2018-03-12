package com.hebeu.ask.model.po;

import java.util.Date;

public class SpiderKeyword {
    /** */
    private Integer id;

    /** 关键词*/
    private String keyword;

    /** 0没开始抓取，1正在抓取，2抓取完成，3抓取失败*/
    private Integer crawlStatus;

    /** 关键词分类*/
    private String category;

    /** */
    private Date createTime;

    /** */
    private Date updateTime;

    /** */
    private Byte isDelete;

    /** 分类id*/
    private Integer categoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getCrawlStatus() {
        return crawlStatus;
    }

    public void setCrawlStatus(Integer crawlStatus) {
        this.crawlStatus = crawlStatus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}