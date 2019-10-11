
package com.sc.reporte.almacen.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechasUtil implements Serializable {

	private static final long serialVersionUID = -1429533566617951695L;
	
	public static String formatearFecha(Date pFecha) {
		DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String fechaFormateada = formatoFecha.format(pFecha);
		
		return fechaFormateada;
    }

	public static String formatearFecha(Date pFechaSinFormato, String pFormato) {
		SimpleDateFormat formatter = new SimpleDateFormat(pFormato);
		String fechaConFormato = formatter.format(pFechaSinFormato);

		return fechaConFormato;
	}
}
