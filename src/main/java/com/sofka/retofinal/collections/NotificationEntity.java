package com.sofka.retofinal.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class NotificationEntity {

    @Id
    private String id;
    private String userId;
    private String message;
    private NotificationsKind type;

    public NotificationEntity(String id, String userId, String message, NotificationsKind type) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.type = type;
    }

    public NotificationEntity() {
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
