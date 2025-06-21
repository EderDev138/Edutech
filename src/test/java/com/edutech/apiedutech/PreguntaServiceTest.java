package com.edutech.apiedutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.apiedutech.model.Pregunta;
import com.edutech.apiedutech.repository.PreguntaRepository;
import com.edutech.apiedutech.service.PreguntaService;

@ExtendWith(MockitoExtension.class)
public class PreguntaServiceTest {

    @Mock
    private PreguntaRepository preguntaRepository;

    @InjectMocks
    private PreguntaService preguntaService;

    @Test
    void almacenarPregunta(){
    Pregunta pregunta = new Pregunta();

    pregunta.setSiglaPregunta("P001_FS");

    when(preguntaRepository.findBySiglaPregunta(pregunta.getSiglaPregunta())).thenReturn(null);
    
    String resultado = preguntaService.guardarPregunta(pregunta);
    assertEquals("Pregunta almacenada correctamente", resultado);
    }

    @Test
    void elimiminarPreg(){
    Pregunta pregunta = new Pregunta();

    pregunta.setSiglaPregunta("P001_FS");

    when(preguntaRepository.findBySiglaPregunta(pregunta.getSiglaPregunta())).thenReturn(null);

    String resultado = preguntaService.eliminarPregunta(pregunta.getSiglaPregunta());
    assertEquals("La pregunta no existe", resultado);
    }

}
