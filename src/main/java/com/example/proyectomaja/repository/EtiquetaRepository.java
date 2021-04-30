package com.example.proyectomaja.repository;

import com.example.proyectomaja.domain.Etiqueta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtiquetaRepository extends CrudRepository<Etiqueta,Long> {
    @Query("select distinct e from Etiqueta e")
    List<Etiqueta> findAllEtiquetas();
}
