package com.example.proyectomaja.dao.impl;

import com.example.proyectomaja.dao.ExpertDAO;

import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Expert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ExpertDAOImpl implements ExpertDAO {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Expert> findAll(Integer paginacion, Integer limite) {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteriaQuery = criteriaBuilder.createQuery(Expert.class);
        Root<Expert> root = criteriaQuery.from(Expert.class);
        criteriaQuery.select(root);
        Query query = manager.createQuery(criteriaQuery);
        query.setMaxResults(limite);
        query.setFirstResult(paginacion);
        manager.close();
        return query.getResultList();
    }

    @Override
    public List<Expert> findAllByNombre(String nombre, Integer paginacion, Integer limite) {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteriaQuery = criteriaBuilder.createQuery(Expert.class);
        Root<Expert> root = criteriaQuery.from(Expert.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(root.get("nombre"),nombre + '%'));
        Query query = manager.createQuery(criteriaQuery);
        query.setMaxResults(limite);
        query.setFirstResult(paginacion);
        manager.close();
        return query.getResultList();
    }

    @Override
    public List<Expert> findAllByEstado(String estado, Integer paginacion, Integer limite) {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteriaQuery = criteriaBuilder.createQuery(Expert.class);
        Root<Expert> root = criteriaQuery.from(Expert.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(root.get("estado"),estado + '%'));
        Query query = manager.createQuery(criteriaQuery);
        query.setMaxResults(limite);
        query.setFirstResult(paginacion);
        manager.close();
        return query.getResultList();
    }

    @Override
    public List<Expert> findAllByModalidad(String modalidad, Integer paginacion, Integer limite) {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteriaQuery = criteriaBuilder.createQuery(Expert.class);
        Root<Expert> root = criteriaQuery.from(Expert.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(root.get("modalidad"),modalidad + '%'));
        Query query = manager.createQuery(criteriaQuery);
        query.setMaxResults(limite);
        query.setFirstResult(paginacion);
        manager.close();
        return query.getResultList();
    }

    @Override
    public List<Etiqueta> findAllEtiqueta(String etiqueta, Integer paginacion, Integer limite) {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteriaQuery = criteriaBuilder.createQuery(Expert.class);
        Root<Expert> root = criteriaQuery.from(Expert.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(root.get("etiquetas"),etiqueta));
        Query query = manager.createQuery(criteriaQuery);
        query.setMaxResults(limite);
        query.setFirstResult(paginacion);
        manager.close();
        return query.getResultList();
    }




}
