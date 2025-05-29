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
        if (contenidoCursoRepository.existsById(contenido.getId())){
            return "El contenido " + contenido.getTitulo() + " ya existe";
        }else {
            contenidoCursoRepository.save(contenido);
            return "El contenido "+contenido.getTitulo()+" guardado correctamente";

        }}

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
