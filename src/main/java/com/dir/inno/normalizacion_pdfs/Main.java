/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.dir.inno.normalizacion_pdfs;

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
import java.util.Iterator;
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
    private static ArrayList<String> text = new ArrayList<>();
    public static void main(String[] args)  throws IOException, TransformerException, ParserConfigurationException, SAXException {
        
        
        
        //Se necesita de un pdf estático
        String filename ="C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\FormularioEIA v3.4.5.1 static.pdf";
        PDDocument document = PDDocument.load(new File(filename));

        
        printFields(document);
        
        File f1= new File("C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\FormularioEIA rb y cb info.txt");
        
        
        if(!f1.exists()) f1.createNewFile();
        FileWriter  fw = new FileWriter(f1);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for (String c: text){
            bw.write(c);
            bw.newLine();
        }
        bw.flush();
        try{                    
            if(fw != null){   
               fw.close();
            }                  
         }
         catch (Exception e3){ 
            e3.printStackTrace();
          }
        //Formulario de presentacion
//        Form_Presentacion activar = new Form_Presentacion("C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion rb y cb info.txt");
//        System.out.println(activar.toString());

        
    }

    public static void printFields(PDDocument pdfDocument) throws IOException{
        
        PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();
        List<PDField> fields = acroForm.getFields();
        
        System.out.println(fields.size() + " top-level fields were found on the form");

        for (PDField field : fields){
            
            processField(field, "|--", field.getPartialName());
        
        }
    }
    private static void processField(PDField field, String sLevel, String sParent) throws IOException{
        String partialName = field.getPartialName();
        
        if (field instanceof PDNonTerminalField)
        {
            if (!sParent.equals(field.getPartialName()))
            {
                if (partialName != null)
                {
                    sParent = sParent + "." + partialName;
                }
            }
            System.out.println(sLevel + sParent);

            for (PDField child : ((PDNonTerminalField)field).getChildren())
            {
                processField(child, "|  " + sLevel, sParent);
            }
        }
        else{
            if(!field.getValueAsString().isEmpty()){
                String fieldValue = field.getValueAsString();
                StringBuilder outputString = new StringBuilder(sLevel);
                if (field.getClass().getName().contains("RadioButton") || field.getClass().getName().contains("CheckBox") ){
                    outputString.append(sParent);
                    if (partialName != null)
                    {
                        outputString.append(".").append(partialName);
                    }
                    outputString.append(" = ").append(fieldValue);
                    //outputString.append(",  type=").append(field.getClass().getName());
                    System.out.println(outputString);
                    text.add(outputString.toString());
                }
            }
            
        }
    }
}
