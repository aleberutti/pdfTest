/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import com.dir.inno.normalizacion_pdfs.RByCB_Info.RByCB_Info;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import com.snowtide.PDF;
import com.snowtide.pdf.Document;
import com.snowtide.pdf.VisualOutputTarget;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
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
        
//        RByCB_Info presentacion = new RByCB_Info("presentacion");
//        RByCB_Info iac = new RByCB_Info("iac");
//        RByCB_Info eia = new RByCB_Info("eia");
        
//        System.out.println(presentacion.printPresentacion());
//        System.out.println("----------------------------------------------------------------\n\n");
//        System.out.println(iac.printIAC());
//        System.out.println("----------------------------------------------------------------\n\n");
//        System.out.println(eia.printEIA());
//        System.out.println("----------------------------------------------------------------\n\n");
        //v4.7(2)_impreso

        String filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(6)_impreso.pdf";

        StringBuilder text;

        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        LectorPDFImpreso47 lector = new LectorPDFImpreso47(text);
        
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        LectorPDFImpreso47V lectorV = new LectorPDFImpreso47V(text);
        
        //MOSTRAR SALIDA
        //System.out.println(text);

        /*String version = lector.obtenerVersion();
        System.out.println("Version: " + version);
        System.out.println("\n");*/
        
        /*ArrayList<ArrayList<String>> listaInsumos = lectorV.obtenerInsumos();
        System.out.println("Lista de Insumos" + "\n" + "==========");
        for (Integer i = 0; i < listaInsumos.size(); i++) {
            System.out.println("Insumos " + (i + 1) + '/' + listaInsumos.size() + ':');
            System.out.println(
                    listaInsumos.get(i).get(0) + ", "
                    + listaInsumos.get(i).get(1) + ", "
                    + listaInsumos.get(i).get(2) + ", "
                    + listaInsumos.get(i).get(3) + ", "
                    + listaInsumos.get(i).get(4) + "; ");     
        }
        System.out.println("\n");*/
        
        /*ArrayList<ArrayList<String>> sustanciasAuxiliares = lectorV.obtenerSustAuxiliares();
        System.out.println("Lista de Sustancias Auxiliares" + "\n" + "==========");
        for (Integer i = 0; i < sustanciasAuxiliares.size(); i++) {
            System.out.println("Sustancia Auxiliar " + (i + 1) + '/' + sustanciasAuxiliares.size() + ':');
            System.out.println(
                    sustanciasAuxiliares.get(i).get(0) + ", "
                    + sustanciasAuxiliares.get(i).get(1) + ", "
                    + sustanciasAuxiliares.get(i).get(2) + ", "
                    + sustanciasAuxiliares.get(i).get(3) + "; "); 
        }
        System.out.println("\rDomicilio Legal: " + lectorV.obtenerDomicilioLegal());*/

        /*System.out.println("\rDomicilio Constituido: " + lectorV.obtenerDomicilioConst() + "\r");*/

        /*ArrayList<ArrayList<String>> nomina = lectorV.obtenerNomina();
        for (int i = 0; i < nomina.size(); i++) {
            System.out.println("Autoridad Societaria " + (i + 1) + '/' + nomina.size() + ':');
            System.out.println(nomina.get(i).get(0) + ' '
                    + nomina.get(i).get(1) + ", "
                    + nomina.get(i).get(2) + ", "
                    + nomina.get(i).get(3));
        }
        System.out.println("\n");*/
        
        /*ArrayList<String> archivosImagenes = lectorV.obtenerArchivosLayOut();
        System.out.println("Nombre de los archivos del Lay-Out" + "\n" + "==========");
        for(int i = 0; i < archivosImagenes.size(); i++){
            System.out.println("Nombre del archivo " + (i + 1) + '/' + archivosImagenes.size() + ':');
            System.out.println(archivosImagenes.get(i));
        }
        System.out.println("\n");*/
        
        /*ArrayList<String> datosDomReal = lectorV.obtenerDomRealPlanta();
        System.out.println("Domicilio real de la planta." + "\n" + "==========");
        for(int i = 0; i < datosDomReal.size(); i++){
            //System.out.println("Nombre del archivo " + (i + 1) + '/' + archivosImagenes.size() + ':');
            switch (i){
                case 0:
                    System.out.println("Calle: " + datosDomReal.get(i));
                    break;
                case 1:
                    System.out.println("Numero de Calle: " + datosDomReal.get(i));
                    break;
                case 2:
                    System.out.println("Piso: " + datosDomReal.get(i));
                    break;
                case 3:
                    System.out.println("NºDpto: " + datosDomReal.get(i));
                    break;
                case 4:
                    System.out.println("Provincia: " + datosDomReal.get(i));
                    break;
                case 5:
                    System.out.println("Departamento: " + datosDomReal.get(i));
                    break;
                case 6:
                    System.out.println("Localidad: " + datosDomReal.get(i));
                    break;
                case 7:
                    System.out.println("Código postal: " + datosDomReal.get(i));
                    break;
                case 8:
                    System.out.println("Zonificación: " + datosDomReal.get(i));
                    break;
                case 9:
                    System.out.println("Nombre del Archivo: " + datosDomReal.get(i));
                    break;
                default:
                    break;
            }
        }
        System.out.println("\n");*/
        
        /*ArrayList<ArrayList<String>> inmueblesAnexos = lectorV.obtenerInmueblesAnexos();
        System.out.println("Lista de inmuebles anexos" + "\n" + "==========");
        for (int i = 0; i < inmueblesAnexos.size(); i++) {
            System.out.println("Inmueble " + (i + 1) + '/' + inmueblesAnexos.size() + ':');
            System.out.println(
                    inmueblesAnexos.get(i).get(0) + ", "
                    + inmueblesAnexos.get(i).get(1) + "; "
                    ); 
        }
        System.out.println("\n");*/
        
        /*ArrayList<String> dimensiones = lectorV.obtenerDimensionamiento();
        System.out.println("Dimensionamiento de la planta." + "\n" + "==========");
        for(int i = 0; i < dimensiones.size(); i++){
            switch (i){
                case 0:
                    System.out.println("Superficie total del predio: " + dimensiones.get(i));
                    break;
                case 1:
                    System.out.println("Superficie cubierta: " + dimensiones.get(i));
                    break;
                case 2:
                    System.out.println("Potencia instalada: " + dimensiones.get(i));
                    break;
                case 3:
                    System.out.println("Dotación de personal: " + dimensiones.get(i));
                    break;
            }
            
        }
        System.out.println("\n");*/
        
        /*ArrayList<ArrayList<String>> formacionPersonal = lectorV.obtenerFormacionDePersonal();
        System.out.println("Formacion de personal." + "\n" + "==========");
        for (int i = 0; i < formacionPersonal.size(); i++) {
            System.out.println("Personal " + (i + 1) + '/' + formacionPersonal.size() + ':');
            System.out.println(
                    formacionPersonal.get(i).get(0) + ", "
                    + formacionPersonal.get(i).get(1) + "; "
                    ); 
        }
        System.out.println("\n");*/
        
        /*ArrayList<ArrayList<String>> emisionGaseosaNatural = lectorV.obtenerEmisionGaseosaNatural();
        System.out.println("Emisiones Gaseosas de Componentes Naturales" + "\n" + "==========");
        for(int i = 0; i < emisionGaseosaNatural.size(); i++){
            System.out.println("Emisiones Gaseosas de Componentes Naturales" +" "+(i + 1) + '/' + emisionGaseosaNatural.size() + ':');
            System.out.println(
                emisionGaseosaNatural.get(i).get(0) + ","
                + emisionGaseosaNatural.get(i).get(1) + ","
                + emisionGaseosaNatural.get(i).get(2) + ";"
            );
        }
        System.out.println("\n");*/
        
        /*ArrayList<ArrayList<String>> emisionGasCombustion = lectorV.obtenerEmisionGasCombustion();
        System.out.println("Emisiones Gaseosas de Combustibles" + "\n" + "==========");
        for(int i = 0; i < emisionGasCombustion.size(); i++){
            System.out.println("Emisiones Gaseosas de Combustibles" +" "+(i + 1) + '/' + emisionGasCombustion.size() + ':');
            System.out.println(
                emisionGasCombustion.get(i).get(0) + ","
                + emisionGasCombustion.get(i).get(1) + ","
                + emisionGasCombustion.get(i).get(2) + ";"
            );
        }
        System.out.println("\n");*/
        
        /*ArrayList<ArrayList<String>> emisionGasNoContemplado = lectorV.obtenerEmisionGasNoContemplado();
        System.out.println("Emisiones de gases no contemplados en el formulario: " + "\n" + "==========");
        for(int i = 0; i < emisionGasNoContemplado.size(); i++){
            System.out.println("Emisiones de gases no contemplados en el formulario: " +" "+(i + 1) + '/' + emisionGasNoContemplado.size() + ':');
            System.out.println(
                emisionGasNoContemplado.get(i).get(0) + ","
                + emisionGasNoContemplado.get(i).get(1) + ","
                + emisionGasNoContemplado.get(i).get(2) + ";"
            );
        }
        System.out.println("\n");*/
        
        

//        ArrayList<ArrayList<String>> admins = lectorV.obtenerAdministradores();
//        for (int i = 0; i < admins.size(); i++) {
//            System.out.println("Administrador " + (i + 1) + '/' + admins.size() + ':');
//            System.out.println(admins.get(i).get(0) + ' '
//                    + admins.get(i).get(1) + ", "
//                    + admins.get(i).get(2) + ", "
//                    + admins.get(i).get(3));
//        }
//
//        System.out.println("\nRepresentante Legal: " + lector.obtenerRepLegal());
//
//        System.out.println("Consultor/Experto: " + lector.obtenerConsultor());
//
//        System.out.println("\nDomicilio Real: " + lectorV.obtenerDomicilioReal());
//
//        System.out.println("\nNombre archivo foto satelital: " + lector.obtenerNombreArchivoFotoSat());
//
//        ArrayList<ArrayList<String>> partidas = lectorV.obtenerPartidasInm();
//        for (int i = 0; i < partidas.size(); i++) {
//            System.out.println("Partida inmobiliaria " + (i + 1) + '/'
//                    + partidas.size() + ": " + partidas.get(i).get(0));
//            System.out.println("Lat: " + partidas.get(i).get(1)
//                    + ", Long: " + partidas.get(i).get(2));
//        }
//
//        System.out.println("\nDatos para la categorización ambiental: ");
//        System.out.println(lectorV.obtenerDatosPlantaCatAmb());
//
//        System.out.println("\nPlantas fuera de la provincia: ");
//        ArrayList<ArrayList<String>> plantasFuera = lectorV.obtenerPlantasFueraProv();
//        if (plantasFuera.isEmpty()) {
//            System.out.print("No posee.");
//        } else {
//            for (int i = 0; i < plantasFuera.size(); i++) {
//                System.out.println("Planta " + (i + 1) + '/'
//                        + plantasFuera.size() + ":\n"
//                        + plantasFuera.get(i).get(0) + ", "
//                        + plantasFuera.get(i).get(1) + ", "
//                        + plantasFuera.get(i).get(2) + ", "
//                        + plantasFuera.get(i).get(3));
//            }
//        }
//        
//        System.out.println("\nProductos: ");
//         ArrayList<ArrayList<String>> productos = lectorV.obtenerProductos();
//         if (productos.isEmpty()) {
//            System.out.print("No posee.");
//        } else {
//            for (int i = 0; i < productos.size(); i++) {
//                System.out.println("Producto " + (i + 1) + '/'
//                        + productos.size() + ":\n"
//                        + productos.get(i).get(0) + ", "
//                        + productos.get(i).get(1) + ", "
//                        + productos.get(i).get(2) + ", "
//                        + productos.get(i).get(3) + ", "
//                        + productos.get(i).get(4));
//            }
//         }
//         
//        System.out.println("\nMaterias Primas: ");
//        ArrayList<ArrayList<String>> materias = lectorV.obtenerMateriasPrimas();
//        if (materias.isEmpty()) {
//            System.out.print("No posee.");
//        } else {
//            for (int i = 0; i < materias.size(); i++) {
//                System.out.println("Materia Prima " + (i + 1) + '/'
//                        + materias.size() + ":\n"
//                        + materias.get(i).get(0) + ", "
//                        + materias.get(i).get(1) + ", "
//                        + materias.get(i).get(2) + ", "
//                        + materias.get(i).get(3) + ", "
//                        + materias.get(i).get(4));
//            }
//         }
        
        /*ArrayList<ArrayList<String>> efluentesNoPeligrosos = lectorV.obtenerEfluenteNoPeligroso();
        System.out.println("obtenerEfluenteNoPeligroso \n");
        for(int i = 0; i < efluentesNoPeligrosos.size(); i++){
            System.out.println("Efluente " + (i + 1) + '/' + efluentesNoPeligrosos.size() + ':'
                + efluentesNoPeligrosos.get(i).get(0) + ", "
                + efluentesNoPeligrosos.get(i).get(1) + ", "
                + efluentesNoPeligrosos.get(i).get(2) + ", "
                + efluentesNoPeligrosos.get(i).get(3) + ", "
                + efluentesNoPeligrosos.get(i).get(4) + ", "
                + efluentesNoPeligrosos.get(i).get(5));
        }*/
        
        ArrayList<ArrayList<String>> residuosLiquidosPeligrosos = lectorV.obtenerResiduosLiquidosPeligrosos();
        System.out.println("obtenerResiduosLiquidosPeligrosos \n");
        for(int i = 0; i < residuosLiquidosPeligrosos.size(); i++){
            System.out.println("Efluente " + (i + 1) + '/' + residuosLiquidosPeligrosos.size() + ':'
                + residuosLiquidosPeligrosos.get(i).get(0) + ", "
                + residuosLiquidosPeligrosos.get(i).get(1) + ", "
                + residuosLiquidosPeligrosos.get(i).get(2) + ", "
                + residuosLiquidosPeligrosos.get(i).get(3) + ", "
                + residuosLiquidosPeligrosos.get(i).get(4) + ", "
                + residuosLiquidosPeligrosos.get(i).get(5));
        }

        
        
        
    }
         
    
}

