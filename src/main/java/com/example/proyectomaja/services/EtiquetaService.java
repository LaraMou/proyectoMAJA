package com.example.proyectomaja.services;

import com.example.proyectomaja.domain.Etiqueta;

import java.util.List;

public interface EtiquetaService {

    public List<Etiqueta> findAllEtiquetas();

    public Etiqueta findEtiquetaById(Long id);

    public Etiqueta saveEtiqueta(Etiqueta factura);

    public void deleteEtiquetaById(Long id);

}
