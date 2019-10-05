package com.sc.reporte.almacen.service;

import java.util.Date;
import java.util.List;

import com.sc.reporte.almacen.entity.ActividadComercial;
import com.sc.reporte.almacen.exception.ReporteNotFound;

public interface ActividadComercialService {

	public List<ActividadComercial> getAllReportes();

	public ActividadComercial crearReporte(ActividadComercial pReporte) throws Exception;

	public ActividadComercial updateReporte(ActividadComercial pReporte) throws ReporteNotFound;

	public void deleteReporte(Long id) throws ReporteNotFound;

	public ActividadComercial findById(Long id) throws ReporteNotFound;

	public ActividadComercial findByElaboradoPor(String username) throws ReporteNotFound;

	public ActividadComercial findByFechaCreacion(Date fechaCreacion) throws Exception;

	public ActividadComercial findFirstId() throws ReporteNotFound;

}