package com.edutech.apiedutech.dto;
// REALIZADO POR: DAYANA VEGA

public class PreguntaDTO {
     private int id;
     private String enunciado;
     private int evaluacionId;
     
     public int getId() {
         return id;
     }
     public void setId(int id) {
         this.id = id;
     }
     public String getEnunciado() {
         return enunciado;
     }
     public void setEnunciado(String enunciado) {
         this.enunciado = enunciado;
     }
     public int getEvaluacionId() {
         return evaluacionId;
     }
     public void setEvaluacionId(int evaluacionId) {
         this.evaluacionId = evaluacionId;
     }

     
    

     
}
