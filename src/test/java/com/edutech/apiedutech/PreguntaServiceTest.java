package com.edutech.apiedutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    void crearPreguntaNueva(){
    Pregunta pregunta = new Pregunta();

    pregunta.setSiglaPregunta("P001_FS");

    when(preguntaRepository.findBySiglaPregunta(pregunta.getSiglaPregunta())).thenReturn(null);
    
    String resultado = preguntaService.guardarPregunta(pregunta);
    assertEquals("Pregunta almacenada correctamente", resultado);
    }

    @Test
    void crearPreguntaExistente() {
        Pregunta pregunta = new Pregunta();
        pregunta.setSiglaPregunta("P001_FS");

        when(preguntaRepository.findBySiglaPregunta(pregunta.getSiglaPregunta()))
            .thenReturn(pregunta);

        String resultado = preguntaService.guardarPregunta(pregunta);
        assertEquals("La pregunta ya existe", resultado);
    }


    @Test
    void mostrarPregunta(){
        List<String> opciones = new ArrayList<>();
        opciones.add("@Entity");
        opciones.add("@RestController");
        opciones.add("@Service");
        opciones.add("@Autowired");
        Pregunta pregunta = new Pregunta();
        pregunta.setSiglaPregunta("PREG01");
        pregunta.setEnunciado("¿Cuál anotación se usa para indicar que una clase es un controlador REST en Spring Boot?");
        pregunta.setOpciones(opciones);
        pregunta.setRespuestaCorrecta("@RestController");   
        
        when(preguntaRepository.findBySiglaPregunta(pregunta.getSiglaPregunta())).thenReturn(pregunta);

        ResponseEntity<?> resultado = preguntaService.mostrarPreguntaPorSigla(pregunta.getSiglaPregunta());
        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    void eliminarPregunta() {
        Pregunta pregunta = new Pregunta();
        pregunta.setSiglaPregunta("P002_FS");

        when(preguntaRepository.findBySiglaPregunta("P002_FS")).thenReturn(pregunta);

        String resultado = preguntaService.eliminarPregunta("P002_FS");
        assertEquals("Pregunta eliminada con éxito", resultado);
    }


}
