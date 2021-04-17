package com.example.proyectomaja.dao;

import com.example.proyectomaja.domain.Etiqueta;

import java.util.List;
import java.util.Optional;

public interface EtiquetaDAO {
    List<Etiqueta> findAllEtiquetas();
    Optional<Etiqueta> findEtiquetaById(Long id);
}
