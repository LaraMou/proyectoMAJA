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
public class ProyectoMajaApplication  implements CommandLineRunner {

    @Autowired
    ExpertRepository expertRepository;


    public static void main(String[] args) {
        SpringApplication.run(ProyectoMajaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Etiqueta tag1 = new Etiqueta("Cobol", Instant.now(),"Monica",Instant.now());
        Etiqueta tag2 = new Etiqueta("Java", Instant.now(),"Luis",Instant.now());
    Expert expert1 = new Expert("experto1","nif1","estado1","motivo1",false,"modalidad",true,"9999999","experto1@experto1.com","ciudad1","direccion","linkedin1",1.0,2.0,2.0,"imagen1","stringcv","origen1","observaciones",Instant.now(),Instant.now());



    expert1.getEtiquetas().add(tag1);
    expert1.getEtiquetas().add(tag2);
        tag1.getExperts().add(expert1);
        tag2.getExperts().add(expert1);
        expertRepository.save(expert1);


    }
}
