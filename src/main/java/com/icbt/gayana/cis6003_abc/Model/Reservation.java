package com.icbt.gayana.cis6003_abc.Model;

import java.time.LocalDateTime;

public class Reservation {
    private int reservationId;
    private int user_id;
    private String reservationType;
    private LocalDateTime dateTime;
    private int guestCount;
    private String status;
    private LocalDateTime created_at;

//    public Reservation(int reservationId, User user, LocalDateTime reservationDate, String reservationType) {
//        this.reservationId = reservationId;
//        this.user_id = user.getUser_id();
//        this.reservationType = reservationType;
//        this.dateTime = reservationDate;
//        this.guestCount = 1;
//        this.status = "Available";
//        this.created_at = LocalDateTime.now();
//    }

    // Getters and Setters for each field
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getUserId() { return user_id; }

    public String getReservationType() {
        return reservationType;
    }

    public void setReservationType(String reservationType) {
        this.reservationType = reservationType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserId(int userId) { this.user_id = userId; }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
