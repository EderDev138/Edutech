package com.edutech.apiedutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.apiedutech.model.Respuesta;
import com.edutech.apiedutech.service.RespuestaService;
// REALIZADO POR: DAYANA VEGA

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {
    @Autowired  
    private RespuestaService respuestaService;  

    @PostMapping
    public ResponseEntity<String> crearRespuesta(@RequestBody Respuesta respuesta) {
        try {
            Respuesta guardada = respuestaService.guardarRespuesta(respuesta);
            return ResponseEntity.ok("Respuesta registrada con ID: " + guardada.getId());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminarRespuesta(@RequestParam int id) {
        String resultado = respuestaService.eliminarRespuesta(id);
        return ResponseEntity.ok(resultado);
    }


    public String listarRespuestas() {
        return respuestaService.listar().toString();
    }


}
