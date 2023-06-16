package com.edu.unju.edm.PV2023.service.imp;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.model.CuestionarioAlumno;

import com.edu.unju.edm.PV2023.repository.CuestionarioAlumnoRepository;
import com.edu.unju.edm.PV2023.service.ICuestionarioAlumnoService;

@Service
@Qualifier("serviceCuestionarioAlumnoMySQL")
public class ImpMySQLCuestionarioAlumnoService implements ICuestionarioAlumnoService {

	@Autowired
	CuestionarioAlumnoRepository cuestionarioAlumnoRepository;
	private static final Log grupo6 = LogFactory.getLog(ImpMySQLDocenteService.class);
	
	@Override
	public void cargarCuestionarioAlumno(CuestionarioAlumno unCuestionarioAlumno) {
		
		unCuestionarioAlumno.setEstado(true);
		cuestionarioAlumnoRepository.save(unCuestionarioAlumno);
		
	}

	@Override
	public ArrayList<CuestionarioAlumno> listarCuestionarioAlumno() {
		
		return (ArrayList<CuestionarioAlumno>) cuestionarioAlumnoRepository.findByEstado(true);
	}

	@Override
	public CuestionarioAlumno mostrarUnCuestionarioAlumno(Integer idCuestionarioAlumno) {
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
	public CuestionarioAlumno modificarUnCuestionarioAlumno(Integer idCuestionarioAlumno) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eliminarCuestionarioAlumno(Integer unIdCuestionarioAlumno) {
		//cuestionarioAlumnoRepository.deleteById(unIdCuestionarioAlumno);
		Optional<CuestionarioAlumno> auxiliar=Optional.of(new CuestionarioAlumno());
		auxiliar= cuestionarioAlumnoRepository.findById(unIdCuestionarioAlumno);
		auxiliar.get().setEstado(false);
		cuestionarioAlumnoRepository.save(auxiliar.get());
	}

	
}