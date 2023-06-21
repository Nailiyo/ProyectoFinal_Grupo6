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
import jakarta.validation.constraints.NotNull;
@Component
@Entity
public class CuestionarioAlumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCuestionarioAlumno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idAlumno")
	Alumno unAlumno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCuestionario")
	Cuestionario unCuestionario;
	
	@NotNull(message="se necesita: FechaRealizada")
	private Date fechaCompletado;
	
	@NotNull(message="se necesita: Puntaje Logrado")
	private Integer puntajeLogrado;
	
	private Boolean estadoCuestionarioAlumno;
	
	public CuestionarioAlumno() {}
	public CuestionarioAlumno(Alumno unAlumno, Cuestionario unCuestionario, Date fechaCompletado, Integer puntajeLogrado, Boolean estadoCuestionarioAlumno) {
		this.unAlumno = unAlumno;
        this.unCuestionario = unCuestionario;
        this.fechaCompletado = fechaCompletado;
        this.puntajeLogrado = puntajeLogrado;
        this.estadoCuestionarioAlumno = estadoCuestionarioAlumno;
    }
	public Integer getIdCuestionarioAlumno() {
		return idCuestionarioAlumno;
	}
	public void setIdCuestionarioAlumno(Integer idCuestionarioAlumno) {
		this.idCuestionarioAlumno= idCuestionarioAlumno;
	}
	public Alumno getUnAlumno() {
		return unAlumno;
	}
	public void setUnAlumno(Alumno unAlumno) {
		this.unAlumno = unAlumno;
	}
	public Cuestionario getUnCuestionario() {
		return unCuestionario;
	}
	public void setunCuestionario(Cuestionario unCuestionario) {
		this.unCuestionario = unCuestionario;
	}
	public Date getFechaCompletado() {
		return fechaCompletado;
	}
	public void setFechaCompletado(Date fechaCompletado) {
		this.fechaCompletado = fechaCompletado;
	}
	public Integer getPuntajeLogrado() {
		return puntajeLogrado;
	}
	public void setPuntajeLogrado(Integer puntajeLogrado) {
		this.puntajeLogrado = puntajeLogrado;
	}
	public Boolean getEstadoCuestionarioAlumno() {
		return estadoCuestionarioAlumno;
	}
	public void setEstadoCuestionarioAlumno(Boolean estadoCuestionarioAlumno) {
		this.estadoCuestionarioAlumno = estadoCuestionarioAlumno;
	}
}
