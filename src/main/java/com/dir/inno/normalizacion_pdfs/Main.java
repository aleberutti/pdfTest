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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException, SAXException, ParseException {

        String pdfFilePath = "E:\\Users\\MODERNIZACION05\\Desktop\\tempFormularios\\pdfTest\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7 muy lleno_impreso.pdf";

        Document pdf = PDF.open(pdfFilePath);
        XMLOutputTarget xml = new XMLOutputTarget();
        pdf.pipe(xml);
        StringBuilder text = new StringBuilder();
        pdf.pipe(new OutputTarget(text));
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

        Double cuit = obtenerCuit(text);
        System.out.println("CUIT: " + cuit);

        Date fechaInicioAct = obtenerFechaInicioAct(text);
        System.out.println("Fecha Inicio Actividades: " + fechaInicioAct);

        ArrayList<Integer> actividadesEmpresa = obtenerActividades(text);
        for (Integer i = 0; i < actividadesEmpresa.size(); i++) {
            System.out.println("Actividad " + (i + 1) + " de la empresa: CUACM " + actividadesEmpresa.get(i));
        }

        String domicilioLegal = obtenerDomicilioLegal(text);
        System.out.println("Domicilio Legal: " + domicilioLegal);

    }

    private static String obtenerVersion(StringBuilder text) {
        String sub = "VERSIÓN";
        Integer index = text.indexOf(sub) + sub.length();
        while (text.charAt(index) == ' ') {
            index++;
        }
        String version = text.substring(index, index + 3);
        return version;
    }

    private static String obtenerNombre(StringBuilder text) {
        String sub = "NOMBRE COMPLETO / RAZÓN SOCIAL (*)";
        Integer index = text.indexOf(sub) + sub.length();
        index = skipBlank(index, text);
        String nombre = new String();
        while ((text.charAt(index) != ' ' && text.charAt(index) != '\r')
                || ((text.charAt(index) == ' ')
                && (text.charAt(index + 1) != ' ' || text.charAt(index + 1) != '\r'))) {
            nombre += text.charAt(index);
            index++;
        }
        return nombre;
    }

    private static Double obtenerCuit(StringBuilder text) {
        String sub = "ACTIVIDADES DE LA EMPRESA: (*)";
        Integer index = text.indexOf(sub) + sub.length();
        index = skipBlank(index, text);
        String cuit = text.substring(index, index + 2);
        index++;
        index += 2;
        while ((text.charAt(index + 1) != ' ' && text.charAt(index + 1) != '\r')
                || ((text.charAt(index + 1) == ' ')
                && (text.charAt(index + 2) != ' ' || text.charAt(index + 2) != '\r'))) {
            cuit += text.charAt(index + 1);
            index++;
        }
        index += 2;
        cuit += text.charAt(index + 1);
        Double cuitN = Double.parseDouble(cuit);
        return cuitN;
    }

    private static Date obtenerFechaInicioAct(StringBuilder text) throws ParseException {
        String sub = "ACTIVIDADES DE LA EMPRESA: (*)";
        Integer index = text.indexOf(sub) + sub.length();
        index = skipBlank(index, text);
        /*
        index+=3;
        while ((text.charAt(index+1) != ' ' && text.charAt(index+1) != '\r') ||
                ((text.charAt(index+1) == ' ') && 
                (text.charAt(index+2) != ' ' || text.charAt(index+2) != '\r')
                )
                ){
            index++;
        }
        index+=3;
         */
        index += 17;
        String dateString = new String();
        while (text.charAt(index) != '\r') {
            dateString += text.charAt(index);
            index++;
        }
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        return date;
    }

    private static ArrayList<Integer> obtenerActividades(StringBuilder text) {
        String sub = "CUACM";
        Integer index = text.indexOf(sub) + sub.length();
        ArrayList<Integer> actividadesEmpresa = new ArrayList<>();
        while (index != -1 && index < 9000) {
            while (text.charAt(index) == ' ') {
                index++;
            }
            String codigoString = new String();
            while (text.charAt(index) != ' ' && text.charAt(index) != '\r') {
                codigoString += text.charAt(index);
                index++;
            }
            Integer codigo = Integer.parseInt(codigoString);
            if (!actividadesEmpresa.contains(codigo)) {
                actividadesEmpresa.add(codigo);
            }
            index = text.indexOf(sub, index) + sub.length();
        }
        return actividadesEmpresa;
    }

    private static String obtenerDomicilioLegal(StringBuilder text) {
        String sub = "DEPTO";
        Integer index = text.indexOf(sub) + sub.length();
        index = skipBlank(index, text);
        String domicilio = new String();
        while ((text.charAt(index) != ' ' && text.charAt(index) != '\r')
                || ((text.charAt(index) == ' ')
                && (text.charAt(index + 1) != ' ' || text.charAt(index + 1) != '\r'))) {
            domicilio += text.charAt(index);
            index++;
        }
        index = skipBlank(index, text);
        domicilio += ", ";
        while ((text.charAt(index) != ' ' && text.charAt(index) != '\r')
                || ((text.charAt(index) == ' ')
                && (text.charAt(index + 1) != ' ' || text.charAt(index + 1) != '\r'))) {
            domicilio += text.charAt(index);
            index++;
        }
        index = skipBlank(index, text);
        domicilio += ", ";
        while ((text.charAt(index) != ' ' && text.charAt(index) != '\r')
                || ((text.charAt(index) == ' ')
                && (text.charAt(index + 1) != ' ' || text.charAt(index + 1) != '\r'))) {
            domicilio += text.charAt(index);
            index++;
        }
        index = skipBlank(index, text);
        domicilio += ", ";
        while ((text.charAt(index) != ' ' && text.charAt(index) != '\r')
                || ((text.charAt(index) == ' ')
                && (text.charAt(index + 1) != ' ' || text.charAt(index + 1) != '\r'))) {
            domicilio += text.charAt(index);
            index++;
        }
        return domicilio;
    }

    private static Integer skipBlank(Integer index, StringBuilder text) {
        while (text.charAt(index) == ' ' || text.charAt(index) == '\r') {
            index += 2;
        }
        return index;
    }
}
