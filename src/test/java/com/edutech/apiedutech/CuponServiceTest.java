package com.edutech.apiedutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.apiedutech.model.Cupon;
import com.edutech.apiedutech.repository.CuponRepository;
import com.edutech.apiedutech.service.CuponService;

// REALIZADO POR: ENCAR PORTILLO


@ExtendWith(MockitoExtension.class)
public class CuponServiceTest {


    @Mock
    private CuponRepository cuponRepository;

    @InjectMocks
    private CuponService cuponService;

    @Test
    void nuevoCupon(){
        Cupon cupon = new Cupon();
            cupon.setCodigo("DESCJUN2025");
            cupon.setCantidadDescuento(10);
            cupon.setDescripcion("Decuento Junio");
            cupon.setFechaExpiracion(LocalDate.of(2025,07,01));
            cupon.setFechaUso(null);
            cupon.setUsado(false);
        
        when(cuponRepository.findByCodigo(cupon.getCodigo())).thenReturn(null);

        String resultado = cuponService.crearCupon(cupon);
        assertEquals("El cupón " + cupon.getCodigo() + " registrado correctamente", resultado);
    }

    @Test
    void agregarCuponExistente(){

        Cupon cupon = new Cupon();
            cupon.setCodigo("DESCJUN2025");
            cupon.setCantidadDescuento(10);
            cupon.setDescripcion("Decuento Junio");
            cupon.setFechaExpiracion(LocalDate.of(2025,07,01));
            cupon.setFechaUso(null);
            cupon.setUsado(false);
            
            when(cuponRepository.findByCodigo(cupon.getCodigo())).thenReturn(cupon);
            
            String resultado = cuponService.crearCupon(cupon);
            assertEquals("El cupon " + cupon.getCodigo() + " que intenta ingresar ya existe", resultado);
        }
        
    @Test
    void listarCupones(){
        Cupon cup01 = new Cupon();
            cup01.setCodigo("DESCJUN2025");
            cup01.setCantidadDescuento(10);
            cup01.setDescripcion("Decuento Junio");
            cup01.setFechaExpiracion(LocalDate.of(2025,07,01));
            cup01.setFechaUso(null);
            cup01.setUsado(false);

        Cupon cup02 = new Cupon();
            cup02.setCodigo("DESCJUL2025");
            cup02.setCantidadDescuento(10);
            cup02.setDescripcion("Decuento Julio");
            cup02.setFechaExpiracion(LocalDate.of(2025,8,01));
            cup02.setFechaUso(null);
            cup02.setUsado(false);
        
        List<Cupon> cupones = new ArrayList<>();
        cupones.add(cup01);
        cupones.add(cup02);
        
        when(cuponRepository.findAll()).thenReturn(cupones);
        
        List<Cupon> resultado = cuponService.listarCupones();
        assertEquals(2, resultado.size());
        assertEquals("DESCJUL2025", resultado.get(1).getCodigo());
    }

    @Test
    void eliminarCupon(){
        Cupon cupon = new Cupon();
            cupon.setCodigo("DESCJAN");
        
        when(cuponRepository.findByCodigo(cupon.getCodigo())).thenReturn(cupon);

        String resultado = cuponService.eliminarCupon(cupon.getCodigo());
        assertEquals("Cupon " + cupon.getCodigo() + " eliminado correctamente", resultado);

    }

    

}
