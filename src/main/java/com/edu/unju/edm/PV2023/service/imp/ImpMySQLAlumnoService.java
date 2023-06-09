package com.edu.unju.edm.PV2023.service.imp;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.edu.unju.edm.PV2023.model.Alumno;
import com.edu.unju.edm.PV2023.repository.AlumnoRepository;
import com.edu.unju.edm.PV2023.service.IAlumnoService;


@Service
@Qualifier("serviceAlumnoMySQL")
public class ImpMySQLAlumnoService implements IAlumnoService{

	@Autowired
	AlumnoRepository alumnoRepository;
	

	@Override
	public void cargarAlumno(Alumno unAlumno) {
		
		unAlumno.setEstadoAlumno(true);
		alumnoRepository.save(unAlumno);
		
	}

	@Override
	public ArrayList<Alumno> listarAlumnos() {
		
		return (ArrayList<Alumno>) alumnoRepository.findByEstadoAlumno(true);
	}

	@Override
	public Alumno mostrarAlumno(Integer idAlumno) {
		// TODO Auto-generated method stub
		Optional<Alumno> auxiliar = Optional.of(new Alumno());
		auxiliar = alumnoRepository.findById(idAlumno);
		return auxiliar.get();
	}

	@Override
	public void eliminarTodosLosAlumnos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Alumno modificarAlumno(Integer idAlumno) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eliminarAlumno(Integer unIdAlumno) {
		//alumnoRepository.deleteById(unIdAlumno);
		Optional<Alumno> auxiliar=Optional.of(new Alumno());
		auxiliar= alumnoRepository.findById(unIdAlumno);
		auxiliar.get().setEstadoAlumno(false);
		alumnoRepository.save(auxiliar.get());
	}

	
}
