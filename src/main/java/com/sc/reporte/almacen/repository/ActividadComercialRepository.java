package com.sc.reporte.almacen.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sc.reporte.almacen.entity.ActividadComercial;

@Repository
public interface ActividadComercialRepository extends CrudRepository<ActividadComercial, Long> {

	public Optional<ActividadComercial> findByElaboradoPor(String pUsername);

	public Optional<ActividadComercial> findByFechaCreacion(Date pFechaCreacion);

	// TODO: revisar
	// @Query("Select ra From ReporteAlmacen ra Order By id Desc Limit 1")
	@Query("SELECT ac FROM ACTIVIDAD_COMERCIAL ac ORDER BY ID DESC")
	public List<ActividadComercial> findFirstIdDesc();
	// public ReporteAlmacen findTopByIdByFechaCreacionDesc();
	// public ReporteAlmacen findTopIdByFechaCreacionDesc();
	// public ReporteAlmacen findFirstById();
	// User findTopByOrderByAgeDesc();
	// public ReporteAlmacen findTopByTipoOrderByIdDesc(String pTipo);
	
	@Query("SELECT ac FROM ACTIVIDAD_COMERCIAL ac WHERE FECHA_CREACION >= :pFechaDesde AND FECHA_CREACION <= :pFechaHasta")
	//@Query("SELECT ac FROM ACTIVIDAD_COMERCIAL ac WHERE FECHA_CREACION BETWEEN :pFechaDesde AND :pFechaHasta")
	public List<ActividadComercial> getAllBetweenDates(@Param("pFechaDesde") Date pFechaDesde, @Param("pFechaHasta") Date pFechaHasta);

}