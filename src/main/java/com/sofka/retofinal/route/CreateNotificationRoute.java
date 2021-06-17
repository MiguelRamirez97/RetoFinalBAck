package com.sofka.retofinal.route;

import com.sofka.retofinal.model.NotificationDTO;
import com.sofka.retofinal.usecase.CreateNotifications;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateNotificationRoute {
    @Bean
    public RouterFunction<ServerResponse> createNotify(CreateNotifications createNotifications) {
        return route(POST("/createNotifications").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(NotificationDTO.class)
                        .flatMap(notificationDTO -> createNotifications
                                            .apply(notificationDTO)
                                            .flatMap(response -> ServerResponse.ok()
                                                    .contentType(MediaType.APPLICATION_JSON)
                                                    .bodyValue(response))));

    }
}
