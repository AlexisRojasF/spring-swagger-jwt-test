package prueba.service;

import prueba.models.entity.Area;

import java.util.List;
import java.util.Optional;

public interface AreaService {

    Optional<Area> findBuId(Long id);

    Optional<Area> findBtName(String name);

    List<Area> findAll();

    Area save(Area area);

    boolean delete(Long id);

}
