package com.example.proyectomaja.repository;

import com.example.proyectomaja.domain.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository  extends JpaRepository<Expert,Long>, PagingAndSortingRepository<Expert, Long>,
        JpaSpecificationExecutor<Expert> {}
