package com.sofka.retofinal.route;

import com.sofka.retofinal.model.KrDTO;
import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.usecase.GetAllKrByOkrId;
import com.sofka.retofinal.usecase.GetAllOkr;
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
public class GetAllKrByOkrIdRoute {
    @Bean
    RouterFunction<ServerResponse> getAllkrsByOkrId(GetAllKrByOkrId getAllKrByOkrId) {
        return route(
                GET("/krs/{okrId}"),
                serverRequest -> ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters
                                    .fromPublisher(getAllKrByOkrId.
                                    apply(serverRequest.pathVariable("okrId")), KrDTO.class))
                );
    }
}
