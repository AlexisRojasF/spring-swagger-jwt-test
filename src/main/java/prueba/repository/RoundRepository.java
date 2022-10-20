package prueba.repository;


import org.springframework.data.repository.CrudRepository;
import prueba.models.entity.Round;

public interface RoundRepository extends CrudRepository<Round,Long> {
}
