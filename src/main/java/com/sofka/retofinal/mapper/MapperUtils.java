package com.sofka.retofinal.mapper;

import com.sofka.retofinal.collections.KrEntity;
import com.sofka.retofinal.model.KrDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUtils {

    public Function<KrDTO, KrEntity> krDTOToKrEntity() {
        return krDTO -> {
            var krEntity = new KrEntity();
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


}
