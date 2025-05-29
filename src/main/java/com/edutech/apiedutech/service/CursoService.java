package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.ContenidoCurso;
import com.edutech.apiedutech.model.Curso;
import com.edutech.apiedutech.repository.ContenidoCursoRepository;
import com.edutech.apiedutech.repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ContenidoCursoRepository contenidoCursoRepository;

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

    public String asignarContenido(String sigla, Long id){
        if (!cursoRepository.existsById(sigla)){
            return "El curso no existe";
        }else if (!contenidoCursoRepository.existsById(id)){
            return "El contenido seleccionado no existe";
        }else{
            Curso curso = cursoRepository.findById(sigla).get();
            ContenidoCurso contenidoCurso = contenidoCursoRepository.findById(id).get();

            curso.getContenidoCurso().add(contenidoCurso);
            cursoRepository.save(curso);
            return "El contenido " + contenidoCurso.getTitulo() + " ha sido almacenado";
        }

    }
}