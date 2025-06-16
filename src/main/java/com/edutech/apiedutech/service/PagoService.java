package com.edutech.apiedutech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.Cupon;
import com.edutech.apiedutech.model.Pago;
import com.edutech.apiedutech.repository.CuponRepository;
import com.edutech.apiedutech.repository.PagoRepository;
import com.edutech.apiedutech.repository.TarjetaRepository;

// REALIZADO POR: DAYANA VEGA

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private CuponRepository cuponRepository;

    @Autowired
    private TarjetaRepository tarjetaRepository;

    public String realizarPago(Pago pago){
        Tarjeta tarjeta = tarjetaRepository.findById(pago.getTarjeta().getId())
        if (tarjeta == null){
            return "La tarjeta no existe";
        }
    }

    public Pago buscarPago(int id){
        return pagoRepository.findById(id).orElse(null);
    }
    
    public String eliminarPago(int id){
        Pago pago = pagoRepository.findById(id).orElse(null);
        if (pago != null){
            pagoRepository.delete(pago);
            return "Pago eliminado con éxito";
        
        }else{
            return "Pago no encontrado";
        }
    }
}
