package com.edu.unju.edm.PV2023.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.model.Cuestionario;


@Service
public interface ICuestionarioService {

	public void cargarCuestionario(Cuestionario unCuestionario);
	public void eliminarCuestionario(Integer unIdCuestionario);
	public ArrayList<Cuestionario> listarCuestionarios();
	public Cuestionario mostrarCuestionario(Integer idCuestionario);
	public void eliminarTodosLosCuestionarios();
	public Cuestionario modificarCuestionario(Integer idCuestionario);
	
}
