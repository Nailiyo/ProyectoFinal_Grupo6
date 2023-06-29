package com.edu.unju.edm.PV2023.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class principalController {

	@GetMapping("/principal")
	public ModelAndView home() {
		ModelAndView principal = new ModelAndView("principal.html");
		return principal;
	}
	
}
