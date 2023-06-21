package com.edu.unju.edm.PV2023.controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.unju.edm.PV2023.model.CuestionarioAlumno;
import com.edu.unju.edm.PV2023.service.IAlumnoService;
import com.edu.unju.edm.PV2023.service.ICuestionarioAlumnoService;
import com.edu.unju.edm.PV2023.service.ICuestionarioService;

import jakarta.validation.Valid;

@Controller
public class cuestionarioAlumnoController {
	private static final Log G6 = LogFactory.getLog(cuestionarioAlumnoController.class);
	
	@Autowired
	ICuestionarioAlumnoService cuestionarioAlumnoService;
	@Autowired
	IAlumnoService alumnoService;
	@Autowired
	ICuestionarioService cuestionarioService;
	@Autowired
	CuestionarioAlumno unCuestionarioAlumno;
	
	@GetMapping("/hacerAlumnoCuestionario")
	public ModelAndView cargarCuestionarioAlumno () {
		ModelAndView cuestionariosAlumno = new ModelAndView("cuestionarioAlumno");
		cuestionariosAlumno.addObject("cuesAlumno", unCuestionarioAlumno);
		cuestionariosAlumno.addObject("cuestionario", cuestionarioService.listarCuestionarios());
		cuestionariosAlumno.addObject("alumno", alumnoService.listarAlumnos());
		return cuestionariosAlumno;
	}
	
	@PostMapping("/guardarCuestionarioAlumno")
	public ModelAndView guardarCuestionarioAlumno (@Valid @ModelAttribute("cuesAlumno") CuestionarioAlumno unCuestionarioAlumnoConDatos, BindingResult resultado) {
		if(resultado.hasErrors()) {
			G6.error(resultado.getAllErrors());
			ModelAndView cuestionariosAlumno = new ModelAndView("cuestionarioAlumno");
			cuestionariosAlumno.addObject("cuesAlumno", unCuestionarioAlumnoConDatos);
			cuestionariosAlumno.addObject("cuestionarioListado", cuestionarioService.listarCuestionarios());
			cuestionariosAlumno.addObject("alumnoListado", alumnoService.listarAlumnos());
			return cuestionariosAlumno;
		}
		ModelAndView resultadoCuestionarioAlumno = new ModelAndView("mostrarCuestionarioAlumno");
		try {
			cuestionarioAlumnoService.cargarCuestionarioAlumno(unCuestionarioAlumnoConDatos);
		}catch(Exception e) {
			resultadoCuestionarioAlumno.addObject("messageErrorCuestionarioAlumno", e.getMessage());
		}
		resultadoCuestionarioAlumno.addObject("todosCuestionariosAlumnos", cuestionarioAlumnoService.listarCuestionarioAlumnos() );
		return resultadoCuestionarioAlumno;
	}
}