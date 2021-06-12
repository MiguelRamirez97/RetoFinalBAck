package com.sofka.retofinal.usecase;

import com.sofka.retofinal.collections.KrEntity;
import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.KrDTO;
import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.repository.KrRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
public class UpdateKr {

    private final KrRepository krRepository;
    private final MapperUtils mapperUtils;

    public UpdateKr(KrRepository krRepository, MapperUtils mapperUtils) {
        this.krRepository = krRepository;
        this.mapperUtils = mapperUtils;
    }

    public Mono<Void> apply(@Valid  KrDTO krDTO) {
        return krRepository.findById(krDTO.getKrId())
                .flatMap(krEntity -> {
                    krEntity.setPercentageWeight(krDTO.getPercentageWeight());
                    krEntity.setOkrId(krDTO.getOkrId());
                    krEntity.setKeyResult(krDTO.getKeyResult());
                    krEntity.setResponEmail(krDTO.getResponEmail());
                    krEntity.setResponName(krDTO.getResponName());
                    krEntity.setDescription(krDTO.getDescription());
                    krEntity.setProgressKr(krDTO.getProgressKr());
                    krEntity.setStartDate(krDTO.getStartDate());
                    krEntity.setEndDate(krDTO.getEndDate());
                    krEntity.setId(krDTO.getKrId());
                    return krRepository.save(krEntity);
                })
                .flatMap(krEntity -> Mono.empty());


    }
}
