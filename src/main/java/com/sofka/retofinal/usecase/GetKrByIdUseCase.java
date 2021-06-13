package com.sofka.retofinal.usecase;

import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.KrDTO;
import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.repository.KrRepository;
import com.sofka.retofinal.utils.Utilities;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class GetKrByIdUseCase implements Function<String, Mono<KrDTO>> {

    private final MapperUtils mapperUtils;
    private final KrRepository krRepository;

    public GetKrByIdUseCase(MapperUtils mapperUtils, KrRepository krRepository) {
        this.mapperUtils = mapperUtils;
        this.krRepository = krRepository;
    }


    @Override
    public Mono<KrDTO> apply(String id) {
        return krRepository.findById(id)
                .map(mapperUtils.krEntityToKrDto());
    }



}

