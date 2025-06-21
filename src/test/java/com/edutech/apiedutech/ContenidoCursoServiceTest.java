package com.edutech.apiedutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.apiedutech.model.ContenidoCurso;
import com.edutech.apiedutech.repository.ContenidoCursoRepository;
import com.edutech.apiedutech.service.ContenidoCursoService;

// REALIZADO POR: ENCAR PORTILLO


@ExtendWith(MockitoExtension.class)
public class ContenidoCursoServiceTest {


    @Mock
    private ContenidoCursoRepository contenidoCursoRepository;

    @InjectMocks
    private ContenidoCursoService contenidoCursoService;

    @Test
    void almacenarContenidoNuevo(){
        ContenidoCurso contenido = new ContenidoCurso();
        contenido.setTitulo("Contenido_01");
        contenido.setId(1L);

        when(contenidoCursoRepository.existsById(contenido.getId())).thenReturn(false);

        String resultado = contenidoCursoService.almacenarContenido(contenido);
        assertEquals("El contenido "+contenido.getTitulo()+" guardado correctamente", resultado);
    }
    
    @Test
    void almacenarContenidoExistente(){
        ContenidoCurso contenido = new ContenidoCurso();
        contenido.setTitulo("Contenido_01");
        contenido.setId(1L);

        when(contenidoCursoRepository.existsById(contenido.getId())).thenReturn(true);

        String resultado = contenidoCursoService.almacenarContenido(contenido);
        assertEquals("El contenido " + contenido.getTitulo() + " ya existe", resultado);
    }

    @Test
    void listarContenidos(){
        ContenidoCurso con01 = new ContenidoCurso();
            con01.setId(1L);
            con01.setTitulo("Unidad_01");
            con01.setDescripcion("Material Unidad 01");
       
        ContenidoCurso con02 = new ContenidoCurso();
            con02.setId(2L);
            con02.setTitulo("Unidad_02");
            con02.setDescripcion("Material Unidad 02");
        ContenidoCurso con03 = new ContenidoCurso();
            con03.setId(2L);
            con03.setTitulo("Unidad_03");
            con03.setDescripcion("Material Unidad 03");

        List<ContenidoCurso> contenidos = new ArrayList<>();
            contenidos.add(con01);
            contenidos.add(con02);
            contenidos.add(con03);

        when(contenidoCursoRepository.findAll()).thenReturn(contenidos);

        List<ContenidoCurso> resultado = contenidoCursoService.listar();
        assertEquals(3, resultado.size());
        assertEquals("Unidad_02", resultado.get(1).getTitulo());
    }

    @Test
    void eliminarContenidoExistente(){
        ContenidoCurso contenido = new ContenidoCurso();
            contenido.setId(1L);
            contenido.setTitulo("Unidad_01");
            contenido.setDescripcion("Material Unidad 01");
        
        when(contenidoCursoRepository.existsById(contenido.getId())).thenReturn(true);
        when(contenidoCursoRepository.findById(contenido.getId())).thenReturn(Optional.of(contenido));

        String resultado = contenidoCursoService.eliminarContenido(contenido.getId());
        assertEquals("El contenido "+contenido.getTitulo()+" eliminado correctamente",resultado);        
    }


}
