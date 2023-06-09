package com.edu.unju.edm.PV2023.controller;

import com.edu.unju.edm.PV2023.model.Alumno;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class alumnoController {
    private static final Log G6 = LogFactory.getLog(alumnoController.class);
    @Autowired
    Alumno Alumnos;
    @Autowired
    @Qualifier("serviceAlumnoMySQL")
    IAlumnoService servicio;
    @GetMapping("/alumno")
    public ModelAndView cargarAlumno(){
        ModelAndView cargarAlumno = new ModelAndView("formularioAlumno");
        cargarAlumno.addObject("cargarAlumno", Alumnos);
        return cargarAlumno;
    }
    @PostMapping("guardarAlumno")
    public ModelAndView guardarAlumno(@ModelAttribute("cargarAlumno")Alumno unAlumno){
        ModelAndView listarAlumnos = new ModelAndView("mostrarAlumnos");
        G6.warn("mostrando alumno"+unAlumno.getNombreAlumno());
        try{
            servicio.cargarAlumno(unAlumno);
        }catch(Exception e){}
        listarAlumnos.addObject("alumnoListado",servicio.listarAlumnos());
        return listarAlumnos;
    }
}
