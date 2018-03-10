package com.hebeu.ask.model.po;

import java.util.Date;

public class Credit {
    /** */
    private Integer id;

    /** */
    private Integer userId;

    /** */
    private String action;

    /** */
    private Integer sourceId;

    /** */
    private String sourceSubject;

    /** */
    private Integer coins;

    /** */
    private Integer credits;

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