package com.edu.unju.edm.PV2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.unju.edm.PV2023.model.CuestionarioPreguntas;
import com.edu.unju.edm.PV2023.service.ICuestionarioPreguntasService;
import com.edu.unju.edm.PV2023.service.ICuestionarioService;
import com.edu.unju.edm.PV2023.service.IPreguntasService;
import jakarta.validation.Valid;

@Controller
public class cuestionarioPreguntasController {

	@Autowired
	ICuestionarioPreguntasService cuestionarioPreguntasService;
	@Autowired
	IPreguntasService preguntaService;
	@Autowired
	ICuestionarioService cuestionarioService;
	@Autowired
	CuestionarioPreguntas unCuestionarioPreguntas;
	
	@GetMapping("/CuestionarioPregunta")
	public ModelAndView cargarCuesPregunta() {
		ModelAndView unCuesP= new ModelAndView("formularioCuesPregunta");
		unCuesP.addObject("cuesPregunta", unCuestionarioPreguntas);
		unCuesP.addObject("pregunta", preguntaService.listarPreguntas());
		unCuesP.addObject("cuestionario", cuestionarioService.listarCuestionarios());
		
		return unCuesP;
	}
	
	@PostMapping("/guardarCuestionarioPregunta")
	public ModelAndView guardarCuesPregunta(@Valid @ModelAttribute("cuesPregunta") CuestionarioPreguntas CuestionarioP, BindingResult resultados) {
		
		if(resultados.hasErrors()) {
			ModelAndView cargaCuesPregunta= new ModelAndView();
			cargaCuesPregunta.addObject("otroCuesPreg", CuestionarioP);
			return cargaCuesPregunta;
		}
		
		ModelAndView listadoCuesPregunta=new ModelAndView("mostrarCuesPregunta");
		
		try {
			cuestionarioPreguntasService.cargarCuestionarioPreguntas(CuestionarioP);
		}catch(Exception e) {
			listadoCuesPregunta.addObject("cargarCuesPreguntaErrorMessage", e.getMessage());
		}
		
		listadoCuesPregunta.addObject("listadoCuesPreguntas", cuestionarioPreguntasService.mostrarTodosCuestionariosPreguntas());
		return listadoCuesPregunta;
	}
}