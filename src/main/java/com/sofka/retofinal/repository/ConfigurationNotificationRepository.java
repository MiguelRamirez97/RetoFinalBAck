package com.sofka.retofinal.repository;

import com.sofka.retofinal.collections.ConfigurationNotificationEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ConfigurationNotificationRepository
        extends ReactiveCrudRepository<ConfigurationNotificationEntity,String> {
    Mono<ConfigurationNotificationEntity> findByUserId(String userId);
}
