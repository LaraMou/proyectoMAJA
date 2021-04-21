package com.example.proyectomaja.controller;


import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Expert;
import com.example.proyectomaja.exception.BadResourceException;
import com.example.proyectomaja.exception.ResourceAlreadyExistsException;
import com.example.proyectomaja.exception.ResourceNotFoundException;
import com.example.proyectomaja.servicie.ExpertService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@ApiOperation(value = "Find all expert")
public class ExpertController {
    @Value("${message}")
    private String messagetest;
    private final Logger log = LoggerFactory.getLogger(ExpertController.class);
    private final ExpertService expertService;
    private final int ROW_PER_PAGE = 5;
    public ExpertController(ExpertService expertService) {
        this.expertService = expertService;
    }

  @PostMapping("/expertos")
    @ApiOperation("Crear un expert")
    public ResponseEntity<Expert> createExpert(@RequestBody Expert expert) throws URISyntaxException, BadResourceException, ResourceAlreadyExistsException {
        log.debug("REST request to save a expert{}",expert);
        if(expert.getId()!=null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Expert expertcreated = expertService.createExpert(expert);

        return ResponseEntity
                .created(new URI("/api/expertos/"+expertcreated.getId()))
                .body(expertcreated);

    }
    @GetMapping("/expertos")
    @ApiOperation("Encontrar todos los expertos")
    public List<Expert> findAllExpert(){
        System.out.println(messagetest);
        log.debug("Rest request all Expert");
        return expertService.findAll();
    }

    @GetMapping("/expertos/{id}")
    @ApiOperation("Encontrar un experto")
    public ResponseEntity<Expert> findOneExpert(@PathVariable Long id) throws ResourceNotFoundException {
        log.debug("Rest request a Expert with id: "+ id);
        Optional<Expert> expertOpt = expertService.findOne(id);
        return expertOpt.map(expert -> ResponseEntity.ok().body(expert)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
//    @GetMapping("/expertos/etiqueta/{id}")
//    @ApiOperation("Encontrar etiquetas")
//    public ResponseEntity<List<Etiqueta>>findEtiquetas(@PathVariable Long id) throws ResourceNotFoundException {
//        log.debug("Rest request a Expert with id: "+ id);
//        List<Etiqueta>etiquetaList = expertService.findEtiquetasByID(id);
//        if(etiquetaList.isEmpty())
//            return ResponseEntity.noContent().build();
//        return ResponseEntity.ok().body(etiquetaList);
//    }
    @GetMapping(value = "/expertos")

    public ResponseEntity<List<Expert>> findAll(

            @RequestParam(value="page", defaultValue="1") int pageNumber,

            @RequestParam(required=false) String nombre) {

        if (ObjectUtils.isEmpty(nombre)) {

            return ResponseEntity.ok(expertService.findAllPage(pageNumber, ROW_PER_PAGE));

        }

        else {

            return ResponseEntity.ok(expertService.findByName(nombre, pageNumber, ROW_PER_PAGE));

        }

    }
    @DeleteMapping("/expertos/{id}")
    @ApiOperation("Borrar un experto un experto")
    public ResponseEntity<Void> deleteExpert(@PathVariable Long id){
        log.debug("REST request to delete an expert by id {}", id);
        expertService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
