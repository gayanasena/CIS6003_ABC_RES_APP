package com.icbt.gayana.cis6003_abc.Model;

import java.time.LocalDateTime;

public class ActionLog {
    private int actionId;
    private User user; // Foreign key to the staff/admin who performed the action
    private String actionDescription;
    private LocalDateTime actionDate;

    // Constructor
    public ActionLog(int actionId, User user, String actionDescription, LocalDateTime actionDate) {
        this.actionId = actionId;
        this.user = user;
        this.actionDescription = actionDescription;
        this.actionDate = actionDate;
    }

    // Getters and Setters
    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public LocalDateTime getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDateTime actionDate) {
        this.actionDate = actionDate;
    }
}
