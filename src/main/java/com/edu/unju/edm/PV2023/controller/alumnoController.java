package com.edu.unju.edm.PV2023.controller;

import java.io.IOException;
import java.util.Base64;

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


import com.edu.unju.edm.PV2023.model.Alumno;
import com.edu.unju.edm.PV2023.service.IAlumnoService;



@Controller

public class alumnoController {
    private static final Log G6 = LogFactory.getLog(alumnoController.class);
    @Autowired
    Alumno Alumnos;
    @Autowired
    @Qualifier("serviceAlumnoMySQL")
    IAlumnoService servicio;
    @GetMapping("/cargarAlumno")
    public ModelAndView cargarAlumno(){
        ModelAndView cargarAlumno = new ModelAndView("cargarEstudiante");
        cargarAlumno.addObject("alumno", Alumnos);
        return cargarAlumno;
    }
    @PostMapping("/guardarAlumno")
    public ModelAndView guardarAlumno(@ModelAttribute("cargarAlumno")Alumno unAlumno){
        ModelAndView listarAlumnos = new ModelAndView("mostrarEstudiante");
        G6.warn("mostrando alumno"+unAlumno.getNombreAlumno());
        try{
            servicio.cargarAlumno(unAlumno);
        }catch(Exception e){}
        listarAlumnos.addObject("alumnoListado",servicio.listarAlumnos());
        return listarAlumnos;
    }
    
    @GetMapping("/eliminarAlumno/{idAlumno}")
	@ResponseBody
	public ModelAndView borrarAlumno(@PathVariable Integer idAlumno) {
		
		try {
			servicio.eliminarAlumno(idAlumno);
			G6.error("PASANDO...");
		} catch (Exception e) {
			G6.error("encontrando: producto NO encontrado");
		}
		ModelAndView listadoAlumno = new ModelAndView("redirect:/guardarAlumno");
		listadoAlumno.addObject("alumnoListado", servicio.listarAlumnos());
		
		return listadoAlumno;
		}
	
	@GetMapping("/modificarAlumno/{idAlumno}")
	public ModelAndView getModificarAlumno(@PathVariable(name = "idAlumno")  Integer idAlumno) {
		
		ModelAndView modelAndView = new ModelAndView("cargarEstudiante");
		try {
			modelAndView.addObject("alumnoListado", servicio.mostrarUnAlumno(idAlumno));
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
			
			servicio.cargarAlumno(nuevoAlumno);
			
		}catch(Exception e) {
			listadoFinal.addObject("pasa por aqui", e.getMessage());
		}
		
		listadoFinal.addObject("listado", servicio.listarAlumnos());
		
		return listadoFinal;
	}
    
}
