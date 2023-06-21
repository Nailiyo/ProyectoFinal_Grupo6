package com.edu.unju.edm.PV2023.controller;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.unju.edm.PV2023.model.CuestionarioPregunta;
import com.edu.unju.edm.PV2023.service.ICuestionarioPreguntaService;
import com.edu.unju.edm.PV2023.service.ICuestionarioService;
import com.edu.unju.edm.PV2023.service.IPreguntaService;
import jakarta.validation.Valid;

@Controller
public class cuestionarioPreguntaController {

	private static final Log G6 = LogFactory.getLog(cuestionarioPreguntaController.class);
	
	//@Qualifier("serviceCuestionarioPreguntasMySQL")
	@Autowired
	ICuestionarioPreguntaService cuestionarioPreguntaService;
	@Autowired
	IPreguntaService preguntaService;
	@Autowired
	ICuestionarioService cuestionarioService;
	@Autowired
	CuestionarioPregunta unCuestionarioPregunta;
	
	@GetMapping("/CuestionarioPregunta")
	public ModelAndView cargarCuestionarioPregunta() {
		ModelAndView modelAndView= new ModelAndView("cargarCuestionario");
		modelAndView.addObject("cuestionarioPregunta", unCuestionarioPregunta);
		modelAndView.addObject("cuestionario",cuestionarioService.listarCuestionarios());
		modelAndView.addObject("pregunta", preguntaService.listarPreguntas());
		return modelAndView;
		
	}
	
	@PostMapping("/cargarCuestionarioPregunta")
	public ModelAndView guardarCuestionarioPregunta(@Valid @ModelAttribute("cuestionarioPregunta") CuestionarioPregunta unCuestionarioPreguntaConDatos, BindingResult resultado) {
		
		if(resultado.hasErrors()) {
			G6.error(resultado.getAllErrors());
			ModelAndView modelAndView= new ModelAndView("cargarCuestionario");
			modelAndView.addObject("cuestionarioPregunta", unCuestionarioPreguntaConDatos);
			modelAndView.addObject("cuestionario",cuestionarioService.listarCuestionarios());
			modelAndView.addObject("pregunta", preguntaService.listarPreguntas());
			return modelAndView;
		}
		
		ModelAndView modelAndView=new ModelAndView("mostrarCuestionario");
		
		try {
			cuestionarioPreguntaService.cargarCuestionarioPregunta(unCuestionarioPreguntaConDatos);
		}catch(Exception e) {
			modelAndView.addObject("cargarCuestionarioPreguntaErrorMessage", e.getMessage());
		}
		
		modelAndView.addObject("cuestionarioPreguntaListado", cuestionarioPreguntaService.listarCuestionarioPreguntas());
		return modelAndView;
	}
}