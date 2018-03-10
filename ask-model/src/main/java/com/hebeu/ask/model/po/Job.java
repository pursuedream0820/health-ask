package com.hebeu.ask.model.po;

public class Job {
    /** */
    private Long id;

    /** */
    private String queue;

    /** */
    private Byte attempts;

    /** */
    private Byte reserved;

    /** */
    private Integer reservedAt;

    /** */
    private Integer availableAt;

    /** */
    private Integer createdAt;

    /** */
    private String payload;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue == null ? null : queue.trim();
    }

    public Byte getAttempts() {
        return attempts;
    }

    public void setAttempts(Byte attempts) {
        this.attempts = attempts;
    }

    public Byte getReserved() {
        return reserved;
    }

    public void setReserved(Byte reserved) {
        this.reserved = reserved;
    }

    public Integer getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(Integer reservedAt) {
        this.reservedAt = reservedAt;
    }

    public Integer getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(Integer availableAt) {
        this.availableAt = availableAt;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload == null ? null : payload.trim();
    }
}