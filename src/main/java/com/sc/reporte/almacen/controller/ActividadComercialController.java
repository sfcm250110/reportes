package com.sc.reporte.almacen.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sc.reporte.almacen.entity.ActividadComercial;
import com.sc.reporte.almacen.entity.Reporte;
import com.sc.reporte.almacen.exception.CustomeFieldValidationException;
import com.sc.reporte.almacen.reportes.ReporteHelper;
import com.sc.reporte.almacen.repository.ActividadComercialRepository;
import com.sc.reporte.almacen.service.ActividadComercialService;
import com.sc.reporte.almacen.service.ReporteService;
import com.sc.reporte.almacen.util.ConstantesUtil;

@Controller
public class ActividadComercialController extends BaseController {

	private static final long serialVersionUID = -7554821866643742080L;

	@Autowired
	private ActividadComercialService actividadComercialService;

	@Autowired
	private ActividadComercialRepository actividadComercialRepository;
	
	@Autowired
	private ReporteService reporteService;

	@GetMapping("crearActividadComercial")
	public String crearActividadComercial(Model pModel) {
		ActividadComercial actividadComercial = new ActividadComercial();
		pModel.addAttribute("actividadComercial", actividadComercial);

		return "comercial/crear-actividad-comercial";
	}
	
	@GetMapping("consultarActividadComercial")
	public String consultarActividadComercial(Model pModel) {
		ActividadComercial actividadComercial = new ActividadComercial();
		List<ActividadComercial> actividadesComercial = new ArrayList<ActividadComercial>();
		
		pModel.addAttribute("actividadComercial", actividadComercial);
		pModel.addAttribute("actividadesComercial", actividadesComercial);

		return "comercial/consultar-actividad-comercial";
	}
	
	@PostMapping("guardarActividadComercial")
	public String guardarAlmacen(@Valid @ModelAttribute("actividadComercial") ActividadComercial actividadComercial, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			// TODO: revisar

		} else {
			try {
				actividadComercialService.crearActividad(actividadComercial);

			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				// TODO: revisar

			} catch (Exception e) {
				// TODO: revisar
				model.addAttribute("formErrorMessage", e.getMessage());
			}
		}

		return "redirect:" + "consultarActividadComercial";
	}
	
	@PostMapping("consultarActividadComercial")
	public String consultarActividadComercial(@Valid @ModelAttribute("actividadComercial") ActividadComercial actividadComercial, ModelMap pModel) {
		Date fechaDesde = obtenerFecha(actividadComercial.getFechaDesde());
		Date fechaHasta = obtenerFecha(actividadComercial.getFechaHasta());
		
		List<ActividadComercial> actividadesComercial = (List<ActividadComercial>) actividadComercialRepository.getAllBetweenDates(fechaDesde, fechaHasta);
		
		pModel.addAttribute("actividadesComercial", actividadesComercial);
		pModel.addAttribute("actividadComercial", actividadComercial);

		return "comercial/consultar-actividad-comercial";
	}

	@GetMapping(value = "descargarReporteComercial/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
	public String descargarReporteComercial(@PathVariable(value = "id") Long idActividadComercial, HttpServletResponse pResponse, HttpServletRequest pHttpServletRequest) {
		try {
			ActividadComercial actividadComercial = actividadComercialService.findById(idActividadComercial);
			actividadComercial.setRevisadoPor(obtenerUsuarioAutenticado());

			String contenidoXsl = ReporteHelper.obtenerPlantillaXsl(ConstantesUtil.PATH_REPORTE_COMERCIAL);
			String contenidoXml = ReporteHelper.generarReporteActividadComercialXml(actividadComercial);

			byte[] out = ReporteHelper.createPdf(BASEURI, contenidoXsl, contenidoXml);
			InputStream in = new ByteArrayInputStream(out);

			pResponse.setContentType(ConstantesUtil.APPLICATION_PDF);
			pResponse.setHeader("Content-Disposition", "attachment; filename=reporte-almacen.pdf");
			pResponse.setHeader("Content-Length", String.valueOf(out.length));

			FileCopyUtils.copy(in, pResponse.getOutputStream());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:" + "consultarActividadComercial";
	}
	
	@GetMapping(value = "descargarReporteComerciales/{fechaDesde}/{fechaHasta}", produces = MediaType.APPLICATION_PDF_VALUE)
	public String descargarReporteComerciales(@PathVariable(value = "fechaDesde") String pFechaDesde, @PathVariable(value = "fechaHasta") String pFechaHasta, HttpServletResponse pResponse, HttpServletRequest pHttpServletRequest) {
		try {
			Date fechaDesde = obtenerFecha(pFechaDesde);
			Date fechaHasta = obtenerFecha(pFechaHasta);
			
			List<ActividadComercial> actividadesComercial = (List<ActividadComercial>) actividadComercialRepository.getAllBetweenDates(fechaDesde, fechaHasta);

			Reporte reporte = new Reporte();
			reporte.setTipo(ConstantesUtil.TIPO_REPORTE_COMERCIAL);
			reporte.setElaboradoPor(obtenerUsuarioAutenticado());
			reporte.setActividadesComercial(actividadesComercial);
			reporte = reporteService.crearReporte(reporte);

			String contenidoXsl = ReporteHelper.obtenerPlantillaXsl(ConstantesUtil.PATH_REPORTE_COMERCIALES);
			String contenidoXml = ReporteHelper.generarReporteActividadComercialesXml(reporte);

			byte[] out = ReporteHelper.createPdf(BASEURI, contenidoXsl, contenidoXml);
			InputStream in = new ByteArrayInputStream(out);

			pResponse.setContentType(ConstantesUtil.APPLICATION_PDF);
			pResponse.setHeader("Content-Disposition", "attachment; filename=reporte-almacen.pdf");
			pResponse.setHeader("Content-Length", String.valueOf(out.length));

			FileCopyUtils.copy(in, pResponse.getOutputStream());
			
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:" + "consultarActividadComercial";
	}

}
