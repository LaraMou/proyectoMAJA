package com.example.proyectomaja.servicie.impl;

import com.example.proyectomaja.domain.Expert;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ExpertSpecification implements Specification<Expert> {
    private Expert filter;

    public ExpertSpecification(Expert filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Expert> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
       Predicate predicate= criteriaBuilder.disjunction();
       if(filter.getNombre()!=null){
           predicate.getExpressions().add(criteriaBuilder.like(root.get("nombre"),"%"+ filter.getNombre()+"%"));
       }


        if (filter.getModalidad()!= null) {

            predicate.getExpressions().add(criteriaBuilder.like(root.get("modalidad"), "%" + filter.getModalidad() + "%"));

        }
        //TODO GET ESTADO


        return  predicate;
    }
}
