package com.sofka.retofinal.model;

import javax.validation.constraints.NotNull;

public class KrWeightDTO {


    private String id;
    private Integer percentage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
