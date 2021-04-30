package com.example.proyectomaja.services.impl;

import com.example.proyectomaja.dao.EtiquetaDAO;

import com.example.proyectomaja.dao.ExpertDAO;

import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.repository.EtiquetaRepository;
import com.example.proyectomaja.services.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
public class EtiquetaServiceImpl implements EtiquetaService {
    @Autowired
    private EtiquetaDAO etiquetaDAO;

    @Autowired
    private EtiquetaRepository etiquetaRepository;



    @Autowired
    private ExpertDAO expertDAO;




    @Override
    public List<Etiqueta> findAllEtiquetas(Integer paginacion, Integer limite) {

        List <Etiqueta> etiquetas=etiquetaDAO.findAll(limite,paginacion);

        if(!etiquetas.isEmpty()){
            ///Quitar Repetidos
            HashSet hs = new HashSet();
            hs.addAll(etiquetas);
            etiquetas.clear();
            etiquetas.addAll(hs);

            return etiquetas;
        }
        return etiquetas;
    }

    @Override
    public List<Etiqueta> findAllByNombre(String nombre, Integer paginacion, Integer limite) {
        return etiquetaDAO.findAllByNombre(nombre,paginacion,limite);
    }

    @Override
    @Transactional(readOnly = true)
    public Etiqueta findEtiquetaById(Long id) {
        return etiquetaRepository.findById(id).orElse(null);
    }

    @Override
    public Etiqueta saveEtiqueta(Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    @Override
    public void deleteEtiquetaById(Long id) {
        etiquetaRepository.deleteById(id);

    }

}
