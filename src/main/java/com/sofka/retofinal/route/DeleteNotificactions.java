package com.sofka.retofinal.route;

import com.sofka.retofinal.usecase.DeleteNotification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteNotificactions {

    @Bean
    public RouterFunction<ServerResponse> deleteNotifications(DeleteNotification useCase){
        return route (
                DELETE("/deleteNotification/{id}"),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase
                                .apply(request.pathVariable("id")), Void.class))
        );
    }
}
