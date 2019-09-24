package com.sc.reporte.almacen.service;

import java.util.List;

import com.sc.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.entity.ReporteActividad;

public interface ReporteActividadService {

	public List<ReporteActividad> findActividadesByReporte(Long pIdReporte);

	public void createReporteActividades(Long pIdReporte, List<Actividad> pActividades) throws Exception;

}