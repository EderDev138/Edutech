package com.edutech.apiedutech.dto;

public class AdministradorIncidenciaDTO {

    private String adminId;
    private Long incidenciaId;
    
    public AdministradorIncidenciaDTO(){

    }

    public AdministradorIncidenciaDTO(String adminId, Long incidenciaId) {
        this.adminId = adminId;
        this.incidenciaId = incidenciaId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Long getIncidenciaId() {
        return incidenciaId;
    }

    public void setIncidenciaId(Long incidenciaId) {
        this.incidenciaId = incidenciaId;
    }

    

}
