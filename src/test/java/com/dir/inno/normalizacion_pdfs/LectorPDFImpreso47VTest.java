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
}
