package com.example.proyectomaja.dao;

import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface ExpertDAO extends JpaRepository<Expert,Long> {
    @Query("from Etiqueta ")
    public List<Etiqueta> findAllEtiqueta();


}
