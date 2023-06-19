package com.edu.unju.edm.PV2023.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.model.Pregunta;

@Service
public interface IPreguntaService {

	public void cargarPregunta(Pregunta unaPregunta);
	public void eliminarPregunta(Integer unIdPregunta);
	public ArrayList<Pregunta> listarPreguntas();
	public Pregunta mostrarPregunta(Integer idPregunta);
	public void eliminarTodosLasPreguntas();
	public Pregunta modificarPregunta(Integer idPregunta);
	
}