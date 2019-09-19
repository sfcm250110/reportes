package com.sc.reporte.almacen.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.reporte.almacen.entity.Reporte;

@Repository
public interface ReporteRepository extends CrudRepository<Reporte, Long> {

	public Optional<Reporte> findByElaboradoPor(String pUsername);

	public Optional<Reporte> findByFechaCreacion(Date pFechaCreacion);

	public Optional<Reporte> findByNumero(String pNumero);
	
	public Reporte findTopByTipoOrderByIdDesc(String pTipo);

}