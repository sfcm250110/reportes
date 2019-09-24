package com.sc.reporte.almacen.reportes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.styledxmlparser.css.media.MediaDeviceDescription;
import com.itextpdf.styledxmlparser.css.media.MediaType;
import com.sc.reporte.almacen.entity.Reporte;
import com.sc.reporte.almacen.reportes.xml.ReporteGerenciaXml;
import com.sc.reporte.almacen.to.ReporteTo;
import com.sc.reporte.almacen.util.ArchivosUtil;
import com.sc.reporte.almacen.util.ConstantesUtil;
import com.sc.reporte.almacen.util.FechasUtil;

public class ReporteHelper implements Serializable {

	private static final long serialVersionUID = -6248350878202528123L;

	public static byte[] createPdf(String baseUri, Reporte pReporte) throws IOException, TransformerException {
		ConverterProperties properties = new ConverterProperties();
		properties.setBaseUri(baseUri);

		ByteArrayOutputStream pdf = new ByteArrayOutputStream();
		PdfWriter writer = new PdfWriter(pdf);
		PdfDocument pdfDocument = new PdfDocument(writer);
		pdfDocument.setTagged();
		PageSize pageSize = PageSize.A4.rotate();
		pdfDocument.setDefaultPageSize(pageSize);

		MediaDeviceDescription mediaDeviceDescription = new MediaDeviceDescription(MediaType.SCREEN);
		mediaDeviceDescription.setWidth(pageSize.getWidth());
		properties.setMediaDeviceDescription(mediaDeviceDescription);

		String contenidoXsl = ArchivosUtil.obtenerContenidoArchivo(ConstantesUtil.PATH_REPORTE_GERENCIA);
		String conenidoXml = generarReporteGerenciaXml(pReporte);

		byte[] html = createHtml(conenidoXml, contenidoXsl);
		HtmlConverter.convertToPdf(new ByteArrayInputStream(html), pdfDocument, properties);

		return pdf.toByteArray();
	}

	public static String generarReporteGerenciaXml(Reporte pReporte) {
		ReporteTo reporteTo = new ReporteTo();
		reporteTo.setNumero(pReporte.getNumero());
		reporteTo.setElaboradoPor(pReporte.getElaboradoPor());
		reporteTo.setFecha(FechasUtil.formatearFecha(pReporte.getFechaCreacion(), ConstantesUtil.FORMATO_FECHA_DDMMYYHHMM));
		reporteTo.setActividades(pReporte.getActividades());
		String reporteGerenciaXml = ReporteGerenciaXml.generarXml(reporteTo);

		return reporteGerenciaXml;
	}

	public static byte[] createHtml(String pContenidoXml, String pContenidoXsl) throws IOException, TransformerException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Writer writer = new OutputStreamWriter(baos);
		StreamSource xml = new StreamSource(new ByteArrayInputStream(pContenidoXml.getBytes()));
		StreamSource xsl = new StreamSource(new ByteArrayInputStream(pContenidoXsl.getBytes()));
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(xsl);
		transformer.transform(xml, new StreamResult(writer));
		writer.flush();
		writer.close();

		return baos.toByteArray();
	}
}
