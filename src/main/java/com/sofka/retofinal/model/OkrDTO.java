package com.sofka.retofinal.model;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OkrDTO {
    private String id;
    @NotBlank
    private String userId;
    @NotBlank
    private String title;
    @NotBlank
    private String objective;
    @NotBlank
    private String responName;
    @NotBlank
    private String responEmail;
    @NotBlank
    private String vertical;
    private String description;
    private List<KrDTO> krs;

    public OkrDTO() {
    }

    public OkrDTO(String id, String userId, String title, String objective, String responName,
                  String responEmail, String vertical, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.objective = objective;
        this.responName = responName;
        this.responEmail = responEmail;
        this.vertical = vertical;
        this.description = description;

    }

    public List<KrDTO> getKrs() {
        this.krs = Optional.ofNullable(krs).orElse(new ArrayList<>());
        return krs;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getResponName() {
        return responName;
    }

    public void setResponName(String responName) {
        this.responName = responName;
    }

    public String getResponEmail() {
        return responEmail;
    }

    public void setResponEmail(String responEmail) {
        this.responEmail = responEmail;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
