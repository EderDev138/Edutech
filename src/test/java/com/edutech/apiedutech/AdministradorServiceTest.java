package com.edutech.apiedutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.apiedutech.model.Administrador;
import com.edutech.apiedutech.repository.AdministradorRepository;
import com.edutech.apiedutech.service.AdministradorService;

@ExtendWith(MockitoExtension.class)
public class AdministradorServiceTest {

    @Mock
    private AdministradorRepository administradorRepository;

    @InjectMocks
    private AdministradorService administradorService;

    @Test
    void crearAdministradorNoExistente(){
        Administrador administrador = new Administrador();
        administrador.setNombre("Admin01");
        administrador.setEmail("admin01@correo.cl");
        administrador.setContrasena("123456");
        
        when(administradorRepository.existsById(administrador.getEmail())).thenReturn(false);

        String resultado = administradorService.agregarAdmin(administrador);

        assertEquals("Administrador agregado exitosamente", resultado);
        
    }
    @Test
    void crearAdminstradorExistente(){
        Administrador administrador = new Administrador();
        administrador.setNombre("Admin01");
        administrador.setEmail("admin01@correo.cl");
        administrador.setContrasena("123456");
        
        when(administradorRepository.existsById(administrador.getEmail())).thenReturn(true);
    
        String resultado = administradorService.agregarAdmin(administrador);
    
        assertEquals("Email para administrador ya existe, por favor use otro", resultado);
        
    }

}
