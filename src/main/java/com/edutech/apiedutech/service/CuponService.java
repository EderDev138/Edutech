package com.edutech.apiedutech.service;
// REALIZADO POR: ENCAR PORTILLO

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.Cupon;
import com.edutech.apiedutech.repository.CuponRepository;

@Service
public class CuponService {

    @Autowired
    private CuponRepository cuponRepository;

    public List<Cupon> listarCupones(){
        return cuponRepository.findAll();
    }

    public String crearCupon(Cupon cupon){
        if(cuponRepository.findByCodigo(cupon.getCodigo()) != null){
            return "El cupon " + cupon.getCodigo() + " que intenta ingresar ya existe";
        }
        cuponRepository.save(cupon);
        return "El cupón " + cupon.getCodigo() + " registrado correctamente";
    }



}
