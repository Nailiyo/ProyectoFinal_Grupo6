package com.edu.unju.edm.PV2023.service.imp;

import com.edu.unju.edm.PV2023.model.CuestionarioPregunta;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.repository.CuestionarioPreguntaRepository;
import com.edu.unju.edm.PV2023.service.ICuestionarioPreguntaService;

@Service
//@Qualifier("serviceCuestionarioPreguntasMySQL")
public class ImpMySQLCuestionarioPreguntaService implements ICuestionarioPreguntaService {

	
	@Autowired
	CuestionarioPreguntaRepository cuestionarioPreguntaRepository;
	
	private static final Log G6 = LogFactory.getLog(ImpMySQLCuestionarioPreguntaService.class);

	@Override
	public void cargarCuestionarioPregunta(CuestionarioPregunta unCuestionarioPregunta) {
		
		//unCuestionarioPreguntas.setEstadoCuestionarioPreguntas(true);
		cuestionarioPreguntaRepository.save(unCuestionarioPregunta);
		
	}

	@Override
	public ArrayList<CuestionarioPregunta> listarCuestionarioPreguntas() {
		
	//return (ArrayList<CuestionarioPregunta>) cuestionarioPreguntaRepository; //.findByEstadoCuestionarioPreguntas(true);
		return null;
	}

	@Override
	public CuestionarioPregunta mostrarCuestionarioPregunta(Integer idCuestionarioPregunta) {
		// TODO Auto-generated method stub
		Optional<CuestionarioPregunta> auxiliar = Optional.of(new CuestionarioPregunta());
		auxiliar = cuestionarioPreguntaRepository.findById(idCuestionarioPregunta);
		return auxiliar.get();
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
	@Override
	public void eliminarCuestionarioPregunta(Integer unIdCuestionarioPregunta) {
		//cuestionarioPreguntasRepository.deleteById(unIdCuestionarioPreguntas);
		Optional<CuestionarioPregunta> auxiliar=Optional.of(new CuestionarioPregunta());
		auxiliar= cuestionarioPreguntaRepository.findById(unIdCuestionarioPregunta);
		//auxiliar.get().setEstadoCuestionarioPreguntas(false);
		cuestionarioPreguntaRepository.save(auxiliar.get());
	}
	
}
