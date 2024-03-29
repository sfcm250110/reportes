package com.sc.reporte.almacen.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sc.reporte.almacen.entity.Actividad;

@Repository
public interface ActividadRepository extends CrudRepository<Actividad, Long> {

	public Optional<Actividad> findByElaboradoPor(String username);

	public Optional<Actividad> findByFechaCreacion(Date fechaCreacion);
	
	public List<Actividad> findAllById(Long pId);
	
	public List<Actividad> findAllByTipo(String pTipo);
	
}