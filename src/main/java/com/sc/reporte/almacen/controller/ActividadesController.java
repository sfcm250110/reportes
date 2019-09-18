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

import com.ec.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.exception.CustomeFieldValidationException;
import com.sc.reporte.almacen.service.ActividadService;

@Controller
public class ActividadesController {

	@Autowired
	ActividadService actividadService;

	@GetMapping("/consultarActividades")
	public String consultarActividades(Model pModel) {
		List<Actividad> actividades = (List<Actividad>) actividadService.getAllActividades();
		pModel.addAttribute("actividades", actividades);

		return "actividades/consultar";
	}

	@GetMapping("/crearActividad")
	public String crearActividad(Model pModel) {
		Actividad actividad = new Actividad();
		pModel.addAttribute("crearActividad", actividad);

		return "actividades/crear";
	}

	@PostMapping("guardarActividad")
	public String guardarActividad(@Valid @ModelAttribute("actividad") Actividad actividad, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			// TODO: revisar

		} else {
			try {
				actividadService.createActividad(actividad);

			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				// TODO: revisar

			} catch (Exception e) {
				// TODO: revisar
				model.addAttribute("formErrorMessage", e.getMessage());
			}
		}

		return "redirect:" + "consultarActividades";
	}

}
