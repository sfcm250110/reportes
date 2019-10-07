package com.sc.reporte.almacen.reportes.xml;

import java.io.Serializable;

import com.sc.reporte.almacen.to.ReporteTo;
import com.sc.reporte.almacen.util.ConstantesXml;
import com.sc.reporte.almacen.util.HelperXml;

public class ReporteAlmacenXml implements Serializable {

	private static final long serialVersionUID = 3824918907183741146L;

	public static String generarXmlAlmacen(ReporteTo pReporteTo) {
		StringBuilder reporteXml = new StringBuilder();

		reporteXml.append(ConstantesXml.TAG_DECLARACION_XML);
		reporteXml.append(HelperXml.openTag(ConstantesXml.TAG_REPORTE_ALMACEN));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_NUMERO, pReporteTo.getNumero()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_ELABORADO_POR, pReporteTo.getElaboradoPor()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_REVISADO_POR, pReporteTo.getRevisadoPor()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_FECHA, pReporteTo.getFecha()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_HORA_ENTRADA, pReporteTo.getReporteAlmacen().getHoraEntrada()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_HORA_SALIDA, pReporteTo.getReporteAlmacen().getHoraSalida()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_FRANK, pReporteTo.getReporteAlmacen().getFrank()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_VICENTE, pReporteTo.getReporteAlmacen().getVicente()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_INTEGRA, pReporteTo.getReporteAlmacen().getIntegra()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_GEORGE, pReporteTo.getReporteAlmacen().getGeorge()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_BLUE, pReporteTo.getReporteAlmacen().getBlue()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_OTROS, pReporteTo.getReporteAlmacen().getOtros()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_PROVEEDORES_DESCARGADOS, pReporteTo.getReporteAlmacen().getProveedoresDescargados()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_REPARTOS_GEORGE, pReporteTo.getReporteAlmacen().getRepartosGeorge()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_OBSERVACIONES, pReporteTo.getReporteAlmacen().getObservaciones()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_INCIDENCIAS, pReporteTo.getReporteAlmacen().getIncidencias()));
		reporteXml.append(HelperXml.closeTag(ConstantesXml.TAG_REPORTE_ALMACEN));

		return reporteXml.toString();
	}

}
