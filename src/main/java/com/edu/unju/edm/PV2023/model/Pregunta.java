package com.edu.unju.edm.PV2023.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Component
@Entity
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPregunta;
    private String descripcion;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    private Integer opcionCorrecta;
    private Integer puntaje;
    private Boolean estadoPregunta;
    private String nivelPregunta;
    public Pregunta(){}
    public Pregunta(Integer idPregunta,Integer puntaje,String nivelPregunta, String descripcion, String opcion1,
                     String opcion2, String opcion3, String opcion4, Integer opcionCorrecta, Boolean estadoPregunta){
        this.idPregunta = idPregunta;
        this.descripcion = descripcion;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.opcionCorrecta = opcionCorrecta;
        this.estadoPregunta = estadoPregunta;
        this.puntaje = puntaje;
        this.nivelPregunta = nivelPregunta;
    }

    public String getNivelPregunta() {
        return nivelPregunta;
    }

    public void setNivelPregunta(String nivelPregunta) {
        this.nivelPregunta = nivelPregunta;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public Integer getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(Integer opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }

    public Boolean getEstadoPregunta() {
        return estadoPregunta;
    }

    public Integer getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(Integer puntaje){
        this.puntaje = puntaje;
    }

    public void setEstadoPregunta(Boolean estadoPregunta) {
        this.estadoPregunta = estadoPregunta;
    }

}
