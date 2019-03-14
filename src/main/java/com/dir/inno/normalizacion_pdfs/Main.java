/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.dir.inno.normalizacion_pdfs;

import com.itextpdf.licensekey.LicenseKey;
import com.itextpdf.tool.xml.xtra.xfa.XFAFlattener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDNonTerminalField;
import org.apache.pdfbox.pdmodel.interactive.form.PDXFAResource;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.xml.sax.SAXException;

/**
 *
 * @author Administrador
 */
public class Main{
     /**
     * @param args the command line arguments
     */
    private List javascriptEvents;

    public void main(String[] args)  throws IOException {
        try{
            FileInputStream f = new FileInputStream("C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7 muy lleno.pdf");
            FileOutputStream dest = new FileOutputStream("C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7 flattened.pdf");
            
            LicenseKey.loadLicenseFile(System.getenv("ITEXT7_LICENSEKEY") + "/all-products.xml");

 

            this.javascriptEvents = new ArrayList();



            this.javascriptEvents.add("click");

            
            XFAFlattener xfaf = new XFAFlattener();
            
            
            
            xfaf.flatten(f, dest);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }









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
//        String filename ="C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentación v4.7 sd v1 static.pdf";
//        PDDocument document = PDDocument.load(new File(filename));
//        
//        printFields(document);
//        PDAcroForm pdform = document.getDocumentCatalog().getAcroForm();
//        
//        PDXFAResource xfa = pdform.getXFA();
//        Document xfaDocument = xfa.getDocument();
//        xfaDocument.normalize();
//        print(xfaDocument.getElementsByTagName("*"));
        
    }
    
 private static void printNodes(NodeList nodeList) {

     for (int j = 0; j<nodeList.getLength(); j++ ){

        Nodo nodo = new Nodo(nodeList.item(j));
        
        if (nodo.isLeaf()){

            System.out.println("/nNode name:" + nodo.getName());
            System.out.println("Node value:" + nodo.getValue());
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
                outputString.append(sParent);
                if (partialName != null)
                {
                    outputString.append(".").append(partialName);
                }
                outputString.append(" = ").append(fieldValue);
                //outputString.append(",  type=").append(field.getClass().getName());
                System.out.println(outputString);
            }
            
        }
    }
}
