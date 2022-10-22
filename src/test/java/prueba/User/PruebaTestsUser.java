package prueba.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import prueba.models.entity.User;
import prueba.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@DataJpaTest
public class PruebaTestsUser {

    @Autowired
    UserRepository userRepository;


    @Test
    void ExistUserById() {
        Optional<User> user = userRepository.findByNumId("1116270821");
        Assertions.assertTrue(user.isPresent());
        Assertions.assertEquals("brian",user.get().getName_one());
    }

    @Test
    void ExistUserByEmail() {

        Optional<User> user2 = userRepository.findByEmail("mariajose@maria.com");
        Assertions.assertTrue(user2.isPresent());
        Assertions.assertEquals("maria",user2.get().getName_one());
    }

    @Test
    void FindAll() {
        List<User> users = (List<User>) userRepository.findAll();
        Assertions.assertFalse(users.isEmpty());
        Assertions.assertEquals(2,users.size());

    }


}
