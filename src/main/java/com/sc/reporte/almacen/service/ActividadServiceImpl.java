package com.sc.reporte.almacen.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.ec.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.exception.ActividadNotFound;
import com.sc.reporte.almacen.repository.ActividadRepository;

@Service
public class ActividadServiceImpl implements ActividadService {

	@Autowired
	ActividadRepository repository;

	@Override
	public Actividad createActividad(Actividad actividad) throws Exception {
		actividad.setFechaCreacion(new Date());
		actividad.setTipo("gerencia");
		actividad.setIncidencias("incidencia");
		
		actividad = repository.save(actividad);

		return actividad;
	}

	@Override
	public Actividad updateActividad(Actividad actividad) throws ActividadNotFound {
		return repository.save(actividad);
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteActividad(Long id) throws ActividadNotFound {
		Actividad actividad = findById(id);
		repository.delete(actividad);
	}

	@Override
	public Iterable<Actividad> getAllActividades() {
		return repository.findAll();
	}

	@Override
	public Actividad findById(Long id) throws ActividadNotFound {
		return repository.findById(id).orElseThrow(() -> new ActividadNotFound("El Id de la actividad no existe."));
	}

	@Override
	public Actividad findByElaboradoPor(String username) throws ActividadNotFound {
		return repository.findByElaboradoPor(username).orElseThrow(() -> new ActividadNotFound("No existe la persona quien elaboro la actividad."));
	}

	@Override
	public Actividad findByFechaCreacion(Date fechaCreacion) throws Exception {
		return repository.findByFechaCreacion(fechaCreacion).orElseThrow(() -> new ActividadNotFound("No existe la fecha de creacion de la actividad."));
	}

}
