package prueba.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import prueba.models.entity.Round;
import prueba.models.entity.User;
import prueba.repository.RoundRepository;
import prueba.repository.UserRepository;
import prueba.service.RoundService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class RoundServiceImpl implements RoundService {

    @Autowired
    private RoundRepository roundRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    /**
     * Busca un Registro por ID oPk
     */
    public Optional<Round> FindByPk(Long id) {

        return roundRepository.findById(id);
    }

    @Override
    /**
     * Guarda o modifica un Registro
     */
    public Round Save(Round round) {

        Optional<User> user = userRepository.findById(round.getUser().getUser_id());

        if (user.isEmpty()){
            return null;
        }

        round.setUser(user.get());

        return roundRepository.save(round);
    }

    @Override
    /**
     * Valida que la fecha ingresada este en el margen de los 30 dias habiles
     * y guarda la nueva fecha en la base de datos como entrada de ese usuario
     */
    public Round entry(Date entry, Long id) {

        Optional<Round> round = roundRepository.findById(id);

        Date now = new Date();

        Long time = now.getTime() - entry.getTime();

        TimeUnit unidad = TimeUnit.DAYS;

        Long dias = unidad.convert(time,TimeUnit.MILLISECONDS);


        if(dias <= 30 ){

            if (round.isPresent() ){
                return roundRepository.save(round.get());
            }
        }

        return null;

    }

    @Override
    /**
     * Regisytra fecha de salida del usuario
     */
    public Round exit(Date exit, Long id) {
        Optional<Round> round = roundRepository.findById(id);

        Date date= new Date();

        if (round.isPresent()){

            return roundRepository.save(round.get());
        }

        return null;
    }

    @Override
    /**
     * Lista todos los registros de la base de datos
     */
    public List<Round> findAll() {
        return (List<Round>) roundRepository.findAll();
    }


    @Override
    /**
     * Elimina Registro de la base de datos
     */
    public void delete(Long id) {

        Optional<Round> user = roundRepository.findById(id);
        if (user.isPresent()){
            roundRepository.deleteById(id);
        }

    }
}
