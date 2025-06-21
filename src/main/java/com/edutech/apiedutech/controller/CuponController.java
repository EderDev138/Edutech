package com.edutech.apiedutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.apiedutech.model.Cupon;
import com.edutech.apiedutech.service.CuponService;


@RestController
@RequestMapping("/cupones")
public class CuponController {

    @Autowired
    private CuponService cuponService;

    @GetMapping
    public List<Cupon> listar(){
        return cuponService.listarCupones();
    }

    @PostMapping
    public String agregarCupon(@RequestBody Cupon cupon){
        return cuponService.crearCupon(cupon);
        
    }

    @DeleteMapping
    public String eliminar(){
        return cuponService.eliminarTodo();
    }

    @DeleteMapping("/{codigo}")
    public String eliminarCupon(@PathVariable String codigo){
        return cuponService.eliminarCupon(codigo);
    }

}
