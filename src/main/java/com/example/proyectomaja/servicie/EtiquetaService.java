package com.example.proyectomaja.servicie;

import com.example.proyectomaja.domain.Etiqueta;

import java.util.List;
import java.util.Optional;

public interface EtiquetaService {


    Etiqueta createEtiqueta(Etiqueta etiqueta);
    //REATRIEVE
    List<Etiqueta> findAll();
    Optional<Etiqueta> findOne(Long id);



    //UPDATE
    Etiqueta updateEtiqueta(Etiqueta etiqueta);

    //DELETE
    void deleteById(Long id);

    //PROCESSO


}
