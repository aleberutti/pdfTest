/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import com.snowtide.PDF;
import com.snowtide.pdf.Document;
import com.snowtide.pdf.OutputTarget;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MODERNIZACION05
 */
public class LectorPDFImpreso47Test {

    LectorPDFImpreso47 instance1;
    LectorPDFImpreso47 instance2;
    LectorPDFImpreso47 instance3;
    LectorPDFImpreso47 instance4;
    LectorPDFImpreso47 instance5;
    LectorPDFImpreso47 instance6;
    
    LectorPDFImpresoVisual47 instanceVisual1;
    LectorPDFImpresoVisual47 instanceVisual2;
    LectorPDFImpresoVisual47 instanceVisual3;
    LectorPDFImpresoVisual47 instanceVisual4;
    LectorPDFImpresoVisual47 instanceVisual5;
    LectorPDFImpresoVisual47 instanceVisual6;
    
    public LectorPDFImpreso47Test() {
    }

    @BeforeAll
    public static void setUpClass() throws IOException {
    }

    @BeforeEach
    public void setUp() throws IOException {
        
        String filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(1)_impreso.pdf";
        StringBuilder text;
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new OutputTarget(text));
        }
        instance1 = new LectorPDFImpreso47(text);

        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(2)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new OutputTarget(text));
        }
        instance2 = new LectorPDFImpreso47(text);

        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(3)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new OutputTarget(text));
        }
        instance3 = new LectorPDFImpreso47(text);
        
        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(4)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new OutputTarget(text));
        }
        instance4 = new LectorPDFImpreso47(text);
        
        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(5)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new OutputTarget(text));
        }
        instance5 = new LectorPDFImpreso47(text);
        
        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(6)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new OutputTarget(text));
        }
        instance6 = new LectorPDFImpreso47(text);
        
        pdfFilePath = "D:\\Formulario de presentacion v4.7(4)_impreso.pdf";
        try (Document pdf = PDF.open(pdfFilePath)) {
            text = new StringBuilder();
            pdf.pipe(new OutputTarget(text));
        }
        instance4 = new LectorPDFImpreso47(text);
        
        pdfFilePath = "D:\\Formulario de presentacion v4.7(5)_impreso.pdf";
        try (Document pdf = PDF.open(pdfFilePath)) {
            text = new StringBuilder();
            pdf.pipe(new OutputTarget(text));
        }
        instance5 = new LectorPDFImpreso47(text);
        
        pdfFilePath = "D:\\Formulario de presentacion v4.7(6)_impreso.pdf";
        try (Document pdf = PDF.open(pdfFilePath)) {
            text = new StringBuilder();
            pdf.pipe(new OutputTarget(text));
        }
        instance6 = new LectorPDFImpreso47(text);
        
        /*
        * Usando VisualOutputTarget para la salida.
        */
        pdfFilePath = "D:\\Formulario de presentacion v4.7(1)_impreso.pdf";
        StringBuilder textVisual;
        try (Document pdf = PDF.open(pdfFilePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instanceVisual1 = new LectorPDFImpresoVisual47(text);

        pdfFilePath = "D:\\Formulario de presentacion v4.7(2)_impreso.pdf";
        try (Document pdf = PDF.open(pdfFilePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instanceVisual2 = new LectorPDFImpresoVisual47(text);

        pdfFilePath = "D:\\Formulario de presentacion v4.7(3)_impreso.pdf";
        try (Document pdf = PDF.open(pdfFilePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instanceVisual3 = new LectorPDFImpresoVisual47(text);
        
        pdfFilePath = "D:\\Formulario de presentacion v4.7(4)_impreso.pdf";
        try (Document pdf = PDF.open(pdfFilePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instanceVisual4 = new LectorPDFImpresoVisual47(text);
        
        pdfFilePath = "D:\\Formulario de presentacion v4.7(5)_impreso.pdf";
        try (Document pdf = PDF.open(pdfFilePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instanceVisual5 = new LectorPDFImpresoVisual47(text);
        
        pdfFilePath = "D:\\Formulario de presentacion v4.7(6)_impreso.pdf";
        try (Document pdf = PDF.open(pdfFilePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instanceVisual6 = new LectorPDFImpresoVisual47(text);
    }

    /**
     * Test of obtenerVersion method, of class LectorPDFImpreso47.
     */
    @Test
    public void testObtenerVersion() {
        System.out.println("obtenerVersion");

        String expResult = "4.7";
        String result = instance1.obtenerVersion();
        assertEquals(expResult, result);

        expResult = "4.7";
        result = instance2.obtenerVersion();
        assertEquals(expResult, result);

        expResult = "4.7";
        result = instance3.obtenerVersion();
        assertEquals(expResult, result);
        
        expResult = "4.7";
        result = instance4.obtenerVersion();
        assertEquals(expResult, result);
        
        expResult = "4.7";
        result = instance5.obtenerVersion();
        assertEquals(expResult, result);
        
        expResult = "4.7";
        result = instance6.obtenerVersion();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerNombre method, of class LectorPDFImpreso47.
     */
    @Test
    public void testObtenerNombre() {
        System.out.println("obtenerNombre");

        String expResult = "NombreCompleto/RazonSocial";
        String result = instance1.obtenerNombre();
        assertEquals(expResult, result);

        expResult = "Empresa Ficticia";
        result = instance2.obtenerNombre();
        assertEquals(expResult, result);

        expResult = "COCACOLA";
        result = instance3.obtenerNombre();
        assertEquals(expResult, result);
        
        expResult = "Empresa Ficticia";
        result = instance4.obtenerNombre();
        assertEquals(expResult, result);
        
        expResult = "Fact Society";
        result = instance5.obtenerNombre();
        assertEquals(expResult, result);
        
        expResult = "NombreCompleto/RazonSocial";
        result = instance6.obtenerNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerCuit method, of class LectorPDFImpreso47.
     */
    @Ignore
    public void testObtenerCuit() {
        System.out.println("obtenerCuit");

        Long expResult = 30303132333L;
        Long result = instance1.obtenerCuit();
        assertEquals(expResult, result);

        expResult = 20380539684L;
        result = instance2.obtenerCuit();
        assertEquals(expResult, result);

        expResult = 20380539684L;
        result = instance3.obtenerCuit();
        assertEquals(expResult, result);
        
        expResult = 20380539684L;
        result = instance4.obtenerCuit();
        assertEquals(expResult, result);
        
        expResult = 3546825542L;
        result = instance5.obtenerCuit();
        assertEquals(expResult, result);
        
        expResult = 30303132333L;
        result = instance6.obtenerCuit();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerFechaInicioAct method, of class LectorPDFImpreso47.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testObtenerFechaInicioAct() throws Exception {
        System.out.println("obtenerFechaInicioAct");

        Date expResult = new SimpleDateFormat("dd/MM/yyyy").parse("08/03/2019");
        Date result = instance1.obtenerFechaInicioAct();
        assertEquals(expResult, result);

        expResult = new SimpleDateFormat("dd/MM/yyyy").parse("26/03/2019");
        result = instance2.obtenerFechaInicioAct();
        assertEquals(expResult, result);

        expResult = new SimpleDateFormat("dd/MM/yyyy").parse("04/03/2019");
        result = instance3.obtenerFechaInicioAct();
        assertEquals(expResult, result);
        
        expResult = new SimpleDateFormat("dd/MM/yyyy").parse("26/03/2019");
        result = instance4.obtenerFechaInicioAct();
        assertEquals(expResult, result);
        
        expResult = new SimpleDateFormat("dd/MM/yyyy").parse("06/03/2019");
        result = instance5.obtenerFechaInicioAct();
        assertEquals(expResult, result);
        
        expResult = new SimpleDateFormat("dd/MM/yyyy").parse("08/03/2019");
        result = instance6.obtenerFechaInicioAct();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerActividades method, of class LectorPDFImpreso47.
     */
    @Ignore
    public void testObtenerActividades() {
        System.out.println("obtenerActividades");

        ArrayList<Integer> expResult = new ArrayList<>();
        expResult.add(155120);
        ArrayList<Integer> result = instance1.obtenerActividades();
        assertEquals(expResult, result);

        expResult = new ArrayList<>();
        expResult.add(181130);
        expResult.add(112003);
        expResult.add(181120);
        result = instance2.obtenerActividades();
        assertEquals(expResult, result);

        expResult = new ArrayList<>();
        expResult.add(112004);
        result = instance3.obtenerActividades();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(181130);
        expResult.add(112003);
        expResult.add(181120);
        result = instance4.obtenerActividades();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(181130);
        expResult.add(402001);
        result = instance5.obtenerActividades();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(155120);
        expResult.add(12230);
        expResult.add(552112);
        result = instance6.obtenerActividades();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of obtenerRepLegal method, of class LectorPDFImpreso47.
     */
    @Test
    public void testObtenerRepLegal() {
        System.out.println("obtenerRepLegal");

        String expResult = "Apellidorepresentantlegal Nombrerepresentantelegal, 12345678";
        String result = instance1.obtenerRepLegal();
        assertEquals(expResult, result);

        expResult = "Apellidorepleguno Nombrerepleguno, 76545678";
        result = instance2.obtenerRepLegal();
        assertEquals(expResult, result);

        expResult = "Dassda Adssadsa, 12321";
        result = instance3.obtenerRepLegal();
        assertEquals(expResult, result);
        
        expResult = "Apellidorepleguno Nombrerepleguno, 76545678";
        result = instance4.obtenerRepLegal();
        assertEquals(expResult, result);
        
        expResult = "Lega Licenla, 420420";
        result = instance5.obtenerRepLegal();
        assertEquals(expResult, result);
        
        expResult = "Apellidorepresentantlegal Nombrerepresentantelegal, 12345678";
        result = instance6.obtenerRepLegal();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerConsultor method, of class LectorPDFImpreso47.
     */
    @Test
    public void testObtenerConsultor() {
        System.out.println("obtenerConsultor");

        String expResult = "Abbate, Alejandro Agustín, Licenciado en Saneamiento Ambiental, 0391";
        String result = instance1.obtenerConsultor();
        assertEquals(expResult, result);

        expResult = "Acosta, Natalia Carolina, Licenciada en Geoecología y  Medio Ambiente, 0232";
        result = instance2.obtenerConsultor();
        assertEquals(expResult, result);

        expResult = "Acosta, Guillermo Oscar Ariel, Ingeniero Industrial, 0367";
        result = instance3.obtenerConsultor();
        assertEquals(expResult, result);
        
        expResult = "Acosta, Natalia Carolina, Licenciada en Geoecología y  Medio Ambiente, 0232";
        result = instance4.obtenerConsultor();
        assertEquals(expResult, result);
        
        expResult = "Agretti, Saúl Emanuel, Ingeniero Agrónomo, 0115";
        result = instance5.obtenerConsultor();
        assertEquals(expResult, result);
        
        expResult = "Abbate, Alejandro Agustín, Licenciado en Saneamiento Ambiental, 0391";
        result = instance6.obtenerConsultor();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerNombreArchivoFotoSat method, of class LectorPDFImpreso47.
     */
    @Test
    public void testObtenerNombreArchivoFotoSat() {
        System.out.println("obtenerNombreArchivoFotoSat");
        
        String expResult = "NombreArchivoFotoSatelitaldeUbicacion";
        String result = instance1.obtenerNombreArchivoFotoSat();
        assertEquals(expResult, result);
        
        expResult = "archivo1";
        result = instance2.obtenerNombreArchivoFotoSat();
        assertEquals(expResult, result);
        
        expResult = "dsaadssda";
        result = instance3.obtenerNombreArchivoFotoSat();
        assertEquals(expResult, result);
        
        expResult = "archivo1";
        result = instance4.obtenerNombreArchivoFotoSat();
        assertEquals(expResult, result);
        
        expResult = "adwddw";
        result = instance5.obtenerNombreArchivoFotoSat();
        assertEquals(expResult, result);
        
        expResult = "NombreArchivoFotoSatelitaldeUbicacion";
        result = instance6.obtenerNombreArchivoFotoSat();
        assertEquals(expResult, result);
    }
    
    /**
    * Test of obtenerInsumos method, of class LectorPDFImpresoVisual47.
    */
    @Test
    public void testObtenerInsumos(){
        System.out.println("obtenerInsumos");
        
        //pdf1
        ArrayList<ArrayList<String>> expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("NombreInsumos");
        expResult.get(0).add("Sólido");
        expResult.get(0).add("123456");
        expResult.get(0).add("unidades");
        expResult.get(0).add("NombreAlmacenamientoInsumos");
        ArrayList<ArrayList<String>> result = instanceVisual1.obtenerInsumos();
        assertEquals(expResult, result);
        
        //pdf2
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("insumo desconocido");
        expResult.get(0).add("Gaseoso");
        expResult.get(0).add("7551");
        expResult.get(0).add("kg");
        expResult.get(0).add("almacenaje");
        result = instanceVisual2.obtenerInsumos();
        assertEquals(expResult, result);
        
        //pdf3
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("213132");
        expResult.get(0).add("Gaseoso");
        expResult.get(0).add("213");
        expResult.get(0).add("lt");
        expResult.get(0).add("das213");
        result = instanceVisual3.obtenerInsumos();
        assertEquals(expResult, result);
        
        //pdf4
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("insumo desconocido");
        expResult.get(0).add("Gaseoso");
        expResult.get(0).add("7551");
        expResult.get(0).add("kg");
        expResult.get(0).add("almacenaje");
        result = instanceVisual4.obtenerInsumos();
        assertEquals(expResult, result);
        
        //pdf5
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("InsumoUno");
        expResult.get(0).add("Líquido");
        expResult.get(0).add("6");
        expResult.get(0).add("kg");
        expResult.get(0).add("Amlacen");
        expResult.get(1).add("UnsimoDos");
        expResult.get(1).add("Gaseoso");
        expResult.get(1).add("999");
        expResult.get(1).add("lt");
        expResult.get(1).add("Container");
        result = instanceVisual5.obtenerInsumos();
        assertEquals(expResult, result);
        
        //pdf6
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("NombreInsumos1");
        expResult.get(0).add("Gaseoso");
        expResult.get(0).add("1234567890");
        expResult.get(0).add("m3");
        expResult.get(0).add("NombreAlmacenamientoInsumos1");
        expResult.get(1).add("NombreInsumos2");
        expResult.get(1).add("Líquido");
        expResult.get(1).add("1234567890");
        expResult.get(1).add("lt");
        expResult.get(1).add("NombreAlmacenamientoInsumos2");
        expResult.get(2).add("NombreInsumos3");
        expResult.get(2).add("Semisólido");
        expResult.get(2).add("1234567890");
        expResult.get(2).add("kg");
        expResult.get(2).add("NombreAlmacenamientoInsumos3");
        expResult.get(3).add("NombreInsumos4");
        expResult.get(3).add("Sólido");
        expResult.get(3).add("1234567890");
        expResult.get(3).add("tn");
        expResult.get(3).add("NombreAlmacenamientoInsumos4");
        
        result = instanceVisual6.obtenerInsumos();
        assertEquals(expResult, result);
    }
    
    /**
    * Test of obtenerSustAuxiliares method, of class LectorPDFImpresoVisual47.
    */
    @Test
    public void testobtenerSustAuxiliares(){
        System.out.println("obtenerSustAuxiliares");
        ArrayList<ArrayList<String>> expResult;
        ArrayList<ArrayList<String>> result;
        
        //pdf1
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("NombreSustAuxiliaresYFluidos");
        expResult.get(0).add("1234567");
        expResult.get(0).add("lt");
        expResult.get(0).add("NombreAlmacenamientoSustAuxiliaresYFluidos");
        result = instanceVisual1.obtenerSustAuxiliares();
        assertEquals(expResult, result);
        
        //pdf2
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("sustancia");
        expResult.get(0).add("282");
        expResult.get(0).add("kg");
        expResult.get(0).add("almac233");
        expResult.get(1).add("fluido");
        expResult.get(1).add("854");
        expResult.get(1).add("m3");
        expResult.get(1).add("almac6565");
        result = instanceVisual2.obtenerSustAuxiliares();
        assertEquals(expResult, result);
        
        //pdf3
        expResult = new ArrayList<>();
        result = instanceVisual3.obtenerSustAuxiliares();
        assertEquals(expResult, result);
        
        //pdf4
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("sustancia");
        expResult.get(0).add("282");
        expResult.get(0).add("kg");
        expResult.get(0).add("almac233");
        expResult.get(1).add("fluido");
        expResult.get(1).add("854");
        expResult.get(1).add("m3");
        expResult.get(1).add("almac6565");
        result = instanceVisual4.obtenerSustAuxiliares();
        assertEquals(expResult, result);
        
        //pdf5
        expResult = new ArrayList<>();
        result = instanceVisual5.obtenerSustAuxiliares();
        assertEquals(expResult, result);
        
        //pdf6
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("NombreSustAuxiliaresYFluidos1");
        expResult.get(0).add("1234567890");
        expResult.get(0).add("kg");
        expResult.get(0).add("NombreAlmacenamientoSustAuxiliaresYFluidos1");
        expResult.get(1).add("NombreSustAuxiliaresYFluidos2");
        expResult.get(1).add("1234567890");
        expResult.get(1).add("lt");
        expResult.get(1).add("NombreAlmacenamientoSustAuxiliaresYFluidos2");
        expResult.get(2).add("NombreSustAuxiliaresYFluidos3");
        expResult.get(2).add("1234567890");
        expResult.get(2).add("m3");
        expResult.get(2).add("NombreAlmacenamientoSustAuxiliaresYFluidos3");
        expResult.get(3).add("NombreSustAuxiliaresYFluidos4");
        expResult.get(3).add("1234567890");
        expResult.get(3).add("tn");
        expResult.get(3).add("NombreAlmacenamientoSustAuxiliaresYFluidos4");
        result = instanceVisual6.obtenerSustAuxiliares();
        assertEquals(expResult, result);
        
    }
    
    /**
    * Test of obtenerArchivosLayOut method, of class LectorPDFImpresoVisual47.
    */
    @Test
    public void testobtenerArchivosLayOut(){
        System.out.println("obtenerArchivosLayOut");
        ArrayList<String> expResult;
        ArrayList<String> result;
        
        //pdf1
        expResult = new ArrayList<>();
        expResult.add("Nombre del archivo correspondiente al Diagrama de flujo del Proceso Productivo 2.1");
        expResult.add("Nombre del archivo correspondiente al Layout de la planta y/o Layout de máquinas y equipos 2.1");
        expResult.add("2.3 Nombre del archivo correspondiente al Relevamiento fotográfico (Entorno inmediato,estado del predio)");
        result = instanceVisual1.obtenerArchivosLayOut();
        assertEquals(expResult, result);
        
        //pdf2
        expResult = new ArrayList<>();
        expResult.add("nombrearchivo2");
        expResult.add("nombrearchivo3");
        expResult.add("nombrearchivo4");
        result = instanceVisual2.obtenerArchivosLayOut();
        assertEquals(expResult, result);
        
        //pdf3
        expResult = new ArrayList<>();
        expResult.add("12342t");
        expResult.add("123321");
        expResult.add("132123231123");
        result = instanceVisual3.obtenerArchivosLayOut();
        assertEquals(expResult, result);
        
        //pdf4
        expResult = new ArrayList<>();
        expResult.add("nombrearchivo2");
        expResult.add("nombrearchivo3");
        expResult.add("nombrearchivo4");
        result = instanceVisual4.obtenerArchivosLayOut();
        assertEquals(expResult, result);
        
        //pdf5
        expResult = new ArrayList<>();
        expResult.add("DiagramaFlujo_2.1");
        expResult.add("DiagramaPlanta_v1");
        expResult.add("RelevamientoFot_4");
        result = instanceVisual5.obtenerArchivosLayOut();
        assertEquals(expResult, result);
        
        //pdf6
        expResult = new ArrayList<>();
        expResult.add("Nombre del archivo correspondiente al Diagrama de flujo del Proceso Productivo 2.1");
        expResult.add("Nombre del archivo correspondiente al Layout de la planta y/o Layout de máquinas y equipos 2.1");
        expResult.add("2.3 Nombre del archivo correspondiente al Relevamiento fotográfico (Entorno inmediato,estado del predio)");
        result = instanceVisual6.obtenerArchivosLayOut();
        assertEquals(expResult, result);
    }
    
    /**
    * Test of obtenerDomRealPlanta method, of class LectorPDFImpresoVisual47.
    */
    @Test
    public void testobtenerDomRealPlanta(){
        ArrayList<String> expResult;
        ArrayList<String> result;
        
        //pdf1
        expResult = new ArrayList<>();
        expResult.add("CalleDomRealPlanta");
        expResult.add("numDomRealPlant");
        expResult.add(null);
        expResult.add(null);
        expResult.add("Santa Fe");
        expResult.add("ROSARIO");
        expResult.add("ROSARIO");
        expResult.add("2000");
        expResult.add("Parque Industrial");
        expResult.add("NombreArchivoFotoSatelitaldeUbicacion");
        result = instanceVisual1.obtenerDomRealPlanta();
        assertEquals(expResult,result);
        
        //pdf2
        expResult = new ArrayList<>();
        expResult.add("Calle ubicacion de planta");
        expResult.add("09877");
        expResult.add("11");
        expResult.add("2");
        expResult.add("Santa Fe");
        expResult.add("CASTELLANOS");
        expResult.add("AURELIA");
        expResult.add("2301");
        expResult.add("Industrial/Rural");
        expResult.add("archivo1");
        result = instanceVisual2.obtenerDomRealPlanta();
        assertEquals(expResult,result);
        
        //pdf3
        expResult = new ArrayList<>();
        expResult.add("dssadsaads");
        expResult.add("131212");
        expResult.add("21");
        expResult.add("2");
        expResult.add("Santa Fe");
        expResult.add("CASEROS");
        expResult.add("AREQUITO");
        expResult.add("2183");
        expResult.add("Parque Industrial");
        expResult.add("dsaadssda");
        result = instanceVisual3.obtenerDomRealPlanta();
        assertEquals(expResult,result);
        
        //pdf4
        expResult = new ArrayList<>();
        expResult.add("Calle ubicacion de planta");
        expResult.add("09877");
        expResult.add("11");
        expResult.add("2");
        expResult.add("Santa Fe");
        expResult.add("CASTELLANOS");
        expResult.add("AURELIA");
        expResult.add("2301");
        expResult.add("Industrial/Rural");
        expResult.add("archivo1");
        result = instanceVisual4.obtenerDomRealPlanta();
        assertEquals(expResult,result);
        
        //pdf5
        expResult = new ArrayList<>();
        expResult.add("Callecinha");
        expResult.add("89498");
        expResult.add("3");
        expResult.add(null);
        expResult.add("Santa Fe");
        expResult.add("GARAY");
        expResult.add("SANTA ROSA DE CALCHINES");
        expResult.add("3022");
        expResult.add("Otras Zonas");
        expResult.add("adwddw");
        result = instanceVisual5.obtenerDomRealPlanta();
        assertEquals(expResult,result);
        
        //pdf6
        expResult = new ArrayList<>();
        expResult.add("CalleDomRealPlanta");
        expResult.add("numDomRealPlant");
        expResult.add(null);
        expResult.add("2");
        expResult.add("Santa Fe");
        expResult.add("ROSARIO");
        expResult.add("ROSARIO");
        expResult.add("2000");
        expResult.add("Parque Industrial");
        expResult.add("NombreArchivoFotoSatelitaldeUbicacion");
        result = instanceVisual6.obtenerDomRealPlanta();
        assertEquals(expResult,result);
    }
    
    /**
    * Test of obtenerInmueblesAnexos method, of class LectorPDFImpresoVisual47.
    */
    @Test
    public void testobtenerInmueblesAnexos(){
        System.out.println("obtenerInmueblesAnexos");
        ArrayList<ArrayList<String>> expResult;
        ArrayList<ArrayList<String>> result;
        
        //pdf1
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("DomicilioInmuebleAnexo");
        expResult.get(0).add("ActividadInmuebleAnexo");
        result = instanceVisual1.obtenerInmueblesAnexos();
        assertEquals(expResult,result);
        
        //pdf2
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("domicilio inmueble anexo");
        expResult.get(0).add("trabajo muy duro como un esclavo");
        result = instanceVisual2.obtenerInmueblesAnexos();
        assertEquals(expResult,result);
        
        //pdf3
        expResult = new ArrayList<>();
        //expResult.add(new ArrayList<>());
        //expResult.get(0).add("");
        //expResult.get(0).add("");
        result = instanceVisual3.obtenerInmueblesAnexos();
        assertEquals(expResult,result);
        
        //pdf4
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("domicilio inmueble anexo");
        expResult.get(0).add("trabajo muy duro como un esclavo");
        result = instanceVisual4.obtenerInmueblesAnexos();
        assertEquals(expResult,result);
        
        //pdf5
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Anexalo1");
        expResult.get(0).add("Anexamiento");
        expResult.get(1).add("Anexalo2");
        expResult.get(1).add("Inanexamiento");
        result = instanceVisual5.obtenerInmueblesAnexos();
        assertEquals(expResult,result);
        
        //pdf6
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("DomicilioInmuebleAnexo1");
        expResult.get(0).add("ActividadInmuebleAnexo1");
        expResult.get(1).add("DomicilioInmuebleAnexo2");
        expResult.get(1).add("ActividadInmuebleAnexo2");
        expResult.get(2).add("DomicilioInmuebleAnexo3");
        expResult.get(2).add("ActividadInmuebleAnexo3");
        expResult.get(3).add("DomicilioInmuebleAnexo4");
        expResult.get(3).add("ActividadInmuebleAnexo4");
        result = instanceVisual6.obtenerInmueblesAnexos();
        assertEquals(expResult,result);
    }
    
     /**
    * Test of obtenerDimensionamiento method, of class LectorPDFImpresoVisual47.
    */
    @Test
    public void testobtenerDimensionamiento(){
        System.out.println("obtenerDimensionamiento");
        ArrayList<String> expResult;
        ArrayList<String> result;
        
        //pdf1
        expResult = new ArrayList<>();
        expResult.add("superf");
        expResult.add("supcub");
        expResult.add("potins");
        expResult.add("1234");
        result = instanceVisual1.obtenerDimensionamiento();
        assertEquals(expResult,result);
        
        //pdf2
        expResult = new ArrayList<>();
        expResult.add("26215");
        expResult.add("907821");
        expResult.add("86219");
        expResult.add("8868");
        result = instanceVisual2.obtenerDimensionamiento();
        assertEquals(expResult,result);
        
        //pdf3
        expResult = new ArrayList<>();
        expResult.add("313213");
        expResult.add("123123");
        expResult.add("13123");
        expResult.add("123");
        result = instanceVisual3.obtenerDimensionamiento();
        assertEquals(expResult,result);
        
        //pdf4
        expResult = new ArrayList<>();
        expResult.add("26215");
        expResult.add("907821");
        expResult.add("86219");
        expResult.add("8868");
        result = instanceVisual4.obtenerDimensionamiento();
        assertEquals(expResult,result);
        
        //pdf5
        expResult = new ArrayList<>();
        expResult.add("56566");
        expResult.add("56400");
        expResult.add("7894");
        expResult.add("65");
        result = instanceVisual5.obtenerDimensionamiento();
        assertEquals(expResult,result);
        
        //pdf6
        expResult = new ArrayList<>();
        expResult.add("superf");
        expResult.add("supcub");
        expResult.add("potins");
        expResult.add("1234");
        result = instanceVisual6.obtenerDimensionamiento();
        assertEquals(expResult,result);
    }
    
    /**
    * Test of obtenerFormacionDePersonal method, of class LectorPDFImpresoVisual47.
    */
    @Test
    public void testobtenerFormacionDePersonal(){
        System.out.println("obtenerFormacionDePersonal");
        ArrayList<ArrayList<String>> expResult;
        ArrayList<ArrayList<String>> result;
        
        //pdf1
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("1234");
        expResult.get(0).add("cantidad de obreros - capacitacion/especialidades");
        expResult.get(1).add("1234");
        expResult.get(1).add("cantidad de técnicos - capacitacion/especialidades");
        expResult.get(2).add("1234");
        expResult.get(2).add("cantidad de profesionales - capacitacion/especialidades");
        result = instanceVisual1.obtenerFormacionDePersonal();
        assertEquals(expResult, result);
        
        //pdf2
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("21");
        expResult.get(0).add("Ño");
        expResult.get(1).add("56");
        expResult.get(1).add("SI");
        expResult.get(2).add("654");
        expResult.get(2).add("Ñi");
        result = instanceVisual2.obtenerFormacionDePersonal();
        assertEquals(expResult, result);
        
        //pdf3
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("32123");
        expResult.get(0).add("dasdsasd");
        expResult.get(1).add("12321");
        expResult.get(1).add("dasdas");
        expResult.get(2).add("1221");
        expResult.get(2).add("dsadsdasdsa");
        result = instanceVisual3.obtenerFormacionDePersonal();
        assertEquals(expResult, result);
        
        //pdf4
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("21");
        expResult.get(0).add("Ño");
        expResult.get(1).add("56");
        expResult.get(1).add("SI");
        expResult.get(2).add("654");
        expResult.get(2).add("Ñi");
        result = instanceVisual4.obtenerFormacionDePersonal();
        assertEquals(expResult, result);
        
        //pdf5
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("12");
        expResult.get(0).add("Obreros");
        expResult.get(1).add("65");
        expResult.get(1).add("Tecnicos");
        expResult.get(2).add("8");
        expResult.get(2).add("Profesinales");
        result = instanceVisual5.obtenerFormacionDePersonal();
        assertEquals(expResult, result);
        
        //pdf6
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("1234");
        expResult.get(0).add("cantidad de obreros - capacitacion/especialidades");
        expResult.get(1).add("1234");
        expResult.get(1).add("cantidad de técnicos - capacitacion/especialidades");
        expResult.get(2).add("1234");
        expResult.get(2).add("cantidad de profesionales - capacitacion/especialidades");
        result = instanceVisual6.obtenerFormacionDePersonal();
        assertEquals(expResult, result);
    }
    
    /**
    * Test of obtenerFormacionDePersonal method, of class LectorPDFImpresoVisual47.
    */
    @Test
    public void testobtenerEmisionGaseosaNatural(){
        System.out.println("obtenerEmisionGaseosaNatural");
        ArrayList<ArrayList<String>> expResult;
        ArrayList<ArrayList<String>> result;
        
        //pdf1
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("nombreEmisionGaseosa");
        expResult.get(0).add("NombreProcesoGeneradorDeEmisionesGaseosas");
        expResult.get(0).add("NombreTratamientoDeEmisionesGaseosas");
        result = instanceVisual1.obtenerEmisionGaseosaNatural();
        assertEquals(expResult, result);
        
        //pdf2
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Emision1");
        expResult.get(0).add("proceso1");
        expResult.get(0).add("tratamiento1");
        expResult.get(1).add("Emision2");
        expResult.get(1).add("proceso2");
        expResult.get(1).add("tratamiento2");
        result = instanceVisual2.obtenerEmisionGaseosaNatural();
        assertEquals(expResult, result);
        
        //pdf3
        expResult = new ArrayList<>();
        result = instanceVisual3.obtenerEmisionGaseosaNatural();
        assertEquals(expResult, result);
        
        //pdf4
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Emision1");
        expResult.get(0).add("proceso1");
        expResult.get(0).add("tratamiento1");
        expResult.get(1).add("Emision2");
        expResult.get(1).add("proceso2");
        expResult.get(1).add("tratamiento2");
        result = instanceVisual4.obtenerEmisionGaseosaNatural();
        assertEquals(expResult, result);
        
        //pdf5
        expResult = new ArrayList<>();
        result = instanceVisual5.obtenerEmisionGaseosaNatural();
        assertEquals(expResult, result);
        
        //pdf6
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("nombreEmisionGaseosa1");
        expResult.get(0).add("NombreProcesoGeneradorDeEmisionesGaseosas1");
        expResult.get(0).add("NombreTratamientoDeEmisionesGaseosas1");
        expResult.get(1).add("nombreEmisionGaseosa2");
        expResult.get(1).add("NombreProcesoGeneradorDeEmisionesGaseosas2");
        expResult.get(1).add("NombreTratamientoDeEmisionesGaseosas2");
        expResult.get(2).add("nombreEmisionGaseosa3");
        expResult.get(2).add("NombreProcesoGeneradorDeEmisionesGaseosas3");
        expResult.get(2).add("NombreTratamientoDeEmisionesGaseosas3");
        expResult.get(3).add("nombreEmisionGaseosa4");
        expResult.get(3).add("NombreProcesoGeneradorDeEmisionesGaseosas4");
        expResult.get(3).add("NombreTratamientoDeEmisionesGaseosas4");
        result = instanceVisual6.obtenerEmisionGaseosaNatural();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of obtenerEmisionGasCombustion(), of class lectorPDFImpresoVisual47
     */
    @Test
    public void testobtenerEmisionGasCombustion(){
        System.out.println("obtenerEmisionGasCombustion");
        ArrayList<ArrayList<String>> expResult;
        ArrayList<ArrayList<String>> result;
        
        //pdf1
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("NombreEmisionGasDeCombustionDeCombLiquidos");
        expResult.get(0).add("ProcesoGeneradorEmisionGasDeCombLiquido");
        expResult.get(0).add("TratamientoGasDeCombustionDeCombLiquidos");
        result = instanceVisual1.obtenerEmisionGasCombustion();
        assertEquals(expResult, result);
        
        //pdf2
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Emision3");
        expResult.get(0).add("Proceso3");
        expResult.get(0).add("tratam3");
        result = instanceVisual2.obtenerEmisionGasCombustion();
        assertEquals(expResult, result);
        
        //pdf3
        expResult = new ArrayList<>();
        result = instanceVisual3.obtenerEmisionGasCombustion();
        assertEquals(expResult, result);
        
        //pdf4
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Emision3");
        expResult.get(0).add("Proceso3");
        expResult.get(0).add("tratam3");
        result = instanceVisual4.obtenerEmisionGasCombustion();
        assertEquals(expResult, result);
        
        //pdf5
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Emision1");
        expResult.get(0).add("Proceso1");
        expResult.get(0).add("No Se trata");
        expResult.get(1).add("Emision2");
        expResult.get(1).add("Proceso2");
        expResult.get(1).add("Si Se Trata");
        result = instanceVisual5.obtenerEmisionGasCombustion();
        assertEquals(expResult, result);
        
        //pdf6
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("NombreEmisionGasDeCombustionDeCombLiquidos1");
        expResult.get(0).add("ProcesoGeneradorEmisionGasDeCombLiquido1");
        expResult.get(0).add("TratamientoGasDeCombustionDeCombLiquidos1");
        expResult.get(1).add("NombreEmisionGasDeCombustionDeCombLiquidos2");
        expResult.get(1).add("ProcesoGeneradorEmisionGasDeCombLiquido2");
        expResult.get(1).add("TratamientoGasDeCombustionDeCombLiquidos2");
        expResult.get(2).add("NombreEmisionGasDeCombustionDeCombLiquidos3");
        expResult.get(2).add("ProcesoGeneradorEmisionGasDeCombLiquido3");
        expResult.get(2).add("TratamientoGasDeCombustionDeCombLiquidos3");
        expResult.get(3).add("NombreEmisionGasDeCombustionDeCombLiquidos4");
        expResult.get(3).add("ProcesoGeneradorEmisionGasDeCombLiquido4");
        expResult.get(3).add("TratamientoGasDeCombustionDeCombLiquidos4");
        result = instanceVisual6.obtenerEmisionGasCombustion();
        assertEquals(expResult, result);
    }
    
    /**
    * Test of obtenerEmisionGasNoContemplado(), of class lectorPDFImpresoVisual47
    */
    @Test
    public void testobtenerEmisionGasNoContemplado(){
        System.out.println("obtenerEmisionGasNoContemplado");
        ArrayList<ArrayList<String>> expResult;
        ArrayList<ArrayList<String>> result;

        //pdf1
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("ProcesoGeneradorDeGasNoContempladoEnPregAnteriores");
        expResult.get(0).add("ComponentesRelevantesDeGasNoContempladosEnPregAnteriores");
        expResult.get(0).add("TratamientoDeGasesNoContempladosEnPreguntasAnteriores");
        result = instanceVisual1.obtenerEmisionGasNoContemplado();
        assertEquals(expResult, result);

        //pdf2
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Proce4");
        expResult.get(0).add("Comp4");
        expResult.get(0).add("Trat4");
        result = instanceVisual2.obtenerEmisionGasNoContemplado();
        assertEquals(expResult, result);

        //pdf3
        expResult = new ArrayList<>();
        result = instanceVisual3.obtenerEmisionGasNoContemplado();
        assertEquals(expResult, result);

        //pdf4
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Proce4");
        expResult.get(0).add("Comp4");
        expResult.get(0).add("Trat4");
        result = instanceVisual4.obtenerEmisionGasNoContemplado();
        assertEquals(expResult, result);

        //pdf5
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Proceso3");
        expResult.get(0).add("Componente3");
        expResult.get(0).add("Tratamiento3");
        expResult.get(1).add("Proceso4");
        expResult.get(1).add("Componente4");
        expResult.get(1).add("Trat4");
        result = instanceVisual5.obtenerEmisionGasNoContemplado();
        assertEquals(expResult, result);

        //pdf6
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("ProcesoGeneradorDeGasNoContempladoEnPregAnteriores1");
        expResult.get(0).add("ComponentesRelevantesDeGasNoContempladosEnPregAnteriores1");
        expResult.get(0).add("TratamientoDeGasesNoContempladosEnPreguntasAnteriores1");
        expResult.get(1).add("ProcesoGeneradorDeGasNoContempladoEnPregAnteriores2");
        expResult.get(1).add("ComponentesRelevantesDeGasNoContempladosEnPregAnteriores2");
        expResult.get(1).add("TratamientoDeGasesNoContempladosEnPreguntasAnteriores2");
        expResult.get(2).add("ProcesoGeneradorDeGasNoContempladoEnPregAnteriores3");
        expResult.get(2).add("ComponentesRelevantesDeGasNoContempladosEnPregAnteriores3");
        expResult.get(2).add("TratamientoDeGasesNoContempladosEnPreguntasAnteriores3");
        expResult.get(3).add("ProcesoGeneradorDeGasNoContempladoEnPregAnteriores4");
        expResult.get(3).add("ComponentesRelevantesDeGasNoContempladosEnPregAnteriores4");
        expResult.get(3).add("TratamientoDeGasesNoContempladosEnPreguntasAnteriores4");
        result = instanceVisual6.obtenerEmisionGasNoContemplado();
        assertEquals(expResult, result);
    }
}
