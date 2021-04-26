package com.example.proyectomaja.services;

import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Expert;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ExpertService {

    public List<Expert> findAll();

    public Page<Expert> findAll(Pageable pageable);

    public Expert findById(Long id);

    public Expert save(Expert experto);

    public void delete(Long id);

    public List<Etiqueta> findAllEtiquetas();

    public Etiqueta findEtiquetaById(Long id);

    public Etiqueta saveEtiqueta(Etiqueta factura);

    public void deleteEtiquetaById(Long id);

}
