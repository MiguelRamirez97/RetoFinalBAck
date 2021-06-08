package com.sofka.retofinal.mapper;

import com.sofka.retofinal.collections.KrEntity;
import com.sofka.retofinal.collections.OkrEntity;
import com.sofka.retofinal.model.KrDTO;
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

    public  Function<List<KrDTO>,List<KrEntity>> listKrDtoToListKrEntity() {
           return listKrDto ->  listKrDto.stream()
                .map(kr -> krDTOToKrEntity()
                        .apply(kr))
                .collect(Collectors.toList());

    }
}
