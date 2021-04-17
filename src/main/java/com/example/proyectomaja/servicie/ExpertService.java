package com.example.proyectomaja.servicie;

import com.example.proyectomaja.domain.Expert;

import java.util.List;
import java.util.Optional;

public interface ExpertService {

    Expert createExpert(Expert expert);
    List<Expert> findAll();
    Optional<Expert> findOne(Long id);
    Expert updateExpert(Expert expert);
    void deleteById(Long id);

    //PROCESSO


}
