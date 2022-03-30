package com.two57.pets.entity;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public record Visit(@Id Integer id, Integer petId, LocalDate visitDate, Integer vetId, String description) {
}
