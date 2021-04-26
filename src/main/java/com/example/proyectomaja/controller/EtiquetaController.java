package com.example.proyectomaja.controller;


import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.services.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EtiquetaController {


    @Autowired
    private EtiquetaService etiquetaService;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/etiquetas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Etiqueta show(@PathVariable Long id) {
        return etiquetaService.findEtiquetaById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/etiquetas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        etiquetaService.deleteEtiquetaById(id);
    }



    @Secured({"ROLE_ADMIN"})
    @PostMapping("/etiquetas")
    @ResponseStatus(HttpStatus.CREATED)
    public Etiqueta crear(@RequestBody Etiqueta factura) {
        return etiquetaService.saveEtiqueta(factura);
    }
}
