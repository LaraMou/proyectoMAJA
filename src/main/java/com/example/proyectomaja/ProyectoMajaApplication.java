package com.example.proyectomaja;

import com.example.proyectomaja.domain.Estado;
import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Expert;
import com.example.proyectomaja.repository.ExpertRepository;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDate;

@SpringBootApplication
public class ProyectoMajaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoMajaApplication.class, args);
    }



}
