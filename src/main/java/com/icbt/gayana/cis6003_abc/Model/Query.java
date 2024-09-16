package com.icbt.gayana.cis6003_abc.Model;

import java.time.LocalDateTime;

public class Query {
    private int query_id;
    private int user_id;
    private String subject;
    private String message;
    private String status; // 'Pending', 'Resolved'
    private String response;
    private LocalDateTime created_at;

    // Getters and Setters for each field
    public int getQueryId() {
        return query_id;
    }

    public void setQueryId(int queryId) {
        this.query_id = queryId;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUser(User user) {
        this.user_id = user.getUser_id();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.created_at = createdAt;
    }
}
