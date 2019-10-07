package com.sc.reporte.almacen.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.sc.reporte.almacen.entity.User;
import com.sc.reporte.almacen.exception.UsernameOrIdNotFound;
import com.sc.reporte.almacen.service.UserService;
import com.sc.reporte.almacen.util.SpringWebUtil;

public class BaseController implements Serializable {

	private static final long serialVersionUID = 657394834571526085L;

	public static final String BASEURI = "src/main/resources/html/";

	@Autowired
	private UserService userService;

	public String obtenerUsuarioAutenticado() throws UsernameOrIdNotFound {
		String userName = SpringWebUtil.obtenerUsuarioAutenticado();
		User usuario = userService.getUserByUsername(userName);
		String usuarioAutenticado = usuario.getFirstName() + " " + usuario.getLastName();

		return usuarioAutenticado;
	}

}
