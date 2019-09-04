package com.sc.reporte.almacen.reportes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.ec.reporte.almacen.entity.Actividad;
/*import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;*/
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.styledxmlparser.css.media.MediaDeviceDescription;
import com.itextpdf.styledxmlparser.css.media.MediaType;
import com.sc.reporte.almacen.reportes.xml.ReporteGerenciaXml;
import com.sc.reporte.almacen.to.ReporteTo;
import com.sc.reporte.almacen.util.ConstantesXml;
import com.sc.reporte.almacen.util.HelperXml;

public class ReporteHelper implements Serializable {	

    private static final long serialVersionUID = -6248350878202528123L;
    
    public static void createPdf(String baseUri, String dest, List<Actividad> pActividades) throws IOException, TransformerException {
    //public static void createPdf(byte[] html, String baseUri, String dest) throws IOException {
    	String xslPath = "src/main/resources/static/xsl/ReporteGerencia.xsl";
    	String conenidoXml = generarReporteXml(pActividades);
    	
    	ConverterProperties properties = new ConverterProperties();
        properties.setBaseUri(baseUri);
        
        
    	//
    	PdfWriter writer = new PdfWriter(dest);
    	PdfDocument pdf = new PdfDocument(writer);
    	pdf.setTagged();
    	PageSize pageSize = PageSize.A4;
    	//PageSize pageSize = PageSize.A4.rotate();
    	pdf.setDefaultPageSize(pageSize);
    	
    	MediaDeviceDescription mediaDeviceDescription = new MediaDeviceDescription(MediaType.SCREEN);
    	mediaDeviceDescription.setWidth(pageSize.getWidth());
    	properties.setMediaDeviceDescription(mediaDeviceDescription);
    	//
    	
    	
        byte[] html = createHtml(conenidoXml, xslPath);
        //HtmlConverter.convertToPdf(new ByteArrayInputStream(html), new FileOutputStream(dest), properties);
        HtmlConverter.convertToPdf(new ByteArrayInputStream(html), pdf, properties);
    }
    
    public static byte[] createHtml(String pContenidoXml, String xslPath) throws IOException, TransformerException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Writer writer = new OutputStreamWriter(baos);
        StreamSource xml = new StreamSource(new ByteArrayInputStream(pContenidoXml.getBytes()));
        StreamSource xsl = new StreamSource(new File(xslPath));
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(xsl);
        transformer.transform(xml, new StreamResult(writer));
        writer.flush();
        writer.close();
        
        return baos.toByteArray();
	}
    
    public static String generarReporteXml(List<Actividad> pActividades) {
    	ReporteTo reporteTo = new ReporteTo();
    	reporteTo.setNumero(generarNumeroReporte());
    	reporteTo.setElaboradoPor("Santiago Cabrera M.");
    	reporteTo.setFecha("03/09/2019 - 20:22");
    	reporteTo.setTotalEntradaManana("3");
    	reporteTo.setTotalSalidaManana("6");
    	reporteTo.setTotalEntradaTarde("9");
		reporteTo.setTotalSalidaTarde("1");
		reporteTo.setTotalOrdinarias("2");
		reporteTo.setTotalExtras("3");
		reporteTo.setTotalPoblacion("4");
		reporteTo.setTotalCliente("5");
		reporteTo.setTotalVisita("6");
		reporteTo.setTotalCobro("7");
		reporteTo.setTotalPedido("8");
		reporteTo.setTotalOtros("9");
		reporteTo.setTotalIncidencias("0");
        
    	/*List<Actividad> actividades = new ArrayList<Actividad>();
        Actividad actividad = new Actividad();
        actividad.setId(1L);
        actividad.setHoraEntradaManana(new Date());
        actividad.setHoraSalidaManana(new Date());
        actividad.setPoblacion("Alicante");
        actividades.add(actividad);

        actividad = new Actividad();
        actividad.setId(2L);
        actividad.setPoblacion("Barcelona");
        actividades.add(actividad);

        actividad = new Actividad();
        actividad.setId(3L);
        actividad.setPoblacion("Madrid");
        actividades.add(actividad);

        actividad = new Actividad();
        actividad.setId(4L);
        actividad.setPoblacion("Canarias");
        actividades.add(actividad);
        
        reporteTo.setActividades(actividades);*/
		reporteTo.setActividades(pActividades);

        String reporteGerenciaXml = ReporteGerenciaXml.generarXml(reporteTo);
        System.out.println(reporteGerenciaXml);
        
        
        try {
	        String xslPath = "src/main/resources/static/xsl/ReporteGerencia.xsl";
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        Writer writer = new OutputStreamWriter(baos);
	        StreamSource xml = new StreamSource(new ByteArrayInputStream(reporteGerenciaXml.getBytes()));
	        StreamSource xsl = new StreamSource(new File(xslPath));
	        TransformerFactory factory = TransformerFactory.newInstance();
	        Transformer transformer = factory.newTransformer(xsl);
	        transformer.transform(xml, new StreamResult(writer));
	        writer.flush();
	        writer.close();
	        
	        //baos.toByteArray();
	        
	        String d = new String(baos.toByteArray());
	        System.out.println(d);
        
        } catch (Exception e) {
			e.printStackTrace();
		}
        
        return reporteGerenciaXml;
    }
    
    /*
	public static void generarReporte() throws DocumentException, IOException {
        
        // step 1
		Document document = new Document();
		
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/actividades/consultar.pdf"));
        // step 3
        document.open();
        // step 4
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream("/actividades/consultar.html")); 
        
        //step 5
        document.close();
 
        System.out.println( "PDF Created!" );
    }
    */
    
    private static String generarNumeroReporte() {
    	String numeroReporte = "00001";
    	
    	return numeroReporte;
    }

}
