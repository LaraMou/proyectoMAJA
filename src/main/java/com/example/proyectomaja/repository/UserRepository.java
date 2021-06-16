package com.example.proyectomaja.repository;


import com.example.proyectomaja.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    User  findUserByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
