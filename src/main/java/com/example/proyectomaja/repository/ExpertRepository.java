package com.example.proyectomaja.repository;

import com.example.proyectomaja.domain.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpertRepository  extends JpaRepository<Expert,Long> {
}
