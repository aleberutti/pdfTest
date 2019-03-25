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
import com.snowtide.pdf.VisualOutputTarget;
import java.text.ParseException;
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
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException, SAXException, ParseException {

        String pdfFilePath = "D:\\Formulario de presentacion v4.7(6)_impreso.pdf";

        StringBuilder text;
        try (Document pdf = PDF.open(pdfFilePath)) {
            XMLOutputTarget xml = new XMLOutputTarget();
            pdf.pipe(xml);
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        //LectorPDFImpreso47 lector = new LectorPDFImpreso47(text);
        LectorPDFImpresoVisual47 lectorVisual = new LectorPDFImpresoVisual47(text);

        /*
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Source input = new DOMSource(xml.getXMLDocument());
        Result output = new StreamResult(new File("output.xml"));
        transformer.transform(input, output);
         */
//        System.out.println(text);
//
//        System.out.println("Version: " + lector.obtenerVersion() + "\r");
//
//        System.out.println("Nombre: " + lector.obtenerNombre());
//
//        System.out.println("CUIT: " + lector.obtenerCuit());
//
//        System.out.println("Fecha Inicio Actividades: " + lector.obtenerFechaInicioAct() + "\r");
//
//        ArrayList<Integer> actividadesEmpresa = lector.obtenerActividades();
//        for (Integer i = 0; i < actividadesEmpresa.size(); i++) {
//            System.out.println("Actividad " + (i + 1) + '/' + actividadesEmpresa.size() + " de la empresa: CUACM " + actividadesEmpresa.get(i));
//        }
//
//        System.out.println("\rDomicilio Legal: " + lector.obtenerDomicilioLegal());
//
//        System.out.println("\rDomicilio Constituido: " + lector.obtenerDomicilioConst() + "\r");
//
//        ArrayList<ArrayList<String>> nomina = lector.obtenerNomina();
//        for (Integer i = 0; i < nomina.size(); i++) {
//            System.out.println("Autoridad Societaria " + (i + 1) + '/' + nomina.size() + ':');
//            System.out.println(nomina.get(i).get(0) + ' '
//                    + nomina.get(i).get(1) + ", "
//                    + nomina.get(i).get(2) + ", "
//                    + nomina.get(i).get(3));
//        }
        
        System.out.println(text);

        System.out.println();

        //System.out.println("Representante Legal: " + lector.obtenerRepLegal());
        
        //System.out.println("Consultor/Experto: " + lector.obtenerConsultor());
        
        //System.out.println("Insumos:\n" + lector.obtenerInsumos());
        
        System.out.println("Insumos:\n" + lectorVisual.obtenerInsumos());

    }
}
