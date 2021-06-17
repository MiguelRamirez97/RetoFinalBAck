package com.sofka.retofinal.usecase;

import com.sofka.retofinal.model.KrWeightDTO;
import com.sofka.retofinal.repository.KrRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UpdatePercentageKR {

    private final KrRepository repository;

    public UpdatePercentageKR(KrRepository repository) {
        this.repository = repository;
    }

    public Mono<Void> apply(List<KrWeightDTO> list){
        return Flux.fromIterable(list)
                .flatMap(krWeightDTO -> repository.findById(krWeightDTO.getId())
                        .flatMap(krEntity -> {
                            krEntity.setPercentageWeight(krWeightDTO.getPercentage());
                            return repository.save(krEntity);
                        })).collectList().flatMap(krEntities -> Mono.empty());
    }
}
