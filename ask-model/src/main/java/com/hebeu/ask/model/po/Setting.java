package com.hebeu.ask.model.po;

public class Setting {
    /** 设置名称*/
    private String name;

    /** 设置值*/
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}