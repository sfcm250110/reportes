package com.sc.reporte.almacen.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.ec.reporte.almacen.entity.Reporte;
import com.sc.reporte.almacen.exception.ReporteNotFound;
import com.sc.reporte.almacen.reportes.ReporteHelper;
import com.sc.reporte.almacen.service.ReporteService;
import com.sc.reporte.almacen.util.ConstantesUtil;

@Controller
public class ReporteController {
	
	public static final String BASEURI = "src/main/resources/html/";
	
	@Autowired
	ReporteService reporteService;

	@GetMapping("/consultarReporte")
	public String reportes(Model pModel) {
		pModel.addAttribute("crearReporte", new Reporte());
		pModel.addAttribute("reportes", reporteService.getAllReportes());
		
		return "reportes/consultar";
	}
	
	@PostMapping("/reportes/crear")
	public String createReporte(@Valid @ModelAttribute("crearReporte") Reporte pReporte, BindingResult pResult, ModelMap pModel) {
		try {
			//reporteService.createReporte(pReporte, null);
			pModel.addAttribute("crearReporte", new Reporte());
			pModel.addAttribute("reportes", reporteService.getAllReportes());

		//} catch (CustomeFieldValidationException cfve) {
			//pResult.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
			//pModel.addAttribute("crearReporte", new Reporte());
			
		} catch (Exception e) {
			pModel.addAttribute("formErrorMessage", e.getMessage());
			pModel.addAttribute("crearReporte", new Reporte());
		}
		
		return "reportes/consultar";
	}
	
	@GetMapping(value = "/reporteGerencia", produces = MediaType.APPLICATION_PDF_VALUE)
	public @ResponseBody void downloadA(HttpServletResponse pResponse, HttpServletRequest pHttpServletRequest) throws IOException, TransformerException, ReporteNotFound {
		List<Actividad> actividades = (List) pHttpServletRequest.getAttribute("actividades");
		
	    Reporte reporte = reporteService.findReporteById(1L);
		
	    byte[] out = ReporteHelper.createPdf(BASEURI, reporte);
	    InputStream in = new ByteArrayInputStream(out);
	    
	    pResponse.setContentType(ConstantesUtil.APPLICATION_PDF);
	    pResponse.setHeader("Content-Disposition", "attachment; filename=citiesreport.pdf");
	    pResponse.setHeader("Content-Length", String.valueOf(out.length));
	    
	    FileCopyUtils.copy(in, pResponse.getOutputStream());
	}

}