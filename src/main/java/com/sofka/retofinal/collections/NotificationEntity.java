package com.sofka.retofinal.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class NotificationEntity {
    @Id
    private String Id;
    private String UserId;
    private Enum TypeNotification;
    private Boolean Screen;
    private LocalDate Date;

    public NotificationEntity(){
    }

    public NotificationEntity(String userId, Enum typeNotification, Boolean screen, LocalDate date) {
        UserId = userId;
        TypeNotification = typeNotification;
        Screen = screen;
        Date = date;
    }

    public String getId() {
        return Id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public Enum getTypeNotification() {
        return TypeNotification;
    }

    public void setTypeNotification(Enum typeNotification) {
        TypeNotification = typeNotification;
    }

    public Boolean getScreen() {
        return Screen;
    }

    public void setScreen(Boolean screen) {
        Screen = screen;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }
}
