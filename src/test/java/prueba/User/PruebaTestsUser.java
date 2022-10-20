package prueba.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import prueba.models.entity.User;
import prueba.repository.UserRepository;
import prueba.service.UserService;
import prueba.service.impl.UserServiceImpl;

import java.util.Optional;

@SpringBootTest
public class PruebaTestsUser {

    @MockBean
    UserRepository userRepository;

    @Autowired
    UserService service;

    Optional<User> user = Optional.of(new User());


    @BeforeEach
    void setUp() {


    }

    @Test
    void contextLoads() {
        when(userRepository.findByNumId("1116270821")).thenReturn(user);
        Optional<User> user2 = service.findByNumId("1116270821");
        String id = user2.get().getNumId();
        Assertions.assertEquals(null,id);
    }

    @Test
    void ExistUserById() {
      //  when(userRepository.findByNumId("1116270821")).thenReturn(user);




    }
}
