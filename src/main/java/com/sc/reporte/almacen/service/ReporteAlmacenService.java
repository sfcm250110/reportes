package com.sc.reporte.almacen.service;

import java.util.Date;
import java.util.List;

import com.sc.reporte.almacen.entity.ReporteAlmacen;
import com.sc.reporte.almacen.exception.ReporteNotFound;

public interface ReporteAlmacenService {

	public List<ReporteAlmacen> getAllReportes();

	public ReporteAlmacen crearReporte(ReporteAlmacen pReporte) throws Exception;

	public ReporteAlmacen updateReporte(ReporteAlmacen pReporte) throws ReporteNotFound;

	public void deleteReporte(Long id) throws ReporteNotFound;

	public ReporteAlmacen findById(Long id) throws ReporteNotFound;

	public ReporteAlmacen findByElaboradoPor(String username) throws ReporteNotFound;

	public ReporteAlmacen findByFechaCreacion(Date fechaCreacion) throws Exception;
	
	public ReporteAlmacen findFirstId() throws ReporteNotFound;

}