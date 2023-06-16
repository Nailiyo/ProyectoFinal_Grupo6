package com.edu.unju.edm.PV2023.controller;

import java.io.IOException;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.edu.unju.edm.PV2023.model.Cuestionario;

import com.edu.unju.edm.PV2023.service.ICuestionarioService;

@Controller
public class cuestionarioController {

	private static final Log G6 = LogFactory.getLog(docenteController.class);
    @Autowired
    Cuestionario elCuestionario;
        @Autowired
        @Qualifier("serviceCuestionarioMySQL")
        ICuestionarioService cuestionarioService;

        @GetMapping("/cargarCuestionario")
        public ModelAndView cargarCuestionario() {
            ModelAndView cargarCuestionario= new ModelAndView("cargarCuestionario.html");
            cargarCuestionario.addObject("cuestionario",elCuestionario);
            return cargarCuestionario;
        }

        @PostMapping("/guardarCuestionario")
        public ModelAndView guardarCuestionario(@ModelAttribute("cuestionario") Cuestionario cuestionario) {
            ModelAndView listarCuestionarios = new ModelAndView("mostrarCuestionario");
            G6.warn("mostrando el nuevo Cuestionario"+cuestionario.getNivelCuestionario());
            try{
            cuestionarioService.cargarCuestionario(cuestionario);
            }catch(Exception e){}
            listarCuestionarios.addObject("cuestionarioListado",cuestionarioService.listarCuestionarios());
            return listarCuestionarios;
        }
        
        
        @GetMapping("/eliminarCuestionario/{idCuestionario}")
    	@ResponseBody
    	public ModelAndView borrarCuestionario(@PathVariable Integer idCuestionario) {
    		
    		try {
    			cuestionarioService.eliminarCuestionario(idCuestionario);
    			G6.error("PASANDO...");
    		} catch (Exception e) {
    			G6.error("encontrando: producto NO encontrado");
    		}
    		ModelAndView listadoCuestionario = new ModelAndView("redirect:/guardarAlumno");
    		listadoCuestionario.addObject("cuestionarioListado", cuestionarioService.listarCuestionarios());
    		
    		return listadoCuestionario;
    		}
    	
    	@GetMapping("/modificarCuestionario/{idCuestionario}")
    	public ModelAndView getModificarAlumno(@PathVariable(name = "idCuestionario")  Integer idCuestionario) {
    		
    		ModelAndView modelAndView = new ModelAndView("cargarEstudiante");
    		try {
    			modelAndView.addObject("alumnoListado", cuestionarioService.mostrarUnCuestionario(idCuestionario));
    		}catch (Exception e) {
    			modelAndView.addObject("modificacionDeCuestionarioErrorMessage", e.getMessage());
    		}
    		
    		//bandera
    		modelAndView.addObject("band", true);
    		return modelAndView;
    	}
    	
    	@PostMapping(value="/modificarCuestionario")
    	public ModelAndView modificarCuestionario(@ModelAttribute ("cargarCuestionario") Cuestionario nuevoCuestionario) throws IOException {
    		
    		ModelAndView listadoFinal= new ModelAndView("mostrarCuestionario");
    		
    		G6.warn("Mostrando el nuevo producto " + nuevoCuestionario.getNivelCuestionario());
    		
    		try {
    			
    			cuestionarioService.cargarCuestionario(nuevoCuestionario);
    			
    		}catch(Exception e) {
    			listadoFinal.addObject("pasa por aqui", e.getMessage());
    		}
    		
    		listadoFinal.addObject("listado", cuestionarioService.listarCuestionarios());
    		
    		return listadoFinal;
    	}
        
	
}
