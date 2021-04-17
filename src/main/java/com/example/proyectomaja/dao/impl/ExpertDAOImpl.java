package com.example.proyectomaja.dao.impl;

import com.example.proyectomaja.dao.ExpertDAO;
import com.example.proyectomaja.domain.Expert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class ExpertDAOImpl  implements ExpertDAO {

    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Expert> findAllExperts() {
        return null;
    }

    @Override
    public Optional<Expert> findExpertByID(Long id) {
        return Optional.empty();
    }
}
