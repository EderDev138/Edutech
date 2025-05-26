package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.Curso;
import com.edutech.apiedutech.repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    //almacenar sin dto
    public String almacenar(Curso curso) {
        if (cursoRepository.findById(curso.getSigla()).isPresent()) {
            return "El curso con sigla " + curso.getSigla() + " ya existe.";
        }

        cursoRepository.save(curso);
        return "Curso registrado exitosamente";
    }

    //almacenar con dto

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    public Curso buscar(String sigla) {
        return cursoRepository.findById(sigla).orElse(null);
    }
}