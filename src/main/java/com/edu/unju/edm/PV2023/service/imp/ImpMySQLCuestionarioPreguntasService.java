package com.edu.unju.edm.PV2023.service.imp;

import com.edu.unju.edm.PV2023.model.CuestionarioPreguntas;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.repository.CuestionarioPreguntasRepository;
import com.edu.unju.edm.PV2023.service.ICuestionarioPreguntasService;

@Service
@Qualifier("serviceCuestionarioPreguntasMySQL")
public class ImpMySQLCuestionarioPreguntasService implements ICuestionarioPreguntasService {

	
	@Autowired
	CuestionarioPreguntasRepository cuestionarioPreguntasRepository;
	
	private static final Log grupo6 = LogFactory.getLog(ImpMySQLDocenteService.class);

	@Override
	public void cargarCuestionarioPreguntas(CuestionarioPreguntas unCuestionarioPreguntas) {
		
		//unCuestionarioPreguntas.setEstadoCuestionarioPreguntas(true);
		cuestionarioPreguntasRepository.save(unCuestionarioPreguntas);
		
	}

	@Override
	public ArrayList<CuestionarioPreguntas> listarCuestionarioPreguntas() {
		
		return (ArrayList<CuestionarioPreguntas>) cuestionarioPreguntasRepository; //.findByEstadoCuestionarioPreguntas(true);
	}

	@Override
	public CuestionarioPreguntas mostrarUnCuestionarioPreguntas(Integer idCuestionarioPreguntas) {
		// TODO Auto-generated method stub
		Optional<CuestionarioPreguntas> auxiliar = Optional.of(new CuestionarioPreguntas());
		auxiliar = cuestionarioPreguntasRepository.findById(idCuestionarioPreguntas);
		return auxiliar.get();
	}

	@Override
	public void eliminarTodosLosCuestionarioPreguntas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CuestionarioPreguntas modificarUnCuestionarioPreguntas(Integer idCuestionarioPreguntas) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eliminarCuestionarioPreguntas(Integer unIdCuestionarioPreguntas) {
		//cuestionarioPreguntasRepository.deleteById(unIdCuestionarioPreguntas);
		Optional<CuestionarioPreguntas> auxiliar=Optional.of(new CuestionarioPreguntas());
		auxiliar= cuestionarioPreguntasRepository.findById(unIdCuestionarioPreguntas);
		//auxiliar.get().setEstadoCuestionarioPreguntas(false);
		cuestionarioPreguntasRepository.save(auxiliar.get());
	}
	
}
