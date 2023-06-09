package com.edu.unju.edm.PV2023.alumnoservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.model.Alumno;

@Service
public interface IAlumnoService {

	public void cargarAlumno(Alumno unAlumno);
	public void eliminarAlumno(Integer unIdAlumno);
	public ArrayList<Alumno> listarAlumnos();
	public Alumno mostrarUnAlumno(Integer idAlumno);
	public void eliminarTodosLosAlumnos();
	public Alumno modificarUnAlumno(Integer idAlumno);
	
}
