package com.edu.unju.edm.PV2023.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Component
@Entity
public class Cuestionario {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer idCuestionario;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idDocente")
	Docente docente;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idAlumno")
	Alumno alumno;
	
	private String nivelCuestionario;
	private Integer puntajeCuestionario;
	private Integer puntajeTotal;
	private Date fechaCuestionario;
	private Boolean estadoCuestionario;
	
	public Cuestionario() {
		
	}
	
	public Cuestionario(Integer idCuestionario, String nivelCuestionario, Integer puntajeCuestionario, Integer puntajeTotal, Date fechaCuestionario, Boolean estadoCuestionario) {
		this.idCuestionario = idCuestionario;
		this.nivelCuestionario = nivelCuestionario;
		this.puntajeCuestionario = puntajeCuestionario;
		this.puntajeTotal = puntajeTotal;
		this.fechaCuestionario = fechaCuestionario;
		this.estadoCuestionario = estadoCuestionario;
	}
	
	public Integer getIdCuestionario() {
		return idCuestionario;
	}
	public void setIdCuestionario(Integer idCuestionario) {
		this.idCuestionario = idCuestionario;
	}
	public String getNivelCuestionario() {
		return nivelCuestionario;
	}
	public void setNivelCuestionario(String nivel) {
		this.nivelCuestionario = nivel;
	}
	public Integer getPuntajeCuestionario() {
		return puntajeCuestionario;
	}
	public void setPuntajeCuestionario(Integer puntaje) {
		this.puntajeCuestionario = puntaje;
	}
	public Integer getPuntajeTotal() {
		return puntajeTotal;
	}
	public void setPuntajeTotal(Integer puntajeTotal) {
		this.puntajeTotal = puntajeTotal;
	}
	public Date getFechaCuestionario() {
		return fechaCuestionario;
	}
	public void setFecha(Date fechaCuestionario) {
		this.fechaCuestionario = fechaCuestionario;
	}

	public Boolean getEstadoCuestionario() {
		return estadoCuestionario;
	}

	public void setEstadoCuestionario(Boolean estadoCuestionario) {
		this.estadoCuestionario = estadoCuestionario;
	}
	
	
}
