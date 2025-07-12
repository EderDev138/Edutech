package com.edutech.apiedutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.apiedutech.model.Cupon;
import com.edutech.apiedutech.model.Pago;
import com.edutech.apiedutech.repository.PagoRepository;
import com.edutech.apiedutech.service.PagoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoRepository pagoRepository;

    @Autowired
    private PagoService pagoService;

    PagoController(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    // Crear un pago
    @PostMapping
    public String realizarPago(@RequestBody Pago pago) {
        return pagoService.realizarPago(pago);
    }

    @GetMapping("/pago/{id}")
    public ResponseEntity<?> buscarPago(@PathVariable int id) {
        Pago pago = pagoService.buscarPagoPorId(id);

        if (pago == null) {
            return ResponseEntity.badRequest().body("ID de pago no válido");
        }

        return ResponseEntity.ok(pago);
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
