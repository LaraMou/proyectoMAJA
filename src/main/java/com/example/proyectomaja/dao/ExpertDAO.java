package com.example.proyectomaja.dao;

import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Expert;

import java.util.List;

public interface ExpertDAO {
    List<Expert> findAll( Integer paginacion,Integer limite);
    List<Expert> findAllByNombre(String nombre, Integer paginacion,Integer limite);
    List<Expert> findAllByEstado(String estado, Integer paginacion,Integer limite);
    List<Expert> findAllByModalidad(String modalidad, Integer paginacion,Integer limite);
    List<Etiqueta> findAllEtiqueta(String etiqueta, Integer paginacion,Integer limite);


}
