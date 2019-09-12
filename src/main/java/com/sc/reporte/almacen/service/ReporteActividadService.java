package com.sc.reporte.almacen.service;

import java.util.List;

import com.ec.reporte.almacen.entity.Actividad;

public interface ReporteActividadService {

	public List<Actividad> findActividadesByReporte(Long pIdReporte);

	public void createReporteActividades(Long pIdReporte, List<Actividad> pActividades) throws Exception;

}