package com.edu.unju.edm.PV2023.service.imp;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.model.Cuestionario;
import com.edu.unju.edm.PV2023.repository.CuestionarioRepository;
import com.edu.unju.edm.PV2023.service.ICuestionarioService;

@Service
//@Qualifier("serviceCuestionarioMySQL")
public class ImpMySQLCuestionarioService implements ICuestionarioService{

	@Autowired
	CuestionarioRepository cuestionarioRepository;
	
	@Override
	public void cargarCuestionario(Cuestionario unCuestionario) {
		unCuestionario.setEstadoCuestionario(true);
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
		Optional<Cuestionario> auxiliar = Optional.of(new Cuestionario());
		auxiliar=cuestionarioRepository.findById(unIdCuestionario);
		auxiliar.get().setEstadoCuestionario(false);
		cuestionarioRepository.save(auxiliar.get());
	}



	
	
	
}
