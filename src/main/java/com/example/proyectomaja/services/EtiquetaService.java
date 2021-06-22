package com.example.proyectomaja.services;

import com.example.proyectomaja.domain.Etiqueta;

import java.util.List;

public interface EtiquetaService {

    public List<Etiqueta> findAllEtiquetas(Integer paginacion,Integer limite);

    public List<Etiqueta> findAllByNombre(String nombre, Integer paginacion,Integer limite);

    public Etiqueta findEtiquetaById(Long id);

    public Etiqueta saveEtiqueta(Etiqueta etiqueta);

    public void deleteEtiquetaById(Long id);

}
