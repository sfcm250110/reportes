package com.sc.reporte.almacen.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.entity.Reporte;
import com.sc.reporte.almacen.entity.ReporteAlmacen;
import com.sc.reporte.almacen.reportes.ReporteHelper;
import com.sc.reporte.almacen.repository.ActividadRepository;
import com.sc.reporte.almacen.repository.ReporteAlmacenRepository;
import com.sc.reporte.almacen.service.ReporteService;
import com.sc.reporte.almacen.util.ArchivosUtil;
import com.sc.reporte.almacen.util.ConstantesUtil;

@Controller
public class ReporteController extends BaseController {

	private static final long serialVersionUID = 3878933243405801411L;

	@Autowired
	private ReporteService reporteService;

	@Autowired
	private ActividadRepository actividadRepository;

	@Autowired
	private ReporteAlmacenRepository reporteAlmacenRepository;

	@GetMapping(value = "descargarReporteComercial", produces = MediaType.APPLICATION_PDF_VALUE)
	public @ResponseBody void downloadReporteGerencia(HttpServletResponse pResponse, HttpServletRequest pHttpServletRequest) {
		try {
			List<Actividad> actividades = (List<Actividad>) actividadRepository.findAllByTipo(ConstantesUtil.TIPO_REPORTE_COMERCIAL);

			Reporte reporte = new Reporte();
			reporte.setElaboradoPor(obtenerUsuarioAutenticado());
			reporte.setTipo(ConstantesUtil.TIPO_REPORTE_COMERCIAL);
			reporte.setActividades(actividades);
			reporte = reporteService.crearReporte(reporte);

			String contenidoXsl = ArchivosUtil.obtenerContenidoArchivo(ConstantesUtil.PATH_REPORTE_COMERCIAL);
			String contenidoXml = ReporteHelper.generarReporteComercialXml(reporte);

			byte[] out = ReporteHelper.createPdf(BASEURI, contenidoXsl, contenidoXml);
			InputStream in = new ByteArrayInputStream(out);

			pResponse.setContentType(ConstantesUtil.APPLICATION_PDF);
			pResponse.setHeader("Content-Disposition", "attachment; filename=reporte-comercial.pdf");
			pResponse.setHeader("Content-Length", String.valueOf(out.length));

			FileCopyUtils.copy(in, pResponse.getOutputStream());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value = "descargarReportesAlmacen", produces = MediaType.APPLICATION_PDF_VALUE)
	public @ResponseBody void descargarReporteAlmacen(HttpServletResponse pResponse, HttpServletRequest pHttpServletRequest) {
		try {
			List<Actividad> actividades = (List<Actividad>) actividadRepository.findAllByTipo(ConstantesUtil.TIPO_REPORTE_ALMACEN);

			Reporte reporte = new Reporte();
			reporte.setElaboradoPor(obtenerUsuarioAutenticado());
			reporte.setTipo(ConstantesUtil.TIPO_REPORTE_ALMACEN);
			reporte.setActividades(actividades);
			reporte = reporteService.crearReporte(reporte);

			String contenidoXsl = ReporteHelper.obtenerPlantillaXsl(ConstantesUtil.PATH_REPORTE_ALMACEN);
			String contenidoXml = ReporteHelper.generarReporteAlmacenXml(reporte);

			byte[] out = ReporteHelper.createPdf(BASEURI, contenidoXsl, contenidoXml);
			InputStream in = new ByteArrayInputStream(out);

			pResponse.setContentType(ConstantesUtil.APPLICATION_PDF);
			pResponse.setHeader("Content-Disposition", "attachment; filename=reporte-almacen.pdf");
			pResponse.setHeader("Content-Length", String.valueOf(out.length));

			FileCopyUtils.copy(in, pResponse.getOutputStream());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value = "descargarReporteAlmacen/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
	public String descargarReporteAlmacen(@PathVariable(value = "id") Long idReporteAlmacen, HttpServletResponse pResponse, HttpServletRequest pHttpServletRequest) {
		try {
			Optional<ReporteAlmacen> reporteAlmacenOptional = reporteAlmacenRepository.findById(idReporteAlmacen);

			if (reporteAlmacenOptional.isPresent()) {
				ReporteAlmacen reporteAlmacen = reporteAlmacenOptional.get();
				reporteAlmacen.setRevisadoPor(obtenerUsuarioAutenticado());

				String contenidoXsl = ReporteHelper.obtenerPlantillaXsl(ConstantesUtil.PATH_REPORTE_ALMACEN);
				String contenidoXml = ReporteHelper.generarReporteAlmacenXml(reporteAlmacen);

				byte[] out = ReporteHelper.createPdf(BASEURI, contenidoXsl, contenidoXml);
				InputStream in = new ByteArrayInputStream(out);

				pResponse.setContentType(ConstantesUtil.APPLICATION_PDF);
				pResponse.setHeader("Content-Disposition", "attachment; filename=reporte-almacen.pdf");
				pResponse.setHeader("Content-Length", String.valueOf(out.length));

				FileCopyUtils.copy(in, pResponse.getOutputStream());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:" + "consultarReporteAlmacen";
	}

	@GetMapping("/consultarReporte")
	public String reportes(Model pModel) {
		pModel.addAttribute("crearReporte", new Reporte());
		pModel.addAttribute("reportes", reporteService.getAllReportes());

		return "reportes/consultar";
	}

	@PostMapping("/reportes/crear")
	public String createReporte(@Valid @ModelAttribute("crearReporte") Reporte pReporte, BindingResult pResult, ModelMap pModel) {
		try {
			// reporteService.createReporte(pReporte, null);
			pModel.addAttribute("crearReporte", new Reporte());
			pModel.addAttribute("reportes", reporteService.getAllReportes());

			// } catch (CustomeFieldValidationException cfve) {
			// pResult.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
			// pModel.addAttribute("crearReporte", new Reporte());

		} catch (Exception e) {
			pModel.addAttribute("formErrorMessage", e.getMessage());
			pModel.addAttribute("crearReporte", new Reporte());
		}

		return "reportes/consultar";
	}

}
