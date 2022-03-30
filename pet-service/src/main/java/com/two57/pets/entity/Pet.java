package com.two57.pets.entity;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public record Pet(
        @Id Integer id,
        String name,
        LocalDate birthDate,
        String type,
        Integer ownerId) {
}