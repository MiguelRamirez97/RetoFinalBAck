package com.sofka.retofinal.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ConfigurationNotificationEntity {
    private String UserId;
    private Boolean OKRFinishScreen;
    private Boolean KRFinishScreen;
    private Boolean KRLateScreen;
    private Boolean OKREditScreen;

    public ConfigurationNotificationEntity(){
    }

    public ConfigurationNotificationEntity(String userId){
        UserId = userId;
        this.OKRFinishScreen = true;
        this.KRFinishScreen = true;
        this.KRLateScreen = true;
        this.OKREditScreen = true;
    }

    public ConfigurationNotificationEntity(String userId, boolean OKRFinishScreen, boolean KRFinishScreen,
                                           boolean KRLateScreen, boolean OKREditScreen) {
        UserId = userId;
        this.OKRFinishScreen = OKRFinishScreen;
        this.KRFinishScreen = KRFinishScreen;
        this.KRLateScreen = KRLateScreen;
        this.OKREditScreen = OKREditScreen;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public Boolean getOKRFinishScreen() {
        return OKRFinishScreen;
    }

    public void setOKRFinishScreen(Boolean OKRFinishScreen) {
        this.OKRFinishScreen = OKRFinishScreen;
    }

    public Boolean getKRFinishScreen() {
        return KRFinishScreen;
    }

    public void setKRFinishScreen(Boolean KRFinishScreen) {
        this.KRFinishScreen = KRFinishScreen;
    }

    public Boolean getKRLateScreen() {
        return KRLateScreen;
    }

    public void setKRLateScreen(Boolean KRLateScreen) {
        this.KRLateScreen = KRLateScreen;
    }

    public Boolean getOKREditScreen() {
        return OKREditScreen;
    }

    public void setOKREditScreen(Boolean OKREditScreen) {
        this.OKREditScreen = OKREditScreen;
    }
}
