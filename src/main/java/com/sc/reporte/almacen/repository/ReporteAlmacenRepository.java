package com.sc.reporte.almacen.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sc.reporte.almacen.entity.ReporteAlmacen;

@Repository
public interface ReporteAlmacenRepository extends CrudRepository<ReporteAlmacen, Long> {

	public Optional<ReporteAlmacen> findByElaboradoPor(String pUsername);

	public Optional<ReporteAlmacen> findByFechaCreacion(Date pFechaCreacion);

	public Optional<ReporteAlmacen> findByNumero(String pNumero);

	// TODO: revisar
	//@Query("Select ra From ReporteAlmacen ra Order By id Desc Limit 1")
	@Query("SELECT ra FROM REPORTE_ALMACEN ra ORDER BY ID DESC")
	public List<ReporteAlmacen> findFirstIdDesc();
	//public ReporteAlmacen findTopByIdByFechaCreacionDesc();
	//public ReporteAlmacen findTopIdByFechaCreacionDesc();
	//public ReporteAlmacen findFirstById();
	//User findTopByOrderByAgeDesc();
	//public ReporteAlmacen findTopByTipoOrderByIdDesc(String pTipo);
	
}