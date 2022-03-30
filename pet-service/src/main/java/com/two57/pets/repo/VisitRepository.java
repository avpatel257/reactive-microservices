package com.two57.pets.repo;

import com.two57.pets.entity.Visit;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface VisitRepository extends ReactiveCrudRepository<Visit, Integer> {
    public Flux<Visit> findByPetId(Integer id);
}
