/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import com.dir.inno.normalizacion_pdfs.RByCB_Info.RByCB_Info;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import com.snowtide.PDF;
import com.snowtide.pdf.Document;
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
    @SuppressWarnings("null")
    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException, SAXException, ParseException {

        /*
        RByCB_Info presentacion = new RByCB_Info("presentacion");
        RByCB_Info iac = new RByCB_Info("iac");
        RByCB_Info eia = new RByCB_Info("eia");

        System.out.println(presentacion.printPresentacion());
        System.out.println("----------------------------------------------------------------\n\n");
        System.out.println(iac.printIAC());
        System.out.println("----------------------------------------------------------------\n\n");
        System.out.println(eia.printEIA());
        System.out.println("----------------------------------------------------------------\n\n");
         */
        String filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Presentacion ejemplos\\Formulario de presentación v4.13 Nuevos Senderos_impreso.pdf";

        StringBuilder text;

        try (Document pdf = PDF.open(filePath)) {
            XMLOutputTarget xml = new XMLOutputTarget();
            pdf.pipe(xml);
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        LectorPDFPresent lector = null;
        LectorPDFPresent_47 lectorTemp = new LectorPDFPresent_47(text);

        //MOSTRAR SALIDA
        System.out.println(text);

        switch (lectorTemp.obtenerVersion()) {
            case "4.7":
                lector = new LectorPDFPresent_47(text);
                break;
            case "4.13":
                lector = new LectorPDFPresent_413(text);
                break;
        }
        
        System.out.println("Nombre: " + lector.obtenerNombre());

        System.out.println("CUIT: " + lector.obtenerCuit());

        System.out.println("Fecha Inicio Actividades: " + lector.obtenerFechaInicioAct() + "\r");

        ArrayList<ArrayList<String>> actividadesEmpresa = lector.obtenerActividades();
        for (Integer i = 0; i < actividadesEmpresa.size(); i++) {
            System.out.println("Actividad " + (i + 1) + '/' + actividadesEmpresa.size());
            System.out.println("Actividad " + actividadesEmpresa.get(i).get(0)
                    + ", CUACM " + actividadesEmpresa.get(i).get(1)
                    + ", Estandar amb. " + actividadesEmpresa.get(i).get(2));
        }

        System.out.println("\rDomicilio Legal: " + lector.obtenerDomicilioLegal());

        System.out.println("\rDomicilio Constituido: " + lector.obtenerDomicilioConst() + "\r");

        ArrayList<ArrayList<String>> nomina = lector.obtenerNomina();
        for (Integer i = 0; i < nomina.size(); i++) {
            System.out.println("Autoridad Societaria " + (i + 1) + '/' + nomina.size() + ':');
            System.out.println(nomina.get(i).get(0) + ' '
                    + nomina.get(i).get(1) + ", "
                    + nomina.get(i).get(2) + ", "
                    + nomina.get(i).get(3));
        }

        ArrayList<ArrayList<String>> admins = lector.obtenerAdministradores();
        for (Integer i = 0; i < admins.size(); i++) {
            System.out.println("Administrador " + (i + 1) + '/' + admins.size() + ':');
            System.out.println(admins.get(i).get(0) + ' '
                    + admins.get(i).get(1) + ", "
                    + admins.get(i).get(2) + ", "
                    + admins.get(i).get(3));
        }

        System.out.println("\nRepresentante Legal: " + lector.obtenerRepLegal());

        System.out.println("Consultor/Experto: " + lector.obtenerConsultor());

        System.out.println("\nDomicilio Real: " + lector.obtenerDomicilioReal());

        System.out.println("\nNombre archivo foto satelital: " + lector.obtenerNombreArchivoFotoSat());

        ArrayList<ArrayList<String>> partidas = lector.obtenerPartidasInm();
        for (Integer i = 0; i < partidas.size(); i++) {
            System.out.println("Partida inmobiliaria " + (i + 1) + '/'
                    + partidas.size() + ": " + partidas.get(i).get(0));
            System.out.println("Lat: " + partidas.get(i).get(1)
                    + ", Long: " + partidas.get(i).get(2));
        }

        System.out.println("\nDatos para la categorización ambiental: ");
        System.out.println(lector.obtenerDatosPlantaCatAmb());

        System.out.println("\nPlantas fuera de la provincia: ");
        ArrayList<ArrayList<String>> plantasFuera = lector.obtenerPlantasFueraProv();
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

        System.out.println("\n\nProductos: ");
        ArrayList<ArrayList<String>> productos = lector.obtenerProductos();
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

        System.out.println("\n\nSubproductos: ");
        ArrayList<ArrayList<String>> subproductos = lector.obtenerSubproductos();
        if (subproductos.isEmpty()) {
            System.out.print("No posee.");
        } else {
            for (Integer i = 0; i < subproductos.size(); i++) {
                System.out.println("Producto " + (i + 1) + '/'
                        + subproductos.size() + ":\n"
                        + subproductos.get(i).get(0) + ", "
                        + subproductos.get(i).get(1) + ", "
                        + subproductos.get(i).get(2) + ", "
                        + subproductos.get(i).get(3) + ", "
                        + subproductos.get(i).get(4));
            }
        }

        System.out.println("\nMaterias Primas: ");
        ArrayList<ArrayList<String>> materias = lector.obtenerMateriasPrimas();
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
