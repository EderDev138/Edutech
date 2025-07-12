package com.edutech.apiedutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.apiedutech.model.Cupon;
import com.edutech.apiedutech.model.Pago;
import com.edutech.apiedutech.service.PagoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    // Crear un pago
    @PostMapping
    public String realizarPago(@RequestBody Pago pago) {
        return pagoService.realizarPago(pago);
    }

    // Buscar un pago por ID
    @GetMapping("/pago/{id}")
    public Pago buscarPago(@PathVariable int id) {
        return pagoService.buscarPago(id);
    }

    // Eliminar un pago por ID
    @DeleteMapping("/eliminar/{id}")
    public String eliminarPago(@PathVariable int id) {
        return pagoService.eliminarPago(id);
    }

    // Calcular descuento usando un cupón
    @PostMapping("/descuento")
    public int calcularDescuento(@RequestParam int monto, @RequestBody Cupon cupon) {
        return pagoService.calcularDescuento(monto, cupon);
    }
}
