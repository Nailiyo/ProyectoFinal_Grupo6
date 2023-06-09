package com.edu.unju.edm.PV2023.preguntasservice.imp;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.model.Preguntas;
import com.edu.unju.edm.PV2023.preguntasrepository.PreguntasRepository;
import com.edu.unju.edm.PV2023.preguntasservice.IPreguntasService;

@Service
@Qualifier("servicePreguntaMySQL")
public class ImpMySQLPreguntasService implements IPreguntasService{

	@Autowired
	PreguntasRepository preguntasRepository;
	
	private static final Log grupo6 = LogFactory.getLog(ImpMySQLPreguntasService.class);
	
	@Override
	public void cargarPreguntas(Preguntas unaPregunta) {
		
		unaPregunta.setEstado(true);
		preguntasRepository.save(unaPregunta);
		
	}

	@Override
	public ArrayList<Preguntas> listarPreguntas() {
		
		return (ArrayList<Preguntas>) preguntasRepository.findByEstado(true);
	}

	@Override
	public Preguntas mostrarUnaPregunta(Integer idPregunta) {
		// TODO Auto-generated method stub
		Optional<Preguntas> auxiliar = Optional.of(new Preguntas());
		auxiliar = preguntasRepository.findById(idPregunta);
		return auxiliar.get();
	}

	@Override
	public void eliminarTodosLasPreguntas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Preguntas modificarUnaPregunta(Integer idPregunta) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eliminarPreguntas(Integer idPregunta) {
		//productoRepository.deleteById(unCodigo);
		Optional<Preguntas> auxiliar=Optional.of(new Preguntas());
		auxiliar= preguntasRepository.findById(idPregunta);
		auxiliar.get().setEstado(false);
		preguntasRepository.save(auxiliar.get());
	}
}
