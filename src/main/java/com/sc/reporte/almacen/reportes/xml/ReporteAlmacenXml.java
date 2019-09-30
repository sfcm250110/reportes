package com.sc.reporte.almacen.reportes.xml;

import java.io.Serializable;

import com.sc.reporte.almacen.to.ReporteTo;
import com.sc.reporte.almacen.util.ConstantesXml;
import com.sc.reporte.almacen.util.HelperXml;

public class ReporteAlmacenXml implements Serializable {

	private static final long serialVersionUID = 3824918907183741146L;

	public static String generarXml(ReporteTo pReporteTo) {
		StringBuilder reporteAlmacenXml = new StringBuilder();

		reporteAlmacenXml.append(ConstantesXml.TAG_DECLARACION_XML);
		reporteAlmacenXml.append(HelperXml.openTag(ConstantesXml.TAG_REPORTE_ALMACEN));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_NUMERO, pReporteTo.getNumero()));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_ELABORADO_POR, pReporteTo.getElaboradoPor()));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_REVISADO_POR, pReporteTo.getRevisadoPor()));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_FECHA, pReporteTo.getFecha()));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_HORA_ENTRADA, pReporteTo.getReporteAlmacen().getHoraEntrada()));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_HORA_SALIDA, pReporteTo.getReporteAlmacen().getHoraSalida()));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_FRANK, pReporteTo.getReporteAlmacen().getFrank()));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_VICENTE, pReporteTo.getReporteAlmacen().getVicente()));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_INTEGRA, pReporteTo.getReporteAlmacen().getIntegra()));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_GEORGE, pReporteTo.getReporteAlmacen().getGeorge()));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_BLUE, pReporteTo.getReporteAlmacen().getBlue()));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_OTROS, pReporteTo.getReporteAlmacen().getOtros()));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_PROVEEDORES_DESCARGADOS, pReporteTo.getReporteAlmacen().getProveedoresDescargados()));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_REPARTOS_GEORGE, pReporteTo.getReporteAlmacen().getRepartosGeorge()));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_OBSERVACIONES, pReporteTo.getReporteAlmacen().getObservaciones()));
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_INCIDENCIAS, pReporteTo.getReporteAlmacen().getIncidencias()));
		reporteAlmacenXml.append(HelperXml.closeTag(ConstantesXml.TAG_REPORTE_ALMACEN));

		return reporteAlmacenXml.toString();
	}

}
