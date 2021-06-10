package com.sofka.retofinal.usecase;

import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.repository.KrRepository;
import com.sofka.retofinal.repository.OkrRepository;
import com.sofka.retofinal.utils.Utilities;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class GetOrkById implements Function<String, Mono<OkrDTO>> {

    private final OkrRepository okrRepository;
    private final MapperUtils mapperUtils;
    private final KrRepository krRepository;

    public GetOrkById(OkrRepository okrRepository, MapperUtils mapperUtils, KrRepository krRepository) {
        this.okrRepository = okrRepository;
        this.mapperUtils = mapperUtils;
        this.krRepository = krRepository;
    }


    @Override
    public Mono<OkrDTO> apply(String id) {
        return okrRepository.findById(id)
                .map(mapperUtils.okrEntityToOkrDTO())
                .flatMap(joinOkrWithKr())
                .flatMap(Utilities::modifiedProgressOkr);
    }

    public Function<OkrDTO, Mono<OkrDTO>> joinOkrWithKr() {
        return okrDto ->
                Mono.just(okrDto).zipWith(
                        krRepository.findAllByOkrId(okrDto.getId())
                                .map(mapperUtils.krEntityToKrDto())
                                .collectList(),
                        (okr, krs) -> {
                            okr.setKrs(krs);
                            return okr;
                        }
                );
    }
}
