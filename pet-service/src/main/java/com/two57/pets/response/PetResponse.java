package com.two57.pets.response;

import com.two57.pets.entity.Pet;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PetResponse extends BaseResponse {
    private Integer id;
    private String name;
    private LocalDate birthDate;
    private String type;
    private Customer owner;
    private List<VisitResponse> visits;

    public PetResponse(Pet pet, Customer customer) {
        this.id = pet.id();
        this.name = pet.name();
        this.birthDate = pet.birthDate();
        this.type = pet.type();
        this.owner = customer;
    }
}
