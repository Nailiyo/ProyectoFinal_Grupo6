package com.edu.unju.edm.PV2023.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.unju.edm.PV2023.model.Pregunta;

@Repository
public interface PreguntaRepository extends CrudRepository <Pregunta, Integer>{

	public ArrayList<Pregunta> findByEstadoPregunta (Boolean estadoPregunta);
	
}
