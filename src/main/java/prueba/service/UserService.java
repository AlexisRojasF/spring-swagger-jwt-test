package prueba.service;

import prueba.models.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> FindByPk(Long id);

    Optional<User>findByEmail(String email);

    Optional<User>findByNumId(String id);

    User Save(User user);

    void delete(Long id);
}
