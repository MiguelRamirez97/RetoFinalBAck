package com.sofka.retofinal.repository;

import com.sofka.retofinal.collections.KrEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface KrRepository extends ReactiveCrudRepository<KrEntity,String> {
}
