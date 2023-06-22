package com.edu.unju.edm.PV2023.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;**/

@Component
@Entity
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocente;
    
    @NotNull(message="se necesita: dniDocente")
    private Integer dniDocente;
    
    @NotBlank(message="se necesita: nombreDocente")
    @Size(min=3, max = 20)
    private String nombreDocente;
    
    @NotBlank(message="se necesita: apellidoDocente")
    @Size(min=3, max = 20)
    private String apellidoDocente;
    
    private Boolean estadoDocente;
    
    @NotBlank(message="se necesita: materiaDocente")
    private String materiaDocente;
    
    @Size(min=3, max=20, message=" entre 4 o 20 numeros")
    @NotNull(message="se necesita: contraseñaDocente")
    @Size (min=3, max=20)
    private String contraseñaDocente;
    
    @NotBlank(message="se necesita: emailDocente")
    @Email
    private String emailDocente;
    public Docente(){super();}
    public Docente(Integer idDocente, Integer dniDocente, String emailDocente, String nombreDocente, String apellidoDocente, Boolean estadoDocente, String materiaDocente, String contraseñaDocente){
        super();
        this.emailDocente = emailDocente;
        this.idDocente = idDocente;
        this.dniDocente = dniDocente;
        this.nombreDocente = nombreDocente;
        this.apellidoDocente = apellidoDocente;
        this.estadoDocente = estadoDocente;
        this.materiaDocente = materiaDocente;
        this.contraseñaDocente = contraseñaDocente;
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
	public String getNombreDocente() {
		return nombreDocente;
	}
	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}
	public String getApellidoDocente() {
		return apellidoDocente;
	}
	public void setApellidoDocente(String apellidoDocente) {
		this.apellidoDocente = apellidoDocente;
	}
	public Boolean getEstadoDocente() {
		return estadoDocente;
	}
	public void setEstadoDocente(Boolean estadoDocente) {
		this.estadoDocente = estadoDocente;
	}
	public String getMateriaDocente() {
		return materiaDocente;
	}
	public void setMateriaDocente(String materiaDocente) {
		this.materiaDocente = materiaDocente;
	}
	public String getContraseñaDocente() {
		return contraseñaDocente;
	}
	public void setContraseñaDocente(String contraseñaDocente) {
		this.contraseñaDocente = contraseñaDocente;
	}
	public String getEmailDocente() {
		return emailDocente;
	}
	public void setEmailDocente(String emailDocente) {
		this.emailDocente = emailDocente;
	}
    
  
}
