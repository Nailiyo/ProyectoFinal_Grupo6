package com.edu.unju.edm.PV2023.service;

import java.util.ArrayList;

import com.edu.unju.edm.PV2023.model.CuestionarioAlumno;

public interface ICuestionarioAlumnoService {

	public void cargarCuestionarioAlumno(CuestionarioAlumno unCuestionarioAlumno);
	public void eliminarCuestionarioAlumno(Integer unIdCuestionarioAlumno);
	public ArrayList<CuestionarioAlumno> listarCuestionarioAlumno();
	public CuestionarioAlumno mostrarUnCuestionarioAlumno(Integer idCuestionarioAlumno);
	public void eliminarTodosLosCuestionarioAlumno();
	public CuestionarioAlumno modificarUnCuestionarioAlumno(Integer idCuestionarioAlumno);
	
}
