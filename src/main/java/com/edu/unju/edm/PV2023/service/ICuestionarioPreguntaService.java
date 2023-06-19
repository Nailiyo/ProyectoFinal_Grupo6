package com.edu.unju.edm.PV2023.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.model.CuestionarioPregunta;

@Service
public interface ICuestionarioPreguntaService {

	public void cargarCuestionarioPregunta(CuestionarioPregunta unCuestionarioPregunta);
	public void eliminarCuestionarioPregunta(Integer unIdCuestionarioPregunta);
	public ArrayList<CuestionarioPregunta> listarCuestionarioPreguntas();
	public CuestionarioPregunta mostrarCuestionarioPregunta(Integer idCuestionarioPregunta);
	public void eliminarTodosLosCuestionarioPreguntas();
	public CuestionarioPregunta modificarCuestionarioPregunta(Integer idCuestionarioPregunta);
	
}
