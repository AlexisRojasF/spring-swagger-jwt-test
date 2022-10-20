package prueba.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.models.entity.Area;
import prueba.models.models.SingleData;
import prueba.models.models.SingleLong;
import prueba.service.AreaService;

import javax.validation.Valid;

@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService service;


    @ApiOperation("Realiza la insercion y modificacion de una nueva Area en la base de datos")
    @ApiResponse(code = 200,message = "Area Entity")
    @PostMapping("/save")
    public ResponseEntity<?> save( @Valid @RequestBody Area area){

        Area areaSave = service.save(area);

        if (areaSave.equals(null)){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(areaSave);

    }

    @ApiOperation("Elimina una Area Existente por Id o pk")
    @ApiResponse(code = 200,message = "")
    @DeleteMapping("delete/")
    public ResponseEntity<?> delete(@RequestBody SingleLong id){

        service.delete(id.getId());

        return ResponseEntity.noContent().build();
    }

    @ApiOperation("Trae todos las areas creadas en la base de datos")
    @GetMapping("all")
    @ApiResponse(code = 200,message = "Lista de Areas")
    public ResponseEntity<?> all(){

        return ResponseEntity.ok(service.findAll());
    }

    @ApiOperation("Busca en area en especifico por su nombre ")
    @ApiResponse(code = 200,message = "Area Entity")
    @GetMapping("find")
    public ResponseEntity<?> all(@RequestBody SingleData data){

        return ResponseEntity.ok(service.findBtName(data.getData()));
    }
}
