package com.example.proyectomaja.controller;


import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Expert;
import com.example.proyectomaja.services.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EtiquetaController {


    @Autowired
    private EtiquetaService etiquetaService;


    @GetMapping("/etiquetas")
    public List<Etiqueta> index(@RequestParam(name = "nombre", required = false) String nombre,
                                @RequestParam(name = "limit", required = false, defaultValue = "20") Integer limit,
                                @RequestParam(name = "page", required = false, defaultValue = "0") Integer page){
        if(nombre!=null){
        return etiquetaService.findAllByNombre(nombre,page,limit);
        }else{
            return etiquetaService.findAllEtiquetas(page,limit);
        }
    }


    @GetMapping("/etiquetas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Etiqueta show(@PathVariable Long id) {
        return etiquetaService.findEtiquetaById(id);
    }


    @DeleteMapping("/etiquetas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Etiqueta etiqueta = etiquetaService.findEtiquetaById(id);


            etiquetaService.deleteEtiquetaById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar la etiqueta de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "Etiqueta eliminada con éxito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }



    @PostMapping("/etiquetas")
    @ResponseStatus(HttpStatus.CREATED)
    public Etiqueta crear(@RequestBody Etiqueta etiqueta) {
        System.out.println("Entrar aqui+ "+ etiqueta);
        return etiquetaService.saveEtiqueta(etiqueta);
    }

    @PutMapping("/etiquetas/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Etiqueta etiqueta, BindingResult result, @PathVariable Long id) {

        Etiqueta etiquetaActual = etiquetaService.findEtiquetaById(id);

        Etiqueta etiquetaUpdated = null;

        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if (etiquetaActual == null) {
            response.put("mensaje", "Error: no se pudo editar, el etiqueta ID: "
                    .concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {


            etiquetaActual.setNombre(etiqueta.getNombre());
            etiquetaActual.setLastModifiedBy(etiqueta.getLastModifiedBy());
            etiquetaActual.setCreatedDate(etiqueta.getCreatedDate());


            etiquetaUpdated = etiquetaService.saveEtiqueta(etiquetaActual);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el etiqueta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El etiqueta ha sido actualizado con éxito!");
        response.put("etiqueta", etiquetaUpdated);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
