package com.edu.unju.edm.PV2023.model;

import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;

@Component
@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlumno;
    private Integer dniAlumno;
    private String nombreAlumno;
    private String apellidoAlumno;
    private Boolean estadoAlumno;

    public Alumno(){super();}
    public Alumno(Integer idAlumno, Integer dniAlumno, String nombreAlumno, String apellidoAlumno, Boolean estadoAlumno){
        super();
        this.idAlumno = idAlumno;
        this.dniAlumno = dniAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.estadoAlumno = estadoAlumno;
    }
    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Integer getDniAlumno() {
        return dniAlumno;
    }

    public void setDniAlumno(Integer dniAlumno) {
        this.dniAlumno = dniAlumno;
    }

    public String getNombreAlumno(){
        return nombreAlumno;
    }
    public void setNombreAlumno(String nombreAlumno){
        this.nombreAlumno = nombreAlumno;
    }
    public String getApellidoAlumno(){
        return apellidoAlumno;
    }
    public void setApellidoAlumno(String apellidoAlumno){
        this.apellidoAlumno = apellidoAlumno;
    }
    public Boolean getEstadoAlumno() {
        return estadoAlumno;
    }
    public void setEstadoAlumno (Boolean estadoAlumno){
        this.estadoAlumno = estadoAlumno;
    }
}

