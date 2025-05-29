package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.Evaluacion;
import com.edutech.apiedutech.model.Pregunta;
import com.edutech.apiedutech.repository.EvaluacionRepository;
import com.edutech.apiedutech.repository.PreguntaRepository;
// REALIZADO POR: DAYANA VEGA

@Service
public class EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    public List<Evaluacion> listar(){
        return evaluacionRepository.findAll();

    }
    
    public String registrarEvaluacion (Evaluacion evaluacion){
        if(evaluacionRepository.existsById(evaluacion.getId())){
            return "La evaluación " + evaluacion.getTitulo() + " ya existe";
        }else{
            evaluacionRepository.save(evaluacion);
            return "Evaluación registrada correctamente";
        }

    }

    public String asignarPregunta(int evaluacionId, int preguntaId ){
        if(!evaluacionRepository.existsById(evaluacionId)){
            return "La evaluación no existe";
        }else if(!preguntaRepository.existsById(preguntaId)){
            return "La pregunta no existe";
        }else{
            Evaluacion evaluacion = evaluacionRepository.findById(evaluacionId).get();
            Pregunta pregunta = preguntaRepository.findById(preguntaId).get();
            
            evaluacion.getPreguntas().add(pregunta);
            evaluacionRepository.save(evaluacion);

            return "Pregunta agregada correctamente";

        }
        
    }

    public String eliminarEvaluacion(int id) {
        evaluacionRepository.deleteById(id);
        return "Evaluación eliminada correctamente";
        
    }

    
    
}


