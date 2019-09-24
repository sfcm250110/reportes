package com.sc.reporte.almacen.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.sc.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.exception.ActividadNotFound;
import com.sc.reporte.almacen.repository.ActividadRepository;

@Service
public class ActividadServiceImpl implements ActividadService {

	@Autowired
	ActividadRepository repository;

	@Override
	public Actividad crearActividad(Actividad actividad) throws Exception {
		actividad.setFechaCreacion(new Date());
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
	public List<Actividad> getAllActividades() {
		return (List<Actividad>) repository.findAll();
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
