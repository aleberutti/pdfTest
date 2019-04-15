/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import static java.lang.Character.isLetter;
import java.util.ArrayList;
import java.util.Scanner;
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
    
    /**Método para leer una palabra y guardarla en un string*/
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
    
    /**Método para saltear una linea de texto*/
    public Integer skipLine(){
        
        while(text.charAt(index) != '\n' && text.charAt(index) != '\r'){
            index++;
        }
        index++;
        return index;
    }
    
    /**Método que saltea una palabra*/
    public Integer skipWord(){

        while ((text.charAt(index) != ' ' && text.charAt(index) != '\r')
                || ((text.charAt(index) == ' ')
                && (text.charAt(index + 1) != ' ' && (
                text.charAt(index + 1) != '\r' || text.charAt(index + 1) != '\n')))) {
            index++;
        }
        return index;
    }
   
    /**Método que saltea los caracteres en blanco*/
    private Integer skipBlank() {
        while (text.charAt(index) == ' ' || text.charAt(index) == '\r' || text.charAt(index) == '\n') {
            index++;
        }
        return index;
    }
    
    /**Método que permite saltear el pie de página de los pdfs*/
    public Integer skipFooter(){
        String sub = "(03482) 449189 | (342) 5112121";
        index = text.indexOf(sub,index) + sub.length();
    
        return index;
    }
    
    /**Método utilizado para debug. Permite pausar la ejecución del programa
    *y renaudar la misma mediante la pulsación de la tecla enter.
    */
    public void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }//usado para debuguear
   
    /**Método para obtener la lista de insumos utilizada por la planta
    *de producción
    */
   public ArrayList<ArrayList<String>> obtenerInsumos(){

	ArrayList<ArrayList<String>> insumos = new ArrayList<>();
        Integer indice = 0;
	String aux, nombreInsumo, estadoAgregacion, consumoAnual, unidad, almacenamiento;

	/*String insumo = 
            "Nombre del insumo: " + nombreInsumo + "; \n" +
            "Estado físico de agregación: " + estadoAgregacion + "; \n" +
            "Consumo anual del insumo: " + consumoAnual + "; \n"+
            "Unidad de medida: " + unidad + "; \n"+
            "Almacenamiento: " + almacenamiento + "; \n";*/

	String sub = "INSUMO";
	index = text.indexOf(sub) + sub.length();
	index = text.indexOf(sub, index) + sub.length();

	sub = "AGREGACIÓN";
	index = text.indexOf(sub, index) + sub.length();

	skipBlank();
	aux = readField();       
        
	while(StringUtils.isNumeric(aux) ||!(aux.replaceAll(" ", "").equals("SUSTANCIASAUXILIARESUTILIZADAS"))){
            //System.out.println(aux.replaceAll(" ", ""));
            if(StringUtils.isNumeric(aux)){ /*casos pdfs 3 y 5*/
                   // System.out.println("Entró en caso 3/5.");
                    insumos.add(new ArrayList<>());
                    indice++;
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
                    
                    insumos.get(indice - 1).add(nombreInsumo);
                    insumos.get(indice - 1).add(estadoAgregacion);
                    insumos.get(indice - 1).add(consumoAnual);
                    insumos.get(indice - 1).add(unidad);
                    insumos.get(indice - 1).add(almacenamiento);
                    
                    /*insumo = 
                        "Nombre del insumo: " + nombreInsumo + "; \n" +
                        "Estado físico de agregación: " + estadoAgregacion + "; \n" +
                        "Consumo anual del insumo: " + consumoAnual + "; \n"+
                        "Unidad de medida: " + unidad + "; \n"+
                        "Almacenamiento: " + almacenamiento + "; \n";*/

                    //insumos.add(insumo);
                    skipBlank();
                    aux = readField();
                    //System.out.println("Aux: " + aux);
            }

	    if(aux.equals("Firma y Aclaración")){ //casos pdfs 2 y 4
	    	//System.out.println("Entró en caso 2/4.");
                indice++;
                insumos.add(new ArrayList<>());
                
                skipFooter();
                skipBlank();
                aux = readField();
                //System.out.println("Valor de Aux al inicio del caso: " + aux);
                //promptEnterKey();
                if(StringUtils.isNumeric(aux)){ 
	            skipBlank();
	            nombreInsumo = readField();
                    //System.out.println(nombreInsumo);
	            skipBlank();
	            estadoAgregacion = readField();
                    //System.out.println(estadoAgregacion);
	            skipBlank();
	            consumoAnual = readField();
                    //System.out.println(consumoAnual);
	            skipBlank();
	            unidad = readField();
                    //System.out.println(unidad);
	            skipBlank();
	            almacenamiento = readField();
                    //System.out.println(almacenamiento);
                    
                    insumos.get(indice - 1).add(nombreInsumo);
                    insumos.get(indice - 1).add(estadoAgregacion);
                    insumos.get(indice - 1).add(consumoAnual);
                    insumos.get(indice - 1).add(unidad);
                    insumos.get(indice - 1).add(almacenamiento);
                    	            
                    skipBlank();
                    aux = readField();
                    //System.out.println("Valor de Aux al final del caso: " + aux);
                    //promptEnterKey();
                }
	    }

	    if(!aux.equals("Firma y Aclaración") && !StringUtils.isNumeric(aux) && 
                    !(aux.replaceAll(" ", "").equals("SUSTANCIASAUXILIARESUTILIZADAS")) ){
                // casos pdfs 1 y 6
                indice++;
                insumos.add(new ArrayList<>());
                
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
                    
                    insumos.get(indice - 1).add(nombreInsumo);
                    insumos.get(indice - 1).add(estadoAgregacion);
                    insumos.get(indice - 1).add(consumoAnual);
                    insumos.get(indice - 1).add(unidad);
                    insumos.get(indice - 1).add(almacenamiento);
                                        
                    skipBlank();
                    aux = readField();
                }
	    }
	}
	return insumos;
}
   
   /**Método para obtener la lista de sustancias auxiliares utilizada por 
   la planta de producción.
   */
   public ArrayList<ArrayList<String>> obtenerSustAuxiliares(){
       ArrayList<ArrayList<String>> sustAuxiliares = new ArrayList<>();
       String sustancias, consumo, unidad, almacenamiento;
       Integer indice = 0;
       String sub = "SUSTANCIA";
       index = text.indexOf(sub);
       sub = "ANUAL";
       
       if(text.indexOf(sub,index) != -1){
           index = text.indexOf(sub,index) + sub.length();
           String aux,aux1;
           
           skipBlank();
           aux = readField();

           while(!aux.replace(" ","").equals("LAY-OUT,DIAGRAMADEFLUJOSyRELEVAMIENTOFOTOGRÁFICO:(Sepresentaenformatodigitalyen")){
               if(StringUtils.isNumeric(aux)){ //casos pdfs 2 y 4
                    indice++;
                    sustAuxiliares.add(new ArrayList<>());
                    
                    skipBlank();
                    sustancias = readField();
                    skipBlank();
                    consumo = readField();
                    skipBlank();
                    unidad = readField();
                    skipBlank();
                    almacenamiento = readField();
                    skipBlank();       
                    
                    sustAuxiliares.get(indice - 1).add(sustancias);
                    sustAuxiliares.get(indice - 1).add(consumo);
                    sustAuxiliares.get(indice - 1).add(unidad);
                    sustAuxiliares.get(indice - 1).add(almacenamiento);
               }
               else{ //casos pdfs 1 y 6
                   indice++;
                   sustAuxiliares.add(new ArrayList<>());
                   
                   sustancias = aux;
                   skipBlank();
                   almacenamiento = readField();
                   skipBlank();
                   aux1 = readField();
                   skipBlank();
                   consumo = readField();
                   skipBlank();
                   unidad = readField();
                   skipBlank();
                   sustancias += readField();
                   skipBlank();
                   almacenamiento += readField();
                   
                   sustAuxiliares.get(indice - 1).add(sustancias);
                   sustAuxiliares.get(indice - 1).add(consumo);
                   sustAuxiliares.get(indice - 1).add(unidad);
                   sustAuxiliares.get(indice - 1).add(almacenamiento);  
               }
               skipBlank();
               aux = readField();
            }     
       }
       return sustAuxiliares;
   }
   
   /**Método para obtener los nombres de los archivos correspondientes al 
   * lay-out de la planta, diagrama de proceso productivo, y relevamiento 
   * fotografico
   */
   public ArrayList<String> obtenerArchivosLayOut(){ 
       ArrayList<String> archivos = new ArrayList<>();
       
       String sub, aux, diagFlujo, layOut, relevFotografico;
       
       sub = "LAY-OUT";
       index = text.indexOf(sub);
       //caso pdf 1
       sub = "2.1";
       index = text.indexOf(sub);
       
       skipLine();
       skipBlank();
       diagFlujo = readField();
       //System.out.println("Diagrama de Flujo: " + diagFlujo);
       skipBlank();
       aux = readField();
       //System.out.println("Aux: " + aux);
       
       if(aux.equals("Firma y Aclaración")){//caso pdf 5
           skipFooter();
       }
       
       if(aux.replace(" ","").equals("2.2NombredelarchivocorrespondientealLayoutdelaplantay/oLayoutdemáquinasyequipos")){
            skipBlank();
            layOut = readField();
            //System.out.println("Layout: " + layOut);
       } else{
            skipBlank();
            skipLine();
            skipBlank();
            layOut = readField();
            //System.out.println("Layout: " + layOut);
       }
       
       sub = "estado del predio):";
       index = text.indexOf(sub, index) + sub.length();
       skipBlank();
       relevFotografico = readField();
       skipBlank();
       aux = readField();
       
       if(!aux.equals("Firma y Aclaración") && !aux.replace(" ", "").equals("3.LOCALIZACIÓN")){//caso pdf 2, 3, 4
           relevFotografico += aux;
       }
       //System.out.println("Relevamiento Fotográfico: " + relevFotografico);
       
       archivos.add(diagFlujo);
       archivos.add(layOut);
       archivos.add(relevFotografico);
       
       return archivos;
   }
   
   /**Método para obtener el domicilio real de la planta*/
   public ArrayList<String> obtenerDomRealPlanta(){
       String sub, aux, aux1, calle, numCalle, 
               piso = null, 
               numDpto = null, 
               provincia = null, 
               departamento = null,
               localidad = null, 
               codPostal = null, 
               zonificacion = null, 
               nombreArchivo = null;
       Integer int1, int2, int3;
       ArrayList<String> datosDomReal = new ArrayList<>();
       
       sub = "3. LOCALIZACIÓN";
       index = text.indexOf(sub) + sub.length();
       sub = "DEPTO";
       index = text.indexOf(sub, index) + sub.length();
       skipBlank();
       
       calle = readField();
       skipBlank();
       numCalle = readField();
       int1 = index;
       skipBlank();
       aux = readField();
       int2 = index - aux.length();
       //System.out.println("Aux: " + aux);
       if(aux.replace(" ","").equals("PROVINCIA(*)")){
           //caso donde no hay ni piso ni numDpto
           //pdf 1
           sub = "CP (*)";
           index = text.indexOf(sub,index) + sub.length();
           skipBlank();
           provincia = readField();
           skipBlank();
           departamento = readField();
           skipBlank();
           localidad = readField();
           skipBlank();
           codPostal = readField();
           
           sub = "(Se presenta en formato digital y en papel)";
           index = text.indexOf(sub,index) + sub.length();
           skipBlank();
           zonificacion = readField();
           skipBlank();
           nombreArchivo = readField();
       } else {
           int3 = int2 - int1;
           if(int3 >= 18 && int3 <= 27){// caso donde encuentra primero el piso
               //pdfs 2, 3, 4 y 5
               //System.out.println("Posible Piso: " + aux);
               piso = aux;
               skipBlank();
               aux = readField();
               //System.out.println("Posible numDpto: " + aux);
               
               if(!aux.replace(" ","").equals("PROVINCIA(*)")){ //evaluo si se encuentra numDpto después de piso
                //pdfs 2, 3 y 4   
                numDpto = aux;  
               }           
               sub = "CP (*)";
               index = text.indexOf(sub,index) + sub.length();
               skipBlank();
               provincia = readField();
               skipBlank();
               departamento = readField();
               skipBlank();
               localidad = readField();
               skipBlank();
               codPostal = readField();
               
               sub = "(Se presenta en formato digital y en papel)";
               index = text.indexOf(sub,index) + sub.length();
               skipBlank();
               zonificacion = readField();
               skipBlank();
               nombreArchivo = readField();
               
           } else {
               if(int3 >= 30){ //caso donde no hay piso, sólo numDpto
                    //pdf 6
                    //System.out.println("Posible numDpto: " + aux);
                    numDpto = aux;
                   
                    sub = "CP (*)";
                    index = text.indexOf(sub,index) + sub.length();
                    skipBlank();
                    provincia = readField();
                    skipBlank();
                    departamento = readField();
                    skipBlank();
                    localidad = readField();
                    skipBlank();
                    codPostal = readField();

                    sub = "(Se presenta en formato digital y en papel)";
                    index = text.indexOf(sub,index) + sub.length();
                    skipBlank();
                    zonificacion = readField();
                    skipBlank();
                    nombreArchivo = readField();
               }
           }
       }
       
       datosDomReal.add(calle);
       datosDomReal.add(numCalle);
       datosDomReal.add(piso);
       datosDomReal.add(numDpto);
       datosDomReal.add(provincia);
       datosDomReal.add(departamento);
       datosDomReal.add(localidad);
       datosDomReal.add(codPostal);
       datosDomReal.add(zonificacion);
       datosDomReal.add(nombreArchivo);
     
       return datosDomReal;
   }
   
   /**Método para obtener los inmuebles anexos a la planta con sus
   * respectivas actividades
   */
   public ArrayList<ArrayList<String>> obtenerInmueblesAnexos(){
       ArrayList<ArrayList<String>> inmueblesAnexos = new ArrayList<>();
       String sub, aux, domicilio, actividad;
    
       sub = "EXISTEN INMUEBLES";
       index = text.indexOf(sub);
       sub = "ACTIVIDAD DESARROLLADA";
       index = text.indexOf(sub,index) + sub.length();
       skipBlank();
       skipWord();
       Character num = text.charAt(index-1);
       skipBlank();
       aux = readField();
       //System.out.println("Num: " + num);
       //System.out.println("Aux: " + aux);
       
       if(StringUtils.isNumeric(Character.toString(num))){
           while (!aux.replace(" ", "").equals("ENERGÍAELÉCTRICA:")){
               ArrayList<String> inmueble = new ArrayList<>();
               domicilio = aux;
               //System.out.println("Domicilio: " + domicilio);
               //promptEnterKey();
               
               skipBlank();
               actividad = readField();
               //System.out.println("Actividad Dom: " + actividad);
               //promptEnterKey();
               
               skipBlank();
               skipWord();//saltea la X al final de cada linea
               skipBlank();
               skipWord();
               skipBlank();
               aux = readField();
               
               inmueble.add(domicilio);
               inmueble.add(actividad);
               inmueblesAnexos.add(inmueble); 
           }
       }
       return inmueblesAnexos;
   }
   
   /**Método para obtener las dimensiones de la planta*/
   public ArrayList<String> obtenerDimensionamiento(){
       ArrayList<String> dimensiones = new ArrayList<>();
       String sub, supTotal, supCubierta, potenciaInstalada = null, dotPersonal = null, aux;
       
       sub = "4. DIMENSIONAMIENTO";
       index = text.indexOf(sub);
       sub = "SUPERFICIE CUBIERTA (en m2): (*)";
       index = text.indexOf(sub,index) + sub.length();
       
       skipBlank();
       supTotal = readField();
       //System.out.println("supTotal: " + supTotal);
       skipBlank();
       supCubierta = readField();
       //System.out.println("supCubierta: " + supCubierta);
       skipBlank();
       aux = readField();
       
       if(aux.equals("Firma y Aclaración")){
           skipFooter();
           skipBlank();
           skipLine();
           skipBlank();
           potenciaInstalada = readField();
           //System.out.println("potenciaInstalada: " + potenciaInstalada);
           skipBlank();
           dotPersonal = readField();
           //System.out.println("dotPersonal: " + dotPersonal);
       }
       else{
           if(aux.replace(" ", "").equals("POTENCIAINSTALADA(enHP):(*)")){
               skipLine();
               skipBlank();
               potenciaInstalada = readField();
               //System.out.println("potenciaInstalada: " + potenciaInstalada);
               skipBlank();
               dotPersonal = readField();
               //System.out.println("dotPersonal: " + dotPersonal);
           }
       }
       dimensiones.add(supTotal);
       dimensiones.add(supCubierta);
       dimensiones.add(potenciaInstalada);
       dimensiones.add(dotPersonal);
       
       return dimensiones;
   }
   
   /**Método para obtener la conformación del personal de la planta*/
   public ArrayList<ArrayList<String>> obtenerFormacionDePersonal(){
       ArrayList<ArrayList<String>> formacionPersonal = new ArrayList<>();
       String sub, cantObreros, espObreros, cantTecnicos, espTecnicos, cantProfesionales, espProfesionales;
       
       sub = "FORMACIÓN  DE PERSONAL:";
       index = text.indexOf(sub) + sub.length();
      
       //levanto info de obreros
       sub = "Obreros:";
       index = text.indexOf(sub,index) + sub.length();
       sub = "Cantidad:";
       index = text.indexOf(sub,index) + sub.length();
       skipBlank();
       cantObreros = readField();
       //System.out.println("cantObreros: " + cantObreros);
       sub = "Capacitación/";
       index = text.indexOf(sub,index) + sub.length();
       skipBlank();
       espObreros = readField();
       //System.out.println("espObreros: " + espObreros);
       
       //levanto info de tecnicos
       sub = "Técnicos:";
       index = text.indexOf(sub,index) + sub.length();
       sub = "Cantidad:";
       index = text.indexOf(sub,index) + sub.length();
       skipBlank();
       cantTecnicos = readField();
       //System.out.println("cantTecnicos: " + cantTecnicos);
       sub = "Capacitación/";
       index = text.indexOf(sub,index) + sub.length();
       skipBlank();
       espTecnicos = readField();
       //System.out.println("espTecnicos: " + espTecnicos);
       
       //levanto info de profesionales
       sub = "Profesionales:";
       index = text.indexOf(sub,index) + sub.length();
       sub = "Cantidad:";
       index = text.indexOf(sub,index) + sub.length();
       skipBlank();
       cantProfesionales = readField();
       //System.out.println("cantProfesionales: " + cantProfesionales);
       sub = "Capacitación/";
       index = text.indexOf(sub,index) + sub.length();
       skipBlank();
       espProfesionales = readField();
       //System.out.println("espTecnicos: " + espProfesionales);
       
       ArrayList<String> obreros = new ArrayList<>();
       ArrayList<String> tecnicos = new ArrayList<>();
       ArrayList<String> profesionales = new ArrayList<>();
       
       obreros.add(cantObreros);
       obreros.add(espObreros);
       tecnicos.add(cantTecnicos);
       tecnicos.add(espTecnicos);
       profesionales.add(cantProfesionales);
       profesionales.add(espProfesionales);
       formacionPersonal.add(obreros);
       formacionPersonal.add(tecnicos);
       formacionPersonal.add(profesionales);
       
       return formacionPersonal;
   }
   
   /**
    * Método para obtener emisiones gaseosas de componentes naturales
     *  
    */
   public ArrayList<ArrayList<String>> obtenerEmisionGaseosaNatural(){
       ArrayList<ArrayList<String>> emisionGas = new ArrayList<>();
       String sub,emision, proceso, tratamiento, aux;
       Integer point1, point2, flag = 0;
       
       sub = "GASEOSAS";
       index = text.indexOf(sub);
       sub = "No";
       index = text.indexOf(sub, index) + sub.length();
       skipBlank();
       aux = readField();
       //System.out.println("Aux: " + aux);
       
       if(aux.replace(" ","").equals("¿Poseeemisionesdegasesdecombustióndecombustibleslíquidos?(*)")){
           //caso pdf 5
           //System.out.println("No hay emisiones gaseosas provenientes de insumos naturales.");
           return emisionGas;
       } 
       else
       {
           
           if(aux.replace(" ","").equals("FirmayAclaración")){
           skipFooter();
           }
           if(aux.equals("EMISIÓN")){
               //System.out.println("Reconoció Emision");
               sub = "TRATAMIENTO";
               index = text.indexOf(sub,index) + sub.length();
               point1 = index;
               skipBlank();
               aux = readField();
               //System.out.println("Aux: " + aux);
               point2 = index - aux.length();
               //System.out.println("Espacios hasta la sig palabra antes de loopear: " + (point2 - point1));
               
               if((point2 - point1) <= 30){
                   //casos pdf 2 y 4
                   index = index - aux.length();
                   
                   while(!aux.replace(" ","").equals("Agregarfila")){
                       ArrayList<String> fila = new ArrayList<>();
                       
                       if (flag == 0){
                           aux = readField();
                           flag = 1;
                       }
                       emision = aux;
                       //System.out.println("Emisión: " + emision);
                       skipBlank();
                       proceso = readField();
                       //System.out.println("Proceso: " + proceso);
                       skipBlank();
                       tratamiento = readField();
                       //System.out.println("Tratamiento: " + tratamiento);
                       skipBlank();
                       aux = readField();
                       //System.out.println("Aux: " + aux);
                       fila.add(emision);
                       fila.add(proceso);
                       fila.add(tratamiento);
                       emisionGas.add(fila);
                   }
               }
               else{
                   /*casos pdfs 1 y 6 -> DETALLE: El código está asquerosamente harcodeado, dado que hay campos
                    distintos con sólo un caracter en blanco de separación, con lo que es imposible de distinguir cuando
                    tenemos una palabra distinta en el mismo campo de una palabra distinta en otro campo. Específicamente 
                    los campos son proceso y tratamiento.
                   */
                   //index = index - aux.length();
                   String strSplit[];
                   //promptEnterKey();
                   while(!aux.replace(" ","").equals("Agregarfila")){
                       ArrayList<String> fila = new ArrayList<>();
                       if (flag == 0){
                           strSplit = aux.split("\\s");
//                           promptEnterKey();
//                           System.out.println("strSplit[0]");
//                           System.out.println(strSplit[0]);
//                           promptEnterKey();
//                           System.out.println("strSplit[1]");
//                           System.out.println(strSplit[1]);
                           flag = 1;
                       }
                       strSplit = aux.split("\\s");
                       proceso = strSplit[0];
//                       System.out.println("Proceso: " + proceso);
//                       skipBlank();
                       tratamiento = strSplit[1];
//                       System.out.println("Tratamiento: " + tratamiento);
                       skipBlank();
                       emision = readField();
//                       System.out.println("Emisión: " + emision);
                       skipBlank();
                       proceso += readField();
//                       System.out.println("Proceso: " + proceso);
                       skipBlank();
                       tratamiento += readField();
//                       System.out.println("Tratamiento: " + tratamiento);
                       skipBlank();
                       aux = readField();
                       fila.add(emision);
                       fila.add(proceso);
                       fila.add(tratamiento);
                       emisionGas.add(fila);
//                       promptEnterKey();
                   }
               }
               
           }
           else{
               skipBlank();
               aux = readField();
               if(aux.replace(" ","").equals("¿Poseeemisionesdegasesdecombustióndecombustibleslíquidos?(*)")){
                   //caso pdf 3
                   //System.out.println("Entro a emisiones de comb liquidos despues de skipFooter();");
                   return emisionGas;
                }
            }     
        
        }
     return emisionGas;
   }  
   /** método que retorna la lista de gases emitidos por la combustión de 
    * combustibles líquidos
   */
     
public ArrayList<ArrayList<String>> obtenerEmisionGasCombustion(){
    ArrayList<ArrayList<String>> emisionGas = new ArrayList<>();
    String sub, aux, emision, proceso, tratamiento, strSplit[];
    
    sub = "combustibles líquidos? (*)";
    index = text.indexOf(sub);
    sub = "No";
    index = text.indexOf(sub,index) + sub.length();
    //index = text.indexOf(sub,index) + sub.length();
    skipBlank();
    aux = readField();
    System.out.println("Aux: " + aux);
    
    switch(aux.replace(" ","")){
        
        case "FirmayAclaración": 
            skipFooter();
            skipBlank();
            aux = readField();
            if (aux.replace(" ","").equals("EMISIÓN")){
                
                sub = "TRATAMIENTO";
                skipBlank();
                aux = readField();
                index = index - aux.length();
                //caso pdfs 2 y 5
                if(aux.length() < 30){
                    while(!aux.replace(" ","").equals("Agregarfila")){
                    ArrayList<String> fila = new ArrayList<>();
                    index = index - aux.length();
                    emision = readField();
                    skipBlank();
                    proceso = readField();
                    skipBlank();
                    tratamiento = readField();
                    skipBlank();
                    aux = readField();
                    
                    fila.add(emision);
                    fila.add(proceso);
                    fila.add(tratamiento);
                    emisionGas.add(fila);
                    }        
                }
                else { // caso pdf 6
                    while(!aux.replace(" ","").equals("Agregarfila")){
                        ArrayList<String> fila = new ArrayList<>();
                        index = index - aux.length();
                        skipBlank();
                        aux = readField();
                        strSplit = aux.split("\\s");
                        emision = strSplit[0];
                        proceso = strSplit[1];
                        tratamiento = strSplit[2];
                        skipBlank();
                        emision += readField();
                        skipBlank();
                        proceso += readField();
                        skipBlank();
                        tratamiento +=readField();
                        aux = readField();
                        
                        fila.add(emision);
                        fila.add(proceso);
                        fila.add(tratamiento);
                        emisionGas.add(fila);
                    }
                }
                
            }
            break;
        
        case "EMISIÓN":
            skipBlank();
            aux = readField();
            System.out.println("Aux despues de emision1: " + aux);
            skipBlank();
            aux = readField();
            System.out.println("Aux despues de emision2: " + aux);
            skipBlank();
            aux = readField();
            System.out.println("Aux despues de emision3: " + aux);
            promptEnterKey();
            if(aux.replace(" ","").equals("FirmayAclaración")){
                skipFooter();
            }
            //caso pdf1 
            if(aux.length() > 30){
                while(!aux.replace(" ","").equals("Agregarfila")){
                    ArrayList<String> fila = new ArrayList<>();
                    //index = index - aux.length();
                    skipBlank();
                    aux = readField();
                    System.out.println("Aux dentro del while: " + aux);
                    strSplit = aux.split("\\s");
                    emision = strSplit[0];
                    proceso = strSplit[1];
                    tratamiento = strSplit[2];
                    skipBlank();
                    emision += readField();
                    skipBlank();
                    proceso += readField();
                    skipBlank();
                    tratamiento +=readField();
                    aux = readField();

                    fila.add(emision);
                    fila.add(proceso);
                    fila.add(tratamiento);
                    emisionGas.add(fila);
                }
            }
            else { //caso pdf 4
                while(!aux.replace(" ","").equals("Agregarfila")){
                    System.out.println("Entro en el caso 4");
                    ArrayList<String> fila = new ArrayList<>();
                    index = index - aux.length();
                    emision = readField();
                    skipBlank();
                    proceso = readField();
                    skipBlank();
                    tratamiento = readField();
                    skipBlank();
                    aux = readField();
                    
                    fila.add(emision);
                    fila.add(proceso);
                    fila.add(tratamiento);
                    emisionGas.add(fila);
                }        
            }
            break;
            
        case "¿Poseeemisionesdegasesnocontempladosenlaspreguntasanteriores?(*)":
            break;
    }
    
    
    


    return emisionGas;
    }  
}

