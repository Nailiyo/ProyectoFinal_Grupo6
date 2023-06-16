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
	
	private String nivel;
	private Integer puntaje;
	private Integer puntajeTotal;
	private Date fechaCuestionario;
	private Boolean estadoCuestionario;
	
	public Cuestionario() {
		
	}
	
	public Cuestionario(Integer idCuestionario, String nivel, Integer puntaje, Integer puntajeTotal, Date fechaCuestionario, Boolean estadoCuestionario) {
		this.idCuestionario = idCuestionario;
		this.nivel = nivel;
		this.puntaje = puntaje;
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
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public Integer getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
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
