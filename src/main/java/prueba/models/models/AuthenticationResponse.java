package prueba.models.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
/**
 * Clase para Mapear Json wed tokrn generado
 */
public class AuthenticationResponse {

    private String jwt;
}
