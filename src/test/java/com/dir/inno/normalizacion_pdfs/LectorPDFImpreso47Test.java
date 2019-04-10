/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import com.snowtide.PDF;
import com.snowtide.pdf.Document;
import com.snowtide.pdf.OutputTarget;
import com.snowtide.pdf.VisualOutputTarget;
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
        String pdfFilePath = "D:\\Formulario de presentacion v4.7(1)_impreso.pdf";
        StringBuilder text;
        try (Document pdf = PDF.open(pdfFilePath)) {
            text = new StringBuilder();
            pdf.pipe(new OutputTarget(text));
        }
        instance1 = new LectorPDFImpreso47(text);

        pdfFilePath = "D:\\Formulario de presentacion v4.7(2)_impreso.pdf";
        try (Document pdf = PDF.open(pdfFilePath)) {
            text = new StringBuilder();
            pdf.pipe(new OutputTarget(text));
        }
        instance2 = new LectorPDFImpreso47(text);

        pdfFilePath = "D:\\Formulario de presentacion v4.7(3)_impreso.pdf";
        try (Document pdf = PDF.open(pdfFilePath)) {
            text = new StringBuilder();
            pdf.pipe(new OutputTarget(text));
        }
        instance3 = new LectorPDFImpreso47(text);
        
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
    }

    /**
     * Test of obtenerFechaInicioAct method, of class LectorPDFImpreso47.
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
        result = instance2.obtenerActividades();
        assertEquals(expResult, result);

        expResult = new ArrayList<>();
        expResult.add(112004);
        result = instance3.obtenerActividades();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(112003);
        result = instance4.obtenerActividades();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(181130);
        result = instance5.obtenerActividades();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(155120);
        result = instance6.obtenerActividades();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerDomicilioLegal method, of class LectorPDFImpreso47.
     */
    @Test
    public void testObtenerDomicilioLegal() {
        System.out.println("obtenerDomicilioLegal");

        String expResult = "CalleDomicilioLegal nºcalle, Piso 1, Depto 2,\n"
                + "Localidaddomlegal, Dptodomlegal, Entre Ríos\n"
                + "CP codPost\n"
                + "Tel.: 3414567897\n"
                + "E-mail: domiciliolegal@mail.com";
        String result = instance1.obtenerDomicilioLegal();
        assertEquals(expResult, result);

        expResult = "Calle sinnombre 1231, Piso 1, Depto 1,\n"
                + "Helvecia, Garay, Santa Fe\n"
                + "CP 3003\n"
                + "Tel.: 343325216\n"
                + "E-mail: email@fominio.com";
        result = instance2.obtenerDomicilioLegal();
        assertEquals(expResult, result);

        expResult = "LLERENA 780, Piso 5, Depto 4,\n"
                + "Bauer Y Sigel, Castellanos, Santa Fe\n"
                + "CP 2311\n"
                + "Tel.: 213231\n"
                + "E-mail: 231asddsa";
        result = instance3.obtenerDomicilioLegal();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerDomicilioConst method, of class LectorPDFImpreso47.
     */
    @Test
    public void testObtenerDomicilioConst() {
        System.out.println("obtenerDomicilioConst");

        String expResult = "CalleDomicilioConstituido nºcalle, Piso 1, Depto 2,\n"
                + "Localidaddomconstituido, Departamentodomicilioconst, Entre Ríos\n"
                + "CP codPost\n"
                + "Tel.: 3414567897\n"
                + "E-mail: domicilioConstituido@mail.com";
        String result = instance1.obtenerDomicilioConst();
        assertEquals(expResult, result);

        expResult = "Calle constituida 1243, Piso 21, Depto 1,\n"
                + "Bella Italia, Castellanos, Santa Fe\n"
                + "CP 2401\n"
                + "Tel.: 3421123456\n"
                + "E-mail: email.dominio@algo.com";
        result = instance2.obtenerDomicilioConst();
        assertEquals(expResult, result);

        expResult = "dassda asd, Piso 32, Depto 21,\n"
                + "Bouquet, Belgrano, Santa Fe\n"
                + "CP 2523\n"
                + "Tel.: 123321231\n"
                + "E-mail: 123";
        result = instance3.obtenerDomicilioConst();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerNomina method, of class LectorPDFImpreso47.
     */
    @Test
    public void testObtenerNomina() {
        System.out.println("obtenerNomina");

        ArrayList<ArrayList<String>> expResult = new ArrayList<>(4);
        expResult.add(new ArrayList<>());
        expResult.get(0).add("ApellidoMiembroDirectorio");
        expResult.get(0).add("NombreMiembroDirectorio");
        expResult.get(0).add("12345678");
        expResult.get(0).add("CargoAsignado");
        ArrayList<ArrayList<String>> result = instance1.obtenerNomina();
        assertEquals(expResult, result);

        expResult = new ArrayList<>(4);
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Apellidouno");
        expResult.get(0).add("nombreuno");
        expResult.get(0).add("12431421");
        expResult.get(0).add("dsadl");
        expResult.get(1).add("apellidodos");
        expResult.get(1).add("nombredos");
        expResult.get(1).add("45678911");
        expResult.get(1).add("adsdsasadsdasd");
        result = instance2.obtenerNomina();
        assertEquals(expResult, result);

        expResult = new ArrayList<>(4);
        expResult.add(new ArrayList<>());
        expResult.get(0).add("das");
        expResult.get(0).add("asd");
        expResult.get(0).add("123");
        expResult.get(0).add("ads");
        result = instance3.obtenerNomina();
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
    }
    
    /*
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
    
    /*
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
    
    /*
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
    
    /*
    * Test of obtenerDomRealPlanta method, of class LectorPDFImpresoVisual47.
    */
    @Test
    public void testobtenerDomRealPlanta(){
        ArrayList<String> expResult;
        ArrayList<String> result;
        
        //pdf1
        expResult = new ArrayList<>();
        
    }
}
