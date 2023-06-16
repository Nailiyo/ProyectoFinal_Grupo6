package com.edu.unju.edm.PV2023.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
	
	@NotNull(message = "se necesita:puntajeFinal")
	private Integer puntajeFinal;
	@NotBlank(message= "se necesita: pregunta1")
	private String pregunta1;
	@NotBlank(message= "se necesita: pregunta2")
	private String pregunta2;
	@NotBlank(message= "se necesita: pregunta3")
	private String pregunta3;
	@NotBlank(message="se necesita: pregunta4")
	private String pregunta4;
	@NotBlank(message="se necesita: pregunta5")
	private String pregunta5;
	private Boolean estado;
	
	public Cuestionario(){}

	public Cuestionario(Integer idCuestionario, String pregunta1,
	String pregunta2, String pregunta3, String pregunta4, String pregunta5,
	Docente docente, Integer puntajeFinal) {
		super();
		this.pregunta1 = pregunta1;
		this.pregunta2 = pregunta2;
		this.pregunta3 = pregunta3;
		this.pregunta4 = pregunta4;
		this.pregunta5 = pregunta5;
		this.idCuestionario = idCuestionario;
		this.docente = docente;
		this.puntajeFinal = puntajeFinal;
	}
	public Integer getIdCuestionario() {
		return idCuestionario;
	}
	public void setIdCuestionario(Integer idCuestionario) {
		this.idCuestionario = idCuestionario;
	}
	public String getPregunta1() {
		return pregunta1;
	}
	public void setPregunta1(String pregunta1) {
		this.pregunta1 = pregunta1;
	}
	public String getPregunta2() {
		return pregunta2;
	}
	public void setPregunta2(String pregunta2) {
		this.pregunta2 = pregunta2;
	}
	public String getPregunta3() {
		return pregunta3;
	}
	public void setPregunta3(String pregunta3) {
		this.pregunta3 = pregunta3;
	}
	public String getPregunta4() {
		return pregunta4;
	}
	public void setPregunta4(String pregunta4) {
		this.pregunta4 = pregunta4;
	}
	public String getPregunta5() {
		return pregunta5;
	}
	public void setPregunta5(String pregunta5) {
		this.pregunta5 = pregunta5;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
		public Integer getPuntajeFinal() {
		return puntajeFinal;
	}
	public void setPuntajeFinal(Integer puntajeFinal) {
		this.puntajeFinal = puntajeFinal;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}	
}
