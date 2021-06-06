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

    public Mono<String> apply(@Valid OkrDTO okrDTO){
        return okrRepository.save(mapperUtils.okrDTOToOkrEntity().apply(okrDTO))
                .flatMap(okr ->  {
                    okrDTO.getKrs().forEach(kr-> {
                        kr.setOkrId(okr.getId());
                        krRepository.save(mapperUtils.krDTOToKrEntity().apply(kr));

                    } );
                    return Mono.just(okr.getId());
                }  );
    }
}
