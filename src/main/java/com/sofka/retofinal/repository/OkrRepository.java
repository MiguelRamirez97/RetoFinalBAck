package com.sofka.retofinal.repository;

import com.sofka.retofinal.collections.OkrEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OkrRepository extends ReactiveCrudRepository<OkrEntity,String> {
    Flux<OkrEntity> findByUserId(String userId);
}
