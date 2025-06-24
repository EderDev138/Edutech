package com.edutech.apiedutech;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.edutech.apiedutech.dto.ActualizarIncidenciaDTO;
import com.edutech.apiedutech.model.Incidencia;
import com.edutech.apiedutech.repository.IncidenciaRepository;
import com.edutech.apiedutech.service.IncidenciaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class IncidenciaServiceTest {

    @Mock
    private IncidenciaRepository incidenciaRepository;


    @InjectMocks
    private IncidenciaService incidenciaService;

    @Test
    void crearIncidencia() {
        Incidencia incidencia = new Incidencia();
        incidencia.setId(1L);
        incidencia.setComentario("Error en login");

        String resultado = incidenciaService.crearIncidencia(incidencia);
        verify(incidenciaRepository).save(incidencia);
        assertEquals("Incidencia guardada", resultado);
    }

    @Test
    void encontrarIncidenciaExistente() {
        Incidencia incidencia = new Incidencia();
        incidencia.setId(1L);

        when(incidenciaRepository.existsById(1L)).thenReturn(true);
        when(incidenciaRepository.findById(1L)).thenReturn(Optional.of(incidencia));

        Incidencia resultado = incidenciaService.encontrarIncidencia(1L);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void actualizarIncidenciaExistente() {
        Incidencia incidencia = new Incidencia();
        incidencia.setId(1L);

        ActualizarIncidenciaDTO dto = new ActualizarIncidenciaDTO();
        dto.setComentario("Resuelto");
        dto.setEstado("Finalizado");
        LocalDateTime fechaAct = LocalDateTime.now();
        dto.setFechaActualizacion(fechaAct);

        when(incidenciaRepository.existsById(1L)).thenReturn(true);
        when(incidenciaRepository.findById(1L)).thenReturn(Optional.of(incidencia));

        String resultado = incidenciaService.actualizaIncidencia(1L, dto);
        assertEquals("Incidencia con id: "+incidencia.getId()+" Actualizada", resultado);
    }


}
