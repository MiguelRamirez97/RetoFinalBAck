package com.sofka.retofinal.model;

public class ConfigurationNotificationDTO {

    private String id;
    private String userId;
    private Boolean oKRFinishScreen;
    private Boolean kRFinishScreen;
    private Boolean kRLateScreen;
    private Boolean oKREditScreen;
    private Boolean oKRDeleteScreen;

    public ConfigurationNotificationDTO(){}

    public ConfigurationNotificationDTO(String id,String userId, Boolean oKRFinishScreen, Boolean kRFinishScreen,
                                        Boolean kRLateScreen, Boolean oKREditScreen, Boolean oKRDeleteScreen) {
        this.id = id;
        this.userId = userId;
        this.oKRFinishScreen = oKRFinishScreen;
        this.kRFinishScreen = kRFinishScreen;
        this.kRLateScreen = kRLateScreen;
        this.oKREditScreen = oKREditScreen;
        this.oKRDeleteScreen = oKRDeleteScreen;
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

    public Boolean getoKRFinishScreen() {
        return oKRFinishScreen;
    }

    public void setoKRFinishScreen(Boolean oKRFinishScreen) {
        this.oKRFinishScreen = oKRFinishScreen;
    }

    public Boolean getkRFinishScreen() {
        return kRFinishScreen;
    }

    public void setkRFinishScreen(Boolean kRFinishScreen) {
        this.kRFinishScreen = kRFinishScreen;
    }

    public Boolean getkRLateScreen() {
        return kRLateScreen;
    }

    public void setkRLateScreen(Boolean kRLateScreen) {
        this.kRLateScreen = kRLateScreen;
    }

    public Boolean getoKREditScreen() {
        return oKREditScreen;
    }

    public void setoKREditScreen(Boolean oKREditScreen) {
        this.oKREditScreen = oKREditScreen;
    }

    public Boolean getoKRDeleteScreen() {
        return oKRDeleteScreen;
    }

    public void setoKRDeleteScreen(Boolean oKRDeleteScreen) {
        this.oKRDeleteScreen = oKRDeleteScreen;
    }
}
