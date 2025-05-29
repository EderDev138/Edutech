package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.edutech.apiedutech.model.Evaluacion;
import com.edutech.apiedutech.repository.EvaluacionRepository;

public class EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public List<Evaluacion> listar(){
        return evaluacionRepository.findAll();

    }
    
    public String registrarEvaluacion (Evaluacion evaluacion){
        if (evaluacionRepository.findById(evaluacion.getId()).isPresent()){
            return "La Evaluación" + evaluacion.getTitulo() + " ya existe";
        }
        evaluacionRepository.save(evaluacion);
        return ResponseEntity.ok("Evaluación registada existosamente").toString();
    }


        
    }




