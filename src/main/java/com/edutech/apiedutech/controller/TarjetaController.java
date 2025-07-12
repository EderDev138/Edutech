package com.edutech.apiedutech.controller;

import com.edutech.apiedutech.dto.TarjetaValidacionDTO;
import com.edutech.apiedutech.model.Tarjeta;
import com.edutech.apiedutech.service.TarjetaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tarjetas")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    @PostMapping("/validar")
    public ResponseEntity<?> validarTarjeta(@RequestBody TarjetaValidacionDTO datos) {
        try {
            Tarjeta tarjetaValida = tarjetaService.validarTarjeta(datos.getTarjeta(), datos.getUsuario());
            return ResponseEntity.ok(tarjetaValida);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/agregar")
    public ResponseEntity<String> agregarTarjeta(@RequestBody Tarjeta tarjeta) {
        String respuesta = tarjetaService.agregarTarjeta(tarjeta);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTarjeta(@PathVariable int id) {
        String respuesta = tarjetaService.eliminarTarjeta(id);
        return ResponseEntity.ok(respuesta);
    }

}        