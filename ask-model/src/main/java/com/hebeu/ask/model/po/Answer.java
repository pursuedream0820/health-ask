package com.hebeu.ask.model.po;

import java.util.Date;

public class Answer {
    /** */
    private Integer id;

    /** */
    private String questionTitle;

    /** */
    private Integer questionId;

    /** */
    private Integer userId;

    /** */
    private Integer supports;

    /** */
    private Integer oppositions;

    /** */
    private Integer comments;

    /** */
    private Byte device;

    /** */
    private Byte status;

    /** */
    private Date adoptedAt;

    /** */
    private Date createdAt;

    /** */
    private Date updatedAt;

    /** */
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