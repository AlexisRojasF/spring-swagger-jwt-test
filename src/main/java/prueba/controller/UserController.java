package prueba.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.models.entity.User;
import prueba.models.models.SingleData;
import prueba.config.SecurityConfig;
import prueba.models.models.SingleLong;
import prueba.service.UserService;

import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service ;

    @Autowired
    private SecurityConfig securityConfig;

    @ApiOperation("Guarda un nuevo usuario")
    @ApiResponse(code = 200,message = "User entity")
    @PostMapping("/save")
    public ResponseEntity<?> save( @RequestBody User user){

        return CreateUserPassEncry(user);
    }

    @ApiOperation("Modifica un usuario")
    @ApiResponse(code = 200,message = "User entity")
    @PutMapping("/save")
    public ResponseEntity<?> saveEdit( @RequestBody User user){

        return CreateUserPassEncry(user);
    }

    @ApiOperation("Elimina un  usuario")
    @ApiResponse(code = 200,message = "")
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody SingleLong id){
        service.delete(id.getId());

        return ResponseEntity.noContent().build();

    }
    @ApiOperation("Busqeda de un usuario por Email")
    @ApiResponse(code = 200,message = "User entity")
    @GetMapping("/email")
    public ResponseEntity<?> findEmail(@RequestBody SingleData data){
        Optional<User> email = service.findByEmail(data.getData());

        if(email.isPresent()){
            return ResponseEntity.ok(email.get());
        }
        return ResponseEntity.badRequest().body("No se encontro el Email: "+ data.getData());


    }

    @ApiOperation("Busqeda de un usuario por id o pk")
    @ApiResponse(code = 200,message = "User entity")
    @GetMapping("/find")
    public ResponseEntity<?> find(@RequestBody SingleLong id){


        Optional<User> user = service.FindByPk(id.getId());
        if (user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.badRequest().body("No se encontro la llave: "+id.getId());

    }

    @ApiOperation("Busqeda de un usuario por identificacion")
    @ApiResponse(code = 200,message = "User entity")
    @GetMapping("/find/cc")
    public ResponseEntity<?> findbyid(@RequestBody SingleData data){
        Optional<User> user = service.findByNumId(data.getData());
        if (user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
         return ResponseEntity.badRequest().body("No se encontro el docuemntos de identidad: "+ data.getData());
    }


    private ResponseEntity<?> CreateUserPassEncry(@RequestBody User user) {
        user.setPassw(securityConfig.passwordEncoder().encode(user.getPassw()));

        Optional<User> userSave = Optional.ofNullable(service.Save(user));

        if (userSave.isEmpty()){
            return ResponseEntity.badRequest().body("No se pudo crear el usuario");
        }

        return ResponseEntity.ok(userSave.get());
    }
}
