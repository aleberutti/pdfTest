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
    @Test
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
    @Test
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
        
        expResult = "Calle sinnombre 1231, Piso 1, Depto 1,\n"
                + "Helvecia, Garay, Santa Fe\n"
                + "CP 3003\n"
                + "Tel.: 343325216\n"
                + "E-mail: email@fominio.com";
        result = instance4.obtenerDomicilioLegal();
        assertEquals(expResult, result);
        
        expResult = "Calle 5656 3245, Piso 4, Depto null,\n"
                + "Carreras, General Lopez, Santa Fe\n"
                + "CP 2729\n"
                + "Tel.: 35535344\n"
                + "E-mail: vampires@yahoo.ahre";
        result = instance5.obtenerDomicilioLegal();
        assertEquals(expResult, result);
        
        expResult = "CalleDomicilioLegal nºcalle, Piso null, Depto 2,\n"
                + "Localidaddomlegal, Dptodomlegal, Entre Ríos\n"
                + "CP codPost\n"
                + "Tel.: 3414567897\n"
                + "E-mail: domiciliolegal@mail.com";
        result = instance6.obtenerDomicilioLegal();
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
        
        expResult = "Calle constituida 1243, Piso 21, Depto 1,\n"
                + "Bella Italia, Castellanos, Santa Fe\n"
                + "CP 2401\n"
                + "Tel.: 3421123456\n"
                + "E-mail: email.dominio@algo.com";
        result = instance4.obtenerDomicilioConst();
        assertEquals(expResult, result);
        
        expResult = "Calle 8 333, Piso 05, Depto null,\n"
                + "Ing. Chanourdie, General Obligado, Santa Fe\n"
                + "CP 3575\n"
                + "Tel.: 35435458\n"
                + "E-mail: lalalal@lelele.lulu";
        result = instance5.obtenerDomicilioConst();
        assertEquals(expResult, result);
        
        expResult = "CalleDomicilioConstituido nºcalle, Piso null, Depto 2,\n"
                + "Localidaddomconstituido, Departamentodomicilioconst, Entre Ríos\n"
                + "CP codPost\n"
                + "Tel.: 3414567897\n"
                + "E-mail: domicilioConstituido@mail.com";
        result = instance6.obtenerDomicilioConst();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerNomina method, of class LectorPDFImpreso47.
     */
    @Test
    public void testObtenerNomina() {
        System.out.println("obtenerNomina");
        
        
        ArrayList<ArrayList<String>> expResult = new ArrayList<>();
        ArrayList<ArrayList<String>> result;
        /*
        expResult.add(new ArrayList<>(4));
        expResult.get(0).add("ApellidoMiembroDirectorio");
        expResult.get(0).add("NombreMiembroDirectorio");
        expResult.get(0).add("12345678");
        expResult.get(0).add("CargoAsignado");
        ArrayList<ArrayList<String>> result = instance1.obtenerNomina();
        assertEquals(expResult, result);

        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(4));
        expResult.add(new ArrayList<>(4));
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

        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(4));
        expResult.get(0).add("das");
        expResult.get(0).add("asd");
        expResult.get(0).add("123");
        expResult.get(0).add("ads");
        result = instance3.obtenerNomina();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(4));
        expResult.add(new ArrayList<>(4));
        expResult.get(0).add("Apellidouno");
        expResult.get(0).add("nombreuno");
        expResult.get(0).add("12431421");
        expResult.get(0).add("dsadl");
        expResult.get(1).add("apellidodos");
        expResult.get(1).add("nombredos");
        expResult.get(1).add("45678911");
        expResult.get(1).add("adsdsasadsdasd");
        result = instance4.obtenerNomina();
        assertEquals(expResult, result);
        */
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(4));
        expResult.add(new ArrayList<>(4));
        expResult.add(new ArrayList<>(4));
        expResult.get(0).add("Jorge");
        expResult.get(0).add("Jorgito");
        expResult.get(0).add("22233344");
        expResult.get(0).add("The Big Boss");
        expResult.get(1).add("Mara");
        expResult.get(1).add("Marita");
        expResult.get(1).add("68468468");
        expResult.get(1).add("The Small Boss");
        expResult.get(2).add("ElJefe");
        expResult.get(2).add("Lucho");
        expResult.get(2).add("8949498");
        expResult.get(2).add("ElJefe");
        result = instance5.obtenerNomina();
        assertEquals(expResult, result);
        
        /*
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(4));
        expResult.add(new ArrayList<>(4));
        expResult.get(0).add("ApellidoMiembroDirectorio");
        expResult.get(0).add("NombreMiembroDirectorio");
        expResult.get(0).add("12345678");
        expResult.get(0).add("CargoAsignado");
        expResult.get(1).add("ApellidoMiembroDirectorio");
        expResult.get(1).add("NombreMiembroDirectorio");
        expResult.get(1).add("12345678");
        expResult.get(1).add("CargoAsignado");
        expResult.get(2).add("ApellidoMiembroDirectorio");
        expResult.get(2).add("NombreMiembroDirectorio");
        expResult.get(2).add("12345678");
        expResult.get(2).add("CargoAsignado");
        result = instance6.obtenerNomina();
        assertEquals(expResult, result);
        */
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
     * Test of obtenerDomicilioReal method, of class LectorPDFImpreso47.
     */
    @Test
    public void testObtenerDomicilioReal() {
        System.out.println("obtenerDomicilioReal");
        String expResult = "CalleDomRealPlanta numDomRealPlant, Piso null, Depto null,\n"
                + "Rosario, Rosario, Santa Fe\n"
                + "CP 2000\n"
                + "Tel.: Telefono/Fax\n"
                + "Zonificacion: Parque Industrial\n"
                + "E-mail: emaildomrealplanta@mail.com";
        String result = instance1.obtenerDomicilioReal();
        assertEquals(expResult, result);

        expResult = "Calle ubicacion de planta 09877, Piso 11, Depto 2,\n"
                + "Aurelia, Castellanos, Santa Fe\n"
                + "CP 2301\n"
                + "Tel.: 342827252\n"
                + "Zonificacion: Industrial/Rural\n"
                + "E-mail: email.com@dominio.com";
        result = instance2.obtenerDomicilioReal();
        assertEquals(expResult, result);

        expResult = "dssadsaads 131212, Piso 21, Depto 2,\n"
                + "Arequito, Caseros, Santa Fe\n"
                + "CP 2183\n"
                + "Tel.: das12321321321\n"
                + "Zonificacion: Parque Industrial\n"
                + "E-mail: dsadassda";
        result = instance3.obtenerDomicilioReal();
        assertEquals(expResult, result);
        
        expResult = "Calle ubicacion de planta 09877, Piso 11, Depto 2,\n"
                + "Aurelia, Castellanos, Santa Fe\n"
                + "CP 2301\n"
                + "Tel.: 342827252\n"
                + "Zonificacion: Industrial/Rural\n"
                + "E-mail: email.com@dominio.com";
        result = instance4.obtenerDomicilioReal();
        assertEquals(expResult, result);
        
        expResult = "Callecinha 89498, Piso 3, Depto null,\n"
                + "Santa Rosa De Calchines, Garay, Santa Fe\n"
                + "CP 3022\n"
                + "Tel.: 668676767\n"
                + "Zonificacion: Otras Zonas\n"
                + "E-mail: sadanosdn@ogrio.ogr";
        result = instance5.obtenerDomicilioReal();
        assertEquals(expResult, result);
        
        expResult = "CalleDomRealPlanta numDomRealPlant, Piso null, Depto 2,\n"
                + "Rosario, Rosario, Santa Fe\n"
                + "CP 2000\n"
                + "Tel.: Telefono/Fax\n"
                + "Zonificacion: Parque Industrial\n"
                + "E-mail: emaildomrealplanta@mail.com";
        result = instance6.obtenerDomicilioReal();
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
     * Test of obtenerPartidasInm method, of class LectorPDFImpreso47.
     */
    @Test
    public void testObtenerPartidasInm() {
        System.out.println("obtenerPartidasInm");
        
        ArrayList<ArrayList<String>> expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("123456789");
        expResult.get(0).add("132321321321");
        expResult.get(0).add("321321321321");
        ArrayList<ArrayList<String>> result = instance1.obtenerPartidasInm();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("2345678");
        expResult.get(0).add("87654");
        expResult.get(0).add("456789");
        expResult.get(1).add("0987654");
        expResult.get(1).add("5678");
        expResult.get(1).add("098765");
        result = instance2.obtenerPartidasInm();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("123213231");
        expResult.get(0).add("123321213");
        expResult.get(0).add("123");
        result = instance3.obtenerPartidasInm();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("2345678");
        expResult.get(0).add("87654");
        expResult.get(0).add("456789");
        expResult.get(1).add("0987654");
        expResult.get(1).add("5678");
        expResult.get(1).add("098765");
        expResult.get(2).add("565346656556");
        expResult.get(2).add("212121");
        expResult.get(2).add("122112");
        result = instance4.obtenerPartidasInm();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("165198");
        expResult.get(0).add("32");
        expResult.get(0).add("12");
        result = instance5.obtenerPartidasInm();
        assertEquals(expResult, result);
        
        /* NO ANDA ESTE CASO
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("123456789");
        expResult.get(0).add("132321321321");
        expResult.get(0).add("321321321321");
        expResult.get(1).add("123456789");
        expResult.get(1).add("132321321321");
        expResult.get(1).add("321321321321");
        expResult.get(2).add("123456789");
        expResult.get(2).add("132321321321");
        expResult.get(2).add("321321321321");
        result = instance6.obtenerPartidasInm();
        assertEquals(expResult, result);
        */
    }

    /**
     * Test of obtenerAdministradores method, of class LectorPDFImpreso47.
     */
    @Test
    public void testObtenerAdministradores() {
        System.out.println("obtenerAdministradores");
        
        ArrayList<ArrayList<String>> expResult = new ArrayList();
        expResult.add(new ArrayList<>(4));
        expResult.get(0).add("ApellidoAdministrador");
        expResult.get(0).add("NombreAdministrador");
        expResult.get(0).add("12345678");
        expResult.get(0).add("CargoAdminAsignado");
        ArrayList<ArrayList<String>> result = instance1.obtenerAdministradores();
        assertEquals(expResult, result);
        
        
    }
}
