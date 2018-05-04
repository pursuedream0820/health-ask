package com.hebeu.ask.model.po;

import java.util.Date;

public class Credit {
    /** 主键id*/
    private Integer id;

    /** 用户id*/
    private Integer userId;

    /** 动作标识*/
    private String action;

    /** 积分源id*/
    private Integer sourceId;

    /** 积分源项目*/
    private String sourceSubject;

    /** 金币数*/
    private Integer coins;

    /** 积分数*/
    private Integer credits;

    /** 创建时间*/
    private Date createdAt;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceSubject() {
        return sourceSubject;
    }

    public void setSourceSubject(String sourceSubject) {
        this.sourceSubject = sourceSubject == null ? null : sourceSubject.trim();
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}