package com.edu.unju.edm.PV2023.docenteservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.unju.edm.PV2023.model.Docente;

@Service
public interface IDocenteService {

	
	public void cargarDocente(Docente unDocente);
	public void eliminarDocente(Integer unIdDocente);
	public List<Docente> listarDocentes();
	public Docente mostrarUnDocente(Integer idDocente);
	public void eliminarTodosLosDocentes();
	public Docente modificarUnDocente(Integer idDocente);
	
}
