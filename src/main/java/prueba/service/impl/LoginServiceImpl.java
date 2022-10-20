package prueba.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import prueba.service.LoginService;
import prueba.service.UserService;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;



    @Override
    /**
     * Carca el usermane del usuario loggeado y busca que ese usuario exista
     * el usermane  es el numero de identificacion de usuario
     * despues de la verificacion creo un nuevo usuario tipo UseDetails con la imformacion de la db y pasa a respetiba validacion en el sistemas
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<prueba.models.entity.User> userDb = userService.findByNumId(username);

       if (userDb.isEmpty()){
           throw new UsernameNotFoundException("Usuario o password inválidos");

       }
       return  new User(userDb.get().getEmail(),userDb.get().getPassw(),new ArrayList<>());


    }
}
