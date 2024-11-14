package com.example.bank.bankapp.model;
import java.time.LocalDateTime;

public class Notifications {
    private Long id;
    private Long user_id;
    private String message;
    private String notification_type;
    private LocalDateTime timestamp;

    public Notifications() {

    }
    public Notifications(Long id, Long user_id, String message, String notification_type, LocalDateTime timestamp) {
        this.id = id;
        this.user_id = user_id;
        this.message = message;
        this.notification_type = notification_type;
        this.timestamp = timestamp;
    }
    public Long getId() {
        return this.id;
    }
    public Long getUserId() {
        return this.user_id;
    }
    public String getMessage() {
        return this.message;
    }
    public String getNotificationType() {
        return this.notification_type;
    }
    public LocalDateTime getTimeStamp() {
        return this.timestamp;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setUserId(Long user_id) {
        this.user_id = user_id;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setNotificationType(String notification_type) {
        this.notification_type = notification_type;
    }
    public void setTimeStamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    @Override
    public String toString() {
        return "Notification{" +
                "id=" + this.id +
                ", userId=" + this.user_id +
                ", message='" + this.message + '\'' +
                ", notificationType='" + this.notification_type + '\'' +
                ", timestamp=" + this.timestamp +
                '}';
    }
}