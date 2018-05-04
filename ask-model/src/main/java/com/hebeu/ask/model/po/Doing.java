package com.hebeu.ask.model.po;

import java.util.Date;

public class Doing {
    /** 主键id*/
    private Integer id;

    /** 用户id*/
    private Integer userId;

    /** 动作标识*/
    private String action;

    /** 动态源id*/
    private Integer sourceId;

    /** 动态源类型*/
    private String sourceType;

    /** 项目*/
    private String subject;

    /** 动态内容*/
    private String content;

    /** 关联id*/
    private Integer referId;

    /** 关联用户id*/
    private Integer referUserId;

    /** 关联内容*/
    private String referContent;

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

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getReferId() {
        return referId;
    }

    public void setReferId(Integer referId) {
        this.referId = referId;
    }

    public Integer getReferUserId() {
        return referUserId;
    }

    public void setReferUserId(Integer referUserId) {
        this.referUserId = referUserId;
    }

    public String getReferContent() {
        return referContent;
    }

    public void setReferContent(String referContent) {
        this.referContent = referContent == null ? null : referContent.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}