package com.sofka.retofinal.usecase;

import com.sofka.retofinal.collections.HistoryOkrEntity;
import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.KrDTO;
import com.sofka.retofinal.repository.HistoryOkrRepository;
import com.sofka.retofinal.repository.KrRepository;
import com.sofka.retofinal.repository.OkrRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class UpdateProgressKr {
    private final KrRepository krRepository;
    private final MapperUtils mapperUtils;
    private final HistoryOkrRepository historyOkrRepository;
    private final OkrRepository okrRepository;
    private final GetOrkById getOrkById;


    public UpdateProgressKr(KrRepository krRepository, MapperUtils mapperUtils, HistoryOkrRepository historyOkrRepository, OkrRepository okrRepository, GetOrkById getOrkById) {
        this.krRepository = krRepository;
        this.mapperUtils = mapperUtils;
        this.historyOkrRepository = historyOkrRepository;
        this.okrRepository = okrRepository;
        this.getOrkById = getOrkById;
    }

    public Mono<String> apply(KrDTO krDTO) {
        return krRepository.save(mapperUtils.krDTOToKrEntity().apply(krDTO))
                .flatMap(krEntity -> getOrkById.apply(krDTO.getOkrId())
                .flatMap(okrDTO ->
                    historyOkrRepository.save(new HistoryOkrEntity(okrDTO.getId(), okrDTO.getProgressOkr(), LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"))))
                    .flatMap(historyOkrEntity -> Mono.just(historyOkrEntity.getOkrId()))));
    }



}
