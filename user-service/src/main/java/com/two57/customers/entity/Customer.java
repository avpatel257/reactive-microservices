package com.two57.customers.entity;

import org.springframework.data.annotation.Id;

public record Customer(
        @Id Integer id,
        String firstName,
        String lastName,
        String address,
        String city,
        String telephone) {
}
