package com.sc.reporte.almacen.service;

import java.util.Date;

import com.ec.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.exception.ActividadNotFound;

public interface ActividadService {

	public Iterable<Actividad> getAllActividades();

	public Actividad createActividad(Actividad actividad) throws Exception;

	public Actividad updateActividad(Actividad actividad) throws ActividadNotFound;

	public Actividad findByElaboradoPor(Long id) throws ActividadNotFound;

	public Actividad findByFechaCreacion(Date fechaCreacion) throws Exception;

	public void deleteActividad(Long id) throws ActividadNotFound;


}