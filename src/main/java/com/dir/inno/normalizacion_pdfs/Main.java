/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.licensekey.LicenseKey;
import com.itextpdf.text.pdf.PdfAcroForm;
import com.itextpdf.text.pdf.XfaForm;
import com.itextpdf.tool.xml.xtra.xfa.XFAFlattener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.xml.sax.SAXException;
import com.snowtide.PDF;
import com.snowtide.pdf.Document;
import com.snowtide.pdf.OutputTarget;
import com.snowtide.pdf.VisualOutputTarget;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import pdfts.examples.XMLOutputTarget;

/**
 *
 * @author Administrador
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws javax.xml.transform.TransformerException
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     */

    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException, SAXException {

        String pdfFilePath = "E:\\Users\\MODERNIZACION05\\Desktop\\tempFormularios\\pdfTest\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7 muy lleno_impreso.pdf";

        Document pdf = PDF.open(pdfFilePath);
        XMLOutputTarget xml = new XMLOutputTarget();
        pdf.pipe(xml);
        StringBuilder text = new StringBuilder();
        pdf.pipe(new OutputTarget (text));
        pdf.close();
        /*
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Source input = new DOMSource(xml.getXMLDocument());
        Result output = new StreamResult(new File("output.xml"));
        transformer.transform(input, output);
*/
        System.out.println(text);
        
        String version = obtenerVersion(text);
        System.out.println("Version: " + version);
        
        String nombre = obtenerNombre(text);
        System.out.println("Nombre: " + nombre);
        
        String cuil = obtenerCuil(text);
        System.out.println("CUIL: " + cuil);
    }

    private static String obtenerVersion(StringBuilder text) {
        String sub = "VERSIÓN";
        Integer index = text.indexOf(sub) + sub.length();
        while (text.charAt(index) == ' ') index++;
        String version = text.substring(index, index + 3);
        return version;
    }

    private static String obtenerNombre(StringBuilder text) {
        String sub = "NOMBRE COMPLETO / RAZÓN SOCIAL (*)";
        Integer index = text.indexOf(sub) + sub.length();
        while (text.charAt(index) == ' ' || text.charAt(index) == '\r') index+=2;
        String nombre = text.substring(index, index+2);
        index ++;
        while ((text.charAt(index+1) != ' ' && text.charAt(index+1) != '\r') ||
                ((text.charAt(index+1) == ' ') && 
                (text.charAt(index+2) != ' ' || text.charAt(index+2) != '\r')
                )
                ){
            nombre += text.charAt(index+1);
            index++;
        }
        return nombre;
    }

    private static String obtenerCuil(StringBuilder text) {
        String sub = "ACTIVIDADES DE LA EMPRESA: (*)";
        Integer index = text.indexOf(sub) + sub.length();
        while (text.charAt(index) == ' ' || text.charAt(index) == '\r') index+=2;
        String cuil = text.substring(index, index+2);
        index ++;
        cuil+='-';
        index+=2;
        while ((text.charAt(index+1) != ' ' && text.charAt(index+1) != '\r') ||
                ((text.charAt(index+1) == ' ') && 
                (text.charAt(index+2) != ' ' || text.charAt(index+2) != '\r')
                )
                ){
            cuil += text.charAt(index+1);
            index++;
        }
        cuil+='-';
        index+=2;
        cuil+=text.charAt(index+1);
        return cuil;
    }
}
