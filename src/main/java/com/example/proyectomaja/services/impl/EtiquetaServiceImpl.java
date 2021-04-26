package com.example.proyectomaja.services.impl;

import com.example.proyectomaja.dao.EtiquetaDAO;
import com.example.proyectomaja.dao.ExpertDAO;
import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.services.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EtiquetaServiceImpl implements EtiquetaService {
    @Autowired
    private EtiquetaDAO etiquetaDAO;
    @Autowired
    private ExpertDAO expertDAO;
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
