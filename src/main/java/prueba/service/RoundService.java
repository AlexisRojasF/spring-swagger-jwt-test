package prueba.service;


import prueba.models.entity.Round;


import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RoundService {

    Optional<Round> FindByPk(Long id);

    Round Save(Round round);

    Round entry(Date entry , Long id);
    Round exit(Date exit,Long id);

    List<Round> findAll();

    void delete(Long id);


}
