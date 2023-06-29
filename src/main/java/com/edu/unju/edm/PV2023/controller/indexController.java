package com.edu.unju.edm.PV2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.unju.edm.PV2023.model.Docente;

@Controller
public class indexController {

	@Autowired
	Docente unDocente;
	
	@GetMapping({"/","/index","/home","login"})
    public ModelAndView cargarPrincipal() {
        ModelAndView modelAndView= new ModelAndView("index");
        modelAndView.addObject("docenteParaLoguear",unDocente);
        return modelAndView;
    }
	
	
	
}
