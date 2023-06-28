package com.edu.unju.edm.PV2023.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;**/

@Component
@Entity
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPregunta;
    
    @NotBlank(message="se necesita: descripcion")
    @Size(min=5, max=20, message="INGRESA PREGUNTA LOCO")
    private String descripcion;
    
    @NotBlank(message="COLOCA OPCION 1")
    @Size(min=5, max=20)
    private String opcion1;
    
    @NotBlank(message="COLOCA OPCION 2")
    @Size(min=5, max=20)
    private String opcion2;
    
    @NotBlank(message="COLOCA OPCION 3")
    @Size(min=5, max=20)
    private String opcion3;
    
    @NotBlank(message="COLOCA OPCION 4")
    @Size(min=5, max=20)
    private String opcion4;
    
    private Integer opcionCorrecta;
    
    /**@NotNull(message="CUANTO PUNTOS VALE")
    private Integer puntaje;**/
    
    private Boolean estadoPregunta;
    
    private Integer nivelPregunta;
    public Pregunta(){}
    public Pregunta(Integer idPregunta,Integer puntaje,Integer nivelPregunta, String descripcion, String opcion1,
                     String opcion2, String opcion3, String opcion4, Integer opcionCorrecta, Boolean estadoPregunta){
        this.idPregunta = idPregunta;
        this.descripcion = descripcion;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.opcionCorrecta = opcionCorrecta;
        this.estadoPregunta = estadoPregunta;
        //this.puntaje = puntaje;
        this.nivelPregunta = nivelPregunta;
    }

    public Integer getNivelPregunta() {
        return nivelPregunta;
    }

    public void setNivelPregunta(Integer nivelPregunta) {
        this.nivelPregunta = nivelPregunta;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public Integer getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(Integer opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }

    public Boolean getEstadoPregunta() {
        return estadoPregunta;
    }

    /**public Integer getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(Integer puntaje){
        this.puntaje = puntaje;
    }**/

    public void setEstadoPregunta(Boolean estadoPregunta) {
        this.estadoPregunta = estadoPregunta;
    }

}
