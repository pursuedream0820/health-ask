package com.hebeu.ask.model.po;

import java.util.Date;

public class Authentication {
    /** */
    private Integer userId;

    /** */
    private Integer categoryId;

    /** */
    private String realName;

    /** */
    private Short province;

    /** */
    private String title;

    /** */
    private Byte gender;

    /** */
    private Short city;

    /** */
    private String idCard;

    /** */
    private String idCardImage;

    /** */
    private String skill;

    /** */
    private String skillImage;

    /** */
    private String failedReason;

    /** */
    private Byte status;

    /** */
    private Date createdAt;

    /** */
    private Date updatedAt;

    /** */
    private String description;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Short getProvince() {
        return province;
    }

    public void setProvince(Short province) {
        this.province = province;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Short getCity() {
        return city;
    }

    public void setCity(Short city) {
        this.city = city;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getIdCardImage() {
        return idCardImage;
    }

    public void setIdCardImage(String idCardImage) {
        this.idCardImage = idCardImage == null ? null : idCardImage.trim();
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill == null ? null : skill.trim();
    }

    public String getSkillImage() {
        return skillImage;
    }

    public void setSkillImage(String skillImage) {
        this.skillImage = skillImage == null ? null : skillImage.trim();
    }

    public String getFailedReason() {
        return failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason == null ? null : failedReason.trim();
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