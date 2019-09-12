package com.sc.reporte.almacen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.reporte.almacen.entity.Actividad;
import com.ec.reporte.almacen.entity.ReporteActividad;
import com.sc.reporte.almacen.repository.ReporteActividadRepository;

@Service
public class ReporteActividadServiceImpl implements ReporteActividadService {

	@Autowired
	ReporteActividadRepository repository;

	@Override
	public List<Actividad> findActividadesByReporte(Long pIdReporte) {
		return repository.findActividadesByIdReporte(pIdReporte);
	}

	@Override
	public void createReporteActividades(Long pIdReporte, List<Actividad> pActividades) throws Exception {
		ReporteActividad reporteActividad = new ReporteActividad();
		reporteActividad.setIdReporte(pIdReporte);

		for (Actividad actividad : pActividades) {
			reporteActividad.setIdActividad(actividad.getId());
		}

		repository.save(reporteActividad);
	}

}
