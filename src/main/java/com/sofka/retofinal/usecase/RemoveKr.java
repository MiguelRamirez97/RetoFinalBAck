package com.sofka.retofinal.usecase;

import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.repository.KrRepository;
import com.sofka.retofinal.repository.OkrRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class RemoveKr {

    private final OkrRepository okrRepository;
    private  final KrRepository krRepository;
    private final MapperUtils mapperUtils;

    public RemoveKr(OkrRepository okrRepository, KrRepository krRepository, MapperUtils mapperUtils) {
        this.okrRepository = okrRepository;
        this.krRepository = krRepository;
        this.mapperUtils = mapperUtils;
    }

    public Mono<Void> apply(String krId){
        return krRepository.deleteById(krId);

    }
}
