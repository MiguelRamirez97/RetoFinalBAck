package com.sofka.retofinal.usecase;

import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.ConfigurationNotificationDTO;
import com.sofka.retofinal.repository.ConfigurationNotificationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
public class GetConfigNotifications implements Supplier<Flux<ConfigurationNotificationDTO>> {

    private final ConfigurationNotificationRepository configurationNotificationRepository;
    private final MapperUtils mapperUtils;

    public GetConfigNotifications(ConfigurationNotificationRepository configurationNotificationRepository, MapperUtils mapperUtils) {
        this.configurationNotificationRepository = configurationNotificationRepository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Flux<ConfigurationNotificationDTO> get() {
        return configurationNotificationRepository.findAll()
                .map(mapperUtils.ConfigurationNotificationEntityToConfigurationNotificationDTO());
    }
}
