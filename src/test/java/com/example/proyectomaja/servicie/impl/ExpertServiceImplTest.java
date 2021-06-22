package com.example.proyectomaja.servicie.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.example.proyectomaja.dao.ExpertDAO;
import com.example.proyectomaja.domain.Expert;
import com.example.proyectomaja.repository.ExpertRepository;
import com.example.proyectomaja.services.impl.ExpertServiceImpl;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;






@SpringBootTest
class ExpertServiceImplTest {

    @Mock
    private DataSource dataSource;
    @InjectMocks
    private ExpertServiceImpl expertService;
    @Mock
    private ExpertRepository repository;
   @Mock
    private ExpertDAO expertDao;



    @Test
    void createExpert()  throws  Exception{
        Expert expert = new Expert();
        expert.setNombre("Juan Valera");
        expert.setNif("123456789v");
        expert.setEmail("jv@dominio.com");
        expert.setNif("12345566v");
        expertService.save(expert);
        assertNotNull(expert.getId());
        Expert findExpert = (expertService.findById(expert.getId()));


    }

    @Test
    void findAll() {
    }

    @Test
    void findOne() {
    }

    @Test
    void updateExpert() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findAllPage() {
    }

    @Test
    void findByName() {
    }
}
