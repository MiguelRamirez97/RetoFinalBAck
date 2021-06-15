package com.sofka.retofinal.route;

import com.sofka.retofinal.model.ConfigurationNotificationDTO;
import com.sofka.retofinal.model.NotificationDTO;
import com.sofka.retofinal.usecase.GetConfigNotifications;
import com.sofka.retofinal.usecase.GetNotifications;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetNotificationsRoute {
    @Bean
    RouterFunction<ServerResponse> getAllNotifications(GetNotifications getNotifications) {
        return route(
                GET("/GetNotifications/{email}"),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getNotifications.apply(request.pathVariable("email")),
                                NotificationDTO.class)));
    }
}
