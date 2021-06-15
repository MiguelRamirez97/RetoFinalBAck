package com.sofka.retofinal.model;

public class NotificationDTO {
    private String id;
    private String userId;
    private String okrId;
    private String krId;
    private String message;

    public NotificationDTO(){

    }

    public NotificationDTO(String id, String userId, String okrId, String krId, String message) {
        this.id = id;
        this.userId = userId;
        this.okrId = okrId;
        this.krId = krId;
        this.message = message;
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
}
