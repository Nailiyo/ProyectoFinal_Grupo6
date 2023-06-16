package com.edu.unju.edm.PV2023.controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
            G6.warn("mostrando el nuevo Cuestionario"+cuestionario.getPregunta1());
            try{
            cuestionarioService.cargarCuestionario(cuestionario);
            }catch(Exception e){}
            listarCuestionarios.addObject("cuestionarioListado",cuestionarioService.listarCuestionarios());
            return listarCuestionarios;
        }
	
}
