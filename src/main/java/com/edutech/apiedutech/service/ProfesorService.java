package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edutech.apiedutech.model.Profesor;
import com.edutech.apiedutech.repository.ProfesorRepository;

public class ProfesorService{
    @Autowired
    private ProfesorRepository profesorRepository;

    public String registrarProfesor(Profesor profesor) {
        if (profesorRepository.findById(profesor.getRut()).isPresent()) {
            return "El profesor con RUT " + profesor.getRut() + " ya existe.";
        }

        profesorRepository.save(profesor);
        return "Usuario registrado exitosamente.";
    }
    
    public List<Profesor> listarProfesor() {
        return profesorRepository.findAll();
    }
    }


