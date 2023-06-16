package com.edu.unju.edm.PV2023.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Component
public class CuestionarioPreguntas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCuestionarioPreguntas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idPregunta")
	Preguntas preguntas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCuestionario")
	Cuestionario cuestionario;

	public CuestionarioPreguntas(){}
	public CuestionarioPreguntas(Preguntas preguntas, Cuestionario cuestionario) {
        super();
        this.preguntas = preguntas;
        this.cuestionario = cuestionario;
    }	
	public Integer getIdCuestionarioPreguntas() {
		return idCuestionarioPreguntas;
	}
	public void setIdCuestionarioPreguntas(Integer idCuestionarioPreguntas) {
		this.idCuestionarioPreguntas = idCuestionarioPreguntas;
	}
	public Cuestionario getCuestionario() {
		return cuestionario;
	}
	public void setCuestionario(Cuestionario cuestionario) {
		this.cuestionario = cuestionario;
	}
	public Preguntas getPreguntas() {
		return preguntas;
	}
	public void setPregunta(Preguntas preguntas) {
		this.preguntas = preguntas;
	}	
}