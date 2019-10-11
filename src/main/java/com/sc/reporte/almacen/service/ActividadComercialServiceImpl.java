package com.sc.reporte.almacen.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.sc.reporte.almacen.entity.ActividadComercial;
import com.sc.reporte.almacen.exception.ReporteNotFound;
import com.sc.reporte.almacen.repository.ActividadComercialRepository;
import com.sc.reporte.almacen.util.ConstantesUtil;

@Service
public class ActividadComercialServiceImpl implements ActividadComercialService {

	@Autowired
	ActividadComercialRepository actividadComercialRepository;

	@Override
	public ActividadComercial crearActividad(ActividadComercial pReporte) throws Exception {
		pReporte = actividadComercialRepository.save(pReporte);

		return pReporte;
	}

	@Override
	public ActividadComercial updateActividad(ActividadComercial pReporte) throws ReporteNotFound {
		return actividadComercialRepository.save(pReporte);
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteActividad(Long id) throws ReporteNotFound {
		ActividadComercial reporte = findById(id);
		actividadComercialRepository.delete(reporte);
	}

	@Override
	public List<ActividadComercial> getAllActividades() {
		return (List<ActividadComercial>) actividadComercialRepository.findAll();
	}

	@Override
	public ActividadComercial findById(Long id) throws ReporteNotFound {
		return actividadComercialRepository.findById(id).orElseThrow(() -> new ReporteNotFound("El Id del reporte no existe."));
	}

	@Override
	public ActividadComercial findByElaboradoPor(String username) throws ReporteNotFound {
		return actividadComercialRepository.findByElaboradoPor(username).orElseThrow(() -> new ReporteNotFound("No existe la persona quien elaboro el reporte."));
	}

	@Override
	public ActividadComercial findByFechaCreacion(Date fechaCreacion) throws Exception {
		return actividadComercialRepository.findByFechaCreacion(fechaCreacion).orElseThrow(() -> new ReporteNotFound("No existe la fecha de creacion del reporte."));
	}

	@Override
	public ActividadComercial findFirstId() throws ReporteNotFound {
		List<ActividadComercial> reportes = actividadComercialRepository.findFirstIdDesc();
		ActividadComercial reporte = null;

		if (!reportes.isEmpty()) {
			reporte = reportes.get(ConstantesUtil.PRIMER_REGISTRO);
		}

		return reporte;
	}

}
