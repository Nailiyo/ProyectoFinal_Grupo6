package com.edu.unju.edm.PV2023.controller;

import com.edu.unju.edm.PV2023.model.Preguntas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class preguntasController {
    @Autowired
    Preguntas Pregunta;
    @Autowired
    @Qualifier("servicePreguntaMySQL")
    IPreguntaService servicio;
    @GetMapping("/pregunta")
    public ModelAndView cargarPregunta(){
        ModelAndView cargarPregunta = new ModelAndView("formularioPregunta");
        cargarPregunta.addObject("cargarPregunta", Pregunta);
        return cargarPregunta;
    }
    @PostMapping("/guardarPregunta")
    public ModelAndView guardarPregunta(@ModelAttribute("cargarPregunta") Preguntas unaPregunta) {
        ModelAndView guardarEsaPregunta = new ModelAndView("mostarPegunta");
        try{
            servicio.cargarPregunta(unaPregunta);
        }catch (Exception e){}
        guardarEsaPregunta.addObject("preguntaGuardada", servicio.listarPreguntas());
        return guardarEsaPregunta;
    }
}