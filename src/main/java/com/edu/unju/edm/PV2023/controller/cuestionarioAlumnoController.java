package com.edu.unju.edm.PV2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.unju.edm.PV2023.model.CuestionarioAlumno;
import com.edu.unju.edm.PV2023.service.IAlumnoService;
import com.edu.unju.edm.PV2023.service.ICuestionarioService;

import jakarta.validation.Valid;

@Controller
public class cuestionarioAlumnoController {
	
	@Autowired
	ICuestionarioAlumnoService cuestionarioAlumnoService;
	@Autowired
	IAlumnoService alumnoService;
	@Autowired
	ICuestionarioService cuestionarioService;
	@Autowired
	CuestionarioAlumno CuestionarioAlumno;
	
	@GetMapping("/hacerAlumnoCuestionario")
	public ModelAndView cargarCuestionarioAlumno () {
		ModelAndView cuestionariosAlumno = new ModelAndView("cuestionarioAlumno");
		cuestionariosAlumno.addObject("cuestionario", cuestionarioService.listarCuestionarios());
		cuestionariosAlumno.addObject("alumno", alumnoService.listarAlumnos());
		cuestionariosAlumno.addObject("cuestionarioAlumno", CuestionarioAlumno);
		return cuestionariosAlumno;
	}
	
	@PostMapping("/guardarAlumnoCuestionarioHecho")
	public ModelAndView guardarCuestionarioAlumno (@Valid @ModelAttribute("cuestionarioAlumno") CuestionarioAlumno finalizado, BindingResult totalResult) {
		if(totalResult.hasErrors()) {
			ModelAndView cargarCuestionarioAlumno = new ModelAndView("listarCuestionarioAlumno");
			cargarCuestionarioAlumno.addObject("uncuestionarioAlumno", finalizado);
			return cargarCuestionarioAlumno;
		}
		ModelAndView resultadoCuestionarioAlumno = new ModelAndView("mostrarCuestionarioAlumno");
		try {
			cuestionarioAlumnoService.cargarCuestionarioAlumno(finalizado);
		}catch(Exception e) {
			resultadoCuestionarioAlumno.addObject("messageErrorCuestionarioAlumno", e.getMessage());
		}
		resultadoCuestionarioAlumno.addObject("todosCuestionariosAlumnos", cuestionarioAlumnoService.mostrarTodosCuestionariosAlumnos() );
		return resultadoCuestionarioAlumno;
	}
}
