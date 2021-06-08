package com.sofka.retofinal.route;

import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.usecase.CreateOkr;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

@Configuration
public class PostOkr {

    @Bean
    public RouterFunction<ServerResponse> create(CreateOkr useCase) {
        return route(POST("/okr").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(OkrDTO.class)
                        .flatMap(okrDTO -> useCase.apply(okrDTO)
                                .flatMap(response -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(response))
                        )
        );
    }
}
