package com.edu.unju.edm.PV2023.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.unju.edm.PV2023.model.Cuestionario;
import com.edu.unju.edm.PV2023.model.CuestionarioPregunta;

@Repository
public interface CuestionarioPreguntaRepository extends CrudRepository<CuestionarioPregunta, Integer>{

	ArrayList<CuestionarioPregunta> findAllByCuestionario(Cuestionario unCuestionario);
	
}
