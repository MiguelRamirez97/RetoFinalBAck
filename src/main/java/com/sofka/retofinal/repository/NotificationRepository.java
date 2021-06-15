package com.sofka.retofinal.repository;

import com.sofka.retofinal.collections.NotificationEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface NotificationRepository extends ReactiveCrudRepository<NotificationEntity, String> {
}
