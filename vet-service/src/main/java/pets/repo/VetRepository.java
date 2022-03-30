package pets.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import pets.entity.Vet;

public interface VetRepository extends ReactiveCrudRepository<Vet, Integer> {
}
