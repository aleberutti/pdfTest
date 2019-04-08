/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import com.dir.inno.normalizacion_pdfs.RByCB_Info.Form_Presentacion;
import com.dir.inno.normalizacion_pdfs.RByCB_Info.RByCB_Info;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.xml.sax.SAXException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDNonTerminalField;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import com.snowtide.PDF;
import com.snowtide.pdf.Document;
import com.snowtide.pdf.OutputTarget;
import com.snowtide.pdf.VisualOutputTarget;
import java.io.File;
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
        
        RByCB_Info presentacion = new RByCB_Info("presentacion");
        RByCB_Info iac = new RByCB_Info("iac");
        RByCB_Info eia = new RByCB_Info("eia");
        
        System.out.println(presentacion.printPresentacion());
        System.out.println("----------------------------------------------------------------\n\n");
        System.out.println(iac.printIAC());
        System.out.println("----------------------------------------------------------------\n\n");
        System.out.println(eia.printEIA());
        System.out.println("----------------------------------------------------------------\n\n");

        String filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(1)_impreso.pdf";

        StringBuilder text;

        try (Document pdf = PDF.open(filePath)) {
            XMLOutputTarget xml = new XMLOutputTarget();
            pdf.pipe(xml);
            text = new StringBuilder();
            pdf.pipe(new OutputTarget(text));
        }
        LectorPDFImpreso47 lector = new LectorPDFImpreso47(text);
        
        try (Document pdf = PDF.open(filePath)) {
            XMLOutputTarget xml = new XMLOutputTarget();
            pdf.pipe(xml);
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        LectorPDFImpreso47V lectorV = new LectorPDFImpreso47V(text);
        
        //MOSTRAR SALIDA
        System.out.println(text);

        System.out.println("Version: " + lector.obtenerVersion() + "\r");

        System.out.println("Nombre: " + lector.obtenerNombre());

        System.out.println("CUIT: " + lector.obtenerCuit());

        System.out.println("Fecha Inicio Actividades: " + lector.obtenerFechaInicioAct() + "\r");

        ArrayList<Integer> actividadesEmpresa = lector.obtenerActividades();
        for (Integer i = 0; i < actividadesEmpresa.size(); i++) {
            System.out.println("Actividad " + (i + 1) + '/' + actividadesEmpresa.size() + " de la empresa: CUACM " + actividadesEmpresa.get(i));
        }

        System.out.println("\rDomicilio Legal: " + lectorV.obtenerDomicilioLegal());

        System.out.println("\rDomicilio Constituido: " + lectorV.obtenerDomicilioConst() + "\r");

        ArrayList<ArrayList<String>> nomina = lectorV.obtenerNomina();
        for (Integer i = 0; i < nomina.size(); i++) {
            System.out.println("Autoridad Societaria " + (i + 1) + '/' + nomina.size() + ':');
            System.out.println(nomina.get(i).get(0) + ' '
                    + nomina.get(i).get(1) + ", "
                    + nomina.get(i).get(2) + ", "
                    + nomina.get(i).get(3));
        }

        ArrayList<ArrayList<String>> admins = lectorV.obtenerAdministradores();
        for (Integer i = 0; i < admins.size(); i++) {
            System.out.println("Administrador " + (i + 1) + '/' + admins.size() + ':');
            System.out.println(admins.get(i).get(0) + ' '
                    + admins.get(i).get(1) + ", "
                    + admins.get(i).get(2) + ", "
                    + admins.get(i).get(3));
        }

        System.out.println("\nRepresentante Legal: " + lector.obtenerRepLegal());

        System.out.println("Consultor/Experto: " + lector.obtenerConsultor());

        System.out.println("\nDomicilio Real: " + lectorV.obtenerDomicilioReal());

        System.out.println("\nNombre archivo foto satelital: " + lector.obtenerNombreArchivoFotoSat());

        ArrayList<ArrayList<String>> partidas = lectorV.obtenerPartidasInm();
        for (Integer i = 0; i < partidas.size(); i++) {
            System.out.println("Partida inmobiliaria " + (i + 1) + '/'
                    + partidas.size() + ": " + partidas.get(i).get(0));
            System.out.println("Lat: " + partidas.get(i).get(1)
                    + ", Long: " + partidas.get(i).get(2));
        }

        System.out.println("\nDatos para la categorización ambiental: ");
        System.out.println(lectorV.obtenerDatosPlantaCatAmb());

        System.out.println("\nPlantas fuera de la provincia: ");
        ArrayList<ArrayList<String>> plantasFuera = lectorV.obtenerPlantasFueraProv();
        if (plantasFuera.isEmpty()) {
            System.out.print("No posee.");
        } else {
            for (Integer i = 0; i < plantasFuera.size(); i++) {
                System.out.println("Planta " + (i + 1) + '/'
                        + plantasFuera.size() + ":\n"
                        + plantasFuera.get(i).get(0) + ", "
                        + plantasFuera.get(i).get(1) + ", "
                        + plantasFuera.get(i).get(2) + ", "
                        + plantasFuera.get(i).get(3));
            }
        }
        
        System.out.println("\nProductos: ");
         ArrayList<ArrayList<String>> productos = lectorV.obtenerProductos();
         if (productos.isEmpty()) {
            System.out.print("No posee.");
        } else {
            for (Integer i = 0; i < productos.size(); i++) {
                System.out.println("Producto " + (i + 1) + '/'
                        + productos.size() + ":\n"
                        + productos.get(i).get(0) + ", "
                        + productos.get(i).get(1) + ", "
                        + productos.get(i).get(2) + ", "
                        + productos.get(i).get(3) + ", "
                        + productos.get(i).get(4));
            }
         }
         
         System.out.println("\nMaterias Primas: ");
         ArrayList<ArrayList<String>> materias = lectorV.obtenerMateriasPrimas();
         if (materias.isEmpty()) {
            System.out.print("No posee.");
        } else {
            for (Integer i = 0; i < materias.size(); i++) {
                System.out.println("Materia Prima " + (i + 1) + '/'
                        + materias.size() + ":\n"
                        + materias.get(i).get(0) + ", "
                        + materias.get(i).get(1) + ", "
                        + materias.get(i).get(2) + ", "
                        + materias.get(i).get(3) + ", "
                        + materias.get(i).get(4));
            }
         }
    }
}
