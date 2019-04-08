/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs.RByCB_Info;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDNonTerminalField;

/**
 *
 * @author Administrador
 */
public class RByCB_Info {
    private static ArrayList<String> form = new ArrayList<>();
    private String filename;
    private String destfile;
    private boolean presentacion;
    private boolean iac;
    private boolean eia;
    private Form_Presentacion form_presentacion;
    private Form_IAC form_iac;
    private Form_EIA form_eia;
    
    
    public RByCB_Info(String formulario) throws IOException{
       //Cambiar paths//Se necesita de un pdf estático SIN CERRAR
        switch (formulario){
            case "presentacion":
                this.filename="C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\Formulario de presentacion v4.7 static.pdf";
                this.destfile="C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\FormularioPresentacion rb y cb info.txt";
                this.presentacion=true;
                this.iac=false;
                this.eia=false;
                break;
            case "iac":
                this.filename="C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\Formulario IAC v2.5.2SD static.pdf";
                this.destfile="C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\FormularioIAC rb y cb info.txt";
                this.presentacion=false;
                this.iac=true;
                this.eia=false;
                break;
            case "eia":
                this.filename="C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\FormularioEIA v3.4.5.1 static.pdf";
                this.destfile="C:\\Users\\Administrador\\Desktop\\AB\\Almacenamiento PDFs editables\\PDFs editables\\FormularioEIA rb y cb info.txt";
                this.presentacion=false;
                this.iac=false;
                this.eia=true;
                break;
        }
        this.init();
    }
    public void init() throws IOException{
        PDDocument document = PDDocument.load(new File(filename));

        
        printFields(document);
        
        File f1= new File(destfile);
        
        
        if(!f1.exists()) f1.createNewFile();
        FileWriter  fw = new FileWriter(f1);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for (String c: form){
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
        if(presentacion){
           this.form_presentacion= new Form_Presentacion(destfile);
        }
       
        //Formulario de IAC
        if(iac){
            this.form_iac= new Form_IAC (destfile);
        }
        
        //Formulario EIA
        if(eia){
            this.form_eia=new Form_EIA(destfile);
        }
        document.close();
    }
    public String printPresentacion(){
        if(presentacion){
            return this.form_presentacion.toString();
        }
        else{
            return "El formulario de presentacion no ha sido cargado.";
        }
    }
    public String printEIA(){
        if(eia){
            return this.form_eia.toString();
        }
        else{
            return "El formulario EIA no ha sido cargado.";
        }
    }
    
    public String printIAC(){
        if(iac){
            return this.form_iac.toString();
        }
        else{
            return "El formulario IAC no ha sido cargado.";
        }
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
            //System.out.println(sLevel + sParent);

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
                    form.add(outputString.toString());
                }
            }
            
        }
    }
    
}
