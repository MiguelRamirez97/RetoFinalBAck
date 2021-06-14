package com.sofka.retofinal.usecase;

import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.ConfigurationNotificationDTO;
import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.repository.ConfigurationNotificationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class GetConfigNotifications implements Function<String, Mono<ConfigurationNotificationDTO>> {

    private final ConfigurationNotificationRepository configurationNotificationRepository;
    private final MapperUtils mapperUtils;

    public GetConfigNotifications(ConfigurationNotificationRepository configurationNotificationRepository, MapperUtils mapperUtils) {
        this.configurationNotificationRepository = configurationNotificationRepository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<ConfigurationNotificationDTO> apply(String userId) {
        return configurationNotificationRepository.findByUserId(userId)
                .map(mapperUtils.ConfigurationNotificationEntityToConfigurationNotificationDTO());
    }
}
