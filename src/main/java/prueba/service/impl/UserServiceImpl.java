package prueba.service.impl;

import lombok.AllArgsConstructor;
import prueba.models.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.repository.UserRepository;
import prueba.service.UserService;


import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    /**
     * Busca un usuario por ID o PK
     */
    public Optional<User> FindByPk(Long id) {
        return repository.findById(id);
    }



    @Override
    /**
     * Busca un usuario por email
     */
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    /**
     * Busca un usuario por idenficacion
     */
    public Optional<User> findByNumId(String id) {
        return repository.findByNumId(id);
    }

    @Override
    /**
     * Genera correo con un formato en especifico
     * Valida no exist el correo
     * creo  o modifica usuario
     */
    public User Save(User user) {
        String email;
        String emailUsa;
        String emailFinal;
        String base;
        boolean exists = true;
        int num = 0;

        if (user.getCountry().equals("cop")){

            base = user.getName_one().toLowerCase() + "." +
                    user.getLast_name_one().toLowerCase() ;
            email = "@cidenet.com.co";
            emailFinal = base + email;

        }else{
            base = user.getName_one().toLowerCase() + "." +
                    user.getLast_name_one().toLowerCase() ;

            email = "@cidenet.com.us";
            emailFinal = base+email;
        }


        do{
            Optional<User> userExists = findByEmail(emailFinal);

            if (userExists.isPresent()){
                emailFinal = base +"."+num + email;
                num ++;
                exists = true;
            }else{
                user.setEmail(emailFinal);
                exists = false;
            }
        }while(exists == true);

        user.setCreate_at(new Date());
        user.setStatus(true);

        return repository.save(user);
    }

    @Override
    public void delete(Long id) {

        Optional<User> user = repository.findById(id);

        if (user.isPresent()){
            repository.deleteById(id);
        }

    }
}
