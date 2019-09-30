package com.sc.reporte.almacen.service;

import java.util.Date;
import java.util.Formatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.sc.reporte.almacen.entity.ReporteAlmacen;
import com.sc.reporte.almacen.exception.ReporteNotFound;
import com.sc.reporte.almacen.repository.ReporteAlmacenRepository;
import com.sc.reporte.almacen.util.ConstantesUtil;

@Service
public class ReporteAlmacenServiceImpl implements ReporteAlmacenService {

	@Autowired
	ReporteAlmacenRepository reporteAlmacenRepository;

	@Override
	public ReporteAlmacen crearReporte(ReporteAlmacen pReporte) throws Exception {
		ReporteAlmacen reporte = findFirstId();

		pReporte.setNumero(generarNumeroReporte(reporte));
		pReporte.setFechaCreacion(new Date());
		pReporte = reporteAlmacenRepository.save(pReporte);

		return pReporte;
	}

	@Override
	public ReporteAlmacen updateReporte(ReporteAlmacen pReporte) throws ReporteNotFound {
		return reporteAlmacenRepository.save(pReporte);
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteReporte(Long id) throws ReporteNotFound {
		ReporteAlmacen reporte = findById(id);
		reporteAlmacenRepository.delete(reporte);
	}

	@Override
	public List<ReporteAlmacen> getAllReportes() {
		return (List<ReporteAlmacen>) reporteAlmacenRepository.findAll();
	}

	@Override
	public ReporteAlmacen findById(Long id) throws ReporteNotFound {
		return reporteAlmacenRepository.findById(id).orElseThrow(() -> new ReporteNotFound("El Id del reporte no existe."));
	}

	@Override
	public ReporteAlmacen findByElaboradoPor(String username) throws ReporteNotFound {
		return reporteAlmacenRepository.findByElaboradoPor(username).orElseThrow(() -> new ReporteNotFound("No existe la persona quien elaboro el reporte."));
	}

	@Override
	public ReporteAlmacen findByFechaCreacion(Date fechaCreacion) throws Exception {
		return reporteAlmacenRepository.findByFechaCreacion(fechaCreacion).orElseThrow(() -> new ReporteNotFound("No existe la fecha de creacion del reporte."));
	}
	
	@Override
	public ReporteAlmacen findFirstId() throws ReporteNotFound {
		List<ReporteAlmacen> reportesAlmacen = reporteAlmacenRepository.findFirstIdDesc();
		ReporteAlmacen reporteAlmacen = null;
		
		if (!reportesAlmacen.isEmpty()) {
			reporteAlmacen = reportesAlmacen.get(ConstantesUtil.PRIMER_REGISTRO);
		}
		
		return reporteAlmacen;
	}

	private String generarNumeroReporte(ReporteAlmacen pReporte) {
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
