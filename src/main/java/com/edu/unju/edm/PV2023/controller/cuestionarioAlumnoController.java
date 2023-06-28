package com.edu.unju.edm.PV2023.controller;

import java.util.Map;

import javax.validation.Valid;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edu.unju.edm.PV2023.model.CuestionarioAlumno;
import com.edu.unju.edm.PV2023.repository.CuestionarioRepository;
import com.edu.unju.edm.PV2023.service.IAlumnoService;
import com.edu.unju.edm.PV2023.service.ICuestionarioAlumnoService;
import com.edu.unju.edm.PV2023.service.ICuestionarioPreguntaService;
import com.edu.unju.edm.PV2023.service.ICuestionarioService;


//import jakarta.validation.Valid;

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
	ICuestionarioPreguntaService cuestionarioPreguntaService;
	@Autowired
	CuestionarioAlumno unCuestionarioAlumno;
	@Autowired
	CuestionarioRepository cuestionarioRepository;
	
	
	@GetMapping("/hacerAlumnoCuestionario")
	public ModelAndView cargarCuestionarioAlumno () {
		ModelAndView cuestionariosAlumno = new ModelAndView("mostrarCuestionariosAAlumnos");;
		cuestionariosAlumno.addObject("cuestionarios", cuestionarioService.listarCuestionarios());
		return cuestionariosAlumno;
	}
	
	
	@GetMapping("/resolverCuestionario/{idCuestionario}")
	public ModelAndView resolverCuestionarioAlumno(@PathVariable(name="idCuestionario")  Integer idCuestionarioElegido) {
		ModelAndView resolverCuestionario = new ModelAndView("resolverCuestionario");
			G6.warn("Estudiante resuelve cuestionario");
			resolverCuestionario.addObject("nuevoCuestionarioAlumno", unCuestionarioAlumno);
			resolverCuestionario.addObject("listadoAlumnos", alumnoService.listarAlumnos());
			
			resolverCuestionario.addObject("cuestionario", cuestionarioService.mostrarCuestionario(idCuestionarioElegido));
			resolverCuestionario.addObject("pregunta", cuestionarioPreguntaService.ListarPreguntasDeUnCuestionario(idCuestionarioElegido));
			
			G6.warn("Nueva resolucion de Cuestionario");
		return resolverCuestionario;
	}
	
	@PostMapping("/resultadoDeCuestionario/{idCuestionario}")
	public ModelAndView guardarCuestionarioERealizado(@ModelAttribute("nuevoCuestionarioAlumno") CuestionarioAlumno nuevoCuestionarioAlumno,
			@RequestParam Map<String,String> respuestasSeleccionadas, @PathVariable(name="idCuestionario") Integer idCuestionario ) { 
		
		ModelAndView resultadoCuestionario = new ModelAndView("resultadoCuestionario");

		G6.warn("Cuestionario realizado");
		try {
		
		nuevoCuestionarioAlumno.setFechaCompletado(cuestionarioAlumnoService.fechaActual());
        nuevoCuestionarioAlumno.setUnCuestionario(cuestionarioRepository.findById(idCuestionario).get());
        nuevoCuestionarioAlumno.setPuntajeLogrado(cuestionarioAlumnoService.calcularPuntajeObtenido(idCuestionario, respuestasSeleccionadas));
        cuestionarioPreguntaService.obtenerPuntajeTotalDeUnCuestionario(idCuestionario);
        cuestionarioAlumnoService.cargarCuestionarioAlumno(nuevoCuestionarioAlumno);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			G6.error(e);
		}
		resultadoCuestionario.addObject("nuevoCuestionarioAlumno", nuevoCuestionarioAlumno);
    
		return resultadoCuestionario;
	}
	
	@GetMapping("/cuestionariosRealizados")
	public ModelAndView guardarCuestionarioAlumno () {
		G6.warn("Listando todos los Cuestionarios");
		ModelAndView listadoCuestionarioAlumno = new ModelAndView("mostrarCuestionariosResueltos");
		
		listadoCuestionarioAlumno.addObject("cuestionarioAlumnoListado", cuestionarioAlumnoService.listarCuestionarioAlumnos() );
		
		return listadoCuestionarioAlumno;
	}
	

}