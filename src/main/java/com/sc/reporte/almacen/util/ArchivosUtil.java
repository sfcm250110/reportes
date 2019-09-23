
package com.sc.reporte.almacen.util;

import java.io.Serializable;
import java.io.InputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;

public class ArchivosUtil implements Serializable {

        public static String obtenerContenidoArchivo(String pPathArchivo) throws IOException {
                InputStream resource = new ClassPathResource(pPathArchivo).getInputStream();
                String contenido = null;

		try ( BufferedReader reader = new BufferedReader(
			new InputStreamReader(resource)) ) {
				contenido = reader.lines().collect(Collectors.joining("\n"));
                }
                
                return contenido;
	}
        
}
