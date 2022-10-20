package prueba.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import prueba.models.entity.User;
import prueba.repository.UserRepository;
import prueba.service.UserService;
import prueba.service.impl.UserServiceImpl;

import javax.sql.DataSource;
import java.util.Optional;


@DataJpaTest
public class PruebaTestsUser {

    @Autowired
    UserRepository userRepository;



    @Test
    void ExistUserByIdAndCreateUser() {
        Optional<User> user = userRepository.findByNumId("1116270821");
        Assertions.assertTrue(user.isPresent());
        Assertions.assertEquals("brian",user.get().getName_one());
    }
}
