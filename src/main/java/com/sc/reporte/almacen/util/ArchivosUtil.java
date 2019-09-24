
package com.sc.reporte.almacen.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;

public class ArchivosUtil implements Serializable {

	private static final long serialVersionUID = -6660825301553726274L;

	public static String obtenerContenidoArchivo(String pPathArchivo) throws IOException {
		InputStream resource = new ClassPathResource(pPathArchivo).getInputStream();
		String contenido = null;

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
			contenido = reader.lines().collect(Collectors.joining("\n"));
		}

		return contenido;
	}

}
