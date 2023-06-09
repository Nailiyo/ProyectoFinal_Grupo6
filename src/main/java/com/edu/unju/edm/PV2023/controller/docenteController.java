package com.edu.unju.edm.PV2023.controller;
import com.edu.unju.edm.PV2023.docenteservice.IDocenteService;
import com.edu.unju.edm.PV2023.model.Docente;
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
    public class docenteController {
    private static final Log G6 = LogFactory.getLog(docenteController.class);
    @Autowired
    Docente elDocente;
        @Autowired
        @Qualifier("serviceDocenteMySQL")
        IDocenteService docenteService;

        @GetMapping("/docentes")
        public ModelAndView cargarDocente() {
            ModelAndView cargarDocente = new ModelAndView("formDocente");
            cargarDocente.addObject("cargardocente",elDocente);
            return cargarDocente;
        }

        @PostMapping("/guardarDocente")
        public ModelAndView guardarDocente(@ModelAttribute("docente") Docente docente) {
            ModelAndView listarDocentes = new ModelAndView("mostrarDocentes");
            G6.warn("mostrando el nuevo docente"+docente.getNombreDocente());
            try{
            docenteService.cargarDocente(docente);
            }catch(Exception e){}
            listarDocentes.addObject("docenteListado",docenteService.listarDocentes());
            return listarDocentes;
        }
}
