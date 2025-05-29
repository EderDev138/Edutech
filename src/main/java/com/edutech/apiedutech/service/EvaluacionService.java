package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edutech.apiedutech.model.Evaluacion;
import com.edutech.apiedutech.repository.EvaluacionRepository;

public class EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public List<Evaluacion> listar(){
        return evaluacionRepository.findAll();

    }

}
