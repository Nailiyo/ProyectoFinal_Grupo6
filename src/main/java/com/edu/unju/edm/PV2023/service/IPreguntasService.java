package com.edu.unju.edm.PV2023.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.model.Preguntas;

@Service
public interface IPreguntasService {

	public void cargarPreguntas(Preguntas unaPregunta);
	public void eliminarPreguntas(Integer idPregunta);
	public ArrayList<Preguntas> listarPreguntas();
	public Preguntas mostrarUnaPregunta(Integer idPregunta);
	public void eliminarTodosLasPreguntas();
	public Preguntas modificarUnaPregunta(Integer idPregunta);
	
}
