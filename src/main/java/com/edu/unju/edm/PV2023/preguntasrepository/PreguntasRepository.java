package com.edu.unju.edm.PV2023.preguntasrepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.edu.unju.edm.PV2023.model.Preguntas;

public interface PreguntasRepository extends CrudRepository <Preguntas, Integer>{

	public List<Preguntas> findByEstado (Boolean estado);
	
}
