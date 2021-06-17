package com.sofka.retofinal.usecase;

import com.sofka.retofinal.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteNotification {

    private final NotificationRepository notificationRepository;

    public DeleteNotification(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Mono<Void> apply(String notificationID){
        return  notificationRepository.deleteById(notificationID);
    }
}
