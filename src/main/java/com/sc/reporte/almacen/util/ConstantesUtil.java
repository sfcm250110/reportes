
package com.sc.reporte.almacen.util;

import java.io.Serializable;

public class ConstantesUtil implements Serializable {

	private static final long serialVersionUID = -1513079122885835424L;
	
	public static final int PRIMER_REGISTRO = 0;

	public static final String APPLICATION_PDF = "application/pdf";
	
	public static final String FORMATO_FECHA_DDMMYYHHMM = "dd/MM/yyyy - HH:mm";
	public static final String FORMATO_FECHA_YYYYMMDDHHMM = "yyyy-MM-dd'T'HH:mm";
	public static final String FORMATO_FECHA_YYYYMMDD = "yyyy-MM-dd";
	
	public static final String PATH_REPORTE_COMERCIAL = "static/xsl/reporte-comercial.xsl";
	public static final String PATH_REPORTE_COMERCIALES = "static/xsl/reporte-comerciales.xsl";
	public static final String PATH_REPORTE_ALMACEN = "static/xsl/reporte-almacen.xsl";
	public static final String PATH_REPORTE_ALMACENES = "static/xsl/reportes-almacen.xsl";
	
	public static final String TIPO_REPORTE_COMERCIAL = "COMERCIAL";
	public static final String TIPO_REPORTE_ALMACEN = "ALMACEN";
	
	public static final String PATH_REPORTE_CSS_DEV = "../static/css/reportes.css";
	public static final String PATH_REPORTE_CSS_PRO = "/home/reportes/app/css/reportes.css";
	public static final String PATH_REPORTE_CSS = PATH_REPORTE_CSS_PRO;

}
