package com.two57.pets.service;

import com.two57.pets.repo.PetRepository;
import com.two57.pets.response.Customer;
import com.two57.pets.response.PetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Service class to get pets from repo and hydrate the owners by making a rest call to get owner by id
 */
@Service
@Slf4j
public class PetService {
    @Autowired
    private PetRepository repo;

    @Autowired
    private WebClient customerService;


    public Flux<PetResponse> findAll() {
        return repo.findAll().flatMap(pet -> getCustomer(pet.id()).map(cust ->
                new PetResponse(pet, cust)
        ));
    }

    public Mono<PetResponse> findById(Integer id) {
        return repo.findById(id)
                .flatMap(pet -> getCustomer(pet.id()).map(cust ->
                        new PetResponse(pet, cust)
                ));
    }

    private Mono<Customer> getCustomer(Integer id) {
        return customerService.get()
                .uri("/customers/" + id)
                .exchangeToMono(resp -> {
                    //Error handling
                    if (resp.statusCode().isError()) {// or resp.statusCode().value() >= 400
                        logTraceResponse(resp);
                        //Decide if you want to throw error, or return empty response her
                        return Mono.just(new Customer());
                        //return resp.createException().flatMap(Mono::error);
                    }
                    return resp.bodyToMono(Customer.class);
                });
    }

    private void logTraceResponse(ClientResponse response) {
        if (log.isWarnEnabled()) {
            log.trace("Response status: {}", response.statusCode());
            log.trace("Response headers: {}", response.headers().asHttpHeaders());
            response.bodyToMono(String.class)
                    .publishOn(Schedulers.boundedElastic())
                    .subscribe(body -> log.trace("Response body: {}", body));
        }
    }
}
