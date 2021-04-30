package com.example.proyectomaja.repository;

import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpertRepository  extends JpaRepository<Expert,Long>, PagingAndSortingRepository<Expert, Long>,
        JpaSpecificationExecutor<Expert> {
    @Query("from Etiqueta ")
    public List<Etiqueta> findAllEtiqueta();
    
}
