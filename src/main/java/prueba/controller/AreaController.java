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
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService service;


    @ApiOperation("Realiza la insercion y modificacion de una nueva Area en la base de datos")
    @ApiResponse(code = 200,message = "Area Entity")
    @PostMapping("/save")
    public ResponseEntity<?> save( @Valid @RequestBody Area area){

        Optional<Area>areaSave = Optional.ofNullable(service.save(area));

        if (areaSave.isEmpty()){
            return ResponseEntity.badRequest().body("No se pudo crear el area");
        }

        return ResponseEntity.ok(areaSave.get());

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

        List<Area> areaList = service.findAll();

        if (areaList.isEmpty()){
            return ResponseEntity.badRequest().body("No se pudo crear la lista de area");
        }
        return ResponseEntity.ok(service.findAll());
    }

    @ApiOperation("Busca en area en especifico por su nombre ")
    @ApiResponse(code = 200,message = "Area Entity")
    @GetMapping("find")
    public ResponseEntity<?> all(@RequestBody SingleData data){

        Optional<Area> area = service.findBtName(data.getData());
        if (area.isEmpty()){
            return ResponseEntity.badRequest().body("No se encontro el area de nombre:" + data.getData());
        }
        return ResponseEntity.ok(service.findBtName(data.getData()));
    }
}
