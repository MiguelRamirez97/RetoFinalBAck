package com.sofka.retofinal.route;

import com.sofka.retofinal.model.KrWeightDTO;
import com.sofka.retofinal.usecase.UpdatePercentageKR;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ReAdjustPercentage {
    @Bean
    public RouterFunction<ServerResponse> putPercentage(UpdatePercentageKR useCase) {
        return route(PUT("/kr/weight").and(accept(MediaType.APPLICATION_JSON)),
                serverRequest ->  serverRequest.bodyToFlux(KrWeightDTO.class)
                        .collectList()
                        .flatMap(useCase::apply)
                        .flatMap(response -> ServerResponse.ok().bodyValue(response))
        );

    }
}
