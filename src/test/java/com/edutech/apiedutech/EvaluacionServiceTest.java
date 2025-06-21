package com.edutech.apiedutech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.apiedutech.model.Evaluacion;
import com.edutech.apiedutech.model.Pregunta;
import com.edutech.apiedutech.repository.EvaluacionRepository;
import com.edutech.apiedutech.repository.PreguntaRepository;
import com.edutech.apiedutech.service.EvaluacionService;
import com.edutech.apiedutech.service.PreguntaService;

@ExtendWith(MockitoExtension.class)
public class EvaluacionServiceTest {

    @Mock
    private EvaluacionRepository evaluacionRepository;

    @Mock
    private PreguntaRepository preguntaRepository;
        
    @InjectMocks
    private EvaluacionService evaluacionService;

    @InjectMocks
    private PreguntaService preguntaService;

    @Test 
    void crearEvaluacion(){
        Evaluacion evaluacion =  new Evaluacion();
        evaluacion.setSigla("EV001FS");
        when(evaluacionRepository.findBySigla(evaluacion.getSigla())).thenReturn(null);
        
        String resultado = evaluacionService.registrarEvaluacion(evaluacion);
        assertEquals("Evaluación registrada correctamente", resultado);
    }

    @Test
    void agregarPregunta(){
        Evaluacion evaluacion = new Evaluacion();
        Pregunta pregunta = new Pregunta();

        evaluacion.setSigla("EV001_FS");
        pregunta.setSiglaPregunta("P001_FS");

        when(evaluacionRepository.findBySigla(evaluacion.getSigla())).thenReturn(null);
        when(preguntaRepository.findBySiglaPregunta(pregunta.getSiglaPregunta())).thenReturn(null);

        String resultado = evaluacionService.asignarPregunta(evaluacion.getSigla(), pregunta.getSiglaPregunta());
        assertEquals("La evaluación no existe", resultado);

    }

    @Test
    void eliminarEval(){
        Evaluacion evaluacion = new Evaluacion();
        
        evaluacion.setSigla("EV001_FS");

        when(evaluacionRepository.existsById(evaluacion.getId())).thenReturn(true);

        String resultado = evaluacionService.eliminarEvaluacion(evaluacion.getId());
        assertEquals("Evaluación eliminada correctamente", resultado);

    }

}
