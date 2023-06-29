package com.edu.unju.edm.PV2023.service.imp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.model.CuestionarioAlumno;
import com.edu.unju.edm.PV2023.model.Pregunta;
import com.edu.unju.edm.PV2023.repository.CuestionarioAlumnoRepository;
import com.edu.unju.edm.PV2023.service.ICuestionarioAlumnoService;
import com.edu.unju.edm.PV2023.service.ICuestionarioPreguntaService;


@Service
//@Qualifier("serviceCuestionarioAlumnoMySQL")
public class ImpMySQLCuestionarioAlumnoService implements ICuestionarioAlumnoService {

	@Autowired
	CuestionarioAlumnoRepository cuestionarioAlumnoRepository;
	
	@Autowired
	ICuestionarioPreguntaService cuestionarioPreguntaService;
	
	
	@Override
	public void cargarCuestionarioAlumno(CuestionarioAlumno unCuestionarioAlumno) {
		
		cuestionarioAlumnoRepository.save(unCuestionarioAlumno);
		
	}

	@Override
	public ArrayList<CuestionarioAlumno> listarCuestionarioAlumnos() {
		
		return (ArrayList<CuestionarioAlumno>) cuestionarioAlumnoRepository.findAll();
	}

	@Override
	public CuestionarioAlumno mostrarCuestionarioAlumno(Integer idCuestionarioAlumno) {
		// TODO Auto-generated method stub
		Optional<CuestionarioAlumno> auxiliar = Optional.of(new CuestionarioAlumno());
		auxiliar = cuestionarioAlumnoRepository.findById(idCuestionarioAlumno);
		return auxiliar.get();
	}

	@Override
	public void eliminarTodosLosCuestionarioAlumno() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CuestionarioAlumno modificarCuestionarioAlumno(Integer idCuestionarioAlumno) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eliminarCuestionarioAlumno(Integer unIdCuestionarioAlumno) {
		CuestionarioAlumno aux = cuestionarioAlumnoRepository.findById(unIdCuestionarioAlumno).get();
		cuestionarioAlumnoRepository.delete(aux);
	}

	@Override
	public Integer calcularPuntajeObtenido(Integer idCuestionario, Map<String, String> opcionesElegidas) {
		ArrayList<Pregunta> preguntas = cuestionarioPreguntaService.ListarPreguntasDeUnCuestionario(idCuestionario);
		ArrayList<Integer> opcionesCorrectas = cuestionarioPreguntaService.ListarRespuestasDePreguntas(idCuestionario);
		ArrayList<Integer> puntajes= cuestionarioPreguntaService.ListadoDePuntajes(idCuestionario);
		Integer puntajeObtenido=0;
		
		for(int i=0;i<preguntas.size();i++) {
			String opcion= opcionesElegidas.get("respuestasSeleccionadas[" + preguntas.get(i).getIdPregunta() + "]");
			Integer aux= Integer.parseInt(opcion);
			if(aux==opcionesCorrectas.get(i)) {
				puntajeObtenido+=puntajes.get(i);
			}
		}
		return puntajeObtenido;
	}
	

	@Override
	public String fechaActual() {
		LocalDate fechaActual = LocalDate.now();
		String fechaString = fechaActual.toString();

		return fechaString;
	}

	
}
