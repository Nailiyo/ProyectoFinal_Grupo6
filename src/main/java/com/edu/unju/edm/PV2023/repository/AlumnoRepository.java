package com.edu.unju.edm.PV2023.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.unju.edm.PV2023.model.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository <Alumno, Integer>{

	public ArrayList<Alumno> findByEstadoAlumno (Boolean estadoAlumno);
	
}
