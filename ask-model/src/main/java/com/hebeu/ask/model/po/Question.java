package com.hebeu.ask.model.po;

import java.util.Date;

public class Question {
    /** */
    private Integer id;

    /** */
    private Integer userId;

    /** */
    private Integer categoryId;

    /** */
    private String title;

    /** */
    private Short price;

    /** */
    private Byte hide;

    /** */
    private Integer answers;

    /** */
    private Integer views;

    /** */
    private Integer followers;

    /** */
    private Integer collections;

    /** */
    private Integer comments;

    /** */
    private Byte device;

    /** */
    private Byte status;

    /** */
    private Date createdAt;

    /** */
    private Date updatedAt;

    /** */
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

    public Byte getHide() {
        return hide;
    }

    public void setHide(Byte hide) {
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

    public Byte getDevice() {
        return device;
    }

    public void setDevice(Byte device) {
        this.device = device;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}