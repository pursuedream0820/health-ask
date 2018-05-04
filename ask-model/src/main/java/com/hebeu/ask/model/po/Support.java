package com.hebeu.ask.model.po;

import java.util.Date;

public class Support {
    /** 主键id*/
    private Integer id;

    /** sessionId*/
    private String sessionId;

    /** 用户id*/
    private Integer userId;

    /** 支持表id*/
    private Integer supportableId;

    /** 支持表类型*/
    private String supportableType;

    /** 创建时间*/
    private Date createdAt;

    /** 更新时间*/
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSupportableId() {
        return supportableId;
    }

    public void setSupportableId(Integer supportableId) {
        this.supportableId = supportableId;
    }

    public String getSupportableType() {
        return supportableType;
    }

    public void setSupportableType(String supportableType) {
        this.supportableType = supportableType == null ? null : supportableType.trim();
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