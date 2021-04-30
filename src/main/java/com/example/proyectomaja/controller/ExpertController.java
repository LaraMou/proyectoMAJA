package com.example.proyectomaja.controller;



import com.example.proyectomaja.domain.Expert;
import com.example.proyectomaja.services.ExpertService;
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

@CrossOrigin(origins = { "https://proyecto-final-monica-lara.vercel.app" },methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api")
public class ExpertController {
    @Autowired
    private ExpertService expertoService;


    /**
     * Filtros de expertos pendiente de implmentar en angular
     * @return
     */
    @GetMapping("/expertos")
    public List<Expert> index(@RequestParam(name = "estado", required = false) String estado,
                              @RequestParam(name = "modalidad", required = false) String modalidad,
                              @RequestParam(name = "nombre", required = false) String nombre,
                              @RequestParam(name = "limit", required = false, defaultValue = "20") Integer limit,
                              @RequestParam(name = "page", required = false, defaultValue = "0") Integer page ) {
        if(estado!=null){
            return expertoService.findAllByEstado(estado,page,limit);
        }else if(modalidad!=null){
            return expertoService.findAllByModalidad(modalidad,page,limit);
        }else if(nombre!=null) {
            return expertoService.findAllByNombre(nombre, page, limit);
        }else{
            return expertoService.findAll(page,limit);
        }
    }




//    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/expertos/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {

        Expert experto = null;
        Map<String, Object> response = new HashMap<>();

        try {
            experto = expertoService.findById(id);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(experto == null) {
            response.put("mensaje", "El experto ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Expert>(experto, HttpStatus.OK);
    }

//    @Secured("ROLE_ADMIN")
    @PostMapping("/expertos")
    public ResponseEntity<?> create(@Valid @RequestBody Expert experto, BindingResult result) {

        Expert expertoNew = null;
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            expertoNew = expertoService.save(experto);
            System.out.println("Experto"+experto);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El experto ha sido creado con éxito!");
        response.put("experto", expertoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    private void tratarCreateUpdate() {
    }

    //    @Secured("ROLE_ADMIN")
    @PutMapping("/expertos/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Expert experto, BindingResult result, @PathVariable Long id) {
        Expert expertoActual = expertoService.findById(id);

        Expert expertoUpdated = null;

        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if (expertoActual == null) {
            response.put("mensaje", "Error: no se pudo editar, el experto ID: "
                    .concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {

            validacionActualizar(expertoActual,experto);
            expertoUpdated = expertoService.save(expertoActual);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el experto en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El experto ha sido actualizado con éxito!");
        response.put("experto", expertoUpdated);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    private Expert validacionActualizar(Expert expertoActual, Expert experto) {
        if(expertoActual.getNombre()!=experto.getNombre())
            expertoActual.setNombre(experto.getNombre());
        if(expertoActual.getEmail()!=experto.getEmail())
            expertoActual.setEmail(experto.getEmail());
        if(expertoActual.getMotivo()!=experto.getMotivo())
            expertoActual.setMotivo(experto.getMotivo());
        if(expertoActual.getAutonomo()!=experto.getAutonomo())
             expertoActual.setAutonomo(experto.getAutonomo());
        if(expertoActual.getCreatedDate()!=experto.getCreatedDate())
            expertoActual.setCreatedDate(experto.getCreatedDate());
        if(expertoActual.getCiudad()!=experto.getCiudad())
            expertoActual.setCiudad(experto.getCiudad());
        if(expertoActual.getCv()!=experto.getCv())
            expertoActual.setCv(experto.getCv());
        if(expertoActual.getDireccion()!= experto.getDireccion())
            expertoActual.setDireccion(experto.getDireccion());
        if(expertoActual.getEstado()!=experto.getEstado())
            expertoActual.setEstado(experto.getEstado());
        if(expertoActual.getDisponibilidad()!=experto.getDisponibilidad())
            expertoActual.setDisponibilidad(experto.getDisponibilidad());
        if(expertoActual.getModalidad()!=experto.getModalidad())
            expertoActual.setModalidad(experto.getModalidad());
        if(expertoActual.getObservaciones()!=experto.getObservaciones())
            expertoActual.setObservaciones(experto.getObservaciones());
        if(expertoActual.getLinkedIn()!=experto.getLinkedIn())
            expertoActual.setLinkedIn(experto.getLinkedIn());
        if(expertoActual.getPuntuacion()!=experto.getPuntuacion())
            expertoActual.setPuntuacion(experto.getPuntuacion());
        return expertoActual;
    }


    //    @Secured("ROLE_ADMIN")
    @DeleteMapping("/expertos/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        try {
            Expert experto = expertoService.findById(id);
//            String nombreFotoAnterior = experto.getFoto();
//
//            uploadService.eliminar(nombreFotoAnterior);

            expertoService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el experto de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El experto eliminado con éxito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
