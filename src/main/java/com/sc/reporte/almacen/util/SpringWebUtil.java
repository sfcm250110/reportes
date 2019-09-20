
package com.sc.reporte.almacen.util;

import java.io.Serializable;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringWebUtil implements Serializable {

	private static final long serialVersionUID = -1429533566617951695L;

	public static String obtenerUsuarioAutenticado() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();

		return userName;
	}
}
