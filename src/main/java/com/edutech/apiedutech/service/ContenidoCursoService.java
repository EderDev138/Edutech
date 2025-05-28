package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.dto.ContenidoCursoDTO;
import com.edutech.apiedutech.model.ContenidoCurso;
import com.edutech.apiedutech.model.Curso;
import com.edutech.apiedutech.repository.ContenidoCursoRepository;
import com.edutech.apiedutech.repository.CursoRepository;

@Service
public class ContenidoCursoService {
    @Autowired
    private ContenidoCursoRepository contenidoCursoRepository;


    @Autowired
    public CursoRepository cursoRepository;

    public List<ContenidoCurso> listar(){
        return contenidoCursoRepository.findAll();        
    }

    public ContenidoCursoDTO almacenarContenidoCursoDTO(ContenidoCursoDTO contenidoCursoDto) {
        Curso curso = cursoRepository.findById(contenidoCursoDto.getCursoSigla()).orElse(null);
        if (curso == null) return null;

        ContenidoCurso contenido = new ContenidoCurso();
        contenido.setTitulo(contenidoCursoDto.getTitulo());
        contenido.setDescripcion(contenidoCursoDto.getDescripcion());
        contenido.seturlContenidoCurso(contenidoCursoDto.getUrlContenido());
        contenido.setCurso(curso);
        
        
        return toDTO(contenidoCursoRepository.save(contenido));
    }

    
    private ContenidoCursoDTO toDTO(ContenidoCurso contenido) {
        return new ContenidoCursoDTO(
                contenido.getId(),
                contenido.getTitulo(),
                contenido.getDescripcion(),
                contenido.geturlContenidoCurso(),
                contenido.getCurso().getSigla()
        );
    }
    

}
