package com.sofka.retofinal.usecase;

import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.NotificationDTO;
import com.sofka.retofinal.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
public class GetNotifications implements Function<String, Flux<NotificationDTO>> {

    private final NotificationRepository notificationRepository;
    private final MapperUtils mapperUtils;

    public GetNotifications(NotificationRepository notificationRepository, MapperUtils mapperUtils) {
        this.notificationRepository = notificationRepository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Flux<NotificationDTO> apply(String userId) {
        return notificationRepository.findByUserId(userId)
                .map(mapperUtils.NotificationEntityToNotificationDTO());
    }
}
