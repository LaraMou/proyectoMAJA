package com.example.proyectomaja.repository;

import com.example.proyectomaja.domain.Expert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ExpertRepository  extends JpaRepository<Expert,Long>, PagingAndSortingRepository<Expert, Long>,
        JpaSpecificationExecutor<Expert> {

    Page<Expert> findByNombre(String nombre, Pageable pageable);
    Page<Expert> findByModalidad(String modalidad, Pageable pageable);
//    Page<Expert> findByNameTag(String nameTag, Pageable pageable);
    
}
