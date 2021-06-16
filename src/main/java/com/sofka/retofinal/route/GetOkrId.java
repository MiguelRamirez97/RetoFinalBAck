package com.sofka.retofinal.route;

import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.usecase.GetOrkById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetOkrId {

    @Bean
    RouterFunction<ServerResponse> getById(GetOrkById getOrkById) {
        return route(
                GET("/okrid/{id}").and(accept(MediaType.APPLICATION_JSON)),
                serverRequest -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(getOrkById.apply(serverRequest.pathVariable("id")), OkrDTO.class))
        );
    }


}
