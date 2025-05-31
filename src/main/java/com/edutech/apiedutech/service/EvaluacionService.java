package com.edutech.apiedutech.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.dto.EvaluacionDTO;
import com.edutech.apiedutech.dto.PreguntaDTO;
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

    public List<EvaluacionDTO> listar(){
        return evaluacionRepository.findAll().stream().map(evaluacion ->{
        EvaluacionDTO evaluaciondto = new EvaluacionDTO();

        evaluaciondto.setSigla(evaluacion.getSigla());
        evaluaciondto.setTitulo(evaluacion.getTitulo());
        evaluaciondto.setDescripcion(evaluacion.getDescripcion());
        evaluaciondto.setFechaInicio(evaluacion.getFechaInicio());
        evaluaciondto.setFechaFin(evaluacion.getFechaFin());
        evaluaciondto.setPreguntas(evaluacion.getPreguntas().stream().map(pregunta -> {
                    PreguntaDTO preguntadto = new PreguntaDTO();
                    preguntadto.setSigla(pregunta.getSiglaPregunta());
                    preguntadto.setEnunciado(pregunta.getEnunciado());
                    preguntadto.setOpciones(pregunta.getOpciones());
                    return preguntadto;
        }).collect(Collectors.toList()));
        return evaluaciondto;
    }).collect(Collectors.toList());

    }

    
    public String registrarEvaluacion (Evaluacion evaluacion){
        if(evaluacionRepository.findBySigla(evaluacion.getSigla()) != null){
            return "La evaluación " + evaluacion.getTitulo() + " ya existe";
        }else{
            evaluacionRepository.save(evaluacion);
            return "Evaluación registrada correctamente";
        }

    }

    public String asignarPregunta(String evaluacionSigla, String preguntaSigla ){
        Evaluacion evaluacion = evaluacionRepository.findBySigla(evaluacionSigla);
        Pregunta pregunta = preguntaRepository.findBySiglaPregunta(preguntaSigla);
        if (evaluacion == null){
            return "La evaluación no existe";
        }else if (pregunta == null){
            return "La pregunta no existe";

        }else{
            pregunta.setEvaluacion(evaluacion);
            evaluacion.getPreguntas().add(pregunta);
            preguntaRepository.save(pregunta);
            evaluacionRepository.save(evaluacion);
            return "Pregunta agregada correctamente";
        }

        }


    public String eliminarEvaluacion(int id) {
        if(!evaluacionRepository.existsById(id)){
            return "Evaluación no existe para eliminar";    
        }
        evaluacionRepository.deleteById(id);
        return "Evaluación eliminada correctamente";
        
    }

    
    
}


