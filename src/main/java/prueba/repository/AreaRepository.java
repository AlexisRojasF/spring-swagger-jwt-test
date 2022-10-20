package prueba.repository;

import org.springframework.data.repository.CrudRepository;
import prueba.models.entity.Area;

import java.util.Optional;

public interface AreaRepository extends CrudRepository<Area,Long> {

    Optional<Area> findByNameArea(String name);
}
