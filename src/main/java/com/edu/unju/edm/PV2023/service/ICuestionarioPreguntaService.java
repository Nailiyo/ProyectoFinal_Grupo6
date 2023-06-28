package com.edu.unju.edm.PV2023.service;

import java.util.ArrayList;


import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.model.CuestionarioPregunta;
import com.edu.unju.edm.PV2023.model.Pregunta;



@Service
public interface ICuestionarioPreguntaService {

	public void cargarCuestionarioPregunta(CuestionarioPregunta unCuestionarioPregunta, Integer idCuestionario);
	public void eliminarCuestionarioPregunta(Integer unIdCuestionarioPregunta);
	public ArrayList<CuestionarioPregunta> listarCuestionarioPreguntas();
	public CuestionarioPregunta mostrarCuestionarioPregunta(Integer idCuestionarioPregunta);
	public void eliminarTodosLosCuestionarioPreguntas();
	public CuestionarioPregunta modificarCuestionarioPregunta(Integer idCuestionarioPregunta);
	//public void cargarPreguntasACuestionario (ArrayList<Integer> preguntasSeleccionadas,ArrayList<Integer> puntajesSeleccionados, Integer idCuestionario);
	public ArrayList<Pregunta> ListarPreguntasDeUnCuestionario(Integer idCuestionario);
	public ArrayList<Integer> ListarRespuestasDePreguntas(Integer idCuestionario);
	public ArrayList<Integer> ListadoDePuntajes (Integer idCuestionario);
	public ArrayList<Pregunta> ListarPreguntasNoSeleccionadas(ArrayList<Pregunta> seleccionadas, ArrayList<Pregunta> todasLasPreguntas);
	public void obtenerPuntajeTotalDeUnCuestionario(Integer idCuestionario);
	
	
	
}
