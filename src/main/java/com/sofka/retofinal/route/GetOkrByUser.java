package com.sofka.retofinal.route;

import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.usecase.AllOkrByUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetOkrByUser {

    @Bean
    public RouterFunction<ServerResponse> getAllByUser(AllOkrByUser useCase){
        return route(GET("/all-okr/{userId}"),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.apply(request.pathVariable("userId")), OkrDTO.class)));
    }

}
