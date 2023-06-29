package com.edu.unju.edm.PV2023.service.imp;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



import com.edu.unju.edm.PV2023.model.Docente;
import com.edu.unju.edm.PV2023.repository.DocenteRepository;
import com.edu.unju.edm.PV2023.service.IDocenteService;

@Service
@Qualifier("serviceDocenteMySQL")
public class ImpMySQLDocenteService implements IDocenteService{

	@Autowired
	DocenteRepository docenteRepository;
	

	@Override
	public void cargarDocente(Docente unDocente) {
		
		unDocente.setTipo("ADMIN");
		unDocente.setEstadoDocente(true);
		String pw = unDocente.getContraseñaDocente();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
		unDocente.setContraseñaDocente(encoder.encode(pw));
		docenteRepository.save(unDocente);
		
	}

	@Override
	public ArrayList<Docente> listarDocentes() {
		
		return (ArrayList<Docente>) docenteRepository.findByEstadoDocente(true);
	}

	@Override
	public Docente mostrarDocente(Integer idDocente) {
		// TODO Auto-generated method stub
		Optional<Docente> auxiliar = Optional.of(new Docente());
		auxiliar = docenteRepository.findById(idDocente);
		return auxiliar.get();
	}

	@Override
	public void eliminarTodosLosDocentes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Docente modificarDocente(Integer idDocente) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eliminarDocente(Integer unIdDocente) {
		//docenteRepository.deleteById(unIdDocente);
		Optional<Docente> auxiliar=Optional.of(new Docente());
		auxiliar= docenteRepository.findById(unIdDocente);
		auxiliar.get().setEstadoDocente(false);
		docenteRepository.save(auxiliar.get());
	}
	
	
}
