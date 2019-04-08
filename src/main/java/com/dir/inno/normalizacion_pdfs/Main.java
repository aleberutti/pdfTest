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


/**
 *
 * @author Administrador
 */
public class Main{
     /**
     * @param args the command line arguments
     */

    
    public static void main(String[] args) throws IOException{
        
        RByCB_Info presentacion = new RByCB_Info("presentacion");
        RByCB_Info iac = new RByCB_Info("iac");
        RByCB_Info eia = new RByCB_Info("eia");
        
        System.out.println(presentacion.printPresentacion());
        System.out.println("----------------------------------------------------------------\n\n");
        System.out.println(iac.printIAC());
        System.out.println("----------------------------------------------------------------\n\n");
        System.out.println(eia.printEIA());
        System.out.println("----------------------------------------------------------------\n\n");
    }
}
