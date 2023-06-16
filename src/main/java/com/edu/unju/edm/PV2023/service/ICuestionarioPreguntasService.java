package com.edu.unju.edm.PV2023.service;

import java.util.ArrayList;
import com.edu.unju.edm.PV2023.model.CuestionarioPreguntas;


public interface ICuestionarioPreguntasService {

	public void cargarCuestionarioPreguntas(CuestionarioPreguntas unCuestionarioPreguntas);
	public void eliminarCuestionarioPreguntas(Integer unIdCuestionarioPreguntas);
	public ArrayList<CuestionarioPreguntas> listarCuestionarioPreguntas();
	public CuestionarioPreguntas mostrarUnCuestionarioPreguntas(Integer idCuestionarioPreguntas);
	public void eliminarTodosLosCuestionarioPreguntas();
	public CuestionarioPreguntas modificarUnCuestionarioPreguntas(Integer idCuestionarioPreguntas);
	
}
