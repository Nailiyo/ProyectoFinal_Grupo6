package com.edu.unju.edm.PV2023.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.unju.edm.PV2023.model.Preguntas;

@Repository
public interface PreguntasRepository extends CrudRepository <Preguntas, Integer>{

	public ArrayList<Preguntas> findByEstado (Boolean estado);
	
}
