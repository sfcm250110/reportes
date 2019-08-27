
package com.sc.reporte.almacen.reportes.xml;

import com.ec.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.util.HelperXml;
import com.sc.reporte.almacen.util.ConstantesXml;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class ReporteGerenciaXml implements Serializable {	

	public static String generarXml(String titulo, List<Actividad> actividades) {
                StringBuilder reporteGerenciaXml = new StringBuilder();
                
                reporteGerenciaXml.append(ConstantesXml.TAG_DECLARACION_XML);
                reporteGerenciaXml.append(HelperXml.openTag(ConstantesXml.TAG_REPORTE_GERENCIA));
                reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_TITULO, titulo));

                reporteGerenciaXml.append(HelperXml.openTag(ConstantesXml.TAG_ACTIVIDADES));
                for (Actividad actividad : actividades) {
                        reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_ACTIVIDAD, actividad.getId()));
                        reporteGerenciaXml.append(HelperXml.generarTag(ConstantesXml.TAG_ACTIVIDAD, actividad.getPoblacion()));
                }
                reporteGerenciaXml.append(HelperXml.closeTag(ConstantesXml.TAG_ACTIVIDADES));
                reporteGerenciaXml.append(HelperXml.closeTag(ConstantesXml.TAG_REPORTE_GERENCIA));

                return reporteGerenciaXml.toString();
        }

}
