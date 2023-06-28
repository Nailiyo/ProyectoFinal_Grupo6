package com.edu.unju.edm.PV2023.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;**/

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
	
	private Integer puntaje;

	public CuestionarioPregunta(){}
	public CuestionarioPregunta(Pregunta pregunta, Cuestionario cuestionario, Integer idCuestionarioPregunta, Integer puntaje) {
        super();
        this.idCuestionarioPregunta = idCuestionarioPregunta;
        this.pregunta = pregunta;
        this.cuestionario = cuestionario;
        this.puntaje = puntaje;
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
	public Integer getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}	 	
	
}
