package com.sofka.retofinal.route;

import com.sofka.retofinal.model.KrDTO;
import com.sofka.retofinal.usecase.GetKrByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetKrById {

    @Bean
    public RouterFunction<ServerResponse> krById(GetKrByIdUseCase getKrByIdUseCase){
        return route(GET("/kr/{krId}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters
                        .fromPublisher(getKrByIdUseCase.apply(request.pathVariable("krId")), KrDTO.class)));
    }
}
