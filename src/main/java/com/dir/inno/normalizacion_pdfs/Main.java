/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.dir.inno.normalizacion_pdfs;


import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.xml.sax.SAXException;
import com.snowtide.PDF;
import com.snowtide.pdf.Document;
import com.snowtide.pdf.OutputTarget;
import com.snowtide.pdf.forms.AcroForm;
import com.snowtide.pdf.forms.Form;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDNonTerminalField;
import org.apache.pdfbox.pdmodel.interactive.form.PDXFAResource;
import org.w3c.dom.NodeList;

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
        
        
//        String pdfFilePath = "C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7 muy lleno.pdf";
//
//        Document pdf = PDF.open(pdfFilePath);
//        AcroForm form = (AcroForm)pdf.getFormData();
//        byte [] xml = form.getXFAPacketContents("datasets");
//        
//        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7 by xfa.xml")) {
//            fos.write(xml);
//        }
//        try{
//            File f = new File("C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7 by xfa.xml");
//            
//            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//
//            org.w3c.dom.Document doc = dBuilder.parse(f);
//            doc.getDocumentElement().normalize();
//            
//            if (doc.hasChildNodes()) {
//                
//
//		printNodes(doc.getChildNodes().item(0).getChildNodes());
//
//            }
//            
//
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//        }
        
        //Obtenemos los nombres paquetes
//        Set <String> packetNames = form.getXFAPacketNames();
//        Iterator <String> iterator = packetNames.iterator();
//        
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        Collection fieldNames = form.getFieldNames();
//        System.out.println(fieldNames.size());
//        
//        for (Object o : fieldNames){
//            System.out.println(o.toString());
//        }
//        StringBuilder text = new StringBuilder(1024);
//        pdf.pipe(new OutputTarget(text));
//        pdf.close();
//        System.out.println(text);


//        try{
//            File f = new File("C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\XML Documents\\Formulario de presentacion v4.7 muy lleno.xml");
//            
//            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//
//            Document doc = dBuilder.parse(f);
//            doc.getDocumentElement().normalize();
//            
//            if (doc.hasChildNodes()) {
//                
//
//		printNodes(doc.getChildNodes().item(0).getChildNodes());
//
//            }
//            
//
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//        }
        
        //Se necesita de un epdf estático
        String filename ="C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7 static.pdf";
        PDDocument document = PDDocument.load(new File(filename));
        
        printFields(document);
        
        File f1= new File("C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion rb y cb info.txt");
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
        
        Form_Presentacion activar = new Form_Presentacion("C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion rb y cb info.txt");
        System.out.println(activar.toString());
//        PDAcroForm pdform = document.getDocumentCatalog().getAcroForm();
        
//        PDXFAResource xfa = pdform.getXFA();
//        org.w3c.dom.Document xfaDocument = xfa.getDocument();
//        xfaDocument.normalize();
//        printNodes(xfaDocument.getElementsByTagName("*"));
        
    }
    
    private static void printNodes(NodeList nodeList) {

        for (int j = 0; j<nodeList.getLength(); j++ ){

           Nodo nodo = new Nodo(nodeList.item(j));

           if (nodo.isLeaf()){
               System.out.println("Node name:" + nodo.getName());
               System.out.println("Node value:" + nodo.getValue());
               System.out.println();
               
           }
           else{

               printNodes(nodo.getHijos());
           }
        }


   }
    public static void printFields(PDDocument pdfDocument) throws IOException{
        
        PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();
        List<PDField> fields = acroForm.getFields();
        
        System.out.println(fields.size() + " top-level fields were found on the form");

        for (PDField field : fields)
        {
            
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
                    //System.out.println(outputString);
                    text.add(outputString.toString());
                }
            }
            
        }
    }
}
