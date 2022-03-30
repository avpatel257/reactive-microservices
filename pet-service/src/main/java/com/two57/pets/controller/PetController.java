package com.two57.pets.controller;

import com.two57.pets.response.PetResponse;
import com.two57.pets.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService service;

    @GetMapping
    public Flux<PetResponse> findAll() {
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Mono<PetResponse> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
