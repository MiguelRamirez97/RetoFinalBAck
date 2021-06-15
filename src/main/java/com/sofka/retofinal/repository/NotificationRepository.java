package com.sofka.retofinal.repository;

import com.sofka.retofinal.collections.ConfigurationNotificationEntity;
import com.sofka.retofinal.collections.NotificationEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NotificationRepository extends ReactiveCrudRepository<NotificationEntity, String> {
    Flux<NotificationEntity> findByUserId(String userId);
}
