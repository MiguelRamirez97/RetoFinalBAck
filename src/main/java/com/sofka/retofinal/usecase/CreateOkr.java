package com.sofka.retofinal.usecase;


import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.repository.KrRepository;
import com.sofka.retofinal.repository.OkrRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Service
@Validated
public class CreateOkr {

    private final OkrRepository okrRepository;
    private final KrRepository krRepository;
    private final MapperUtils mapperUtils;


    public CreateOkr(OkrRepository okrRepository, KrRepository krRepository, MapperUtils mapperUtils) {
        this.okrRepository = okrRepository;
        this.krRepository = krRepository;
        this.mapperUtils = mapperUtils;

    }
    public Mono<String> apply(@Valid OkrDTO okrDTO) {

        var totalWeight = IntStream.range(0,okrDTO.getKrs().size())
                .reduce(0, (acc, s2) ->
                        (acc + okrDTO.getKrs().get(s2).getPercentageWeight()));

        return   Optional.of(totalWeight).filter(tw -> tw.equals(100))
                .map(oktE -> okrRepository.save(mapperUtils.okrDTOToOkrEntity().apply(okrDTO))
                        .map(t -> {
                            okrDTO.getKrs().forEach(kr -> kr.setOkrId(t.getId()));
                            krRepository.saveAll(mapperUtils.listKrDtoToListKrEntity().apply(okrDTO.getKrs()))
                                    .subscribe();
                            return t.getId();
                        }))
                .orElseThrow(() -> new IllegalArgumentException("el total de pesos % debe ser igual a 100%"));

    };
}



