package com.sofka.retofinal.model;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class KrDTO {

    @NotBlank
    private String okrId;
    @NotBlank
    private String keyResult;
    @NotBlank
    private String responName;
    @NotBlank
    private String responEmail;
    private String description;

    @NotBlank
    private Integer percentageWeight;
    @NotBlank
    private LocalDate startDate;
    @NotBlank
    private LocalDate endDate;

    public KrDTO(String okrId, String keyResult, String responName, String responEmail, String description, Integer percentageWeight, LocalDate startDate, LocalDate endDate) {
        this.okrId = okrId;
        this.keyResult = keyResult;
        this.responName = responName;
        this.responEmail = responEmail;
        this.description = description;
        this.percentageWeight = percentageWeight;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getOkrId() {
        return okrId;
    }

    public void setOkrId(String okrId) {
        this.okrId = okrId;
    }

    public String getKeyResult() {
        return keyResult;
    }

    public void setKeyResult(String keyResult) {
        this.keyResult = keyResult;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPercentageWeight() {
        return percentageWeight;
    }

    public void setPercentageWeight(Integer percentageWeight) {
        this.percentageWeight = percentageWeight;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
