package com.hebeu.ask.model.po;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
public class Answer implements Serializable {
    /** 主键ID*/
    private Integer id;

    /** 问题标题*/
    private String questionTitle;

    /** 问题标题*/
    private Integer questionId;

    /** 用户id*/
    private Integer userId;

    /** 支持数*/
    private Integer supports;

    /** 反对数*/
    private Integer oppositions;

    /** 评论数*/
    private Integer comments;

    /** */
    private Byte device;

    /** 回答状态*/
    private Byte status;

    /** 采纳时间*/
    private Date adoptedAt;

    /** 创建时间*/
    private Date createdAt;

    /** 更新时间*/
    private Date updatedAt;

    /** 回答内容*/
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle == null ? null : questionTitle.trim();
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSupports() {
        return supports;
    }

    public void setSupports(Integer supports) {
        this.supports = supports;
    }

    public Integer getOppositions() {
        return oppositions;
    }

    public void setOppositions(Integer oppositions) {
        this.oppositions = oppositions;
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

    public Date getAdoptedAt() {
        return adoptedAt;
    }

    public void setAdoptedAt(Date adoptedAt) {
        this.adoptedAt = adoptedAt;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}