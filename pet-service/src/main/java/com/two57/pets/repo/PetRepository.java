package com.two57.pets.repo;

import com.two57.pets.entity.Pet;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PetRepository extends ReactiveCrudRepository<Pet, Integer> {
}
