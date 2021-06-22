package com.example.proyectomaja.services.impl;

import com.example.proyectomaja.dao.EtiquetaDAO;

import com.example.proyectomaja.dao.ExpertDAO;

import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Expert;
import com.example.proyectomaja.repository.ExpertRepository;
import com.example.proyectomaja.services.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExpertServiceImpl implements ExpertService {

    @Autowired
    private ExpertDAO expertDAO;

    @Autowired
    private ExpertRepository expertRepository;

    @Autowired
    private EtiquetaDAO etiquetaDAO;



    @Override
    public List<Expert> findAll(Integer paginacion, Integer limite) {
        return expertDAO.findAll(paginacion, limite);
    }

    @Override
    public List<Expert> findAllByNombre(String nombre, Integer paginacion, Integer limite) {
        return expertDAO.findAllByNombre(nombre,paginacion,limite);
    }

    @Override
    public List<Expert> findAllByEstado(String estado, Integer paginacion, Integer limite) {
       return expertDAO.findAllByEstado(estado,paginacion,limite);
    }

    @Override
    public List<Expert> findAllByModalidad(String modalidad, Integer paginacion, Integer limite) {
        return expertDAO.findAllByModalidad(modalidad,paginacion,limite);
    }


    @Override
    public Expert findById(Long id) {
        return expertRepository.findById(id).orElse(null);
    }

    @Override
    public Expert save(Expert experto) {
        return expertRepository.save(experto);
    }

    @Override
    public void delete(Long id) {
        expertRepository.deleteById(id);

    }

    @Override
    public List<Etiqueta> findAllEtiqueta(String etiqueta, Integer paginacion, Integer limite) {
        return expertDAO.findAllEtiqueta(etiqueta,paginacion,limite);
    }



//    @Override
//    public List<Etiqueta> findAllEtiqueta() {
//        return expertRepository.findAllEtiqueta();
//    }
//
//
}
