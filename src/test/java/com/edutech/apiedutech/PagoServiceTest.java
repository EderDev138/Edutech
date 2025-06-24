package com.edutech.apiedutech;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.edutech.apiedutech.model.Cupon;
import com.edutech.apiedutech.model.Pago;
import com.edutech.apiedutech.model.Tarjeta;
import com.edutech.apiedutech.repository.PagoRepository;
import com.edutech.apiedutech.repository.TarjetaRepository;
import com.edutech.apiedutech.service.PagoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PagoServiceTest {

    @Mock
    private PagoRepository pagoRepository;

    @Mock
    private TarjetaRepository tarjetaRepository;

    @InjectMocks
    private PagoService pagoService;

    @Test
    void realizarPagoConTarjetaExistente() {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setId(1);
        tarjeta.setNumeroTarjeta("12345679");
        tarjeta.setCvv("123");
        tarjeta.setTitular("JUAN RODRIGUEZ");

        Pago pago = new Pago();
        pago.setId(100);
        pago.setTarjeta(tarjeta);

        when(tarjetaRepository.findById(1)).thenReturn(Optional.of(tarjeta));

        String resultado = pagoService.realizarPago(pago);

        verify(pagoRepository).save(pago);
        assertEquals("Pago guardado con éxito", resultado);
    }

    @Test
    void realizarPagoConTarjetaInexistente() {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setId(99);

        Pago pago = new Pago();
        pago.setTarjeta(tarjeta);

        when(tarjetaRepository.findById(99)).thenReturn(Optional.empty());

        String resultado = pagoService.realizarPago(pago);
        assertEquals("La tarjeta no existe", resultado);
    }

    @Test
    void eliminarPagoExistente() {
        Pago pago = new Pago();
        pago.setId(200);

        when(pagoRepository.findById(200)).thenReturn(Optional.of(pago));

        String resultado = pagoService.eliminarPago(200);

        verify(pagoRepository).delete(pago);
        assertEquals("Pago eliminado con éxito", resultado);
    }

    @Test
    void calcularDescuentoConCupon() {
        Cupon cupon = new Cupon();
        cupon.setCantidadDescuento(10);
        cupon.setDescripcion("Descuento 10%");

        int resultado = pagoService.calcularDescuento(10000, cupon);

        assertEquals(9000, resultado);
    }
}
