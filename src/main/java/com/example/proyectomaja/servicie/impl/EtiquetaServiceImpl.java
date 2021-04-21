package com.example.proyectomaja.servicie.impl;

import com.example.proyectomaja.dao.EtiquetaDAO;
import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.repository.EtiquetaRepository;
import com.example.proyectomaja.servicie.EtiquetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
@Service
public class EtiquetaServiceImpl implements EtiquetaService {
    private final Logger log = LoggerFactory.getLogger(EtiquetaServiceImpl.class);
    private final EtiquetaRepository repository;
    private final EtiquetaDAO etiquetaDao;

    public EtiquetaServiceImpl(EtiquetaRepository repository, EtiquetaDAO etiquetaDao) {
        this.repository = repository;
        this.etiquetaDao = etiquetaDao;
    }
    /**
     * Method to create etiquetas
     * @param etiqueta Object Etiqueta
     * @return Created Etiqueta
     */
    @Override
    public Etiqueta createEtiqueta(Etiqueta etiqueta) {
        log.debug("createEtiqueta");
        if(ObjectUtils.isEmpty(etiqueta))
            return null;

        return repository.save(etiqueta);
    }
    /**
     * Method to retrieve all etiquetaer
     * @return List of etiquetas
     */
    @Override
    public List<Etiqueta> findAll() {
        log.debug("findAllEtiqueta");
        return etiquetaDao.findAllEtiquetas();
    }

    /**
     * Method to find One etiqueta by id
     * @param id Long
     * @return One Etiqueta
     */
    @Override
    public Optional<Etiqueta> findOne(Long id) {
        log.debug("findOneByIdEtiqueta");
        if(id != null && repository.existsById(id))
            return etiquetaDao.findEtiquetaById(id);
        return Optional.empty();
    }
    /**
     * Method to update an Exepert
     * @param etiqueta Object etiqueta
     * @return Object Etiqueta
     */

    @Override
    public Etiqueta updateEtiqueta(Etiqueta etiqueta) {
        log.debug("updta Etiqueta");
        if ((ObjectUtils.isEmpty(etiqueta)))
            return null;

        return repository.save(etiqueta);
    }
    /**
     * Method to delete an Etiqueta by Id
     * @param id Long
     */
    @Override
    public void deleteById(Long id) {
        log.debug("Request to delete Employee : {}", id);
        repository.deleteById(id);
    }

}
