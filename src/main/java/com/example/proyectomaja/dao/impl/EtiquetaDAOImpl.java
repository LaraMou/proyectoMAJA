package com.example.proyectomaja.dao.impl;

import com.example.proyectomaja.dao.EtiquetaDAO;
import com.example.proyectomaja.domain.Etiqueta;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
@Repository
public class EtiquetaDAOImpl implements EtiquetaDAO {

    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Etiqueta> findAllEtiquetas() {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Etiqueta> criteriaQuery = criteriaBuilder.createQuery(Etiqueta.class);
        Root<Etiqueta> itemRoot = criteriaQuery.from(Etiqueta.class);
        criteriaQuery.select(itemRoot);

        List<Etiqueta> items = manager.createQuery(criteriaQuery).getResultList();
        manager.close();
        return items;
    }

    @Override
    public Optional<Etiqueta> findEtiquetaById(Long id) {
        return Optional.empty();
    }
    // TODO: 21/04/2021

//    public Optional<Etiqueta> findEtiquetaById(Long id) {
//        if(id!=null) {
//            CriteriaBuilder builder = manager.getCriteriaBuilder();
//            CriteriaQuery<Etiqueta> criteria = builder.createQuery(Etiqueta.class);
//            Root<Etiqueta> root = criteria.from(Etiqueta.class);
//            criteria.select(root);
//            criteria.where(builder.equal(root.get("id"), id));
//            Etiqueta item = manager.createQuery(criteria).getSingleResult();
//            manager.close();
//            return Optional.of(item);
//        }
//        return Optional.empty();
//    }


}
