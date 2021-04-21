package com.example.proyectomaja.servicie.impl;

import com.example.proyectomaja.dao.ExpertDAO;
import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Expert;
import com.example.proyectomaja.exception.BadResourceException;
import com.example.proyectomaja.exception.ResourceAlreadyExistsException;
import com.example.proyectomaja.exception.ResourceNotFoundException;
import com.example.proyectomaja.repository.ExpertRepository;
import com.example.proyectomaja.servicie.ExpertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
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


    private boolean existsById(Long id) {

        return repository.existsById(id);

    }

    /**
     * Method to create experts
     * @param expert Object Expert
     * @return Created Expert
     */
    @Override
    public Expert createExpert(Expert expert) throws BadResourceException, ResourceAlreadyExistsException {
        log.debug("createExpert");

        if (!ObjectUtils.isEmpty(expert)){
            if (expert.getId() != null && existsById(expert.getId())) {
                throw new ResourceAlreadyExistsException("expert with id: " + expert.getId() +
                        " already exists");
            }

            return repository.save(expert);

        }

        else {

            BadResourceException exc = new BadResourceException("Failed to save expert");

            exc.addErrorMessage("Expert is null or empty");

            throw exc;

        }


    }

    /**
     * Method to retrieve all experter
     * @return List of experts
     */
    @Override
    public List<Expert> findAll() {
        log.debug("findAllExpert");
        return expertDao.findAllExperts();
    }

    /**
     * Method to find One expert by id
     * @param id Long
     * @return One Expert
     */
    @Override
    public Optional<Expert> findOne(Long id) throws ResourceNotFoundException {
        log.debug("findOneByIdExpert");
        try{
            if(id != null && repository.existsById(id))
                return expertDao.findExpertByID(id);
            return Optional.empty();
        }catch (Exception e) {
            log.debug("error",e);
            throw new ResourceNotFoundException("Cannot find Expert with id: " + id);
        }

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
        log.debug("Request to delete Expert : {}", id);
        repository.deleteById(id);
    }

    /**
     * Method to find by Page and limit
     * @param pageNumber pageNumber
     * @param rowPerPage number of row per page
     * @return List of Expert
     */
    @Override
    public List<Expert> findAllPage(int pageNumber, int rowPerPage) {
        List<Expert> experts = new ArrayList<>();

        repository.findAll(PageRequest.of(pageNumber - 1, rowPerPage)).forEach(experts::add);

        return experts;
    }

    @Override
    public List<Expert> findByName(String nombre, int pageNumber, int rowPerPage) {
        Expert filter = new Expert();

        filter.setNombre(nombre);

        Specification<Expert> spec = new ExpertSpecification(filter);


        List<Expert> experts = new ArrayList<>();

        repository.findAll(spec, PageRequest.of(pageNumber - 1, rowPerPage)).forEach(experts::add);

        return experts;
    }
    // TODO: 21/04/2021  quitar de aqui poner en  etiqueta
//    @Override
//    public List<Etiqueta> findEtiquetasByID(Long id) throws ResourceNotFoundException {
//        List<Etiqueta> etiquetaList = new ArrayList<>();
//        try{
//            if(id != null && repository.existsById(id))
//                etiquetaList = expertDao.findEtiquetasByID(id);
//                return etiquetaList;
//        }catch (Exception e) {
//            log.debug("error",e);
//            throw new ResourceNotFoundException("Cannot find Expert with id: " + id);
//        }
//
//    }
}
