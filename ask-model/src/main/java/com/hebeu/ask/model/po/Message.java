package com.hebeu.ask.model.po;

import java.util.Date;

public class Message {
    /** */
    private Integer id;

    /** */
    private Integer fromUserId;

    /** */
    private Integer toUserId;

    /** */
    private Byte isRead;

    /** */
    private Byte fromDeleted;

    /** */
    private Byte toDeleted;

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

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Byte getIsRead() {
        return isRead;
    }

    public void setIsRead(Byte isRead) {
        this.isRead = isRead;
    }

    public Byte getFromDeleted() {
        return fromDeleted;
    }

    public void setFromDeleted(Byte fromDeleted) {
        this.fromDeleted = fromDeleted;
    }

    public Byte getToDeleted() {
        return toDeleted;
    }

    public void setToDeleted(Byte toDeleted) {
        this.toDeleted = toDeleted;
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