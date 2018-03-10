package com.hebeu.ask.model.po;

import java.util.Date;

public class FailedJob {
    /** */
    private Integer id;

    /** */
    private Date failedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFailedAt() {
        return failedAt;
    }

    public void setFailedAt(Date failedAt) {
        this.failedAt = failedAt;
    }
}