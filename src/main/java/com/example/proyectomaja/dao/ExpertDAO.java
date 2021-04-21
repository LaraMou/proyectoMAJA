package com.example.proyectomaja.dao;

import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Expert;

import java.util.List;
import java.util.Optional;

public interface ExpertDAO {
    List<Expert> findAllExperts();
    Optional<Expert> findExpertByID(Long id);
    List<Etiqueta> findEtiquetasByID(Long id);

}
