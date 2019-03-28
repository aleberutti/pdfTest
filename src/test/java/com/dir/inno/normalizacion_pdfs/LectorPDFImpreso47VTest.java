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
}
