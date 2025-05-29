package com.edutech.apiedutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.apiedutech.model.Respuesta;
import com.edutech.apiedutech.service.RespuestaService;

@RestController
@RequestMapping("/preguntas")
public class RespuestaController {
    @Autowired  
    private RespuestaService respuestaService;  

    public String crearRespuesta(@RequestBody Respuesta respuesta) {
        return respuestaService.guardarRespuesta(respuesta).toString();

        
    }

    public String eliminarRespuesta(int id) {
        return respuestaService.eliminarRespuesta(id);
    }

    public String listarRespuestas() {
        return respuestaService.listar().toString();
    }


}
