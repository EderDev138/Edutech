package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.dto.ActualizarIncidenciaDTO;
import com.edutech.apiedutech.model.Incidencia;
import com.edutech.apiedutech.repository.IncidenciaRepository;


@Service
public class IncidenciaService {

    @Autowired
    IncidenciaRepository incidenciaRepository;

    public String crearIncidencia(Incidencia incidencia){
        incidenciaRepository.save(incidencia);
        return "Incidencia guardada";
    }

    public Incidencia encontrarIncidencia(Long id){
        if(!incidenciaRepository.existsById(id)){
            throw new RuntimeException("Incidencia no existe") ;
        }else{
            Incidencia incidencia = incidenciaRepository.findById(id).get();
            return incidencia;
        }
    }

    public List<Incidencia> listar(){
        return incidenciaRepository.findAll();
    }

    public String actualizaIncidencia(Long id, ActualizarIncidenciaDTO nvaIncidencia){
        if(!incidenciaRepository.existsById(id)){
            return "No existe incidencia para actualizar";
        }else{
            Incidencia incidencia = incidenciaRepository.findById(id).get();
            incidencia.setComentario(nvaIncidencia.getComentario());
            incidencia.setEstado(nvaIncidencia.getEstado());
            incidencia.setFechaSolucion(nvaIncidencia.getFechaActualizacion());
            incidenciaRepository.save(incidencia);
            return "Incidencia con id: " +incidencia.getId() +" Actualizada";
        }
    }

    public String eliminarIncidencia(Long id){
        if(!incidenciaRepository.existsById(id)){
            return "Incidencia no existe";
        }else{
            incidenciaRepository.deleteById(id);
            return "Incidencia eliminada";
        }
    }

}
