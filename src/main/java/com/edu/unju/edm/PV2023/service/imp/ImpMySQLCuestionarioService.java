package com.edu.unju.edm.PV2023.service.imp;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.model.Alumno;
import com.edu.unju.edm.PV2023.model.Cuestionario;
import com.edu.unju.edm.PV2023.repository.CuestionarioRepository;
import com.edu.unju.edm.PV2023.service.ICuestionarioService;

@Service
//@Qualifier("serviceCuestionarioMySQL")
public class ImpMySQLCuestionarioService implements ICuestionarioService{

	@Autowired
	CuestionarioRepository cuestionarioRepository;
	
	private static final Log grupo6 = LogFactory.getLog(ImpMySQLCuestionarioService.class);
	
	@Override
	public void cargarCuestionario(Cuestionario unCuestionario) {
		cuestionarioRepository.save(unCuestionario);
		
		
	}

	@Override
	public List<Cuestionario> listarCuestionarios() {
		// TODO Auto-generated method stub
		return (ArrayList<Cuestionario>) cuestionarioRepository.findByEstadoCuestionario(true);

	}

	@Override
	public Cuestionario mostrarCuestionario(Integer idCuestionario) {
		// TODO Auto-generated method stub
		Optional<Cuestionario> auxiliar = Optional.of(new Cuestionario());
		auxiliar = cuestionarioRepository.findById(idCuestionario);
		return auxiliar.get();
	}

	@Override
	public void eliminarTodosLosCuestionarios() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cuestionario modificarCuestionario(Integer idCuestionario) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eliminarCuestionario(Integer unIdCuestionario) {
		//cuestionarioRepository.deleteById(unIdCuestionario);
		Optional<Cuestionario> auxiliar=Optional.of(new Cuestionario());
		auxiliar= cuestionarioRepository.findById(unIdCuestionario);
		cuestionarioRepository.save(auxiliar.get());
	}



	
	
	
}
