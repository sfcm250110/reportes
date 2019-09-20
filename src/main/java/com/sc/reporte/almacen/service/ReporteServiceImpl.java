package com.sc.reporte.almacen.service;

import java.util.Date;
import java.util.Formatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.ec.reporte.almacen.entity.Actividad;
import com.ec.reporte.almacen.entity.Reporte;
import com.sc.reporte.almacen.exception.ReporteNotFound;
import com.sc.reporte.almacen.repository.ActividadRepository;
import com.sc.reporte.almacen.repository.ReporteRepository;

@Service
public class ReporteServiceImpl implements ReporteService {

	@Autowired
	ReporteRepository reporteRepository;

	@Autowired
	ActividadRepository actividadRepository;

	@Autowired
	ReporteActividadService reporteActividadService;

	@Override
	public Reporte crearReporte(Reporte pReporte) throws Exception {
		Reporte reporte = reporteRepository.findTopByTipoOrderByIdDesc("gerencia");

		pReporte.setNumero(generarNumeroReporte(reporte));
		pReporte.setFechaCreacion(new Date());
		pReporte.setFechaDesde(new Date());
		pReporte.setFechaHasta(new Date());
		pReporte = reporteRepository.save(pReporte);

		return pReporte;
	}

	@Override
	public Reporte updateReporte(Reporte pReporte) throws ReporteNotFound {
		return reporteRepository.save(pReporte);
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteReporte(Long id) throws ReporteNotFound {
		Reporte reporte = findById(id);
		reporteRepository.delete(reporte);
	}

	@Override
	public List<Reporte> getAllReportes() {
		return (List<Reporte>) reporteRepository.findAll();
	}

	@Override
	public Reporte findById(Long id) throws ReporteNotFound {
		return reporteRepository.findById(id).orElseThrow(() -> new ReporteNotFound("El Id del reporte no existe."));
	}

	@Override
	public Reporte findByElaboradoPor(String username) throws ReporteNotFound {
		return reporteRepository.findByElaboradoPor(username).orElseThrow(() -> new ReporteNotFound("No existe la persona quien elaboro el reporte."));
	}

	@Override
	public Reporte findByFechaCreacion(Date fechaCreacion) throws Exception {
		return reporteRepository.findByFechaCreacion(fechaCreacion).orElseThrow(() -> new ReporteNotFound("No existe la fecha de creacion del reporte."));
	}

	@Override
	public Reporte findReporteById(Long id) throws ReporteNotFound {
		Reporte reporte = findById(id);
		List<Actividad> actividades = actividadRepository.findAllById(reporte.getIdActividad());
		reporte.setActividades(actividades);

		return reporte;
	}

	private String generarNumeroReporte(Reporte pReporte) {
		Long id = null;

		if (pReporte == null) {
			id = 1L;

		} else {
			id = pReporte.getId();
		}

		Formatter formater = new Formatter();
		String numeroReporte = formater.format("%08d", id).toString();
		formater.close();

		return numeroReporte;
	}

}
