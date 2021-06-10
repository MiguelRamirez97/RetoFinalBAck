package com.sofka.retofinal.usecase;

import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.KrDTO;
import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.repository.KrRepository;
import com.sofka.retofinal.repository.OkrRepository;
import com.sofka.retofinal.utils.Utilities;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


import java.time.LocalDate;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GetMaxProgressOrk implements Function<String, Mono<OkrDTO>> {

    private final OkrRepository okrRepository;
    private final MapperUtils mapperUtils;
    private final KrRepository krRepository;

    public GetMaxProgressOrk(OkrRepository okrRepository, MapperUtils mapperUtils, KrRepository krRepository) {
        this.okrRepository = okrRepository;
        this.mapperUtils = mapperUtils;
        this.krRepository = krRepository;
    }

    @Override
    public Mono<OkrDTO> apply(String userId) {
      return    okrRepository.findByUserId(userId)
               .map(mapperUtils.okrEntityToOkrDTO())
               .flatMap(joinOkrWithKr())
               .flatMap(Utilities::modifiedProgressOkr)
               .collect(Collectors.maxBy(Comparator.comparing(OkrDTO::getProgressOkr)))
               .flatMap(okrDTO -> Mono.just(okrDTO.orElse(errorReturnDefault(userId)))
               );

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
                        });

    }

    private OkrDTO errorReturnDefault(String userId){
        OkrDTO okrDTO = new OkrDTO("00",userId, "insertar Okr", "insertar titulo","insertar nombre",
                "insertar email", "insertar vertival", "insertar descripcion");
        okrDTO.setProgressOkr(0L);
        okrDTO.getKrs().add(new KrDTO("00", "01", "insertar kr", "insertar kr",
                "insertarkr", "insertar kr", 0,
                LocalDate.now(), LocalDate.now(),0));
        return okrDTO;
    }
}
