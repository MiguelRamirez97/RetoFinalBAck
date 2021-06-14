package com.sofka.retofinal.usecase;

import com.sofka.retofinal.collections.ConfigurationNotificationEntity;
import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.ConfigurationNotificationDTO;
import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.repository.ConfigurationNotificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Optional;

@Service
@Validated
public class CreateConfigNotifications{

    private final ConfigurationNotificationRepository configurationNotificationRepository;
    private final MapperUtils mapperUtils;

    public CreateConfigNotifications(ConfigurationNotificationRepository configurationNotificationRepository,
                                     MapperUtils mapperUtils) {
        this.configurationNotificationRepository = configurationNotificationRepository;
        this.mapperUtils = mapperUtils;
    }

    public Mono<ConfigurationNotificationEntity> apply(@Valid ConfigurationNotificationDTO configurationNotificationDTO) {
        return configurationNotificationRepository.save(mapperUtils
                .ConfigurationNotificationDTOToConfigurationNotificationEntity()
                .apply(configurationNotificationDTO));
    }
}
