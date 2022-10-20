package prueba.models.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Clase para Mapear las crediciales del loggin
 */
public class AuthenticationRequest {

    private String username;
    private String password;
}
