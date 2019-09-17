package com.sc.reporte.almacen.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ec.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.exception.CustomeFieldValidationException;
import com.sc.reporte.almacen.reportes.ReporteHelper;
import com.sc.reporte.almacen.service.ActividadService;

@Controller
public class ActividadesController {
	
	private static final String APPLICATION_PDF = "application/pdf";

	@Autowired
	ActividadService actividadService;

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
		if (result.hasErrors()) {
			model.addAttribute("crearActividad", actividad);
			System.out.println("aqui 2");
			
		} else {
			try {
				System.out.println("aqui 3");
				System.out.println(actividad.getPoblacion());
				actividadService.createActividad(actividad);
				
				for (Actividad actividadTmp : actividadService.getAllActividades()) {
					System.out.println(actividadTmp);
				}
				
				model.addAttribute("crearActividad", new Actividad());

			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				model.addAttribute("crearActividad", new Actividad());
				
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("crearActividad", new Actividad());
			}
		}
		*/

		return "actividades/registrar";
	}
	
	public static final String TARGET = "target/results/ch01/";
	public static final String BASEURI = "src/main/resources/html/";
	public static final String DEST = String.format("%stest-03.pdf", TARGET);
	
	@GetMapping("/consultar")
	public String consultar(Model model) {
		try {
			List<Actividad> actividades = (List<Actividad>) actividadService.getAllActividades();
			
			/*File file = new File(TARGET);
			file.mkdirs();
			ReporteHelper.createPdf(BASEURI, DEST, actividades);*/
			
			model.addAttribute("actividades", actividades);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "actividades/consultar";
	}
	
	// TODO: revisar
	/*
	@GetMapping("/consultar")
	public String consultar(Model model) {
		model.addAttribute("userForm", new User());
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute("listTab", "active");
		
		return "actividades/consultar";
	}

	@PostMapping("agregar")
	public ResponseEntity agregar(@Valid @RequestBody ChangePasswordForm form, Errors errors) {
		try {
			if (errors.hasErrors()) {
				String result = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
						.collect(Collectors.joining(""));

				throw new Exception(result);
			}
			userService.changePassword(form);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Success");
	}
	*/
	
	//@GetMapping(value = "/reporteGerencia", produces = MediaType.APPLICATION_PDF_VALUE)
	//public @ResponseBody void downloadA(HttpServletResponse pResponse) throws IOException, TransformerException {
	    /*
		List<Actividad> actividades = (List<Actividad>) actividadService.getAllActividades();
		
	    byte[] out = ReporteHelper.createPdf(BASEURI, DEST, actividades);
	    InputStream in = new ByteArrayInputStream(out);
	    
	    pResponse.setContentType(APPLICATION_PDF);
	    pResponse.setHeader("Content-Disposition", "attachment; filename=citiesreport.pdf");
	    pResponse.setHeader("Content-Length", String.valueOf(out.length));
	    
	    FileCopyUtils.copy(in, pResponse.getOutputStream());
	    */
	//}

}
