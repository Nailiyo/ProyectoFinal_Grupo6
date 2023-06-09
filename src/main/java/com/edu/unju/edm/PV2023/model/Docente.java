package com.edu.unju.edm.PV2023.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Component
@Entity
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocente;
    private Integer dniDocente;
    private String nombreDocente;
    private String apellidoDocente;
    private Boolean estadoDocente;

    public Docente(){super();}
    public Docente(Integer idDocente, Integer dniDocente, String nombreDocente, String apellidoDocente, Boolean estadoDocente){
        super();
        this.idDocente = idDocente;
        this.dniDocente = dniDocente;
        this.nombreDocente = nombreDocente;
        this.apellidoDocente = apellidoDocente;
        this.estadoDocente = estadoDocente;
    }
    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public Integer getDniDocente() {
        return dniDocente;
    }

    public void setDniDocente(Integer dniDocente) {
        this.dniDocente = dniDocente;
    }

    public String getNombreDocente(){
        return nombreDocente;
    }
    public void setNombreDocente(String nombreDocente){
        this.nombreDocente = nombreDocente;
    }
    public String getApellidoDocente(){
        return apellidoDocente;
    }
    public void setApellidoDocente(String apellidoDocente){
        this.apellidoDocente = apellidoDocente;
    }
    public Boolean getEstadoDocente() {
        return estadoDocente;
    }
    public void setEstadoDocente(Boolean estadoDocente){
        this.estadoDocente = estadoDocente;
    }
}
