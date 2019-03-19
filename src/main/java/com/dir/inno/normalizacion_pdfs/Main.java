/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import com.snowtide.PDF;
import com.snowtide.pdf.Document;
import com.snowtide.pdf.OutputTarget;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.text.WordUtils;
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
    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException, SAXException, ParseException {

        String pdfFilePath = "E:\\Users\\MODERNIZACION05\\Desktop\\tempFormularios\\pdfTest\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(2)_impreso.pdf";

        Document pdf = PDF.open(pdfFilePath);
        XMLOutputTarget xml = new XMLOutputTarget();
        pdf.pipe(xml);
        StringBuilder text = new StringBuilder();
        pdf.pipe(new OutputTarget(text));
        pdf.close();
        
        LectorPDFImpreso47 lector = new LectorPDFImpreso47(text);
        
        /*
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Source input = new DOMSource(xml.getXMLDocument());
        Result output = new StreamResult(new File("output.xml"));
        transformer.transform(input, output);
         */
        System.out.println(text);

        String version = lector.obtenerVersion();
        System.out.println("Version: " + version);

        String nombre = lector.obtenerNombre();
        System.out.println("Nombre: " + nombre);

        Double cuit = lector.obtenerCuit();
        System.out.println("CUIT: " + cuit);

        Date fechaInicioAct = lector.obtenerFechaInicioAct();
        System.out.println("Fecha Inicio Actividades: " + fechaInicioAct);

        ArrayList<Integer> actividadesEmpresa = lector.obtenerActividades();
        for (Integer i = 0; i < actividadesEmpresa.size(); i++) {
            System.out.println("Actividad " + (i + 1) + " de la empresa: CUACM " + actividadesEmpresa.get(i));
        }

        String domicilioLegal = lector.obtenerDomicilioLegal();
        System.out.println("Domicilio Legal: " + domicilioLegal);

    } 
}