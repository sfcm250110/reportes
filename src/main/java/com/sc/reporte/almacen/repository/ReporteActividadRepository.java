package com.sc.reporte.almacen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.reporte.almacen.entity.Actividad;
import com.ec.reporte.almacen.entity.ReporteActividad;

@Repository
public interface ReporteActividadRepository extends CrudRepository<ReporteActividad, Long> {

	public List<Actividad> findActividadesByIdReporte(Long pIdReporte);

}