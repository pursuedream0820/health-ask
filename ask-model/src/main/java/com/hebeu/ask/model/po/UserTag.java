package com.hebeu.ask.model.po;

import java.util.Date;

public class UserTag {
    /** */
    private Integer id;

    /** */
    private Integer userId;

    /** */
    private Integer tagId;

    /** */
    private Integer questions;

    /** */
    private Integer articles;

    /** */
    private Integer answers;

    /** */
    private Integer supports;

    /** */
    private Integer adoptions;

    /** */
    private Date createdAt;

    /** */
    private Date updatedAt;

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

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getQuestions() {
        return questions;
    }

    public void setQuestions(Integer questions) {
        this.questions = questions;
    }

    public Integer getArticles() {
        return articles;
    }

    public void setArticles(Integer articles) {
        this.articles = articles;
    }

    public Integer getAnswers() {
        return answers;
    }

    public void setAnswers(Integer answers) {
        this.answers = answers;
    }

    public Integer getSupports() {
        return supports;
    }

    public void setSupports(Integer supports) {
        this.supports = supports;
    }

    public Integer getAdoptions() {
        return adoptions;
    }

    public void setAdoptions(Integer adoptions) {
        this.adoptions = adoptions;
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
}