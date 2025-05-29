package com.edutech.apiedutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.apiedutech.model.Evaluacion;
import com.edutech.apiedutech.service.EvaluacionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @PostMapping
    public String crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        return evaluacionService.registrarEvaluacion(evaluacion);

    }
    
}

