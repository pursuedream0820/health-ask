package com.hebeu.ask.model.po;

import java.util.Date;

public class Doing {
    /** */
    private Integer id;

    /** */
    private Integer userId;

    /** */
    private String action;

    /** */
    private Integer sourceId;

    /** */
    private String sourceType;

    /** */
    private String subject;

    /** */
    private String content;

    /** */
    private Integer referId;

    /** */
    private Integer referUserId;

    /** */
    private String referContent;

    /** */
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