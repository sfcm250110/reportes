package com.sc.reporte.almacen.reportes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
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
import com.sc.reporte.almacen.reportes.xml.ReporteGerenciaXml;

public class ReporteHelper implements Serializable {	

    private static final long serialVersionUID = -6248350878202528123L;
    
    public static void createPdf(String baseUri, String dest) throws IOException, TransformerException {
    //public static void createPdf(byte[] html, String baseUri, String dest) throws IOException {
    	String xslPath = "src/main/resources/static/xsl/ReporteGerencia.xsl";
    	String conenidoXml = generarReporteXml();
    	
        ConverterProperties properties = new ConverterProperties();
        properties.setBaseUri(baseUri);
        
        byte[] html = createHtml(conenidoXml, xslPath);
        HtmlConverter.convertToPdf(new ByteArrayInputStream(html), new FileOutputStream(dest), properties);
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
    
    public static String generarReporteXml() {
        String titulo = "Reporte de Gerencia";
        List<Actividad> actividades = new ArrayList<Actividad>();

        Actividad actividad = new Actividad();
        actividad.setId(1L);
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

        String reporteGerenciaXml = ReporteGerenciaXml.generarXml(titulo, actividades);
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

}
