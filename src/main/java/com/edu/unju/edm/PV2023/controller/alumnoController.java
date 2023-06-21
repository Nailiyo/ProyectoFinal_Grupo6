package com.edu.unju.edm.PV2023.controller;

import java.io.IOException;


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


import com.edu.unju.edm.PV2023.model.Alumno;
import com.edu.unju.edm.PV2023.service.IAlumnoService;

import jakarta.validation.Valid;



@Controller

public class alumnoController {
    private static final Log G6 = LogFactory.getLog(alumnoController.class);
    @Autowired
    Alumno unAlumno;
    @Qualifier("serviceAlumnoMySQL")
    @Autowired
    IAlumnoService alumnoService;
    @GetMapping("/cargarAlumno")
    public ModelAndView cargarAlumno(){
        ModelAndView cargarAlumno = new ModelAndView("cargarEstudiante.html");
        cargarAlumno.addObject("alumno", unAlumno);
        return cargarAlumno;
    }
    @PostMapping("/guardarAlumno")
    public ModelAndView guardarAlumno(@Valid @ModelAttribute("alumno")Alumno unAlumnoConDatos, BindingResult resultado){
    	if(resultado.hasErrors()) {
    		G6.error(resultado.getAllErrors());
    		ModelAndView cargarAlumno = new ModelAndView("cargarEstudiante.html");
            cargarAlumno.addObject("alumno", unAlumnoConDatos);
            return cargarAlumno;
    	}
    	
        ModelAndView listarAlumnos = new ModelAndView("mostrarEstudiante");
        G6.warn("mostrando alumno"+unAlumnoConDatos.getNombreAlumno());
        try{
            alumnoService.cargarAlumno(unAlumnoConDatos);
        }catch(Exception e){}
        listarAlumnos.addObject("alumnoListado",alumnoService.listarAlumnos());
        return listarAlumnos;
    }
    
    @GetMapping("/eliminarAlumno/{idAlumno}")
	@ResponseBody
	public ModelAndView borrarAlumno(@PathVariable Integer idAlumno) {
		
		try {
			alumnoService.eliminarAlumno(idAlumno);
			G6.error("PASANDO...");
		} catch (Exception e) {
			G6.error("encontrando: producto NO encontrado");
		}
		ModelAndView listadoAlumno = new ModelAndView("redirect:/guardarAlumno");
		listadoAlumno.addObject("alumnoListado", alumnoService.listarAlumnos());
		
		return listadoAlumno;
		}
	
	@GetMapping("/modificarAlumno/{idAlumno}")
	public ModelAndView getModificarAlumno(@PathVariable(name = "idAlumno")  Integer idAlumno) {
		
		ModelAndView modelAndView = new ModelAndView("cargarEstudiante");
		try {
			modelAndView.addObject("alumnoListado", alumnoService.mostrarAlumno(idAlumno));
		}catch (Exception e) {
			modelAndView.addObject("modificacionDeAlumnoErrorMessage", e.getMessage());
		}
		
		//bandera
		modelAndView.addObject("band", true);
		return modelAndView;
	}
	
	@PostMapping(value="/modificarAlumno")
	public ModelAndView modificarAlumno(@ModelAttribute ("cargarEstudiante") Alumno nuevoAlumno) throws IOException {
		
		ModelAndView listadoFinal= new ModelAndView("mostrarEstudiante");
		
		G6.warn("Mostrando el nuevo producto " + nuevoAlumno.getNombreAlumno());
		
		try {
			
			alumnoService.cargarAlumno(nuevoAlumno);
			
		}catch(Exception e) {
			listadoFinal.addObject("pasa por aqui", e.getMessage());
		}
		
		listadoFinal.addObject("listadoAlumno", alumnoService.listarAlumnos());
		
		return listadoFinal;
	}
    
}
