package com.edu.unju.edm.PV2023.alumnorepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.edu.unju.edm.PV2023.model.Alumno;

public interface AlumnoRepository extends CrudRepository <Alumno, Integer>{

	public List<Alumno> findByEstado (Boolean estado);
	
}
