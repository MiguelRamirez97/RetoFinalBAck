package com.sofka.retofinal.route;


import com.sofka.retofinal.model.KrDTO;
import com.sofka.retofinal.usecase.UpdateKr;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutKr {

    @Bean
    public RouterFunction<ServerResponse> update(UpdateKr useCase) {
        return route(PUT("/kr").and(accept(MediaType.APPLICATION_JSON)),
                serverRequest -> serverRequest.bodyToMono(KrDTO.class)
                        .flatMap(useCase::apply)
                        .flatMap(response -> ServerResponse.ok().bodyValue(response))
        );

    }

}

