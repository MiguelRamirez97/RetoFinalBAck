package com.sofka.retofinal.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class KrEntity {

    @Id
    private String id;
    private String okrId;
    private String keyResult;
    private String responName;
    private String responEmail;
    private String description;
    private Integer percentageWeight;
    private Integer progressKr;
    private LocalDate startDate;
    private LocalDate endDate;

    public KrEntity() {
    }

    public KrEntity(String id, String okrId, String keyResult, String responName, String responEmail,
                    String description, Integer percentageWeight, Integer progressKr, LocalDate startDate,
                    LocalDate endDate) {
        this.id = id;
        this.okrId = okrId;
        this.keyResult = keyResult;
        this.responName = responName;
        this.responEmail = responEmail;
        this.description = description;
        this.percentageWeight = percentageWeight;
        this.progressKr = progressKr;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getProgressKr() {
        return progressKr;
    }

    public void setProgressKr(Integer progressKr) {
        this.progressKr = progressKr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
