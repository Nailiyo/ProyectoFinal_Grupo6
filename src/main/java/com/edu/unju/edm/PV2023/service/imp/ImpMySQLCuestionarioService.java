package com.edu.unju.edm.PV2023.service.imp;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.model.Cuestionario;
import com.edu.unju.edm.PV2023.repository.CuestionarioRepository;
import com.edu.unju.edm.PV2023.service.ICuestionarioService;




@Service
@Qualifier("serviceCuestionarioMySQL")
public class ImpMySQLCuestionarioService implements ICuestionarioService{

	@Autowired
	CuestionarioRepository cuestionarioRepository;
	
	@Override
	public void cargarCuestionario(Cuestionario unCuestionario) {
		
		unCuestionario.setEstado(true);
		cuestionarioRepository.save(unCuestionario);
		
	}

	@Override
	public ArrayList<Cuestionario> listarCuestionarios() {
		
		return (ArrayList<Cuestionario>) cuestionarioRepository.findByEstado(true);
	}

	@Override
	public Cuestionario mostrarUnCuestionario(Integer idCuestionario) {
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
	public Cuestionario modificarUnCuestionario(Integer idCuestionario) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eliminarCuestionario(Integer unIdCuestionario) {
		//productoRepository.deleteById(unCodigo);
		Optional<Cuestionario> auxiliar=Optional.of(new Cuestionario());
		auxiliar= cuestionarioRepository.findById(unIdCuestionario);
		auxiliar.get().setEstado(false);
		cuestionarioRepository.save(auxiliar.get());
	}
	
	
}
