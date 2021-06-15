package com.sofka.retofinal.usecase;

import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.repository.OkrRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@Service
@Validated
public class UpdateOKR {

    private final OkrRepository repository;

    public UpdateOKR(OkrRepository repository) {
        this.repository = repository;
    }

    public Mono<Void> apply(@Valid OkrDTO dto) {
        return repository.findById(dto.getId())
                .flatMap(okrEntity -> {
                    okrEntity.setTitle(dto.getTitle());
                    okrEntity.setDescription(dto.getDescription());
                    okrEntity.setResponEmail(dto.getResponEmail());
                    okrEntity.setResponName(dto.getResponName());
                    okrEntity.setVertical(dto.getVertical());
                    okrEntity.setObjective(dto.getObjective());
                    return repository.save(okrEntity);
                }).flatMap(okrEntity -> Mono.empty());
    }

}
