package com.sofka.retofinal.repository;

import com.sofka.retofinal.collections.ConfigurationNotificationEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ConfigurationNotificationRepository
        extends ReactiveCrudRepository<ConfigurationNotificationEntity,String> {
    Flux<ConfigurationNotificationEntity> findAll();
}
