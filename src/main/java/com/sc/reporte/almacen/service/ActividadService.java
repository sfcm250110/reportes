package com.sc.reporte.almacen.service;

import java.util.Date;
import java.util.List;

import com.sc.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.exception.ActividadNotFound;

public interface ActividadService {

	public List<Actividad> getAllActividades();

	public Actividad crearActividad(Actividad actividad) throws Exception;

	public Actividad updateActividad(Actividad actividad) throws ActividadNotFound;
	
	public void deleteActividad(Long id) throws ActividadNotFound;

	public Actividad findById(Long id) throws ActividadNotFound;
	
	public Actividad findByElaboradoPor(String username) throws ActividadNotFound;

	public Actividad findByFechaCreacion(Date fechaCreacion) throws Exception;


}