package com.two57.customers.controller;

import com.two57.customers.entity.Customer;
import com.two57.customers.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository repo;

    @GetMapping
    public Flux<Customer> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> findById(@PathVariable Integer id) {
        return Mono.error(new RuntimeException(String.format("Unable to find customer: %s", id)));
        //return repo.findById(id);
    }
}
