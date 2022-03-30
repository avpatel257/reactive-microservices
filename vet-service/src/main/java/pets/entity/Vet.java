package pets.entity;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public record Vet(
        @Id Integer id,
        String firstName,
        String lastName,
        String speciality) {
}