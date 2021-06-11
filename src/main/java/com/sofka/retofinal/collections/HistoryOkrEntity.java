package com.sofka.retofinal.collections;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class HistoryOkrEntity {

    private String okrId;
    private Long progressOkr;
    private String dateUpdate;

    public HistoryOkrEntity(){}

    public HistoryOkrEntity(String okrId, Long progressOkr, String dateUpdate) {
        this.okrId = okrId;
        this.progressOkr = progressOkr;
        this.dateUpdate = dateUpdate;
    }

    public String getOkrId() {
        return okrId;
    }

    public void setOkrId(String okrId) {
        this.okrId = okrId;
    }

    public Long getProgressOkr() {
        return progressOkr;
    }

    public void setProgressOkr(Long progressOkr) {
        this.progressOkr = progressOkr;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
