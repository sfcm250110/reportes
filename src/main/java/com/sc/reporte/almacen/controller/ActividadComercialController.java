package com.sc.reporte.almacen.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sc.reporte.almacen.entity.ActividadComercial;
import com.sc.reporte.almacen.entity.ReporteAlmacen;
import com.sc.reporte.almacen.exception.CustomeFieldValidationException;
import com.sc.reporte.almacen.repository.ActividadComercialRepository;
import com.sc.reporte.almacen.service.ActividadComercialService;

@Controller
public class ActividadComercialController extends BaseController {

	@Autowired
	private ActividadComercialService actividadComercialService;

	@Autowired
	ActividadComercialRepository actividadComercialRepository;

	@GetMapping("consultarReporteAlmacen")
	public String consultarReporteAlmacen(Model pModel) {
		List<ActividadComercial> reportes = (List<ActividadComercial>) actividadComercialRepository.findAll();
		pModel.addAttribute("actividadesComercial", reportes);

		return "reportes/consultar-reporte-almacen";
	}

	@GetMapping("crearReporteAlmacen")
	public String crearReporteAlmacen(Model pModel) {
		ReporteAlmacen reporteAlmacen = new ReporteAlmacen();
		pModel.addAttribute("reporteAlmacen", reporteAlmacen);

		return "reportes/crear-reporte-almacen";
	}

	@PostMapping("guardarReporteAlmacen")
	public String guardarAlmacen(@Valid @ModelAttribute("actividadComercial") ActividadComercial actividadComercial, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			// TODO: revisar

		} else {
			try {
				actividadComercialService.crearReporte(actividadComercial);

			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				// TODO: revisar

			} catch (Exception e) {
				// TODO: revisar
				model.addAttribute("formErrorMessage", e.getMessage());
			}
		}

		return "redirect:" + "consultarReporteAlmacen";
	}

}
