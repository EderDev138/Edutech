package com.edutech.apiedutech.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.Cupon;
import com.edutech.apiedutech.model.Pago;
import com.edutech.apiedutech.model.Tarjeta;
import com.edutech.apiedutech.repository.PagoRepository;
import com.edutech.apiedutech.repository.PreguntaRepository;
import com.edutech.apiedutech.repository.TarjetaRepository;

// REALIZADO POR: DAYANA VEGA

@Service
public class PagoService {

    private final PreguntaRepository preguntaRepository;

    @Autowired
    private PagoRepository pagoRepository;


    @Autowired
    private TarjetaRepository tarjetaRepository;

    PagoService(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

   public String realizarPago(Pago pago) {
    if (pago.getTarjeta() == null || pago.getTarjeta().getId() == 0){
        return "Debe proporcionar una tarjeta válida con ID";
    }

    Optional<Tarjeta> tarjeta = tarjetaRepository.findById(pago.getTarjeta().getId());
    if (tarjeta.isEmpty()) {
        return "La tarjeta no existe";
    }

    pago.setTarjeta(tarjeta.get()); // Asegura que se guarda con la entidad persistida
    pagoRepository.save(pago);
    return "Pago guardado con éxito";
}


    public Pago buscarPagoPorId(int id) {
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
    public int calcularDescuento(int monto, Cupon cupon){
        int descuento = cupon.getCantidadDescuento();
        return monto - ((monto * descuento)/100);
    }
}
