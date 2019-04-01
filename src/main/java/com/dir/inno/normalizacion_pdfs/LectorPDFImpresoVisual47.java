/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import static java.lang.Character.isLetter;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

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
        
        while(text.charAt(index) != '\n' && text.charAt(index) != '\r'){
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
        String sub = "(03482) 449189 | (342) 5112121";
        index = text.indexOf(sub,index) + sub.length();
    
        return index;
    }
   
   public ArrayList<String> obtenerInsumos(){

	ArrayList<String> insumos = new ArrayList<>();

	String aux = null;
	String nombreInsumo = null;
	String estadoAgregacion = null;
	String consumoAnual = null;
	String unidad = null;
	String almacenamiento = null;

	String insumo = 
            "Nombre del insumo: " + nombreInsumo + "; \n" +
            "Estado físico de agregación: " + estadoAgregacion + "; \n" +
            "Consumo anual del insumo: " + consumoAnual + "; \n"+
            "Unidad de medida: " + unidad + "; \n"+
            "Almacenamiento: " + almacenamiento + "; \n";

	String sub = "INSUMO";
	index = text.indexOf(sub) + sub.length();
	index = text.indexOf(sub, index) + sub.length();

	sub = "AGREGACIÓN";
	index = text.indexOf(sub, index) + sub.length();

	skipBlank();
	aux = readField();       
        
	while(StringUtils.isNumeric(aux) || !aux.replaceAll(" ", "").equals("SUSTANCIASAUXILIARESUTILIZADAS")){

            if(StringUtils.isNumeric(aux)){ /*casos pdfs 3 y 5*/
                    System.out.println("Entró en caso 3/5.");
                    skipBlank();
                    nombreInsumo = readField();
                    skipBlank();
                    estadoAgregacion = readField();
                    skipBlank();
                    consumoAnual = readField();
                    skipBlank();
                    unidad = readField();
                    skipBlank();
                    almacenamiento = readField();

                    insumo = 
                        "Nombre del insumo: " + nombreInsumo + "; \n" +
                        "Estado físico de agregación: " + estadoAgregacion + "; \n" +
                        "Consumo anual del insumo: " + consumoAnual + "; \n"+
                        "Unidad de medida: " + unidad + "; \n"+
                        "Almacenamiento: " + almacenamiento + "; \n";

                    insumos.add(insumo);
                    skipBlank();
                    aux = readField();
                    System.out.println("Aux: " + aux);
            }

	    if(aux.equals("Firma y Aclaración")){ //casos pdfs 2 y 4
	    	System.out.println("Entró en caso 2/4.");
                skipFooter();
                skipBlank();
                aux = readField();
                System.out.println(aux);
                if(StringUtils.isNumeric(aux)){ 

	            skipBlank();
	            nombreInsumo = readField();
	            skipBlank();
	            estadoAgregacion = readField();
	            skipBlank();
	            consumoAnual = readField();
	            skipBlank();
	            unidad = readField();
	            skipBlank();
	            almacenamiento = readField();

	            insumo = 
		            "Nombre del insumo: " + nombreInsumo + "; \n" +
		            "Estado físico de agregación: " + estadoAgregacion + "; \n" +
		            "Consumo anual del insumo: " + consumoAnual + "; \n"+
		            "Unidad de medida: " + unidad + "; \n"+
		            "Almacenamiento: " + almacenamiento + "; \n";
                    
                    insumos.add(insumo);
                    skipBlank();
                    aux = readField();
                }
	    }

	    if(!aux.equals("Firma y Aclaración") && !StringUtils.isNumeric(aux)){
                
                almacenamiento = aux;
                skipBlank();
                aux = readField();

                if(StringUtils.isNumeric(aux)){ 
                    skipBlank();
                    nombreInsumo = readField();                    
                    skipBlank();
                    estadoAgregacion = readField();                 
                    skipBlank();
                    consumoAnual = readField();
                    skipBlank();
                    unidad = readField();
                    skipBlank();
                    almacenamiento += readField();                   

                    insumo = 
                            "Nombre del insumo: " + nombreInsumo + "; \n" +
                            "Estado físico de agregación: " + estadoAgregacion + "; \n" +
                            "Consumo anual del insumo: " + consumoAnual + "; \n"+
                            "Unidad de medida: " + unidad + "; \n"+
                            "Almacenamiento: " + almacenamiento + "; \n";


                    insumos.add(insumo);
                    skipBlank();
                    aux = readField();
                }
	    }
	}
	return insumos;

}
    
}
