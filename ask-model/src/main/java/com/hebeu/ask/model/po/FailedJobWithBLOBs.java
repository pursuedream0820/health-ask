package com.hebeu.ask.model.po;

public class FailedJobWithBLOBs extends FailedJob {
    /** */
    private String connection;

    /** */
    private String queue;

    /** */
    private String payload;

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection == null ? null : connection.trim();
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue == null ? null : queue.trim();
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload == null ? null : payload.trim();
    }
}