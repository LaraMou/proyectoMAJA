package com.example.proyectomaja.servicie;

import com.example.proyectomaja.domain.Etiqueta;
import com.example.proyectomaja.domain.Expert;
import com.example.proyectomaja.exception.BadResourceException;
import com.example.proyectomaja.exception.ResourceAlreadyExistsException;
import com.example.proyectomaja.exception.ResourceNotFoundException;


import java.util.List;
import java.util.Optional;

public interface ExpertService {

    Expert createExpert(Expert expert) throws BadResourceException, ResourceAlreadyExistsException;
    List<Expert> findAll();
    Optional<Expert> findOne(Long id) throws ResourceNotFoundException;
    Expert updateExpert(Expert expert);
    void deleteById(Long id);

    List<Expert> findAllPage(int pageNumber, int rowPerPage);
    List<Expert> findByName(String nombre, int pageNumber, int rowerPage);
//    List<Etiqueta> findEtiquetasByID(Long id) throws ResourceNotFoundException;



}
