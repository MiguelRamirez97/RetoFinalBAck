package com.sofka.retofinal.route;

import com.sofka.retofinal.usecase.RemoveOkr;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration

public class DeleteOkr {
    @Bean
    public RouterFunction<ServerResponse> delete(RemoveOkr removeOkr){
        return route (
                DELETE("/delete/{id}"),
                request -> ServerResponse.accepted()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(removeOkr.apply(request.pathVariable("id")), Void.class))
        );
    }
}
