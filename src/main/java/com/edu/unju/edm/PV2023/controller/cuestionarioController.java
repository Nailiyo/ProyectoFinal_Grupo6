package com.edu.unju.edm.PV2023.controller;

import java.io.IOException;

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

import org.springframework.web.servlet.ModelAndView;

import com.edu.unju.edm.PV2023.model.Cuestionario;
import com.edu.unju.edm.PV2023.service.ICuestionarioPreguntaService;
import com.edu.unju.edm.PV2023.service.ICuestionarioService;
import com.edu.unju.edm.PV2023.service.IDocenteService;


@Controller
public class cuestionarioController {

	private static final Log G6 = LogFactory.getLog(cuestionarioController.class);
    
    	@Autowired
    	//@Qualifier("serviceCuestionarioMySQL")
    	Cuestionario unCuestionario;
        
    	@Autowired
    	ICuestionarioService cuestionarioService;
    	
        @Autowired
        ICuestionarioPreguntaService cuestionarioPreguntaService;
        
        @Autowired
        IDocenteService docenteService;
        
        @GetMapping("/cargarCuestionario")
        public ModelAndView cargarCuestionario() {
            ModelAndView cargarCuestionario= new ModelAndView("cargarCuestionario");
            cargarCuestionario.addObject("cuestionario",unCuestionario);
            cargarCuestionario.addObject("cuestionarioListado",docenteService.listarDocentes());
            return cargarCuestionario;
        }

        @GetMapping("/listadoCuestionario")
    	public ModelAndView mostrarCuestionarios(){
    		G6.warn("Lista de Cuestionarios");
    		ModelAndView listadoCuestionarios = new ModelAndView("mostrarCuestionario");
    		listadoCuestionarios.addObject("cuestionarioListado", cuestionarioService.listarCuestionarios());
    		
    		return listadoCuestionarios;
    	}
        
        @PostMapping("/guardarCuestionario")
        public ModelAndView guardarCuestionario(@Valid @ModelAttribute("cuestionario") Cuestionario unCuestionarioConDatos, BindingResult resultado) {
            if(resultado.hasErrors()) {
            	G6.error(resultado.getAllErrors());
            	ModelAndView cargarCuestionario= new ModelAndView("cargarCuestionario");
            	cargarCuestionario.addObject("cuestionario",unCuestionarioConDatos);
            	cargarCuestionario.addObject("docenteListado",docenteService.listarDocentes());
            	return cargarCuestionario;
            }
        	
        	ModelAndView listarCuestionarios = new ModelAndView("mostrarCuestionario");
            G6.warn("mostrando el nuevo Cuestionario"+unCuestionarioConDatos.getUnDocente());
            try{
            cuestionarioService.cargarCuestionario(unCuestionarioConDatos);
            }catch(Exception e){
            	listarCuestionarios.addObject("ERROR MESSAGE", e.getMessage());
            }
            listarCuestionarios.addObject("cuestionarioListado",cuestionarioService.listarCuestionarios());
            return listarCuestionarios;
        }
        
        
        @PostMapping("/cuestionarioConPreguntas/{idCuestionario}")
    	public ModelAndView guardarCuestionarioConPreguntas(@PathVariable(name="idCuestionario") Integer id) {
    		
    		ModelAndView listadoCuestionarios = new ModelAndView("mostrarCuestionario");
    		
    		G6.warn("Cuestionario con preguntas: " + unCuestionario.getTitulo());
    		try {
    			listadoCuestionarios.addObject("preguntas", cuestionarioPreguntaService.ListarPreguntasDeUnCuestionario(id));
    		}catch(Exception e) {
    			listadoCuestionarios.addObject("cargaCuestionarioConPreguntasErrorMessage", e.getMessage());
    			G6.error(e);
    		}
    		
    		listadoCuestionarios.addObject("cuestionarioListado", cuestionarioService.listarCuestionarios());
    		
    		return listadoCuestionarios;
    	}
        
        
        
    	
    
    	
        
	
}
