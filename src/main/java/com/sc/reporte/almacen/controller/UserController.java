package com.sc.reporte.almacen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/userForm")
	public String userForm() {
//		model.addAttribute("userForm", new User());
//		model.addAttribute("userList", userService.getAllUsers());
//		model.addAttribute("roles",roleRepository.findAll());
//		model.addAttribute("listTab","active");
		return "user-form/user-view";
	}

}
