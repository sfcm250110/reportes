package com.sc.reporte.almacen.reportes.xml;

import java.io.Serializable;
import java.util.List;

import com.ec.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.util.ConstantesXml;
import com.sc.reporte.almacen.util.HelperXml;

public class ReporteGerenciaXml implements Serializable {
	
	private static final long serialVersionUID = 3824918907183741146L;

	public static String generarXml(String titulo, List<Actividad> actividades) {
		StringBuilder reporteGerenciaXml = new StringBuilder();

		reporteGerenciaXml.append(ConstantesXml.TAG_DECLARACION_XML);
		reporteGerenciaXml.append(HelperXml.openTag(ConstantesXml.TAG_REPORTE_GERENCIA));
		reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_TITULO, titulo));

		reporteGerenciaXml.append(HelperXml.openTag(ConstantesXml.TAG_ACTIVIDADES));
		for (Actividad actividad : actividades) {
			reporteGerenciaXml.append(HelperXml.openTag(ConstantesXml.TAG_ACTIVIDAD));
			reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_CODIGO, actividad.getId()));
			reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_POBLACION, actividad.getPoblacion()));
			reporteGerenciaXml.append(HelperXml.closeTag(ConstantesXml.TAG_ACTIVIDAD));
		}
		reporteGerenciaXml.append(HelperXml.closeTag(ConstantesXml.TAG_ACTIVIDADES));
		reporteGerenciaXml.append(HelperXml.closeTag(ConstantesXml.TAG_REPORTE_GERENCIA));

		return reporteGerenciaXml.toString();
	}

}
