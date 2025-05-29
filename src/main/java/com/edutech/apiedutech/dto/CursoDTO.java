package com.edutech.apiedutech.dto;

import java.util.ArrayList;
import java.util.List;

// REALIZADO POR: EDER VALDIVIA

public class CursoDTO {
       private String sigla;
       private String nombre;
       private List<UsuarioDTO> usuarios;

       public CursoDTO(){
              this.sigla = "";
              this.nombre = "";
              this.usuarios = new ArrayList<>();
       }

 

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }


}
