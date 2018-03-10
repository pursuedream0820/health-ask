package com.hebeu.ask.model.po;

import java.util.Date;

public class UserData {
    /** */
    private Integer userId;

    /** */
    private Integer coins;

    /** */
    private Integer credits;

    /** */
    private Date registeredAt;

    /** */
    private Date lastVisit;

    /** */
    private String lastLoginIp;

    /** */
    private Integer questions;

    /** */
    private Integer articles;

    /** */
    private Integer answers;

    /** */
    private Integer adoptions;

    /** */
    private Integer supports;

    /** */
    private Integer followers;

    /** */
    private Integer views;

    /** */
    private Byte emailStatus;

    /** */
    private Byte mobileStatus;

    /** */
    private Byte authenticationStatus;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
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

    public Integer getAdoptions() {
        return adoptions;
    }

    public void setAdoptions(Integer adoptions) {
        this.adoptions = adoptions;
    }

    public Integer getSupports() {
        return supports;
    }

    public void setSupports(Integer supports) {
        this.supports = supports;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Byte getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(Byte emailStatus) {
        this.emailStatus = emailStatus;
    }

    public Byte getMobileStatus() {
        return mobileStatus;
    }

    public void setMobileStatus(Byte mobileStatus) {
        this.mobileStatus = mobileStatus;
    }

    public Byte getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(Byte authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }
}