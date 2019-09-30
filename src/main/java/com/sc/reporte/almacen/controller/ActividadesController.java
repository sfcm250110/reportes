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

import com.sc.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.exception.CustomeFieldValidationException;
import com.sc.reporte.almacen.repository.ActividadRepository;
import com.sc.reporte.almacen.service.ActividadService;
import com.sc.reporte.almacen.util.ConstantesUtil;

@Controller
public class ActividadesController extends BaseController {

	@Autowired
	private ActividadRepository actividadRepository;

	@Autowired
	ActividadService actividadService;

	@GetMapping("consultarReporteComercial")
	public String consultarReporteComercial(Model pModel) {
		List<Actividad> actividades = (List<Actividad>) actividadRepository.findAllByTipo(ConstantesUtil.TIPO_REPORTE_COMERCIAL);
		pModel.addAttribute("actividades", actividades);

		return "actividades/consultar-reporte-comercial";
	}

	@GetMapping("crearComercial")
	public String crearComercial(Model pModel) {
		Actividad actividad = new Actividad();
		pModel.addAttribute("crearActividad", actividad);

		return "actividades/crear-comercial";
	}

	@PostMapping("guardarComercial")
	public String guardarComercial(@Valid @ModelAttribute("actividad") Actividad actividad, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			// TODO: revisar

		} else {
			try {
				actividad.setElaboradoPor(obtenerElaboradoPor());
				actividad.setTipo(ConstantesUtil.TIPO_REPORTE_COMERCIAL);
				actividadService.crearActividad(actividad);

			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				// TODO: revisar

			} catch (Exception e) {
				// TODO: revisar
				model.addAttribute("formErrorMessage", e.getMessage());
			}
		}

		return "redirect:" + "consultarReporteComercial";
	}

}
