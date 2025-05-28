package com.edutech.apiedutech.dto;

public class ContenidoCursoDTO {


    private Long id;
    private String titulo;
    private String descripcion;
    private String urlContenido;
    private String cursoSigla;

    public ContenidoCursoDTO(){

    }

    public ContenidoCursoDTO(Long id, String titulo, String descripcion, String urlContenido, String cursoSigla) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlContenido = urlContenido;
        this.cursoSigla = cursoSigla;
    }

    


    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return String return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return String return the urlContenido
     */
    public String getUrlContenido() {
        return urlContenido;
    }

    /**
     * @param urlContenido the urlContenido to set
     */
    public void setUrlContenido(String urlContenido) {
        this.urlContenido = urlContenido;
    }

    /**
     * @return String return the cursoSigla
     */
    public String getCursoSigla() {
        return cursoSigla;
    }

    /**
     * @param cursoSigla the cursoSigla to set
     */
    public void setCursoSigla(String cursoSigla) {
        this.cursoSigla = cursoSigla;
    }

}
