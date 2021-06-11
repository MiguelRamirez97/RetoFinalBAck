package com.sofka.retofinal.usecase;

import com.sofka.retofinal.model.BurnDownDTO;
import com.sofka.retofinal.utils.DataCharts;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class GetDataChartsUseCase implements Function<String, Mono<BurnDownDTO>> {

    private final DataCharts dataCharts;


    public GetDataChartsUseCase(DataCharts dataCharts) {
        this.dataCharts = dataCharts;
    }

    @Override
    public Mono<BurnDownDTO> apply(String okrId) {
        var data =  new BurnDownDTO();
        return dataCharts.arrayDates(okrId).flatMap(longs -> {
            data.setActualPercentage(longs);
            return Mono.just(data);
        });
    }

}
