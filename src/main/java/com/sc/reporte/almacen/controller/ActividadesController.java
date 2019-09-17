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

	@GetMapping("/consultar")
	public String consultar(Model model) {
		List<Actividad> actividades = (List<Actividad>) actividadService.getAllActividades();

		model.addAttribute("actividades", actividades);

		return "actividades/consultar";
	}

	@GetMapping("/registrar")
	public String users(Model model) {
		model.addAttribute("crearActividad", new Actividad());
		model.addAttribute("actividades", actividadService.getAllActividades());

		return "actividades/registrar";
	}

	@PostMapping("/actividades/crear")
	public String createActividad(@Valid @ModelAttribute("crearActividad") Actividad actividad, BindingResult result, ModelMap model) {
		try {
			actividadService.createActividad(actividad);

			for (Actividad actividadTmp : actividadService.getAllActividades()) {
				System.out.println(actividadTmp.getPoblacion());
			}

			model.addAttribute("crearActividad", new Actividad());

		} catch (CustomeFieldValidationException cfve) {
			result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
			model.addAttribute("crearActividad", new Actividad());

		} catch (Exception e) {
			model.addAttribute("formErrorMessage", e.getMessage());
			model.addAttribute("crearActividad", new Actividad());
		}

		/*
		 * if (result.hasErrors()) { model.addAttribute("crearActividad", actividad); System.out.println("aqui 2");
		 * 
		 * } else { try { System.out.println("aqui 3"); System.out.println(actividad.getPoblacion()); actividadService.createActividad(actividad);
		 * 
		 * for (Actividad actividadTmp : actividadService.getAllActividades()) { System.out.println(actividadTmp); }
		 * 
		 * model.addAttribute("crearActividad", new Actividad());
		 * 
		 * } catch (CustomeFieldValidationException cfve) { result.rejectVal	ue(cfve.getFieldName(), null, cfve.getMessage()); model.addAttribute("crearActividad", new Actividad());
		 * 
		 * } catch (Exception e) { model.addAttribute("formErrorMessage", e.getMessage()); model.addAttribute("crearActividad", new Actividad()); } }
		 */

		return "actividades/registrar";
	}

}
