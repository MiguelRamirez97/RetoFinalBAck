package com.sofka.retofinal.model;

import com.sofka.retofinal.collections.NotificationsKind;

public class NotificationDTO {
    private String id;
    private String userId;
    private String message;
    private NotificationsKind type;

    public NotificationDTO(){

    }

    public NotificationDTO(String id, String userId, String message) {
        this.id = id;
        this.userId = userId;
        this.message = message;
    }

    public NotificationDTO(String id, String userId, String message, NotificationsKind type) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationsKind getType() {
        return type;
    }

    public void setType(NotificationsKind type) {
        this.type = type;
    }
}
