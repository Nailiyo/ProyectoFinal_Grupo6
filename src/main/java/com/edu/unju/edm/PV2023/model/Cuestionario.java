package com.edu.unju.edm.PV2023.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Component
@Entity
public class Cuestionario {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer idCuestionario;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idDocente")
	Docente unDocente;
	
	//@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="idAlumno")
	//Alumno alumno;
	
	@NotNull(message = "se necesita:puntajeFinal")
	private Integer puntajeFinal;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idPregunta1")
	//@NotBlank(message= "se necesita: pregunta1")
	private Pregunta pregunta1;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idPregunta2")
	//@NotBlank(message= "se necesita: pregunta2")
	private Pregunta pregunta2;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idPregunta3")
	//@NotBlank(message= "se necesita: pregunta3")
	private Pregunta pregunta3;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idPregunta4")
	//@NotBlank(message="se necesita: pregunta4")
	private Pregunta pregunta4;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idPregunta5")
	//@NotBlank(message="se necesita: pregunta5")
	private Pregunta pregunta5;
	
	private Boolean estadoCuestionario;
	
	public Cuestionario(){}

	
	public Integer getIdCuestionario() {
		return idCuestionario;
	}
	public void setIdCuestionario(Integer idCuestionario) {
		this.idCuestionario = idCuestionario;
	}


	public Integer getPuntajeFinal() {
		return puntajeFinal;
	}


	public void setPuntajeFinal(Integer puntajeFinal) {
		this.puntajeFinal = puntajeFinal;
	}


	public Pregunta getPregunta1() {
		return pregunta1;
	}


	public void setPregunta1(Pregunta pregunta1) {
		this.pregunta1 = pregunta1;
	}


	public Pregunta getPregunta2() {
		return pregunta2;
	}


	public void setPregunta2(Pregunta pregunta2) {
		this.pregunta2 = pregunta2;
	}


	public Pregunta getPregunta3() {
		return pregunta3;
	}


	public void setPregunta3(Pregunta pregunta3) {
		this.pregunta3 = pregunta3;
	}


	public Pregunta getPregunta4() {
		return pregunta4;
	}


	public void setPregunta4(Pregunta pregunta4) {
		this.pregunta4 = pregunta4;
	}


	public Pregunta getPregunta5() {
		return pregunta5;
	}


	public void setPregunta5(Pregunta pregunta5) {
		this.pregunta5 = pregunta5;
	}


	public Boolean getEstadoCuestionario() {
		return estadoCuestionario;
	}


	public void setEstadoCuestionario(Boolean estadoCuestionario) {
		this.estadoCuestionario = estadoCuestionario;
	}


	public Docente getUnDocente() {
		return unDocente;
	}


	public void setUnDocente(Docente unDocente) {
		this.unDocente = unDocente;
	}
	
	
	
}
