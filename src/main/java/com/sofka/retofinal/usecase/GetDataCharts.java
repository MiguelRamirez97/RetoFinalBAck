package com.sofka.retofinal.usecase;

import com.sofka.retofinal.model.BurnDownDTO;
import com.sofka.retofinal.utils.DataKrs;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class GetDataCharts implements Function<String, Mono<BurnDownDTO>> {

    private final DataKrs dataKrs;


    public GetDataCharts( DataKrs dataKrs) {
        this.dataKrs = dataKrs;
    }

    @Override
    public Mono<BurnDownDTO> apply(String okrId) {
        var data =  new BurnDownDTO();
        return dataKrs.arrayDates(okrId).flatMap(longs -> {
            data.setActualPercentage(longs);
            return Mono.just(data);
        });
    }

}
