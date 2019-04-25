/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import com.snowtide.PDF;
import com.snowtide.pdf.Document;
import com.snowtide.pdf.VisualOutputTarget;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MODERNIZACION05
 */
public class LectorPDFImpreso47VTest {

    LectorPDFImpreso47V instance1;
    LectorPDFImpreso47V instance2;
    LectorPDFImpreso47V instance3;
    LectorPDFImpreso47V instance4;
    LectorPDFImpreso47V instance5;
    LectorPDFImpreso47V instance6;

    public LectorPDFImpreso47VTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @BeforeEach
    public void setUp() throws IOException {
        String filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(1)_impreso.pdf";
        StringBuilder text;
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instance1 = new LectorPDFImpreso47V(text);

        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(2)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instance2 = new LectorPDFImpreso47V(text);

        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(3)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instance3 = new LectorPDFImpreso47V(text);

        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(4)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instance4 = new LectorPDFImpreso47V(text);

        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(5)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instance5 = new LectorPDFImpreso47V(text);

        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(6)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instance6 = new LectorPDFImpreso47V(text);
    }

    /**
     * Test of obtenerPartidasInm method, of class LectorPDFImpreso47V.
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
    }

    /**
     * Test of obtenerNomina method, of class LectorPDFImpreso47V.
     */
    @Test
    public void testObtenerNomina() {
        System.out.println("obtenerNomina");

        ArrayList<ArrayList<String>> expResult = new ArrayList<>();
        ArrayList<ArrayList<String>> result;

        expResult.add(new ArrayList<>(4));
        expResult.get(0).add("ApellidoMiembroDirectorio");
        expResult.get(0).add("NombreMiembroDirectorio");
        expResult.get(0).add("12345678");
        expResult.get(0).add("CargoAsignado");
        result = instance1.obtenerNomina();
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

        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(4));
        expResult.add(new ArrayList<>(4));
        expResult.add(new ArrayList<>(4));
        expResult.get(0).add("Jorge");
        expResult.get(0).add("Jorgito");
        expResult.get(0).add("22233344");
        expResult.get(0).add("The Big Boss");
        expResult.get(1).add("Mara");
        expResult.get(1).add("Marito");
        expResult.get(1).add("68468468");
        expResult.get(1).add("The Small Boss");
        expResult.get(2).add("ElJefe");
        expResult.get(2).add("Lucho");
        expResult.get(2).add("8949498");
        expResult.get(2).add("ElJefe");
        result = instance5.obtenerNomina();
        assertEquals(expResult, result);

        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(4));
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
    }

    /**
     * Test of obtenerDomicilioConst method, of class LectorPDFImpreso47V.
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
     * Test of obtenerDomicilioLegal method, of class LectorPDFImpreso47V.
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
     * Test of obtenerDomicilioReal method, of class LectorPDFImpreso47V.
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

        expResult = new ArrayList();
        expResult.add(new ArrayList<>(4));
        expResult.add(new ArrayList<>(4));
        expResult.get(0).add("ApellidoRepUno");
        expResult.get(0).add("NombreRepUno");
        expResult.get(0).add("87655432");
        expResult.get(0).add("askdsal");
        expResult.get(1).add("ApellidoRepDos");
        expResult.get(1).add("NombreRepDos");
        expResult.get(1).add("56789009");
        expResult.get(1).add("piuytrewsdfghjk");
        result = instance2.obtenerAdministradores();
        assertEquals(expResult, result);

    }

    /**
     * Test of obtenerDatosPlantaCatAmb method, of class LectorPDFImpreso47V.
     */
    @Test
    public void testObtenerDatosPlantaCatAmb() throws Exception {
        System.out.println("obtenerDatosPlantaCatAmb");

        String expResult = "DatosParaLaCategorizacionAmbientalDeActividades - Planta,\n"
                + "Fecha inicio de actividades: "
                + new SimpleDateFormat("dd/MM/yyyy").parse("08/03/2019");
        String result = instance1.obtenerDatosPlantaCatAmb();
        assertEquals(expResult, result);

        expResult = "Planta 1,\n"
                + "Fecha inicio de actividades: "
                + new SimpleDateFormat("dd/MM/yyyy").parse("26/02/2019");
        result = instance2.obtenerDatosPlantaCatAmb();
        assertEquals(expResult, result);

        expResult = "dsadasdsa,\n"
                + "Fecha inicio de actividades: "
                + new SimpleDateFormat("dd/MM/yyyy").parse("30/01/2019");
        result = instance3.obtenerDatosPlantaCatAmb();
        assertEquals(expResult, result);

        expResult = "Planta 1,\n"
                + "Fecha inicio de actividades: "
                + new SimpleDateFormat("dd/MM/yyyy").parse("26/02/2019");
        result = instance4.obtenerDatosPlantaCatAmb();
        assertEquals(expResult, result);

        expResult = "Plantusi,\n"
                + "Fecha inicio de actividades: "
                + new SimpleDateFormat("dd/MM/yyyy").parse("20/03/2019");
        result = instance5.obtenerDatosPlantaCatAmb();
        assertEquals(expResult, result);

        expResult = "DatosParaLaCategorizacionAmbientalDeActividades - Planta,\n"
                + "Fecha inicio de actividades: "
                + new SimpleDateFormat("dd/MM/yyyy").parse("08/03/2019");
        result = instance6.obtenerDatosPlantaCatAmb();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerPlantasFueraProv method, of class LectorPDFImpreso47V.
     */
    @Test
    public void testObtenerPlantasFueraProv() {
        System.out.println("obtenerPlantasFueraProv");
        ArrayList<ArrayList<String>> expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(4));
        expResult.get(0).add("DomPlantaFueraDeSFE");
        expResult.get(0).add("LocPlantaFueraSFE");
        expResult.get(0).add("Entre Ríos");
        expResult.get(0).add("3100");
        ArrayList<ArrayList<String>> result = instance1.obtenerPlantasFueraProv();
        assertEquals(expResult, result);

        expResult = new ArrayList<>();
        result = instance2.obtenerPlantasFueraProv();
        assertEquals(expResult, result);

        expResult = new ArrayList<>();
        result = instance3.obtenerPlantasFueraProv();
        assertEquals(expResult, result);

        expResult = new ArrayList<>();
        result = instance4.obtenerPlantasFueraProv();
        assertEquals(expResult, result);

        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(4));
        expResult.add(new ArrayList<>(4));
        expResult.get(0).add("AltaCalle");
        expResult.get(0).add("ChubutAhre");
        expResult.get(0).add("Chubut");
        expResult.get(0).add("3333");
        expResult.get(1).add("Alcorta");
        expResult.get(1).add("CABA");
        expResult.get(1).add("Buenos Aires");
        expResult.get(1).add("1");
        result = instance5.obtenerPlantasFueraProv();
        assertEquals(expResult, result);

        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(4));
        expResult.add(new ArrayList<>(4));
        expResult.add(new ArrayList<>(4));
        expResult.get(0).add("DomPlantaFueraDeSFE");
        expResult.get(0).add("LocPlantaFueraSFE");
        expResult.get(0).add("Entre Ríos");
        expResult.get(0).add("3100");
        expResult.get(1).add("DomPlantaFueraDeSFE");
        expResult.get(1).add("LocPlantaFueraSFE");
        expResult.get(1).add("Entre Ríos");
        expResult.get(1).add("3100");
        expResult.get(2).add("DomPlantaFueraDeSFE");
        expResult.get(2).add("LocPlantaFueraSFE");
        expResult.get(2).add("Entre Ríos");
        expResult.get(2).add("3100");
        result = instance6.obtenerPlantasFueraProv();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerProductos method, of class LectorPDFImpreso47V.
     */
    @Test
    public void testObtenerProductos() {
        System.out.println("obtenerProductos");
        
        ArrayList<ArrayList<String>> expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("NombreProductoAElaborar");
        expResult.get(0).add("Líquido");
        expResult.get(0).add("12346");
        expResult.get(0).add("lt");
        expResult.get(0).add("TipoDeAlmacenamientoDelProducto");
        expResult.get(0).add("Otro");
        ArrayList<ArrayList<String>> result = instance1.obtenerProductos();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("producto");
        expResult.get(0).add("Gaseoso");
        expResult.get(0).add("123");
        expResult.get(0).add("kg");
        expResult.get(0).add("almacenamiento");
        expResult.get(0).add("Producto Industrial");
        expResult.get(1).add("producto2");
        expResult.get(1).add("Líquido");
        expResult.get(1).add("123231");
        expResult.get(1).add("m3");
        expResult.get(1).add("almacenamiento2");
        expResult.get(1).add("Bien de Capital");
        result = instance2.obtenerProductos();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("dasdasdas");
        expResult.get(0).add("Gaseoso");
        expResult.get(0).add("21132");
        expResult.get(0).add("lt");
        expResult.get(0).add("sdadassad");
        expResult.get(0).add("Bien de Capital");
        result = instance3.obtenerProductos();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("producto");
        expResult.get(0).add("Gaseoso");
        expResult.get(0).add("123");
        expResult.get(0).add("kg");
        expResult.get(0).add("almacenamiento");
        expResult.get(0).add("Producto Industrial");
        expResult.get(1).add("producto2");
        expResult.get(1).add("Líquido");
        expResult.get(1).add("123231");
        expResult.get(1).add("m3");
        expResult.get(1).add("almacenamiento2");
        expResult.get(1).add("Bien de Capital");
        result = instance4.obtenerProductos();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("Prod1");
        expResult.get(0).add("Sólido");
        expResult.get(0).add("135");
        expResult.get(0).add("kg");
        expResult.get(0).add("Tirado");
        expResult.get(0).add("Bien de Capital");
        expResult.get(1).add("Prod2");
        expResult.get(1).add("Líquido");
        expResult.get(1).add("222");
        expResult.get(1).add("lt");
        expResult.get(1).add("Volcado");
        expResult.get(1).add("Producto Industrial");
        expResult.get(2).add("Prod3");
        expResult.get(2).add("Semisólido");
        expResult.get(2).add("999");
        expResult.get(2).add("tn");
        expResult.get(2).add("Desparramado");
        expResult.get(2).add("Otro");
        result = instance5.obtenerProductos();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("NombreProductoAElaborar");
        expResult.get(0).add("Líquido");
        expResult.get(0).add("1234567890");
        expResult.get(0).add("lt");
        expResult.get(0).add("TipoDeAlmacenamientoDelProducto");
        expResult.get(0).add("Otro");
        expResult.get(1).add("NombreProductoAElaborar2");
        expResult.get(1).add("Gaseoso");
        expResult.get(1).add("1234567890");
        expResult.get(1).add("m3");
        expResult.get(1).add("TipoDeAlmacenamientoDelProducto2");
        expResult.get(1).add("Bien de Consumo");
        expResult.get(2).add("NombreProductoAElaborar3");
        expResult.get(2).add("Semisólido");
        expResult.get(2).add("1234567890");
        expResult.get(2).add("kg");
        expResult.get(2).add("TipoDeAlmacenamientoDelProducto3");
        expResult.get(2).add("Otro");
        expResult.get(3).add("NombreProductoAElaborar4");
        expResult.get(3).add("Sólido");
        expResult.get(3).add("1234567890");
        expResult.get(3).add("tn");
        expResult.get(3).add("TipoDeAlmacenamientoDelProducto4");
        expResult.get(3).add("Bien de Capital");
        result = instance6.obtenerProductos();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerSubproductos method, of class LectorPDFImpreso47V.
     */
    @Test
    public void testObtenerSubproductos() {
        System.out.println("obtenerSubproductos");
        
        ArrayList<ArrayList<String>> expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("NombreSubProducto");
        expResult.get(0).add("Líquido");
        expResult.get(0).add("1321321321");
        expResult.get(0).add("lt");
        expResult.get(0).add("NombreAlmacenamientoSubProducto");
        ArrayList<ArrayList<String>> result = instance1.obtenerSubproductos();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("Subprod");
        expResult.get(0).add("Semisólido");
        expResult.get(0).add("3836");
        expResult.get(0).add("unidades");
        expResult.get(0).add("almacenamiento213");
        expResult.get(1).add("subprod2");
        expResult.get(1).add("Líquido");
        expResult.get(1).add("736");
        expResult.get(1).add("kg");
        expResult.get(1).add("almacenamiento65497");
        result = instance2.obtenerSubproductos();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("dasdsa");
        expResult.get(0).add("Líquido");
        expResult.get(0).add("123");
        expResult.get(0).add("m3");
        expResult.get(0).add("dasad");
        result = instance3.obtenerSubproductos();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("Subprod");
        expResult.get(0).add("Semisólido");
        expResult.get(0).add("3836");
        expResult.get(0).add("unidades");
        expResult.get(0).add("almacenamiento213");
        expResult.get(1).add("subprod2");
        expResult.get(1).add("Líquido");
        expResult.get(1).add("736");
        expResult.get(1).add("kg");
        expResult.get(1).add("almacenamiento65497");
        result = instance4.obtenerSubproductos();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("Subprod");
        expResult.get(0).add("Semisólido");
        expResult.get(0).add("3836");
        expResult.get(0).add("unidades");
        expResult.get(0).add("almacenamiento213");
        expResult.get(1).add("subprod2");
        expResult.get(1).add("Líquido");
        expResult.get(1).add("736");
        expResult.get(1).add("kg");
        expResult.get(1).add("almacenamiento65497");
        result = instance4.obtenerSubproductos();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("Sub1");
        expResult.get(0).add("Semisólido");
        expResult.get(0).add("5");
        expResult.get(0).add("unidades");
        expResult.get(0).add("QSY");
        expResult.get(1).add("Sub2");
        expResult.get(1).add("Líquido");
        expResult.get(1).add("66");
        expResult.get(1).add("m3");
        expResult.get(1).add("Podes no preguntartanto?");
        expResult.get(2).add("Seub 3");
        expResult.get(2).add("Sólido");
        expResult.get(2).add("665");
        expResult.get(2).add("lt");
        expResult.get(2).add("Gracias");
        result = instance5.obtenerSubproductos();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("NombreSubProducto1");
        expResult.get(0).add("Líquido");
        expResult.get(0).add("1321321321");
        expResult.get(0).add("lt");
        expResult.get(0).add("NombreAlmacenamientoSubProducto1");
        expResult.get(1).add("NombreSubProducto2");
        expResult.get(1).add("Gaseoso");
        expResult.get(1).add("1234567890");
        expResult.get(1).add("kg");
        expResult.get(1).add("NombreAlmacenamientoSubProducto2");
        expResult.get(2).add("NombreSubProducto3");
        expResult.get(2).add("Semisólido");
        expResult.get(2).add("1234567890");
        expResult.get(2).add("m3");
        expResult.get(2).add("NombreAlmacenamientoSubProducto3");
        expResult.get(3).add("NombreSubProducto4");
        expResult.get(3).add("Sólido");
        expResult.get(3).add("134567890");
        expResult.get(3).add("tn");
        expResult.get(3).add("NombreAlmacenamientoSubProducto4");
        result = instance6.obtenerSubproductos();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerMateriasPrimas method, of class LectorPDFImpreso47V.
     */
    @Test
    public void testObtenerMateriasPrimas() {
        System.out.println("obtenerMateriasPrimas");
        
        ArrayList<ArrayList<String>> expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("NombreMateriaPrima");
        expResult.get(0).add("Líquido");
        expResult.get(0).add("123456");
        expResult.get(0).add("lt");
        expResult.get(0).add("NombreAlmacenamientoMateriaPrima");
        ArrayList<ArrayList<String>> result = instance1.obtenerMateriasPrimas();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("matprima");
        expResult.get(0).add("Sólido");
        expResult.get(0).add("9543");
        expResult.get(0).add("tn");
        expResult.get(0).add("almac754654");
        result = instance2.obtenerMateriasPrimas();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("asd");
        expResult.get(0).add("Gaseoso");
        expResult.get(0).add("1242");
        expResult.get(0).add("m3");
        expResult.get(0).add("dsasdsad");
        result = instance3.obtenerMateriasPrimas();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("matprima");
        expResult.get(0).add("Sólido");
        expResult.get(0).add("9543");
        expResult.get(0).add("tn");
        expResult.get(0).add("almac754654");
        result = instance4.obtenerMateriasPrimas();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("UnaMateria");
        expResult.get(0).add("Líquido");
        expResult.get(0).add("999");
        expResult.get(0).add("lt");
        expResult.get(0).add("No se almacena");
        expResult.get(1).add("Dos Materias");
        expResult.get(1).add("Sólido");
        expResult.get(1).add("888");
        expResult.get(1).add("kg");
        expResult.get(1).add("Tampoco");
        result = instance5.obtenerMateriasPrimas();
        assertEquals(expResult, result);
        
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.add(new ArrayList<>(5));
        expResult.get(0).add("NombreMateriaPrima1");
        expResult.get(0).add("Gaseoso");
        expResult.get(0).add("1234567980");
        expResult.get(0).add("m3");
        expResult.get(0).add("NombreAlmacenamientoMateriaPrima1");
        expResult.get(1).add("NombreMateriaPrima2");
        expResult.get(1).add("Líquido");
        expResult.get(1).add("1234657980");
        expResult.get(1).add("lt");
        expResult.get(1).add("NombreAlmacenamientoMateriaPrima");
        expResult.get(2).add("NombreMateriaPrima3");
        expResult.get(2).add("Semisólido");
        expResult.get(2).add("1234567890");
        expResult.get(2).add("kg");
        expResult.get(2).add("NombreAlmacenamientoMateriaPrima");
        expResult.get(3).add("NombreMateriaPrima4");
        expResult.get(3).add("Sólido");
        expResult.get(3).add("124567890");
        expResult.get(3).add("tn");
        expResult.get(3).add("NombreAlmacenamientoMateriaPrima");
        result = instance6.obtenerMateriasPrimas();
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
        ArrayList<ArrayList<String>> result = instance1.obtenerInsumos();
        assertEquals(expResult, result);
        
        //pdf2
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("insumo desconocido");
        expResult.get(0).add("Gaseoso");
        expResult.get(0).add("7551");
        expResult.get(0).add("kg");
        expResult.get(0).add("almacenaje");
        result = instance2.obtenerInsumos();
        assertEquals(expResult, result);
        
        //pdf3
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("213132");
        expResult.get(0).add("Gaseoso");
        expResult.get(0).add("213");
        expResult.get(0).add("lt");
        expResult.get(0).add("das213");
        result = instance3.obtenerInsumos();
        assertEquals(expResult, result);
        
        //pdf4
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("insumo desconocido");
        expResult.get(0).add("Gaseoso");
        expResult.get(0).add("7551");
        expResult.get(0).add("kg");
        expResult.get(0).add("almacenaje");
        result = instance4.obtenerInsumos();
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
        result = instance5.obtenerInsumos();
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
        
        result = instance6.obtenerInsumos();
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
        result = instance1.obtenerSustAuxiliares();
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
        result = instance2.obtenerSustAuxiliares();
        assertEquals(expResult, result);
        
        //pdf3
        expResult = new ArrayList<>();
        result = instance3.obtenerSustAuxiliares();
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
        result = instance4.obtenerSustAuxiliares();
        assertEquals(expResult, result);
        
        //pdf5
        expResult = new ArrayList<>();
        result = instance5.obtenerSustAuxiliares();
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
        result = instance6.obtenerSustAuxiliares();
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
        result = instance1.obtenerArchivosLayOut();
        assertEquals(expResult, result);
        
        //pdf2
        expResult = new ArrayList<>();
        expResult.add("nombrearchivo2");
        expResult.add("nombrearchivo3");
        expResult.add("nombrearchivo4");
        result = instance2.obtenerArchivosLayOut();
        assertEquals(expResult, result);
        
        //pdf3
        expResult = new ArrayList<>();
        expResult.add("12342t");
        expResult.add("123321");
        expResult.add("132123231123");
        result = instance3.obtenerArchivosLayOut();
        assertEquals(expResult, result);
        
        //pdf4
        expResult = new ArrayList<>();
        expResult.add("nombrearchivo2");
        expResult.add("nombrearchivo3");
        expResult.add("nombrearchivo4");
        result = instance4.obtenerArchivosLayOut();
        assertEquals(expResult, result);
        
        //pdf5
        expResult = new ArrayList<>();
        expResult.add("DiagramaFlujo_2.1");
        expResult.add("DiagramaPlanta_v1");
        expResult.add("RelevamientoFot_4");
        result = instance5.obtenerArchivosLayOut();
        assertEquals(expResult, result);
        
        //pdf6
        expResult = new ArrayList<>();
        expResult.add("Nombre del archivo correspondiente al Diagrama de flujo del Proceso Productivo 2.1");
        expResult.add("Nombre del archivo correspondiente al Layout de la planta y/o Layout de máquinas y equipos 2.1");
        expResult.add("2.3 Nombre del archivo correspondiente al Relevamiento fotográfico (Entorno inmediato,estado del predio)");
        result = instance6.obtenerArchivosLayOut();
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
        result = instance1.obtenerDomRealPlanta();
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
        result = instance2.obtenerDomRealPlanta();
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
        result = instance3.obtenerDomRealPlanta();
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
        result = instance4.obtenerDomRealPlanta();
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
        result = instance5.obtenerDomRealPlanta();
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
        result = instance6.obtenerDomRealPlanta();
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
        result = instance1.obtenerInmueblesAnexos();
        assertEquals(expResult,result);
        
        //pdf2
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("domicilio inmueble anexo");
        expResult.get(0).add("trabajo muy duro como un esclavo");
        result = instance2.obtenerInmueblesAnexos();
        assertEquals(expResult,result);
        
        //pdf3
        expResult = new ArrayList<>();
        //expResult.add(new ArrayList<>());
        //expResult.get(0).add("");
        //expResult.get(0).add("");
        result = instance3.obtenerInmueblesAnexos();
        assertEquals(expResult,result);
        
        //pdf4
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("domicilio inmueble anexo");
        expResult.get(0).add("trabajo muy duro como un esclavo");
        result = instance4.obtenerInmueblesAnexos();
        assertEquals(expResult,result);
        
        //pdf5
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Anexalo1");
        expResult.get(0).add("Anexamiento");
        expResult.get(1).add("Anexalo2");
        expResult.get(1).add("Inanexamiento");
        result = instance5.obtenerInmueblesAnexos();
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
        result = instance6.obtenerInmueblesAnexos();
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
        result = instance1.obtenerDimensionamiento();
        assertEquals(expResult,result);
        
        //pdf2
        expResult = new ArrayList<>();
        expResult.add("26215");
        expResult.add("907821");
        expResult.add("86219");
        expResult.add("8868");
        result = instance2.obtenerDimensionamiento();
        assertEquals(expResult,result);
        
        //pdf3
        expResult = new ArrayList<>();
        expResult.add("313213");
        expResult.add("123123");
        expResult.add("13123");
        expResult.add("123");
        result = instance3.obtenerDimensionamiento();
        assertEquals(expResult,result);
        
        //pdf4
        expResult = new ArrayList<>();
        expResult.add("26215");
        expResult.add("907821");
        expResult.add("86219");
        expResult.add("8868");
        result = instance4.obtenerDimensionamiento();
        assertEquals(expResult,result);
        
        //pdf5
        expResult = new ArrayList<>();
        expResult.add("56566");
        expResult.add("56400");
        expResult.add("7894");
        expResult.add("65");
        result = instance5.obtenerDimensionamiento();
        assertEquals(expResult,result);
        
        //pdf6
        expResult = new ArrayList<>();
        expResult.add("superf");
        expResult.add("supcub");
        expResult.add("potins");
        expResult.add("1234");
        result = instance6.obtenerDimensionamiento();
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
        result = instance1.obtenerFormacionDePersonal();
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
        result = instance2.obtenerFormacionDePersonal();
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
        result = instance3.obtenerFormacionDePersonal();
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
        result = instance4.obtenerFormacionDePersonal();
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
        result = instance5.obtenerFormacionDePersonal();
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
        result = instance6.obtenerFormacionDePersonal();
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
        result = instance1.obtenerEmisionGaseosaNatural();
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
        result = instance2.obtenerEmisionGaseosaNatural();
        assertEquals(expResult, result);
        
        //pdf3
        expResult = new ArrayList<>();
        result = instance3.obtenerEmisionGaseosaNatural();
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
        result = instance4.obtenerEmisionGaseosaNatural();
        assertEquals(expResult, result);
        
        //pdf5
        expResult = new ArrayList<>();
        result = instance5.obtenerEmisionGaseosaNatural();
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
        result = instance6.obtenerEmisionGaseosaNatural();
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
        result = instance1.obtenerEmisionGasCombustion();
        assertEquals(expResult, result);
        
        //pdf2
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Emision3");
        expResult.get(0).add("Proceso3");
        expResult.get(0).add("tratam3");
        result = instance2.obtenerEmisionGasCombustion();
        assertEquals(expResult, result);
        
        //pdf3
        expResult = new ArrayList<>();
        result = instance3.obtenerEmisionGasCombustion();
        assertEquals(expResult, result);
        
        //pdf4
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Emision3");
        expResult.get(0).add("Proceso3");
        expResult.get(0).add("tratam3");
        result = instance4.obtenerEmisionGasCombustion();
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
        result = instance5.obtenerEmisionGasCombustion();
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
        result = instance6.obtenerEmisionGasCombustion();
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
        result = instance1.obtenerEmisionGasNoContemplado();
        assertEquals(expResult, result);

        //pdf2
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Proce4");
        expResult.get(0).add("Comp4");
        expResult.get(0).add("Trat4");
        result = instance2.obtenerEmisionGasNoContemplado();
        assertEquals(expResult, result);

        //pdf3
        expResult = new ArrayList<>();
        result = instance3.obtenerEmisionGasNoContemplado();
        assertEquals(expResult, result);

        //pdf4
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Proce4");
        expResult.get(0).add("Comp4");
        expResult.get(0).add("Trat4");
        result = instance4.obtenerEmisionGasNoContemplado();
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
        result = instance5.obtenerEmisionGasNoContemplado();
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
        result = instance6.obtenerEmisionGasNoContemplado();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of obtenerEfluenteNoPeligroso() method, of class LectorPDFImpreso47V
     */
    @Test
    public void testObtenerEfluenteNoPeligroso(){
        System.out.println("testObtenerEfluenteNoPeligroso");
        ArrayList<ArrayList<String>> expResult;
        ArrayList<ArrayList<String>> result;

        //pdf1
        expResult = new ArrayList<>();
        result = instance1.obtenerEfluenteNoPeligroso();
        assertEquals(expResult, result);

        //pdf2 //proceso, componentes, valor, volumen, unidadTiempo, cuerpoReceptor
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("ProcesoGenerador1");
        expResult.get(0).add("Componentes1");
        expResult.get(0).add("1");
        expResult.get(0).add("m3");
        expResult.get(0).add("mensual");
        expResult.get(0).add("Conducto pluvial abierto");
        result = instance2.obtenerEfluenteNoPeligroso();
        assertEquals(expResult, result);

        //pdf3
        expResult = new ArrayList<>();
        result = instance3.obtenerEfluenteNoPeligroso();
        assertEquals(expResult, result);

        //pdf4
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.get(0).add("ProcesoGenerador1");
        expResult.get(0).add("Componentes1");
        expResult.get(0).add("1");
        expResult.get(0).add("m3");
        expResult.get(0).add("mensual");
        expResult.get(0).add("Conducto pluvial abierto");
        result = instance4.obtenerEfluenteNoPeligroso();
        assertEquals(expResult, result);

        //pdf5
        expResult = new ArrayList<>();
        expResult.add(new ArrayList<>());
        expResult.add(new ArrayList<>());
        expResult.get(0).add("Proceso5");
        expResult.get(0).add("Componente5");
        expResult.get(0).add("65");
        expResult.get(0).add("lt");
        expResult.get(0).add("diario");
        expResult.get(0).add("Conducto pluvial abierto");
        expResult.get(1).add("Proceso6");
        expResult.get(1).add("Componente6");
        expResult.get(1).add("99");
        expResult.get(1).add("m3");
        expResult.get(1).add("semanal");
        expResult.get(1).add("Cuenca elemental cerrada");
        result = instance5.obtenerEfluenteNoPeligroso();
        assertEquals(expResult, result);

        //pdf6
        expResult = new ArrayList<>();
        result = instance6.obtenerEfluenteNoPeligroso();
        assertEquals(expResult, result);
    }
    
}
