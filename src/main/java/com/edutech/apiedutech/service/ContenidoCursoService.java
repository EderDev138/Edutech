package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.ContenidoCurso;
import com.edutech.apiedutech.repository.ContenidoCursoRepository;
import com.edutech.apiedutech.repository.CursoRepository;
// REALIZADO POR: ENCAR PORTILLO
@Service
public class ContenidoCursoService {
    @Autowired
    private ContenidoCursoRepository contenidoCursoRepository;


    @Autowired
    public CursoRepository cursoRepository;

    public List<ContenidoCurso> listar(){
        return contenidoCursoRepository.findAll();        
    }

public String almacenarContenido(ContenidoCurso contenido){
    if (contenido == null || contenido.getCurso() == null || contenido.getCurso().getSigla() == null) {
        return "Debe asociar el contenido a un curso con sigla válida.";
    }

    if (!cursoRepository.existsById(contenido.getCurso().getSigla())) {
        return "El curso con sigla '" + contenido.getCurso().getSigla() + "' no existe.";
    }

    contenidoCursoRepository.save(contenido);
    return "El contenido '" + contenido.getTitulo() + "' fue guardado correctamente.";
}


    public String eliminarContenido(Long id){
        if (!contenidoCursoRepository.existsById(id)){
            return "El contenido seleccionado no existe";
        }else {
            ContenidoCurso contenido = contenidoCursoRepository.findById(id).get();
            contenidoCursoRepository.delete(contenido);
            return "El contenido "+contenido.getTitulo()+" eliminado correctamente";

        }

    }



    


}
