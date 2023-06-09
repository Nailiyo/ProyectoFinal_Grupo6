package com.edu.unju.edm.PV2023.docenteservice.imp;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.edu.unju.edm.PV2023.docenterepository.DocenteRepository;
import com.edu.unju.edm.PV2023.docenteservice.IDocenteService;
import com.edu.unju.edm.PV2023.model.Docente;

@Service
@Qualifier("serviceDocenteMySQL")
public class ImpMySQLDocenteService implements IDocenteService{

	@Autowired
	DocenteRepository docenteRepository;
	
	private static final Log grupo6 = LogFactory.getLog(ImpMySQLDocenteService.class);

	@Override
	public void cargarDocente(Docente unDocente) {
		
		unDocente.setEstadoDocente(true);
		docenteRepository.save(unDocente);
		
	}

	@Override
	public ArrayList<Docente> listarDocentes() {
		
		return (ArrayList<Docente>) docenteRepository.findByEstadoDocente(true);
	}

	@Override
	public Docente mostrarUnDocente(Integer idDocente) {
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
	public Docente modificarUnDocente(Integer idDocente) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eliminarDocente(Integer unIdDocente) {
		//productoRepository.deleteById(unCodigo);
		Optional<Docente> auxiliar=Optional.of(new Docente());
		auxiliar= docenteRepository.findById(unIdDocente);
		auxiliar.get().setEstadoDocente(false);
		docenteRepository.save(auxiliar.get());
	}
	
	
}
