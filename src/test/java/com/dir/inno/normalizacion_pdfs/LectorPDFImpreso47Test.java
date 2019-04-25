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
    
    LectorPDFImpreso47V instanceVisual1;
    LectorPDFImpreso47V instanceVisual2;
    LectorPDFImpreso47V instanceVisual3;
    LectorPDFImpreso47V instanceVisual4;
    LectorPDFImpreso47V instanceVisual5;
    LectorPDFImpreso47V instanceVisual6;
    
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
        
        
        /*
        * Usando VisualOutputTarget para la salida.
        */
        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(1)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instanceVisual1 = new LectorPDFImpreso47V(text);

        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(2)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instanceVisual2 = new LectorPDFImpreso47V(text);

        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(3)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instanceVisual3 = new LectorPDFImpreso47V(text);

        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(4)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instanceVisual4 = new LectorPDFImpreso47V(text);

        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(5)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instanceVisual5 = new LectorPDFImpreso47V(text);

        filePath = new File("").getAbsolutePath();
        filePath += "\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7(6)_impreso.pdf";
        try (Document pdf = PDF.open(filePath)) {
            text = new StringBuilder();
            pdf.pipe(new VisualOutputTarget(text));
        }
        instanceVisual6 = new LectorPDFImpreso47V(text);

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
   
}
