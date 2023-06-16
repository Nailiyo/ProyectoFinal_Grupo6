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
	Alumno alumno;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCuestionario")
	Cuestionario cuestionario;
	@NotNull(message="se necesita: FechaRealizada")
	private Date fechaCompletado;
	@NotNull(message="se necesita: Puntaje Logrado")
	private int puntajeLogrado;
	private Boolean estado;
	
	public CuestionarioAlumno() {}
	public CuestionarioAlumno(Alumno alumno, Cuestionario cuestionario, Date fechaCompletado, int puntajeLogrado, Boolean estado) {
		this.alumno = alumno;
        this.cuestionario = cuestionario;
        this.fechaCompletado = fechaCompletado;
        this.puntajeLogrado = puntajeLogrado;
        this.estado = estado;
    }
	public Integer getIdCuestionarioAlumno() {
		return idCuestionarioAlumno;
	}
	public void setIdCuestionarioAlumno(Integer idCuestionarioAlumno) {
		this.idCuestionarioAlumno= idCuestionarioAlumno;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Cuestionario getCuestionario() {
		return cuestionario;
	}
	public void setCuestionario(Cuestionario cuestionario) {
		this.cuestionario = cuestionario;
	}
	public Date getFechaCompletado() {
		return fechaCompletado;
	}
	public void setFechaCompletado(Date fechaCompletado) {
		this.fechaCompletado = fechaCompletado;
	}
	public int getPuntajeLogrado() {
		return puntajeLogrado;
	}
	public void setPuntajeLogrado(int puntajeLogrado) {
		this.puntajeLogrado = puntajeLogrado;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
