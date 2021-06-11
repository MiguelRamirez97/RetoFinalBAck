package com.sofka.retofinal.repository;

import com.sofka.retofinal.collections.HistoryOkrEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface HistoryOkrRepository extends ReactiveCrudRepository<HistoryOkrEntity,String> {

    Flux<HistoryOkrEntity> findByOkrId(String okrId);
    Flux<HistoryOkrEntity> findByDateUpdate(String date);
}
