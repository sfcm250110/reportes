package com.sc.reporte.almacen.reportes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.Serializable;

public class ReporteHelper implements Serializable {	

	private static final long serialVersionUID = -6248350878202528123L;

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
