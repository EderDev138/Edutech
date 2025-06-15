package com.edutech.apiedutech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(pagoRepository.findById(pago.getId()) != null){
            return "Pago no encotrado";
        }else{pagoRepository.save(pago);
            return "Pago efectuado con éxito";

        }

        
    }
}
