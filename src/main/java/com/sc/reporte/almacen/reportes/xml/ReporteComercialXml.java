package com.sc.reporte.almacen.reportes.xml;

import java.io.Serializable;

import com.sc.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.to.ReporteTo;
import com.sc.reporte.almacen.util.ConstantesXml;
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

}
