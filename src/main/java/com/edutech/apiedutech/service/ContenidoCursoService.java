package com.edutech.apiedutech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.ContenidoCurso;
import com.edutech.apiedutech.repository.ContenidoCursoRepository;

@Service
public class ContenidoCursoService {
    @Autowired
    private ContenidoCursoRepository contenidoCursoRepository;

    public String almacenarContenidoCurso(ContenidoCurso contenidoCurso) {
        if (contenidoCursoRepository.findById(contenidoCurso.getId()) != null) {
            return "El contenido con ID " + contenidoCurso + " ya existe.";
        }
        contenidoCursoRepository.save(contenidoCurso);
        return "Contenido almacenado exitosamente.";
    }
    

}
