package com.sofka.retofinal.model;

import com.sofka.retofinal.collections.NotificationsKind;

public class NotificationDTO {
    private String id;
    private String userId;
    private String okrId;
    private String krId;
    private String message;
    private NotificationsKind type;

    public NotificationDTO(){

    }

    public NotificationDTO(String id, String userId, String okrId, String krId, String message) {
        this.id = id;
        this.userId = userId;
        this.okrId = okrId;
        this.krId = krId;
        this.message = message;
    }

    public NotificationDTO(String id, String userId, String okrId, String krId, String message, NotificationsKind type) {
        this.id = id;
        this.userId = userId;
        this.okrId = okrId;
        this.krId = krId;
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

    public String getOkrId() {
        return okrId;
    }

    public void setOkrId(String okrId) {
        this.okrId = okrId;
    }

    public String getKrId() {
        return krId;
    }

    public void setKrId(String krId) {
        this.krId = krId;
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
