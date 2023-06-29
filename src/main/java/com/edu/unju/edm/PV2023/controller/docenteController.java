package com.edu.unju.edm.PV2023.controller;


import com.edu.unju.edm.PV2023.model.Docente;
import com.edu.unju.edm.PV2023.service.IDocenteService;

//import jakarta.validation.Valid;

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

@Controller
    public class docenteController {
    private static final Log G6 = LogFactory.getLog(docenteController.class);
    @Autowired
    Docente unDocente;
        @Autowired
        @Qualifier("serviceDocenteMySQL")
        IDocenteService docenteService;

        @GetMapping("/cargarDocente")
        public ModelAndView cargarDocente() {
            ModelAndView cargarDocente = new ModelAndView("cargarDocente.html");
            cargarDocente.addObject("docente",unDocente);
            return cargarDocente;
        }

        @PostMapping("/guardarDocente")
        public ModelAndView guardarDocente(@Valid @ModelAttribute("docente") Docente unDocenteConDatos, BindingResult resultado) {
            if(resultado.hasErrors()) {
            	G6.error(resultado.getAllErrors());
            	ModelAndView cargarDocente = new ModelAndView("cargarDocente.html");
                cargarDocente.addObject("docente",unDocenteConDatos);
                return cargarDocente;
            }
        	
        	ModelAndView listarDocentes = new ModelAndView("mostrarDocente");
            G6.warn("mostrando el nuevo docente"+unDocenteConDatos.getNombreDocente());
            try{
            docenteService.cargarDocente(unDocenteConDatos);
            }catch(Exception e){}
            listarDocentes.addObject("docenteListado",docenteService.listarDocentes());
            return listarDocentes;
        }
        
        @GetMapping("/listaDeDocentes")
    	public ModelAndView mostrarDocentes() {
    		ModelAndView listadoDocentes = new ModelAndView("vistaDocente");
    		listadoDocentes.addObject("docenteListado", unDocente);
    		listadoDocentes.addObject("docenteListado",docenteService.listarDocentes());
    		return listadoDocentes;
    	}
        
        @GetMapping("/eliminarDocente/{idDocente}")
    	@ResponseBody
    	public ModelAndView borrarDocente(@PathVariable Integer idDocente) {
    		
    		try {
    			docenteService.eliminarDocente(idDocente);
    			G6.error("PASANDO...");
    		} catch (Exception e) {
    			G6.error("encontrando: producto NO encontrado");
    		}
    		ModelAndView listadoDocente = new ModelAndView("redirect:/guardarDocente");
    		listadoDocente.addObject("docenteListado", docenteService.listarDocentes());
    		
    		return listadoDocente;
    		}
    	
    	@GetMapping("/modificarDocente/{idDocente}")
    	public ModelAndView getModificarDocente(@PathVariable(name = "idDocente")  Integer idDocente) {
    		
    		ModelAndView modelAndView = new ModelAndView("cargarDocente");
    		try {
    			modelAndView.addObject("docenteListado", docenteService.mostrarDocente(idDocente));
    		}catch (Exception e) {
    			modelAndView.addObject("modificacionDeDocenteErrorMessage", e.getMessage());
    		}
    		
    		//bandera
    		modelAndView.addObject("band", true);
    		return modelAndView;
    	}
    	
    	@PostMapping(value="/modificarDocente")
    	public ModelAndView modificarDocente(@ModelAttribute ("cargarDocente") Docente nuevoDocente) throws IOException {
    		
    		ModelAndView listadoFinal= new ModelAndView("mostrarDocente");
    		
    		G6.warn("Mostrando el nuevo producto " + nuevoDocente.getNombreDocente());
    		
    		try {
    			
    			docenteService.cargarDocente(nuevoDocente);
    			
    		}catch(Exception e) {
    			listadoFinal.addObject("pasa por aqui", e.getMessage());
    		}
    		
    		listadoFinal.addObject("listado", docenteService.listarDocentes());
    		
    		return listadoFinal;
    	}
        
}
