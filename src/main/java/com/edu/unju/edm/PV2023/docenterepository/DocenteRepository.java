package com.edu.unju.edm.PV2023.docenterepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.unju.edm.PV2023.model.Docente;

@Repository
public interface DocenteRepository extends CrudRepository <Docente, Integer>{

	public List<Docente> findByEstado (Boolean estado);

}
