package com.sofka.retofinal.model;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class KrDTO {

    @NotBlank
    private String okrId;
    private String krId;
    @NotBlank
    private String keyResult;
    @NotBlank
    private String responName;
    @NotBlank
    private String responEmail;
    private String description;
    private Integer progressKr;
    @NotBlank
    private Integer percentageWeight;
    @NotBlank
    private LocalDate startDate;
    @NotBlank
        private LocalDate endDate;

    public KrDTO() {
    }

    public KrDTO(String okrId, String krId, String keyResult, String responName,
                 String responEmail, String description, Integer percentageWeight,
                 LocalDate startDate, LocalDate endDate,Integer progressKr) {
        this.okrId = okrId;
        this.krId = krId;
        this.keyResult = keyResult;
        this.responName = responName;
        this.responEmail = responEmail;
        this.description = description;
        this.percentageWeight = percentageWeight;
        this.startDate = startDate;
        this.endDate = endDate;
        this.progressKr = progressKr;
    }

    public String getKrId() {
        return krId;
    }

    public Integer getProgressKr() {
        this.progressKr = Optional.ofNullable(progressKr).orElse(0);
        return progressKr;
    }

    public void setProgressKr(Integer progressKr) {
        this.progressKr = progressKr;
    }

    public void setKrId(String krId) {
        this.krId = krId;
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
