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
import com.sc.reporte.almacen.entity.User;
import com.sc.reporte.almacen.exception.CustomeFieldValidationException;
import com.sc.reporte.almacen.exception.UsernameOrIdNotFound;
import com.sc.reporte.almacen.repository.ActividadRepository;
import com.sc.reporte.almacen.service.ActividadService;
import com.sc.reporte.almacen.service.UserService;
import com.sc.reporte.almacen.util.ConstantesUtil;
import com.sc.reporte.almacen.util.SpringWebUtil;

@Controller
public class ActividadesController {

	@Autowired
	private ActividadRepository actividadRepository;
	
	@Autowired
	ActividadService actividadService;
	
	@Autowired
	private UserService userService;

	@GetMapping("consultarReporteComercial")
	public String consultarReporteComercial(Model pModel) {
		List<Actividad> actividades = (List<Actividad>) actividadRepository.findAllByTipo(ConstantesUtil.TIPO_REPORTE_COMERCIAL);
		pModel.addAttribute("actividades", actividades);

		return "actividades/consultar-reporte-comercial";
	}
	
	@GetMapping("consultarReporteAlmacen")
	public String consultarReporteAlmacen(Model pModel) {
		List<Actividad> actividades = (List<Actividad>) actividadRepository.findAllByTipo(ConstantesUtil.TIPO_REPORTE_ALMACEN);
		pModel.addAttribute("actividades", actividades);

		return "actividades/consultar-reporte-almacen";
	}

	@GetMapping("crearComercial")
	public String crearComercial(Model pModel) {
		Actividad actividad = new Actividad();
		pModel.addAttribute("crearActividad", actividad);

		return "actividades/crear-comercial";
	}
	
	@GetMapping("crearAlmacen")
	public String crearAlmacen(Model pModel) {
		Actividad actividad = new Actividad();
		pModel.addAttribute("crearActividad", actividad);

		return "actividades/crear-almacen";
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
	
	@PostMapping("guardarAlmacen")
	public String guardarAlmacen(@Valid @ModelAttribute("actividad") Actividad actividad, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			// TODO: revisar

		} else {
			try {
				actividad.setElaboradoPor(obtenerElaboradoPor());
				actividad.setTipo(ConstantesUtil.TIPO_REPORTE_ALMACEN);
				actividadService.crearActividad(actividad);

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
	
	private String obtenerElaboradoPor() throws UsernameOrIdNotFound {
		String userName = SpringWebUtil.obtenerUsuarioAutenticado();
		User usuario = userService.getUserByUsername(userName);
		String elaboradoPor = usuario.getFirstName() + " " + usuario.getLastName();
		
		return elaboradoPor;
	}

}
