package com.edu.unju.edm.PV2023.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.model.Docente;

@Service
public interface IDocenteService {

	
	public void cargarDocente(Docente unDocente);
	public void eliminarDocente(Integer unIdDocente);
	public ArrayList<Docente> listarDocentes();
	public Docente mostrarDocente(Integer idDocente);
	public void eliminarTodosLosDocentes();
	public Docente modificarDocente(Integer idDocente);
	
}
