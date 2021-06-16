package com.sofka.retofinal.usecase;

import com.sofka.retofinal.model.ConfigurationNotificationDTO;
import com.sofka.retofinal.repository.ConfigurationNotificationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UpdateConfigNotifications {

    private final ConfigurationNotificationRepository configurationNotificationRepository;

    public UpdateConfigNotifications(ConfigurationNotificationRepository configurationNotificationRepository) {
        this.configurationNotificationRepository = configurationNotificationRepository;
    }

    public Mono<Void> apply(ConfigurationNotificationDTO configurationNotificationDTO){
        return configurationNotificationRepository.findByUserId(configurationNotificationDTO.getUserId())
                .flatMap(configurationNotificationEntity -> {
                    configurationNotificationEntity.setId(configurationNotificationDTO.getId());
                    configurationNotificationEntity.setoKRFinishScreen(configurationNotificationDTO.getoKRFinishScreen());
                    configurationNotificationEntity.setkRFinishScreen(configurationNotificationDTO.getkRFinishScreen());
                    configurationNotificationEntity.setkRLateScreen(configurationNotificationDTO.getkRLateScreen());
                    configurationNotificationEntity.setoKREditScreen(configurationNotificationDTO.getoKREditScreen());
                    configurationNotificationEntity.setoKRDeleteScreen(configurationNotificationDTO.getoKRDeleteScreen());
                    return configurationNotificationRepository.save(configurationNotificationEntity);
                }).flatMap(ConfigurationNotificationEntity -> Mono.empty());
    }

}
