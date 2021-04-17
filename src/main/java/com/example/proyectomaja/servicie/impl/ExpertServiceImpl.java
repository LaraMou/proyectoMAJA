package com.example.proyectomaja.servicie.impl;

import com.example.proyectomaja.dao.ExpertDAO;
import com.example.proyectomaja.domain.Expert;
import com.example.proyectomaja.repository.ExpertRepository;
import com.example.proyectomaja.servicie.ExpertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
@Service
public class ExpertServiceImpl implements ExpertService {
    private final Logger log = LoggerFactory.getLogger(ExpertServiceImpl.class);
    private final ExpertRepository repository;
    private final ExpertDAO expertDao;

    public ExpertServiceImpl(ExpertRepository repository,ExpertDAO expertDao) {
        this.repository = repository;
        this.expertDao = expertDao;
    }

    /**
     * Method to create experts
     * @param expert Object Expert
     * @return Created Expert
     */
    @Override
    public Expert createExpert(Expert expert) {
        log.debug("createExpert");
        if(ObjectUtils.isEmpty(expert))
            return null;

        return repository.save(expert);
    }

    /**
     * Method to retrieve all experter
     * @return List of experts
     */
    @Override
    public List<Expert> findAll() {
        log.debug("findAllExpert");
        return repository.findAll();
    }

    /**
     * Method to find One expert by id
     * @param id Long
     * @return One Expert
     */
    @Override
    public Optional<Expert> findOne(Long id) {
        log.debug("findOneByIdExpert");
        if(id != null && repository.existsById(id))
            return expertDao.findExpertByID(id);
        return Optional.empty();
    }

    /**
     * Method to update an Exepert
     * @param expert Object Expert
     * @return Object Expert
     */
    @Override
    public Expert updateExpert(Expert expert) {
        log.debug("updta Expert");
        if ((ObjectUtils.isEmpty(expert)))
            return null;

        return repository.save(expert);
    }

    /**
     * Method to delete an Expert by Id
     * @param id Long
     */
    @Override
    public void deleteById(Long id) {
        log.debug("Request to delete Employee : {}", id);
        repository.deleteById(id);
    }


}
