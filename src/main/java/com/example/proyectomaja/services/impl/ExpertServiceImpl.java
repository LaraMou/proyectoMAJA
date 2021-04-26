package com.example.proyectomaja.services.impl;

import com.example.proyectomaja.dao.EtiquetaDAO;
import com.example.proyectomaja.dao.ExpertDAO;
import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Expert;

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
    private EtiquetaDAO etiquetaDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Expert> findAll() {
        return expertDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Expert> findAll(Pageable pageable) {
        return expertDAO.findAll(pageable);
    }

    @Override
    public Expert findById(Long id) {
        return expertDAO.findById(id).orElse(null);
    }

    @Override
    public Expert save(Expert experto) {
        return expertDAO.save(experto);
    }

    @Override
    public void delete(Long id) {
        expertDAO.deleteById(id);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Etiqueta> findAllEtiquetas() {
        return expertDAO.findAllEtiqueta();
    }

    @Override
    @Transactional(readOnly = true)
    public Etiqueta findEtiquetaById(Long id) {
        return etiquetaDAO.findById(id).orElse(null);
    }

    @Override
    public Etiqueta saveEtiqueta(Etiqueta etiqueta) {
        return etiquetaDAO.save(etiqueta);
    }

    @Override
    public void deleteEtiquetaById(Long id) {
        etiquetaDAO.deleteById(id);

    }
}
