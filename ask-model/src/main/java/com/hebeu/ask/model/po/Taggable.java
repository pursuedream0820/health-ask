package com.hebeu.ask.model.po;

import java.util.Date;

public class Taggable {
    /** */
    private Integer id;

    /** */
    private Integer tagId;

    /** */
    private Integer taggableId;

    /** */
    private String taggableType;

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

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getTaggableId() {
        return taggableId;
    }

    public void setTaggableId(Integer taggableId) {
        this.taggableId = taggableId;
    }

    public String getTaggableType() {
        return taggableType;
    }

    public void setTaggableType(String taggableType) {
        this.taggableType = taggableType == null ? null : taggableType.trim();
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