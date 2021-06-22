package com.example.proyectomaja.dao.impl;

import com.example.proyectomaja.dao.EtiquetaDAO;

import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Expert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EtiquetaDAOImpl  implements EtiquetaDAO {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Etiqueta> findAllByNombre(String nombre, Integer paginacion, Integer limite) {
        if(nombre!=null) {
            CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
            CriteriaQuery<Etiqueta> criteriaQuery = criteriaBuilder.createQuery(Etiqueta.class);
            Root<Etiqueta> root = criteriaQuery.from(Etiqueta.class);
            criteriaQuery.select(root);
            criteriaQuery.where(criteriaBuilder.like(root.get("nombre"), nombre + '%'));
            Query query = manager.createQuery(criteriaQuery);
            query.setMaxResults(limite);
            query.setFirstResult(paginacion);
            manager.close();
            return query.getResultList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Etiqueta> findAll( Integer limite,Integer paginacion) {

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Etiqueta> criteriaQuery = criteriaBuilder.createQuery(Etiqueta.class);
        Root<Etiqueta> root = criteriaQuery.from(Etiqueta.class);
        criteriaQuery.select(root);
        Query query = manager.createQuery(criteriaQuery);
        query.setMaxResults(limite);
        query.setFirstResult(paginacion);
        manager.close();
        return query.getResultList();

    }
}
