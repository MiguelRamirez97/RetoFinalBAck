package com.sofka.retofinal.model;

import java.util.List;

public class BurnDownDTO {
    private List<Long> actualPercentage;

    public BurnDownDTO(){}

    public BurnDownDTO(List<Long> actualPercentage) {
        this.actualPercentage = actualPercentage;
    }

    public List<Long> getActualPercentage() {
        return actualPercentage;
    }

    public void setActualPercentage(List<Long> actualPercentage) {
        this.actualPercentage = actualPercentage;
    }
}
