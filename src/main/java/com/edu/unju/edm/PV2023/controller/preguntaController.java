package com.edu.unju.edm.PV2023.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.edu.unju.edm.PV2023.model.Pregunta;

import com.edu.unju.edm.PV2023.service.IPreguntaService;


@Controller
public class preguntaController {
private static final Log G6 = LogFactory.getLog(preguntaController.class);
    @Autowired
    Pregunta unaPregunta;
    @Autowired
    @Qualifier("servicePreguntaMySQL")
    IPreguntaService preguntaService;
    @GetMapping("/cargarPregunta")
    public ModelAndView cargarPregunta(){
        ModelAndView cargarPregunta = new ModelAndView("cargarPregunta");
        cargarPregunta.addObject("pregunta", unaPregunta);
        return cargarPregunta;
    }
    @PostMapping("/guardarPregunta")
    public ModelAndView guardarPregunta(@Valid @ModelAttribute("pregunta") Pregunta unaPreguntaConDatos, BindingResult resultado) {
        if(resultado.hasErrors()) {
        	G6.error(resultado.getAllErrors());
            ModelAndView cargarPregunta = new ModelAndView("cargarPregunta");
            cargarPregunta.addObject("pregunta", unaPreguntaConDatos);
            return cargarPregunta;
        }
        
    	ModelAndView guardarEsaPregunta = new ModelAndView("mostrarPregunta");
        try{
            preguntaService.cargarPregunta(unaPreguntaConDatos);
        }catch (Exception e){}
        guardarEsaPregunta.addObject("preguntaListado", preguntaService.listarPreguntas());
        return guardarEsaPregunta;
    }
    
    @GetMapping("/eliminarPregunta/{idPregunta}")
  	@ResponseBody
  	public ModelAndView borrarPregunta(@PathVariable Integer idPregunta) {
  		
  		try {
  			preguntaService.eliminarPregunta(idPregunta);
  			G6.error("PASANDO...");
  		} catch (Exception e) {
  			G6.error("encontrando: producto NO encontrado");
  		}
  		ModelAndView listadoPreguntas = new ModelAndView("redirect:/guardarPregunta");
  		listadoPreguntas.addObject("preguntaListado", preguntaService.listarPreguntas());
  		
  		return listadoPreguntas;
  		}
  	
  	@GetMapping("/modificarPregunta/{idPregunta}")
  	public ModelAndView getModificarPregunta(@PathVariable(name = "idPregunta")  Integer idPregunta) {
  		
  		ModelAndView modelAndView = new ModelAndView("cargarPregunta");
  		try {
  			modelAndView.addObject("preguntaListado", preguntaService.mostrarPregunta(idPregunta));
  		}catch (Exception e) {
  			modelAndView.addObject("modificacionDePreguntaErrorMessage", e.getMessage());
  		}
  		
  		//bandera
  		modelAndView.addObject("band", true);
  		return modelAndView;
  	}
  	
  	@PostMapping(value="/modificarPregunta")
  	public ModelAndView modificarPregunta(@ModelAttribute ("cargarPregunta") Pregunta nuevaPregunta) throws IOException {
  		
  		ModelAndView listadoFinal= new ModelAndView("mostrarPregunta");
  		
  		G6.warn("Mostrando la nueva Pregunta " + nuevaPregunta.getDescripcion());
  		
  		try {
  			
  			preguntaService.cargarPregunta(nuevaPregunta);
  			
  		}catch(Exception e) {
  			listadoFinal.addObject("pasa por aqui", e.getMessage());
  		}
  		
  		listadoFinal.addObject("listado", preguntaService.listarPreguntas());
  		
  		return listadoFinal;
  	}
}