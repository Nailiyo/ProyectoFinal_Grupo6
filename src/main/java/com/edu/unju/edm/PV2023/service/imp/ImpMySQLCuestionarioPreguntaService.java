package com.edu.unju.edm.PV2023.service.imp;

import com.edu.unju.edm.PV2023.model.CuestionarioPregunta;
import com.edu.unju.edm.PV2023.model.Pregunta;
import com.edu.unju.edm.PV2023.model.Cuestionario;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.repository.CuestionarioPreguntaRepository;
import com.edu.unju.edm.PV2023.repository.CuestionarioRepository;
import com.edu.unju.edm.PV2023.repository.PreguntaRepository;
import com.edu.unju.edm.PV2023.service.ICuestionarioPreguntaService;








@Service
//@Qualifier("serviceCuestionarioPreguntasMySQL")
public class ImpMySQLCuestionarioPreguntaService implements ICuestionarioPreguntaService {

	
	@Autowired
	CuestionarioPreguntaRepository cuestionarioPreguntaRepository;
	
	@Autowired 
	CuestionarioRepository cuestionarioRepository;
	
	@Autowired
	PreguntaRepository preguntaRepository;


	@Override
	public void cargarCuestionarioPregunta(CuestionarioPregunta unCuestionarioPregunta, Integer idCuestionario) {
		unCuestionarioPregunta.setCuestionario(cuestionarioRepository.findById(idCuestionario).get());
		cuestionarioPreguntaRepository.save(unCuestionarioPregunta);
		
	}

	@Override
	public void eliminarCuestionarioPregunta(Integer unIdCuestionarioPregunta) {
		// TODO Auto-generated method stub
		cuestionarioPreguntaRepository.deleteById(unIdCuestionarioPregunta);
	}

	@Override
	public ArrayList<CuestionarioPregunta> listarCuestionarioPreguntas() {
		// TODO Auto-generated method stub
		return (ArrayList<CuestionarioPregunta>) cuestionarioPreguntaRepository.findAll();
	}

	@Override
	public CuestionarioPregunta mostrarCuestionarioPregunta(Integer idCuestionarioPregunta) {
		// TODO Auto-generated method stub
		Optional<CuestionarioPregunta> aux= Optional.of(new CuestionarioPregunta());
		aux = cuestionarioPreguntaRepository.findById(idCuestionarioPregunta);
		return aux.get();

	}

	@Override
	public void eliminarTodosLosCuestionarioPreguntas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CuestionarioPregunta modificarCuestionarioPregunta(Integer idCuestionarioPregunta) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public void cargarPreguntasACuestionario(ArrayList<Integer> preguntasSeleccionadas,
			ArrayList<Integer> puntajesSeleccionados, Integer idCuestionario) {
		// TODO Auto-generated method stub
		for(int i=0;i<preguntasSeleccionadas.size();i++) {
			CuestionarioPregunta auxiliar= new CuestionarioPregunta();
			auxiliar.setPregunta(preguntaRepository.findById(preguntasSeleccionadas.get(i)).get());
			auxiliar.setPuntaje(puntajesSeleccionados.get(i));
			auxiliar.setCuestionario(cuestionarioRepository.findById(idCuestionario).get());
			
			cuestionarioPreguntaRepository.save(auxiliar);
		}
		
	}*/

	@Override
	public ArrayList<Pregunta> ListarPreguntasDeUnCuestionario(Integer idCuestionario) {
		Cuestionario aux = cuestionarioRepository.findById(idCuestionario).get();
        ArrayList<CuestionarioPregunta> cuestionarioPreguntas = cuestionarioPreguntaRepository.findAllByCuestionario(aux);
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        for(int i=0;i<cuestionarioPreguntas.size();i++) {
			preguntas.add(cuestionarioPreguntas.get(i).getPregunta());
		}
        return (ArrayList<Pregunta>) preguntas;
	}

	@Override
	public ArrayList<Integer> ListarRespuestasDePreguntas(Integer idCuestionario) {
		ArrayList<Pregunta> preguntas = ListarPreguntasDeUnCuestionario(idCuestionario);
		ArrayList<Integer> respuestas = new ArrayList<>();
		for(int i=0;i<preguntas.size();i++) {
			respuestas.add(preguntas.get(i).getOpcionCorrecta());
		}
		return respuestas;
	}

	@Override
	public ArrayList<Integer> ListadoDePuntajes(Integer idCuestionario) {
		Cuestionario aux = cuestionarioRepository.findById(idCuestionario).get();
        ArrayList<CuestionarioPregunta> cuestionarioPreguntas = cuestionarioPreguntaRepository.findAllByCuestionario(aux);
		ArrayList<Integer> puntajes = new ArrayList<Integer>();
		for(int i=0;i<cuestionarioPreguntas.size();i++) {
			puntajes.add(cuestionarioPreguntas.get(i).getPuntaje());
		}
		return puntajes;
	}

	@Override
	public ArrayList<Pregunta> ListarPreguntasNoSeleccionadas(ArrayList<Pregunta> seleccionadas,
			ArrayList<Pregunta> todasLasPreguntas) {
		ArrayList<Pregunta> noSeleccionadas = new ArrayList<Pregunta>(todasLasPreguntas);
		
		noSeleccionadas.removeAll(seleccionadas);
		
		return noSeleccionadas;
	}

	@Override
	public void obtenerPuntajeTotalDeUnCuestionario(Integer idCuestionario) {
		Cuestionario aux= cuestionarioRepository.findById(idCuestionario).get();
		Integer puntajeFinal=0;
		ArrayList<Integer> puntajes=ListadoDePuntajes(idCuestionario);
		for(int i=0; i <puntajes.size();i++) {
			puntajeFinal+=puntajes.get(i);
		}
		
		aux.setPuntajeFinal(puntajeFinal);
		cuestionarioRepository.save(aux);
	}
	
	
}
