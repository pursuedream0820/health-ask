package com.hebeu.ask.model.po;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
public class Question implements Serializable {
    /** 主键id*/
    private Integer id;

    /** 用户id*/
    private Integer userId;

    /** 分类id*/
    private Integer categoryId;

    /** 问题title*/
    private String title;

    /** 问题价格*/
    private Short price;

    /** 是否隐藏*/
    private Integer hide;

    /** 回答数*/
    private Integer answers;

    /** 查看数*/
    private Integer views;

    /** 关注数*/
    private Integer followers;

    /** 收藏数*/
    private Integer collections;

    /** 评论数*/
    private Integer comments;

    /** */
    private Integer device;

    /** 问题状态*/
    private Integer status;

    /** 创建时间*/
    private Date createdAt;

    /** 更新时间*/
    private Date updatedAt;

    /** 是否建立索引, 0表示未建立索引，1表示已建立索引*/
    private Byte indexed;

    /** 问题描述*/
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Short getPrice() {
        return price;
    }

    public void setPrice(Short price) {
        this.price = price;
    }

    public Integer getHide() {
        return hide;
    }

    public void setHide(Integer hide) {
        this.hide = hide;
    }

    public Integer getAnswers() {
        return answers;
    }

    public void setAnswers(Integer answers) {
        this.answers = answers;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getCollections() {
        return collections;
    }

    public void setCollections(Integer collections) {
        this.collections = collections;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getDevice() {
        return device;
    }

    public void setDevice(Integer device) {
        this.device = device;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Byte getIndexed() {
        return indexed;
    }

    public void setIndexed(Byte indexed) {
        this.indexed = indexed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}