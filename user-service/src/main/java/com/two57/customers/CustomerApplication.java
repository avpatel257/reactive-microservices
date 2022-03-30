package com.two57.customers;

import com.two57.customers.entity.Customer;
import com.two57.customers.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class CustomerApplication {
    public static void main(String[] args) {
        System.out.println(args);
        SpringApplication.run(CustomerApplication.class, args);
    }
}

//@Component
//class SampleDataInitializer implements ApplicationRunner {
//    @Autowired
//    private CustomerRepository repo;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        //fetch
//        Flux<Customer> all = repo.findAll();
//        all.subscribe(System.out::println);
//
//    }
//}

