package com.edutech.apiedutech.model;

@Entity
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int preguntaId;
    private int UsuarioId;
    private Boolean respuestaUsuario;
    private float puntaje;
    @ManyToOne
    @JoinColumn(name = "pregunta_id", nullable = false)
    private Pregunta pregunta;

    public Respuesta(){
        
    }

    public Respuesta(int id, int preguntaId, int usuarioId, Boolean respuestaUsuario, float puntaje) {
        this.id = id;
        this.preguntaId = preguntaId;
        UsuarioId = usuarioId;
        this.respuestaUsuario = respuestaUsuario;
        this.puntaje = puntaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(int preguntaId) {
        this.preguntaId = preguntaId;
    }

    public int getUsuarioId() {
        return UsuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        UsuarioId = usuarioId;
    }

    public Boolean getRespuestaUsuario() {
        return respuestaUsuario;
    }

    public void setRespuestaUsuario(Boolean respuestaUsuario) {
        this.respuestaUsuario = respuestaUsuario;
    }

    public float getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(float puntaje) {
        this.puntaje = puntaje;
    }

    
    }