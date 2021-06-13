package com.sofka.retofinal.usecase;

import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.repository.KrRepository;
import com.sofka.retofinal.repository.OkrRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class DeleteUseCase implements Function<String, Mono<Void>> {
    private final OkrRepository okrRepository;
    private final KrRepository krRepository;
    private final MapperUtils mapperUtils;

    public DeleteUseCase(OkrRepository okrRepository, KrRepository krRepository, MapperUtils mapperUtils) {
        this.okrRepository = okrRepository;
        this.krRepository = krRepository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<Void> apply(String id) {
        return okrRepository.deleteById(id)
                .switchIfEmpty(Mono.defer(() -> okrRepository.deleteById(id)))
                ;
    }
}
