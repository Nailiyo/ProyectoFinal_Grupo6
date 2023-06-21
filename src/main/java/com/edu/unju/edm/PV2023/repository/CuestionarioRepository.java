package com.edu.unju.edm.PV2023.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.unju.edm.PV2023.model.Cuestionario;

@Repository
public interface CuestionarioRepository extends CrudRepository<Cuestionario, Integer>{
	
	ArrayList<Cuestionario> findByEstadoCuestionario (Boolean estadoCuestionario);
	
}
