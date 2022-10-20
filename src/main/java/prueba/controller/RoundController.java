package prueba.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.models.entity.Round;
import prueba.models.models.SingleDate;
import prueba.models.models.SingleLong;
import prueba.service.RoundService;

import javax.validation.Valid;

@RestController
@RequestMapping("/round")
public class RoundController {

    @Autowired
    private RoundService service;

    @ApiOperation("Crea una nuevo registro en la base de datos")
    @ApiResponse(code = 200,message = "Round entity")
    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Round round){

        Round roundSave = service.Save(round);

        if (roundSave.equals(null)){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(roundSave);

    }
    @ApiOperation("Modifica una nuevo registro en la base de datos")
    @ApiResponse(code = 200,message = "Round entity")
    @PutMapping("/save")
    public ResponseEntity<?> saveEdit(@Valid @RequestBody Round round){

        Round roundSave = service.Save(round);

        if (roundSave.equals(null)){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(roundSave);

    }
    @ApiOperation("Elimina un registro por id o pk ")
    @ApiResponse(code = 200,message = "")
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody SingleLong id){

        service.delete(id.getId());

        return ResponseEntity.noContent().build();
    }
    @ApiOperation("Resgitra la entrada a un usuario, debe ingresar el id del resgitro")
    @ApiResponse(code = 200,message = "Fecha añadida")
    @PostMapping("/entry")
    public ResponseEntity<?> entry(@RequestBody SingleDate date){

       Round round = service.entry(date.getDate(),date.getId());

        return ResponseEntity.ok("Fecha añadida");
    }

    @ApiOperation("Resgitra una salida a un usuario, debe ingresar el id del resgitro")
    @ApiResponse(code = 200,message = "Fecha añadida")
    @PostMapping("/exit")
    public ResponseEntity<?> exit(@RequestBody SingleDate date){

        Round round = service.exit(date.getDate(),date.getId());

        return ResponseEntity.ok("Fecha añadida");
    }







}
