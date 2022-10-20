package prueba.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.models.entity.Area;
import prueba.repository.AreaRepository;
import prueba.service.AreaService;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository repository;

    @Override
    /**
     * Busca un Area por Id
     */
    public Optional<Area> findBuId(Long id) {
        return repository.findById(id);
    }

    @Override
    /**
     * Buscar un Area Por nombre
     */
    public Optional<Area> findBtName(String name) {
        return repository.findByNameArea(name);
    }

    @Override
    /**
     * Trae una lista de todas las areas creadas
     */
    public List<Area> findAll() {
        return (List<Area>) repository.findAll();
    }

    @Override
    /**
     * Guarda o modifica un area
     */
    public Area save(Area area) {
        return repository.save(area);
    }

    @Override
    /**
     * Elimina un area
     */
    public boolean delete(Long id) {

        Optional<Area> area = repository.findById(id);

        if (area.isPresent()){
            repository.delete(area.get());
            return true;
        }

        return false;

    }
}
