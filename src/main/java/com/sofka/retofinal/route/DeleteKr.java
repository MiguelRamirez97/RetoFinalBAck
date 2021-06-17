package com.sofka.retofinal.route;

import com.sofka.retofinal.usecase.RemoveKr;
import com.sofka.retofinal.usecase.RemoveOkr;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class DeleteKr {
    @Bean
    public RouterFunction<ServerResponse> deletekr(RemoveKr useCase){
        return route (
                DELETE("/delete/kr/{id}"),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.apply(request.pathVariable("id")), Void.class))
        );
    }
}