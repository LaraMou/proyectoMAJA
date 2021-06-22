package com.example.proyectomaja.dao;

import com.example.proyectomaja.domain.Etiqueta;

import java.util.List;

public interface EtiquetaDAO {
    List<Etiqueta> findAllByNombre(String nombre, Integer paginacion, Integer limite);
    List<Etiqueta> findAll(Integer paginacion, Integer limite);

}
