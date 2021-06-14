package com.sofka.retofinal.route;

import com.sofka.retofinal.model.ConfigurationNotificationDTO;
import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.usecase.CreateConfigNotifications;
import com.sofka.retofinal.usecase.CreateOkr;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateConfigNotificationRoute {

    @Bean
    public RouterFunction<ServerResponse> createConfigNotify(CreateConfigNotifications createConfigNotifications) {
        return route(POST("/createConfigNotifications").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ConfigurationNotificationDTO.class)
                        .flatMap(configurationNotificationDTO -> createConfigNotifications.apply(configurationNotificationDTO)
                                .flatMap(response -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(response))
                        )
        );
    }
}
