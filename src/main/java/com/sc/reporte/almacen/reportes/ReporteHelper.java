package com.sc.reporte.almacen.reportes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import com.ec.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.reportes.xml.ReporteGerenciaXml;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class ReporteHelper implements Serializable {	

    private static final long serialVersionUID = -6248350878202528123L;
    
    public static void generarReporteXml() {
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
    }

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

}
