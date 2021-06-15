package com.sofka.retofinal.route;

import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.usecase.UpdateOKR;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutOKR {

    @Bean
    public RouterFunction<ServerResponse> put(UpdateOKR useCase) {
        return route(PUT("/okr").and(accept(MediaType.APPLICATION_JSON)),
                serverRequest -> serverRequest.bodyToMono(OkrDTO.class)
                        .flatMap(useCase::apply)
                        .flatMap(response -> ServerResponse.ok().bodyValue(response))
        );

    }

}