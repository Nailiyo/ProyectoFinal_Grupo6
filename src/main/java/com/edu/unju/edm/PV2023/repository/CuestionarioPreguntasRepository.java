package com.edu.unju.edm.PV2023.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.unju.edm.PV2023.model.CuestionarioPreguntas;

@Repository
public interface CuestionarioPreguntasRepository extends CrudRepository<CuestionarioPreguntas, Integer> {

}
