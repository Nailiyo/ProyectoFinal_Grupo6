package com.edu.unju.edm.PV2023.service.imp;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.model.Pregunta;
import com.edu.unju.edm.PV2023.repository.PreguntaRepository;
import com.edu.unju.edm.PV2023.service.IPreguntaService;


@Service
@Qualifier("servicePreguntaMySQL")
public class ImpMySQLPreguntaService implements IPreguntaService{

	@Autowired
	PreguntaRepository preguntaRepository;
	
	
	@Override
	public void cargarPregunta(Pregunta unaPregunta) {
		
		unaPregunta.setEstadoPregunta(true);
		preguntaRepository.save(unaPregunta);
		
	}

	@Override
	public ArrayList<Pregunta> listarPreguntas() {
		
		return (ArrayList<Pregunta>) preguntaRepository.findByEstadoPregunta(true);
	}

	@Override
	public Pregunta mostrarPregunta(Integer idPregunta) {
		// TODO Auto-generated method stub
		Optional<Pregunta> auxiliar = Optional.of(new Pregunta());
		auxiliar = preguntaRepository.findById(idPregunta);
		return auxiliar.get();
	}

	@Override
	public void eliminarTodosLasPreguntas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pregunta modificarPregunta(Integer idPregunta) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eliminarPregunta(Integer idPregunta) {
		//preguntasRepository.deleteById(idPregunta);
		Optional<Pregunta> auxiliar=Optional.of(new Pregunta());
		auxiliar= preguntaRepository.findById(idPregunta);
		auxiliar.get().setEstadoPregunta(false);
		preguntaRepository.save(auxiliar.get());
	}
}
