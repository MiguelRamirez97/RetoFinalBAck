package com.sofka.retofinal.usecase;

import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.KrDTO;
import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.repository.KrRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
public class GetAllKrByOkrId implements Function<String, Flux<KrDTO>> {

    private final KrRepository krRepository;
    private final MapperUtils mapperUtils;

    public GetAllKrByOkrId(KrRepository krRepository, MapperUtils mapperUtils) {
        this.krRepository = krRepository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Flux<KrDTO> apply(String OkrId) {
        return krRepository.findAllByOkrId(OkrId).
                map(mapperUtils.krEntityToKrDto());
    }
}
