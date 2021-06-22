package com.example.proyectomaja.services;

import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Expert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExpertService {



    public List<Expert> findAll(Integer paginacion,Integer limite);

    public List<Expert> findAllByNombre(String nombre, Integer paginacion,Integer limite);
    public List<Expert> findAllByEstado(String estado, Integer paginacion,Integer limite);
    public List<Expert> findAllByModalidad(String modalidad, Integer paginacion,Integer limite);

    public Expert findById(Long id);

    public Expert save(Expert experto);

    public void delete(Long id);
    List<Etiqueta> findAllEtiqueta(String etiqueta, Integer paginacion,Integer limite);



}
