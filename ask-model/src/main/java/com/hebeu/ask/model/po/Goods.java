package com.hebeu.ask.model.po;

import java.util.Date;

public class Goods {
    /** */
    private Integer id;

    /** */
    private String logo;

    /** */
    private String name;

    /** */
    private Integer coins;

    /** */
    private Integer remnants;

    /** */
    private Byte postType;

    /** */
    private Byte status;

    /** */
    private Date createdAt;

    /** */
    private Date updatedAt;

    /** */
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getRemnants() {
        return remnants;
    }

    public void setRemnants(Integer remnants) {
        this.remnants = remnants;
    }

    public Byte getPostType() {
        return postType;
    }

    public void setPostType(Byte postType) {
        this.postType = postType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}