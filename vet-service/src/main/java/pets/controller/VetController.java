package pets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pets.entity.Vet;
import pets.repo.VetRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/vets")
public class VetController {
    @Autowired
    private VetRepository repo;

    @GetMapping
    public Flux<Vet> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Vet> findById(@PathVariable Integer id) {
        return repo.findById(id);
    }
}
