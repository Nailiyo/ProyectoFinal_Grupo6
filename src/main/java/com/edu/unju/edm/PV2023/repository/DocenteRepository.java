package com.edu.unju.edm.PV2023.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.unju.edm.PV2023.model.Docente;

@Repository
public interface DocenteRepository extends CrudRepository <Docente, Integer>{

	public ArrayList<Docente> findByEstadoDocente (Boolean estadoDocente);

}
