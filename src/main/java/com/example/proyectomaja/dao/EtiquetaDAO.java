package com.example.proyectomaja.dao;

import com.example.proyectomaja.domain.Etiqueta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EtiquetaDAO extends CrudRepository<Etiqueta,Long> {

}
