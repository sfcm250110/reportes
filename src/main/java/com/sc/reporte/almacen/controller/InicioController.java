package com.sc.reporte.almacen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

	@GetMapping({ "/", "/login" })
	public String index() {
		return "index";
	}

	@GetMapping("/home")
	public String userhome(Model model) {
		return "home";
	}

}
