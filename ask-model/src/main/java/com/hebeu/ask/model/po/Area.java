package com.hebeu.ask.model.po;

public class Area {
    /** 主键id*/
    private Integer id;

    /** 地区名*/
    private String name;

    /** 上级地区id*/
    private Short parentId;

    /** 地区级别*/
    private Byte grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getParentId() {
        return parentId;
    }

    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }

    public Byte getGrade() {
        return grade;
    }

    public void setGrade(Byte grade) {
        this.grade = grade;
    }
}