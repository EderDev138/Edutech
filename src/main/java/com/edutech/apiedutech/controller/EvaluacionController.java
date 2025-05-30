package com.edutech.apiedutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.apiedutech.model.Evaluacion;
import com.edutech.apiedutech.service.EvaluacionService;
// REALIZADO POR: DAYANA VEGA
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @PostMapping
    public String crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        return evaluacionService.registrarEvaluacion(evaluacion);

    }

    @GetMapping
    public List<Evaluacion> listar(){
        return evaluacionService.listar();
    }
    

    @PostMapping("asignar/pregunta/{idEvaluacion}/{idPregunta}")
    public String asignarPregunta(@PathVariable int idEvaluacion, int idPregunta) {
        return evaluacionService.asignarPregunta(idEvaluacion, idPregunta);
    }

    @DeleteMapping("eliminar/evaluacion/{idEv}")
    public String eliminarEvaluacion(@PathVariable int idEv) {
        return evaluacionService.eliminarEvaluacion(idEv);
    }
    


    
}

