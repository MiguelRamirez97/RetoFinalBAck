package com.sofka.retofinal.usecase;

import com.sofka.retofinal.collections.NotificationEntity;
import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.NotificationDTO;
import com.sofka.retofinal.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
public class CreateNotifications {
    private final NotificationRepository notificationRepository;
    private final MapperUtils mapperUtils;

    public CreateNotifications(NotificationRepository notificationRepository,
                                     MapperUtils mapperUtils) {
        this.notificationRepository = notificationRepository;
        this.mapperUtils = mapperUtils;
    }

    public Mono<NotificationEntity> apply(@Valid NotificationDTO notificationDTO) {
        return notificationRepository.save(mapperUtils
                .NotificationDTOToNotificationEntity()
                .apply(notificationDTO));
    }
}
