package com.two57.pets.response;

import com.two57.pets.entity.Visit;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VisitResponse {
    private LocalDate visitDate;
    private Vet vet;
    private String description;

    public VisitResponse(Visit visit, Vet vet) {
        this.visitDate = visit.visitDate();
        this.description = visit.description();
        this.vet = vet;
    }
}
