package com.sofka.retofinal.route;

import com.sofka.retofinal.model.BurnDownDTO;
import com.sofka.retofinal.usecase.GetDataChartsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetDataCharts {
    @Bean
    public RouterFunction<ServerResponse> historyTest(GetDataChartsUseCase testHistory){
        return route(GET("/data-chart/{okrId}").and(accept(MediaType.APPLICATION_JSON)),
                serverRequest -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(testHistory.apply(serverRequest.pathVariable("okrId")), BurnDownDTO.class))
        );
    }

}
