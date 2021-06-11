package com.sofka.retofinal.route;

import com.sofka.retofinal.model.KrDTO;
import com.sofka.retofinal.usecase.UpdateProgressKr;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateProgress {
    @Bean
    public RouterFunction<ServerResponse> updateProgressKrs(UpdateProgressKr updateProgressKr){
        return route(PUT("/okr-update").and(accept(MediaType.APPLICATION_JSON)),
                serverRequest -> serverRequest.bodyToMono(KrDTO.class)
                .flatMap(krDTO -> updateProgressKr.apply(krDTO)
                        .flatMap(response -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(response)))
        );
    }
}
