package com.sofka.retofinal.usecase;

import com.sofka.retofinal.collections.HistoryOkrEntity;
import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.KrDTO;
import com.sofka.retofinal.repository.HistoryOkrRepository;
import com.sofka.retofinal.repository.KrRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Validated
public class UpdateKr {

    private final KrRepository krRepository;
    private final MapperUtils mapperUtils;
    private final HistoryOkrRepository historyOkrRepository;
    private final GetOrkById getOrkById;

    public UpdateKr(KrRepository krRepository, MapperUtils mapperUtils, HistoryOkrRepository historyOkrRepository, GetOrkById getOrkById) {
        this.krRepository = krRepository;
        this.mapperUtils = mapperUtils;
        this.historyOkrRepository = historyOkrRepository;
        this.getOrkById = getOrkById;
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
                .flatMap(krEntity -> getOrkById.apply(krDTO.getOkrId())
                        .flatMap(okrDTO ->
                                historyOkrRepository.save(new HistoryOkrEntity(okrDTO.getId(), okrDTO.getProgressOkr(), LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"))))
                                        .flatMap(historyOkrEntity -> Mono.just(historyOkrEntity.getOkrId()))))
                .flatMap(krEntity -> Mono.empty());


    }
}
