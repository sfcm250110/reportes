package com.sc.reporte.almacen.reportes.xml;

import java.io.Serializable;

import com.sc.reporte.almacen.entity.Actividad;
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
		reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_FECHA, pReporteTo.getFecha()));

		reporteAlmacenXml.append(HelperXml.openTag(ConstantesXml.TAG_ACTIVIDADES));
		for (Actividad actividad : pReporteTo.getActividades()) {
			reporteAlmacenXml.append(HelperXml.openTag(ConstantesXml.TAG_ACTIVIDAD));
			reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_HORA_ENTRADA, actividad.getHoraEntrada()));
			reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_HORA_SALIDA, actividad.getHoraSalida()));
			reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_VISITA, actividad.getVisita()));
			reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_COBRO, actividad.getCobro()));
			reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_PEDIDO, actividad.getPedido()));
			reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_PROVEEDORES, actividad.getProveedores()));
			reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_REPARTOS, actividad.getRepartos()));
			reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_OBSERVACIONES, actividad.getObservaciones()));
			reporteAlmacenXml.append(HelperXml.generarTag(ConstantesXml.TAG_INCIDENCIAS, actividad.getIncidencias()));
			reporteAlmacenXml.append(HelperXml.closeTag(ConstantesXml.TAG_ACTIVIDAD));
		}
		reporteAlmacenXml.append(HelperXml.closeTag(ConstantesXml.TAG_ACTIVIDADES));
		reporteAlmacenXml.append(HelperXml.closeTag(ConstantesXml.TAG_REPORTE_ALMACEN));

		return reporteAlmacenXml.toString();
	}

}
