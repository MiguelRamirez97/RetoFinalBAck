package com.sofka.retofinal.utils;

import com.sofka.retofinal.model.OkrDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Utilities {
    public static Mono<OkrDTO> createProgressOkr(OkrDTO okrDTO) {

        Flux.fromIterable(okrDTO.getKrs()).map(kr ->
                (Double.parseDouble(kr.getPercentageWeight().toString()) / 100)
                        * Double.parseDouble(kr.getProgressKr().toString()))
                .reduce((x, y) -> x + y)
                .subscribe((z) -> {
                    okrDTO.setProgressOkr(Math.round(z));
                });
        return Mono.just(okrDTO);
    }


}
