package com.edu.unju.edm.PV2023.service;

import java.util.ArrayList;
import java.util.Map;

import com.edu.unju.edm.PV2023.model.CuestionarioAlumno;

public interface ICuestionarioAlumnoService {

	public void cargarCuestionarioAlumno(CuestionarioAlumno unCuestionarioAlumno);
	public void eliminarCuestionarioAlumno(Integer unIdCuestionarioAlumno);
	public ArrayList<CuestionarioAlumno> listarCuestionarioAlumnos();
	public CuestionarioAlumno mostrarCuestionarioAlumno(Integer idCuestionarioAlumno);
	public void eliminarTodosLosCuestionarioAlumno();
	public CuestionarioAlumno modificarCuestionarioAlumno(Integer idCuestionarioAlumno);
	public Integer calcularPuntajeObtenido(Integer idCuestionario, Map<String,String> opcionesElegidas);
	public String fechaActual();
}
