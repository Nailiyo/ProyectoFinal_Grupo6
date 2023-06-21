package com.edu.unju.edm.PV2023.model;

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
public class CuestionarioPregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCuestionarioPregunta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idPregunta")
	Pregunta pregunta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCuestionario")
	Cuestionario cuestionario;

	public CuestionarioPregunta(){}
	public CuestionarioPregunta(Pregunta pregunta, Cuestionario cuestionario, Integer idCuestionarioPregunta) {
        super();
        this.idCuestionarioPregunta = idCuestionarioPregunta;
        this.pregunta = pregunta;
        this.cuestionario = cuestionario;
    }	
	
	public Integer getIdCuestionarioPregunta() {
		return idCuestionarioPregunta;
	}
	public void setIdCuestionarioPregunta(Integer idCuestionarioPregunta) {
		this.idCuestionarioPregunta = idCuestionarioPregunta;
	}
	public Cuestionario getCuestionario() {
		return cuestionario;
	}
	public void setCuestionario(Cuestionario cuestionario) {
		this.cuestionario = cuestionario;
	}
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}	 	
	
}
