package com.sc.reporte.almacen.reportes.xml;

import java.io.Serializable;

import com.sc.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.entity.ActividadComercial;
import com.sc.reporte.almacen.to.ReporteTo;
import com.sc.reporte.almacen.util.ConstantesXml;
import com.sc.reporte.almacen.util.FechasUtil;
import com.sc.reporte.almacen.util.HelperXml;

public class ReporteComercialXml implements Serializable {

	private static final long serialVersionUID = 3824918907183741146L;

	public static String generarXml(ReporteTo pReporteTo) {
		StringBuilder reporteComercialXml = new StringBuilder();

		reporteComercialXml.append(ConstantesXml.TAG_DECLARACION_XML);
		reporteComercialXml.append(HelperXml.openTag(ConstantesXml.TAG_REPORTE_COMERCIAL));
		reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_NUMERO, pReporteTo.getNumero()));
		reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_ELABORADO_POR, pReporteTo.getElaboradoPor()));
		reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_FECHA, pReporteTo.getFecha()));

		reporteComercialXml.append(HelperXml.openTag(ConstantesXml.TAG_ACTIVIDADES));
		for (Actividad actividad : pReporteTo.getActividades()) {
			reporteComercialXml.append(HelperXml.openTag(ConstantesXml.TAG_ACTIVIDAD));
			reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_ENTRADA_MANANA, actividad.getHoraEntradaManana()));
			reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_SALIDA_MANANA, actividad.getHoraSalidaManana()));
			reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_ENTRADA_TARDE, actividad.getHoraEntradaTarde()));
			reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_SALIDA_TARDE, actividad.getHoraSalidaTarde()));
			reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_ORDINARIAS, actividad.getHoraOrdinarias()));
			reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_EXTRAS, actividad.getHoraExtras()));
			reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_POBLACION, actividad.getPoblacion()));
			reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_CLIENTE, actividad.getCliente()));
			reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_VISITA, actividad.getVisita()));
			reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_COBRO, actividad.getCobro()));
			reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_PEDIDO, actividad.getPedido()));
			reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_OTROS, actividad.getOtros()));
			reporteComercialXml.append(HelperXml.generarTag(ConstantesXml.TAG_INCIDENCIAS, actividad.getIncidencias()));
			reporteComercialXml.append(HelperXml.closeTag(ConstantesXml.TAG_ACTIVIDAD));
		}
		reporteComercialXml.append(HelperXml.closeTag(ConstantesXml.TAG_ACTIVIDADES));
		reporteComercialXml.append(HelperXml.closeTag(ConstantesXml.TAG_REPORTE_COMERCIAL));

		return reporteComercialXml.toString();
	}
	
	public static String generarXmlActividadComercial(ReporteTo pReporteTo) {
		StringBuilder reporteXml = new StringBuilder();

		reporteXml.append(ConstantesXml.TAG_DECLARACION_XML);
		reporteXml.append(HelperXml.openTag(ConstantesXml.TAG_REPORTE_COMERCIAL));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_NUMERO, pReporteTo.getNumero()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_ELABORADO_POR, pReporteTo.getElaboradoPor()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_REVISADO_POR, pReporteTo.getRevisadoPor()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_FECHA, pReporteTo.getFecha()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_HORA_ENTRADA, pReporteTo.getActividadComercial().getHoraEntrada()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_HORA_SALIDA, pReporteTo.getActividadComercial().getHoraSalida()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_NOMBRE, pReporteTo.getActividadComercial().getNombre()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_POBLACION, pReporteTo.getActividadComercial().getPoblacion()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_REPARTO, pReporteTo.getActividadComercial().getReparto()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_COBRO, pReporteTo.getActividadComercial().getCobro()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_PEDIDO, pReporteTo.getActividadComercial().getPedido()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_OBSERVACIONES, pReporteTo.getActividadComercial().getObservaciones()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_INCIDENCIAS, pReporteTo.getActividadComercial().getIncidencias()));
		reporteXml.append(HelperXml.closeTag(ConstantesXml.TAG_REPORTE_COMERCIAL));

		return reporteXml.toString();
	}
	
	public static String generarXmlActividadComerciales(ReporteTo pReporteTo) {
		StringBuilder reporteXml = new StringBuilder();

		reporteXml.append(ConstantesXml.TAG_DECLARACION_XML);
		reporteXml.append(HelperXml.openTag(ConstantesXml.TAG_REPORTE_COMERCIAL));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_NUMERO, pReporteTo.getNumero()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_ELABORADO_POR, pReporteTo.getElaboradoPor()));
		reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_FECHA, pReporteTo.getFecha()));

		reporteXml.append(HelperXml.openTag(ConstantesXml.TAG_ACTIVIDADES_COMERCIAL));
		for (ActividadComercial actividad : pReporteTo.getActividadesComercial()) {
			reporteXml.append(HelperXml.openTag(ConstantesXml.TAG_REPORTE));
			reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_ID, actividad.getId()));
			reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_FECHA, FechasUtil.formatearFecha(actividad.getFechaCreacion())));
			reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_NOMBRE, actividad.getNombre()));
			reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_POBLACION, actividad.getPoblacion()));
			reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_REPARTO, actividad.getReparto()));
			reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_COBRO, actividad.getCobro()));
			reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_PEDIDO, actividad.getPedido()));
			reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_OBSERVACIONES, actividad.getObservaciones()));
			reporteXml.append(HelperXml.generarTag(ConstantesXml.TAG_INCIDENCIAS, actividad.getIncidencias()));
			reporteXml.append(HelperXml.closeTag(ConstantesXml.TAG_REPORTE));
		}
		reporteXml.append(HelperXml.closeTag(ConstantesXml.TAG_ACTIVIDADES_COMERCIAL));
		reporteXml.append(HelperXml.closeTag(ConstantesXml.TAG_REPORTE_COMERCIAL));

		return reporteXml.toString();
	}

}
