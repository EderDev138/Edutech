package com.edutech.apiedutech;



import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.edutech.apiedutech.model.Curso;
import com.edutech.apiedutech.model.Profesor;
import com.edutech.apiedutech.repository.CursoRepository;
import com.edutech.apiedutech.repository.ProfesorRepository;
import com.edutech.apiedutech.service.ProfesorService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProfesorServiceTest {

    @Mock
    private ProfesorRepository profesorRepository;

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private ProfesorService profesorService;

    @Test
    void registrarProfesorNuevo() {
        Profesor profesor = new Profesor();
        profesor.setRut("11222333-4");
        profesor.setNombre("Mario");
        profesor.setApellido("Marin");

        when(profesorRepository.findById(profesor.getRut())).thenReturn(Optional.empty());

        String resultado = profesorService.registrarProfesor(profesor);
        assertEquals("Profesor registrado exitosamente.", resultado);
    }

    @Test
    void registrarProfesorExistente() {
        Profesor profesor = new Profesor();
        profesor.setRut("22334488-9");
        profesor.setNombre("Julio");
        profesor.setApellido("Esponiza");

        when(profesorRepository.findById(profesor.getRut())).thenReturn(Optional.of(profesor));

        String resultado = profesorService.registrarProfesor(profesor);
        assertEquals("El profesor con RUT "+profesor.getRut()+" ya existe.", resultado);
    }

    @Test
    void asignarCursoProfesor() {
        Profesor profesor = new Profesor();
        profesor.setRut("22222222-3");
                
        List<Curso> cursos = new ArrayList<>();
        profesor.setCursos(cursos);

        Curso curso = new Curso();
        curso.setSigla("CURS02");

        when(profesorRepository.existsById(profesor.getRut())).thenReturn(true);
        when(cursoRepository.existsById(curso.getSigla())).thenReturn(true);
        when(profesorRepository.findById(profesor.getRut())).thenReturn(Optional.of(profesor));
        when(cursoRepository.findById(curso.getSigla())).thenReturn(Optional.of(curso));

        String resultado = profesorService.asignarCurso(profesor.getRut(), curso.getSigla());
        assertEquals("Curso asignado exitosamente al profesor.", resultado);
    }

    @Test
    void asignarCursoYaAsignado() {
        Profesor profesor = new Profesor();
        profesor.setRut("11111111-1");
                
        Curso curso = new Curso();
        curso.setSigla("CURSO01");
        
        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso);
        profesor.setCursos(cursos);

        when(profesorRepository.existsById(profesor.getRut())).thenReturn(true);
        when(cursoRepository.existsById(curso.getSigla())).thenReturn(true);
        when(profesorRepository.findById(profesor.getRut())).thenReturn(Optional.of(profesor));
        when(cursoRepository.findById(curso.getSigla())).thenReturn(Optional.of(curso));

        String resultado = profesorService.asignarCurso(profesor.getRut(), curso.getSigla());
        assertEquals("El profesor ya está asignado al curso con sigla "+curso.getSigla()+".", resultado);
    }
}
