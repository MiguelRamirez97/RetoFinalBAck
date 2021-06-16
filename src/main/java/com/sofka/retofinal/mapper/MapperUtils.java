package com.sofka.retofinal.mapper;

import com.sofka.retofinal.collections.ConfigurationNotificationEntity;
import com.sofka.retofinal.collections.KrEntity;
import com.sofka.retofinal.collections.NotificationEntity;
import com.sofka.retofinal.collections.OkrEntity;
import com.sofka.retofinal.model.ConfigurationNotificationDTO;
import com.sofka.retofinal.model.KrDTO;
import com.sofka.retofinal.model.NotificationDTO;
import com.sofka.retofinal.model.OkrDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MapperUtils {

    public Function<KrDTO, KrEntity> krDTOToKrEntity() {
        return krDTO -> {
            var krEntity = new KrEntity();
            krEntity.setProgressKr(krDTO.getProgressKr());
            krEntity.setProgressKr(krDTO.getProgressKr());
            krEntity.setOkrId(krDTO.getOkrId());
            krEntity.setDescription(krDTO.getDescription());
            krEntity.setStartDate(krDTO.getStartDate());
            krEntity.setEndDate(krDTO.getEndDate());
            krEntity.setKeyResult(krDTO.getKeyResult());
            krEntity.setResponName(krDTO.getResponName());
            krEntity.setResponEmail(krDTO.getResponEmail());
            krEntity.setPercentageWeight(krDTO.getPercentageWeight());
            return krEntity;
        };
    }

    public Function<KrEntity, KrDTO> krEntityToKrDto() {
        return krEntity -> {
            var krDto = new KrDTO();
            krDto.setProgressKr(krEntity.getProgressKr());
            krDto.setKrId(krEntity.getId());
            krDto.setOkrId(krEntity.getOkrId());
            krDto.setDescription(krEntity.getDescription());
            krDto.setStartDate(krEntity.getStartDate());
            krDto.setEndDate(krEntity.getEndDate());
            krDto.setKeyResult(krEntity.getKeyResult());
            krDto.setResponName(krEntity.getResponName());
            krDto.setResponEmail(krEntity.getResponEmail());
            krDto.setPercentageWeight(krEntity.getPercentageWeight());
            return krDto;
        };
    }

    public Function<OkrDTO, OkrEntity> okrDTOToOkrEntity() {
        return okrDTO -> {
            var okrEntity = new OkrEntity();
            okrEntity.setUserId(okrDTO.getUserId());
            okrEntity.setTitle(okrDTO.getTitle());
            okrEntity.setObjective(okrDTO.getObjective());
            okrEntity.setResponName(okrDTO.getResponName());
            okrEntity.setResponEmail(okrDTO.getResponEmail());
            okrEntity.setVertical(okrDTO.getVertical());
            okrEntity.setDescription(okrDTO.getDescription());
            return okrEntity;
        };
    }

    public Function<OkrEntity, OkrDTO> okrEntityToOkrDTO() {
        return okrEntity -> {
            var okrDTO = new OkrDTO();
            okrDTO.setId(okrEntity.getId());
            okrDTO.setUserId(okrEntity.getUserId());
            okrDTO.setTitle(okrEntity.getTitle());
            okrDTO.setObjective(okrEntity.getObjective());
            okrDTO.setResponName(okrEntity.getResponName());
            okrDTO.setResponEmail(okrEntity.getResponEmail());
            okrDTO.setVertical(okrEntity.getVertical());
            okrDTO.setDescription(okrEntity.getDescription());
            return okrDTO;

        };
    }

    public Function<ConfigurationNotificationEntity, ConfigurationNotificationDTO>
    ConfigurationNotificationEntityToConfigurationNotificationDTO() {
        return configurationNotificationEntity -> {
            var configurationNotificationDTO = new ConfigurationNotificationDTO();
            configurationNotificationDTO.setId(configurationNotificationEntity.getId());
            configurationNotificationDTO.setUserId(configurationNotificationEntity.getUserId());
            configurationNotificationDTO.setoKRFinishScreen(configurationNotificationEntity.getoKRFinishScreen());
            configurationNotificationDTO.setkRFinishScreen(configurationNotificationEntity.getkRFinishScreen());
            configurationNotificationDTO.setkRLateScreen(configurationNotificationEntity.getkRLateScreen());
            configurationNotificationDTO.setoKREditScreen(configurationNotificationEntity.getoKREditScreen());
            configurationNotificationDTO.setoKRDeleteScreen(configurationNotificationEntity.getoKRDeleteScreen());
            return configurationNotificationDTO;

        };
    }

    public Function<ConfigurationNotificationDTO, ConfigurationNotificationEntity>
    ConfigurationNotificationDTOToConfigurationNotificationEntity() {
        return configurationNotificationDTO -> {
            var configurationNotificationEntity = new ConfigurationNotificationEntity();
            configurationNotificationEntity.setUserId(configurationNotificationDTO.getUserId());
            configurationNotificationEntity.setoKRFinishScreen(configurationNotificationDTO.getoKRFinishScreen());
            configurationNotificationEntity.setkRFinishScreen(configurationNotificationDTO.getkRFinishScreen());
            configurationNotificationEntity.setkRLateScreen(configurationNotificationDTO.getkRLateScreen());
            configurationNotificationEntity.setoKREditScreen(configurationNotificationDTO.getoKREditScreen());
            configurationNotificationEntity.setoKRDeleteScreen(configurationNotificationDTO.getoKRDeleteScreen());
            return configurationNotificationEntity;

        };
    }

    public Function<NotificationEntity, NotificationDTO> NotificationEntityToNotificationDTO(){
        return notificationEntity -> {
          var notificationDTO = new NotificationDTO();
          notificationDTO.setId(notificationEntity.getId());
          notificationDTO.setUserId(notificationEntity.getUserId());
          notificationDTO.setMessage(notificationEntity.getMessage());
          notificationDTO.setType(notificationEntity.getType());
          return notificationDTO;
        };
    }

    public Function<NotificationDTO, NotificationEntity> NotificationDTOToNotificationEntity(){
        return notificationDTO1 -> {
            var notificationEntity = new NotificationEntity();
            notificationEntity.setId(notificationDTO1.getId());
            notificationEntity.setUserId(notificationDTO1.getUserId());
            notificationEntity.setMessage(notificationDTO1.getMessage());
            notificationEntity.setType(notificationDTO1.getType());
            return notificationEntity;
        };
    }

    public  Function<List<KrDTO>,List<KrEntity>> listKrDtoToListKrEntity() {
           return listKrDto ->  listKrDto.stream()
                .map(kr -> krDTOToKrEntity()
                        .apply(kr))
                .collect(Collectors.toList());

    }
}
