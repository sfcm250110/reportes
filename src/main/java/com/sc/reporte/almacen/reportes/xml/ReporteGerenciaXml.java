package com.sc.reporte.almacen.reportes.xml;

import java.io.Serializable;

import com.sc.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.to.ReporteTo;
import com.sc.reporte.almacen.util.ConstantesXml;
import com.sc.reporte.almacen.util.HelperXml;

public class ReporteGerenciaXml implements Serializable {

	private static final long serialVersionUID = 3824918907183741146L;

	public static String generarXml(ReporteTo pReporteTo) {
		StringBuilder reporteGerenciaXml = new StringBuilder();

		reporteGerenciaXml.append(ConstantesXml.TAG_DECLARACION_XML);
		reporteGerenciaXml.append(HelperXml.openTag(ConstantesXml.TAG_REPORTE_GERENCIA));
		reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_NUMERO, pReporteTo.getNumero()));
		reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_ELABORADO_POR, pReporteTo.getElaboradoPor()));
		reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_FECHA, pReporteTo.getFecha()));

		reporteGerenciaXml.append(HelperXml.openTag(ConstantesXml.TAG_ACTIVIDADES));
		for (Actividad actividad : pReporteTo.getActividades()) {
			reporteGerenciaXml.append(HelperXml.openTag(ConstantesXml.TAG_ACTIVIDAD));
			reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_ENTRADA_MANANA, actividad.getHoraEntradaManana()));
			reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_SALIDA_MANANA, actividad.getHoraSalidaManana()));
			reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_ENTRADA_TARDE, actividad.getHoraEntradaTarde()));
			reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_SALIDA_TARDE, actividad.getHoraSalidaTarde()));
			reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_ORDINARIAS, actividad.getHoraOrdinarias()));
			reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_EXTRAS, actividad.getHoraExtras()));
			reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_POBLACION, actividad.getPoblacion()));
			reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_CLIENTE, actividad.getCliente()));
			reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_VISITA, actividad.getVisita()));
			reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_COBRO, actividad.getCobro()));
			reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_PEDIDO, actividad.getPedido()));
			reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_OTROS, actividad.getOtros()));
			reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_INCIDENCIAS, actividad.getIncidencias()));
			reporteGerenciaXml.append(HelperXml.closeTag(ConstantesXml.TAG_ACTIVIDAD));
		}
		reporteGerenciaXml.append(HelperXml.closeTag(ConstantesXml.TAG_ACTIVIDADES));
		reporteGerenciaXml.append(HelperXml.closeTag(ConstantesXml.TAG_REPORTE_GERENCIA));

		return reporteGerenciaXml.toString();
	}

}
