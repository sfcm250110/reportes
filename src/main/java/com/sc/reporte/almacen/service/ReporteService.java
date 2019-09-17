package com.sc.reporte.almacen.service;

import java.util.Date;
import java.util.List;

import com.ec.reporte.almacen.entity.Actividad;
import com.ec.reporte.almacen.entity.Reporte;
import com.sc.reporte.almacen.exception.ReporteNotFound;

public interface ReporteService {

	public List<Reporte> getAllReportes();

	public Reporte createReporte(Reporte pReporte, List<Actividad> pActividades) throws Exception;

	public Reporte updateReporte(Reporte pReporte) throws ReporteNotFound;

	public void deleteReporte(Long id) throws ReporteNotFound;

	public Reporte findById(Long id) throws ReporteNotFound;

	public Reporte findByElaboradoPor(String username) throws ReporteNotFound;

	public Reporte findByFechaCreacion(Date fechaCreacion) throws Exception;
	
	public Reporte findReporteById(Long id) throws ReporteNotFound;

}