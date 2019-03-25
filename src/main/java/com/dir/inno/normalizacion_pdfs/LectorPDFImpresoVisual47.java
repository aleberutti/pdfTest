/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import static java.lang.Character.isLetter;

/**
 *
 * @author MODERNIZACION04
 */
public class LectorPDFImpresoVisual47 {
    
    private Integer index;
    private final StringBuilder text;

    public LectorPDFImpresoVisual47(StringBuilder text) {
        this.text = text;
    }
    
    private String readField() {
        String field = new String();
        while ((text.charAt(index) != ' '
                && text.charAt(index) != '\r'
                && text.charAt(index) != '\n') || (text.charAt(index) == ' ' && (text.charAt(index + 1) != ' '
                && text.charAt(index + 1) != '\r'
                && text.charAt(index + 1) != '\n')) || (text.charAt(index) == ' ' && (text.charAt(index + 1) == ' ' && (text.charAt(index + 2) != ' '
                && text.charAt(index + 2) != '\r'
                && text.charAt(index + 2) != '\n')))) {
            field += text.charAt(index);
            index++;
        }
        return field;
    }
    
    public Integer skipLine(){
        
        while(text.charAt(index) != '\n'){
            index++;
        }
        index++;
        return index;
    }
     
    public Integer skipWord(){

        while ((text.charAt(index) != ' ' && text.charAt(index) != '\r')
                || ((text.charAt(index) == ' ')
                && (text.charAt(index + 1) != ' ' && (
                text.charAt(index + 1) != '\r' || text.charAt(index + 1) != '\n')))) {
            index++;
        }
        return index;
    }
   
    private Integer skipBlank() {
        while (text.charAt(index) == ' ' || text.charAt(index) == '\r' || text.charAt(index) == '\n') {
            index++;
        }
        return index;
    }
    
    public Integer skipFooter(){
        skipBlank();
        
        for(int i = 0; i < 7; i++){
            skipLine();
        }
        
        return index;
    }
   
    public String obtenerInsumos(){ //no tiene armado el caso para más de un insumo
        
        String aux = null;
        String nombreInsumo = null;
        String estadoAgregacion = null;
        String consumoAnual = null;
        String unidad = null;
        String almacenamiento = null;
        
        String sub = "INSUMO";
        index = text.indexOf(sub) + sub.length();
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();

        aux = readField();
        
//        if(aux.contains("1")){
//           
//            index = skipLine();
//            nombreInsumo = readField();
//
//            sub = "ALMACENAMIENTO"; 
//            index = text.indexOf(sub, index) + sub.length();
//            index = skipBlank();
//            estadoAgregacion = readField();
//
//            index = skipBlank();
//            consumoAnual = readField();
//
//
//            index = skipBlank();
//            unidad = readField();
//
//            index = skipBlank();
//            almacenamiento = readField();
//            
//            if(text.charAt(index+1) == '\n' && isLetter(text.charAt(index+2))){
//                
//                index = skipBlank();
//                almacenamiento += readField();
//            }
//            
//        }
//        
//        if(aux.contains("ESTADO FÍSICO")){
//            
//            sub = "ALMACENAMIENTO";
//            index = text.indexOf(sub,index) + sub.length();
//                
//            /*Salteo el pie de pagina*/
//            skipBlank();
//            skipFooter();
//            skipBlank();
//            skipLine();
//            nombreInsumo = readField();
//            
//            if(nombreInsumo.contains("Gaseoso")){
//                nombreInsumo = nombreInsumo.replace("Gaseoso", "");
//                estadoAgregacion = "Gaseoso";
//            } else{
//                skipBlank();
//                estadoAgregacion = readField();
//            }
//            
//            if(nombreInsumo.contains("Sólido")){
//                nombreInsumo = nombreInsumo.replace("Sólido", "");
//                estadoAgregacion = "Sólido";
//            } else{
//                skipBlank();
//                estadoAgregacion = readField();
//            }
//            
//            if(nombreInsumo.contains("Líquido")){
//                nombreInsumo = nombreInsumo.replace("Líquido", "");
//                estadoAgregacion = "Líquido";
//            } else{
//                skipBlank();
//                estadoAgregacion = readField();
//            }
//            
//            if(nombreInsumo.contains("Semisólido")){
//                nombreInsumo = nombreInsumo.replace("Semisólido", "");
//                estadoAgregacion = "Semisólido";
//            } else{
//                skipBlank();
//                estadoAgregacion = readField();
//            }
//            
//            
//            skipBlank();
//            consumoAnual = readField();
//            skipBlank();
//            unidad = readField();
//            skipBlank();
//            aux = readField();
//            
//            if(aux.contains("SUSTANCIAS AUXILIARES UTILIZADAS")){
//                System.out.println("Hola");
//                almacenamiento = aux.replace("SUSTANCIAS AUXILIARES UTILIZADAS","");
//            }
//            
//        }
        
         String insumo = 
            "Nombre del insumo: " + nombreInsumo + "; \n" +
            "Estado físico de agregación: " + estadoAgregacion + "; \n" +
            "Consumo anual del insumo: " + consumoAnual + "; \n"+
            "Unidad de medida: " + unidad + "; \n"+
            "Almacenamiento: " + almacenamiento + "; \n";
        
        
        return insumo;
    }
    
}
