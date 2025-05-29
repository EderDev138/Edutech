package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.Curso;
import com.edutech.apiedutech.model.Profesor;
import com.edutech.apiedutech.repository.CursoRepository;
import com.edutech.apiedutech.repository.ProfesorRepository;
// REALIZADO POR: EDER VALDIVIA

@Service
public class ProfesorService{
    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public String registrarProfesor(Profesor profesor) {
        if (profesorRepository.findById(profesor.getRut()).isPresent()) {
            return "El profesor con RUT " + profesor.getRut() + " ya existe.";
        }

        profesorRepository.save(profesor);
        return "Profesor registrado exitosamente.";
    }
    
    public List<Profesor> listar() {
        return profesorRepository.findAll();
    }


   public String asignarCurso(String rut, String sigla) {
    if (!profesorRepository.existsById(rut)) {
        return "El profesor con RUT " + rut + " no existe.";
    } else if (!cursoRepository.existsById(sigla)) {
        return "El curso con sigla " + sigla + " no existe.";
    }

    Profesor profesor = profesorRepository.findById(rut).get();
    Curso curso = cursoRepository.findById(sigla).get();

    if (profesor.getCursos().contains(curso)) {
        return "El profesor ya está asignado al curso con sigla " + sigla + ".";
    } else {
        profesor.getCursos().add(curso);
        profesorRepository.save(profesor);
        return "Curso asignado exitosamente al profesor.";
    }
}
        

        
        

    }


