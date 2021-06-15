package com.sofka.retofinal.route;

import com.sofka.retofinal.collections.ConfigurationNotificationEntity;
import com.sofka.retofinal.model.ConfigurationNotificationDTO;
import com.sofka.retofinal.usecase.UpdateConfigNotifications;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateConfigNotificationRoute {

    @Bean
    public RouterFunction<ServerResponse> updateConfig(UpdateConfigNotifications updateConfigNotifications){
        return route(PUT("/UpdateConfigNotifications").and(accept(MediaType.APPLICATION_JSON)),
                serverRequest -> serverRequest.bodyToMono(ConfigurationNotificationDTO.class)
                            .flatMap(updateConfigNotifications::apply)
                            .flatMap(response -> ServerResponse.ok().bodyValue(response))
        );
    }
}
