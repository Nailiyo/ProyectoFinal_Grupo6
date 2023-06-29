package com.edu.unju.edm.PV2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.unju.edm.PV2023.model.CuestionarioPregunta;
import com.edu.unju.edm.PV2023.repository.CuestionarioPreguntaRepository;
import com.edu.unju.edm.PV2023.repository.CuestionarioRepository;
import com.edu.unju.edm.PV2023.service.ICuestionarioPreguntaService;
import com.edu.unju.edm.PV2023.service.ICuestionarioService;
import com.edu.unju.edm.PV2023.service.IPreguntaService;
//import jakarta.validation.Valid;

@Controller
public class cuestionarioPreguntaController {

	
	//@Qualifier("serviceCuestionarioPreguntasMySQL")
	@Autowired
	ICuestionarioPreguntaService cuestionarioPreguntaService;
	@Autowired
	IPreguntaService preguntaService;
	@Autowired
	ICuestionarioService cuestionarioService;
	@Autowired
	CuestionarioPreguntaRepository cuestionarioPreguntaRepository;
	@Autowired
	CuestionarioPregunta unCuestionarioPregunta;
	@Autowired
	CuestionarioRepository cuestionarioRepository;
	
	@GetMapping("/cargarCuestionarioPregunta/{idCuestionario}")
	public ModelAndView cargarCuestionarioPregunta(@PathVariable(name="idCuestionario") Integer idCuestionario) {
		ModelAndView modelAndView= new ModelAndView("cargarCuestionarioPregunta");
		modelAndView.addObject("cuestionarioPregunta", unCuestionarioPregunta);
		modelAndView.addObject("cuestionario", cuestionarioRepository.findById(idCuestionario).get());
		/**modelAndView.addObject("listadoSeleccionadas", cuestionarioPreguntaService.ListarPreguntasDeUnCuestionario(idCuestionario));
		modelAndView.addObject("listadoDeNoSeleccionadas", cuestionarioPreguntaService.ListarPreguntasNoSeleccionadas(cuestionarioPreguntaService.ListarPreguntasDeUnCuestionario(idCuestionario), preguntaService.listarPreguntas()));
		modelAndView.addObject("listadoPreguntas", preguntaService.listarPreguntas());
		**/
		modelAndView.addObject("listadoPreguntas", preguntaService.listarPreguntas());
		return modelAndView;
		
	}
	
	@PostMapping("/guardarCuestionarioPregunta/{idCuestionario}")
	public ModelAndView guardarCuestionarioPregunta(@ModelAttribute("cuestionarioPregunta") CuestionarioPregunta unCuestionarioPreguntaConDatos,@PathVariable(name="idCuestionario") Integer idCuestionario) {
		System.out.println(unCuestionarioPreguntaConDatos.getIdCuestionarioPregunta()+"JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ");
		
		System.out.println(unCuestionarioPreguntaConDatos.getPregunta()+ "AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		//cuestionarioPreguntaService.cargarCuestionarioPregunta(unCuestionarioPreguntaConDatos, idCuestionario);
		ModelAndView mav = new ModelAndView("mostrarCuestionarioPregunta");
		mav.addObject("cuestionarioPreguntaListado",cuestionarioPreguntaService.listarCuestionarioPreguntas());
        return mav;
		
		
		//return "redirect:/listadoCuestionario";
		
	}
}