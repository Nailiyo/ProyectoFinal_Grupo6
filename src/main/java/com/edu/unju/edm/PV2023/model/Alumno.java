package com.edu.unju.edm.PV2023.model;


import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Component
@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlumno;
    @NotNull(message="se necsita: dniAlumno")
    private Integer dniAlumno;
    @NotBlank(message="se necsita: nombreAlumno")
    @Size(min=3, max=20)
    private String nombreAlumno;
    @NotBlank(message="se necesita: apellidoAlumno")
    @Size(min=3, max=20)
    private String apellidoAlumno;
    private Boolean estadoAlumno;
    @Size(min=3, max=20, message=" entre 4 o 20 numeros")
    @NotNull(message="se necesita: contraseñaAlumno")
    @Size (min=3, max=20)
    private String contraseñaAlumno;
    @Email
    private String emailAlumno;
    public Alumno(){super();}
    public Alumno(Integer idAlumno,String emailAlumno, Integer dniAlumno, String nombreAlumno, String apellidoAlumno, Boolean estadoAlumno, String contraseñaAlumno){
        super();
        this.emailAlumno = emailAlumno;
        this.idAlumno = idAlumno;
        this.dniAlumno = dniAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.estadoAlumno = estadoAlumno;
        this.contraseñaAlumno = contraseñaAlumno;
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
	public String getContraseñaAlumno() {
		return contraseñaAlumno;
	}
	public void setContraseñaAlumno(String contraseñaAlumno) {
		this.contraseñaAlumno = contraseñaAlumno;
	}
    public String getEmailAlumno() {
        return emailAlumno;
    }
    public void setEmailAlumno(String emailAlumno) {
        this.emailAlumno = emailAlumno;
    }
}

