/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author MODERNIZACION05
 */
public class LectorPDFImpreso47V extends LectorPDFImpreso47 {

    public LectorPDFImpreso47V(StringBuilder text) {
        super(text);
    }

    public ArrayList<ArrayList<String>> obtenerPartidasInm() {
        ArrayList<ArrayList<String>> partidas = new ArrayList<>();

        String sub = "Nombre del archivo correspondiente a la foto satelital de ubicación";
        index = text.indexOf(sub) + sub.length();
        sub = "digital y en papel)";
        index = text.indexOf(sub, index) + sub.length();
        sub = "COORDENADAS GEOGRÁFICAS:";
        index = text.indexOf(sub, index) + sub.length();
        sub = "LONG:";
        index = text.indexOf(sub, index) + sub.length();

        skipBlank();
        @SuppressWarnings("UnusedAssignment")
        String temp = readField();
        do {
            partidas.add(new ArrayList<>());
            skipBlank();
            partidas.get(partidas.size() - 1).add(readField());
            skipBlank();
            partidas.get(partidas.size() - 1).add(readField());
            skipBlank();
            partidas.get(partidas.size() - 1).add(readField());
            skipBlank();
            temp = readField();
        } while (StringUtils.isNumeric(temp));

        return partidas;
    }

    public ArrayList<ArrayList<String>> obtenerNomina() {
        ArrayList<ArrayList<String>> nomina = new ArrayList<>();

        String sub = "AUTORIDADES SOCIETARIAS - NÓMINA DEL DIRECTORIO";
        index = text.indexOf(sub) + sub.length();
        sub = "DOCUMENTO";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String temp = readField();

        if (temp.contains("Firma y Aclaración")) {
            sub = "Hipólito Yrigoyen 1001 - Reconquista";
            index = text.indexOf(sub, index) + sub.length();
            sub = "(03482) 449189 | (342) 5112121";
            index = text.indexOf(sub, index) + sub.length();
            skipBlank();
            temp = readField();
        }
        while (StringUtils.isNumeric(temp)) {
            nomina.add(new ArrayList<>());
            skipBlank();
            nomina.get(nomina.size() - 1).add(readField());
            skipBlank();
            nomina.get(nomina.size() - 1).add(readField());
            skipBlank();
            nomina.get(nomina.size() - 1).add(readField());
            skipBlank();
            nomina.get(nomina.size() - 1).add(readField());
            skipBlank();
            temp = readField();
        }
        return nomina;
    }

    /**Devuelve el domicilioConstituido como String.
    Se pueden extraer parametros calle, 
    num, piso, dpto, localidad, depto, provincia, CP, tel y mail
     */
    public String obtenerDomicilioConst() {
        String domicilio = new String();

        String sub = "DOMICILIO CONSTITUIDO";
        index = text.indexOf(sub) + sub.length();
        if (index < 80) {
            sub = "DOMICILIO  CONSTITUIDO";
            index = text.indexOf(sub) + sub.length();
            if (index < 80) {
                sub = "DOMICILIO   CONSTITUIDO";
                index = text.indexOf(sub) + sub.length();
            }
        }
        sub = "DEPTO";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String calle = readField();

        skipBlank();
        String num = readField();
        String piso;
        String dpto;

        if (skipBlank() > 25) {
            piso = null;
            dpto = readField();
        } else {
            piso = readField();
            skipBlank();
            dpto = readField();
        }

        if ("PROVINCIA".equals(dpto)) {
            dpto = null;
        }

        sub = "LOCALIDAD";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String provincia = readField();
        provincia = WordUtils.capitalizeFully(provincia);

        skipBlank();
        String depto = readField();
        depto = WordUtils.capitalizeFully(depto);

        skipBlank();
        String loc = readField();
        loc = WordUtils.capitalizeFully(loc);

        sub = "EMAIL";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String cp = readField();

        skipBlank();
        String tel = readField();

        skipBlank();
        String mail = readField();

        domicilio += calle;
        domicilio += ' ' + num;
        domicilio += ", Piso " + piso;
        domicilio += ", Depto " + dpto + ",\n";
        domicilio += loc + ", " + depto + ", " + provincia + "\n";
        domicilio += "CP " + cp + "\n";
        domicilio += "Tel.: " + tel + "\n";
        domicilio += "E-mail: " + mail;

        return domicilio;
    }

    /**Devuelve el domicilioLegal como String.
    Se pueden extraer parametros calle, 
    num, piso, dpto, localidad, depto, provincia, CP, tel y mail
     */
    public String obtenerDomicilioLegal() {
        String domicilio = new String();

        String sub = "DEPTO";
        index = text.indexOf(sub) + sub.length();
        skipBlank();
        String calle = readField();

        skipBlank();
        String num = readField();

        String piso;
        String dpto;

        if (skipBlank() > 25) {
            piso = null;
            dpto = readField();
        } else {
            piso = readField();
            skipBlank();
            dpto = readField();
        }

        if (dpto.contains("PROVINCIA")) {
            dpto = null;
        }

        sub = "LOCALIDAD";
        index = text.indexOf(sub, index) + sub.length();
        sub = "(*)";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String provincia = readField();
        provincia = WordUtils.capitalizeFully(provincia);

        skipBlank();
        String depto = readField();
        depto = WordUtils.capitalizeFully(depto);

        skipBlank();
        String loc = readField();
        loc = WordUtils.capitalizeFully(loc);

        sub = "EMAIL";
        index = text.indexOf(sub, index) + sub.length();
        sub = "(*)";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String cp = readField();

        skipBlank();
        String tel = readField();

        skipBlank();
        String mail = readField();

        domicilio += calle;
        domicilio += ' ' + num;
        domicilio += ", Piso " + piso;
        domicilio += ", Depto " + dpto + ",\n";
        domicilio += loc + ", " + depto + ", " + provincia + "\n";
        domicilio += "CP " + cp + "\n";
        domicilio += "Tel.: " + tel + "\n";
        domicilio += "E-mail: " + mail;

        return domicilio;
    }

    /**Devuelve el domicilioConstituido como String.
    Se pueden extraer parametros calle, 
    num, piso, dpto, localidad, depto, provincia, CP, tel,
    tipo de zonificacion y mail
     */
    public String obtenerDomicilioReal() {
        String domicilio = new String();

        String sub = "DOMICILIO REAL";
        index = text.indexOf(sub) + sub.length();
        sub = "DEPTO";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String calle = readField();

        skipBlank();
        String num = readField();

        String piso;
        String dpto;
        Integer t = skipBlank();
        if (t < 9) {
            piso = null;
            dpto = null;
        } else {
            if (t > 27) {
                piso = null;
                dpto = readField();
            } else {
                piso = readField();
                skipBlank();
                dpto = readField();
            }

            if (dpto.contains("PROVINCIA")) {
                dpto = null;
            }
        }

        sub = "LOCALIDAD";
        index = text.indexOf(sub, index) + sub.length();
        sub = "(*)";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String provincia = readField();
        provincia = WordUtils.capitalizeFully(provincia).trim().replaceAll(" +", " ");

        skipBlank();
        String depto = readField();
        depto = WordUtils.capitalizeFully(depto).trim().replaceAll(" +", " ");

        skipBlank();
        String loc = readField();
        loc = WordUtils.capitalizeFully(loc).trim().replaceAll(" +", " ");

        sub = "TELÉFONO/FAX";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String cp = readField();

        skipBlank();
        String tel = readField();

        sub = "ZONIFICACIÓN (*)";
        index = text.indexOf(sub, index) + sub.length();
        sub = "EMAIL";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String zonificacion = readField();
        if ("(*)".equals(zonificacion)) {
            skipBlank();
            zonificacion = readField();
        }

        skipBlank();
        String mail = readField();

        domicilio += calle;
        domicilio += ' ' + num;
        domicilio += ", Piso " + piso;
        domicilio += ", Depto " + dpto + ",\n";
        domicilio += loc + ", " + depto + ", " + provincia + "\n";
        domicilio += "CP " + cp + "\n";
        domicilio += "Tel.: " + tel + "\n";
        domicilio += "Zonificacion: " + zonificacion + "\n";
        domicilio += "E-mail: " + mail;

        return domicilio;
    }

    public ArrayList<ArrayList<String>> obtenerAdministradores() {
        ArrayList<ArrayList<String>> admins = new ArrayList<>();

        String sub = "ADMINISTRADORES/REPRESENTANTES";
        index = text.indexOf(sub) + sub.length();
        sub = "DOCUMENTO";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String temp = readField();
        while (StringUtils.isNumeric(temp)) {
            admins.add(new ArrayList<>(4));
            skipBlank();
            admins.get(admins.size() - 1).add(readField());
            skipBlank();
            admins.get(admins.size() - 1).add(readField());
            skipBlank();
            admins.get(admins.size() - 1).add(readField());
            skipBlank();
            admins.get(admins.size() - 1).add(readField());
            skipBlank();
            temp = readField();
        }
        return admins;
    }

    public String obtenerDatosPlantaCatAmb() throws ParseException {
        String sub = "CATEGORIZACIÓN";
        index = text.indexOf(sub) + sub.length();
        sub = "PLANTA";
        index = text.indexOf(sub, index) + sub.length();
        sub = "(*)";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String datos = readField();
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String dateString = readField();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        datos += ",\nFecha inicio de actividades: " + date;
        return datos;
    }

    ArrayList<ArrayList<String>> obtenerPlantasFueraProv() {
        ArrayList<ArrayList<String>> plantasFuera = new ArrayList<>();
        String sub = "plantas ubicadas fuera de la provincia";
        index = text.indexOf(sub) + sub.length();
        sub = "LOCALIDAD";
        index = text.indexOf(sub, index) + sub.length();
        sub = "POSTAL";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String temp = readField();
        while (StringUtils.isNumeric(temp)) {
            plantasFuera.add(new ArrayList<>(4));
            skipBlank();
            plantasFuera.get(plantasFuera.size() - 1).add(readField());
            skipBlank();
            plantasFuera.get(plantasFuera.size() - 1).add(new String());
            plantasFuera.get(plantasFuera.size() - 1).add(new String());
            plantasFuera.get(plantasFuera.size() - 1).set(2, readField());
            skipBlank();
            plantasFuera.get(plantasFuera.size() - 1).set(1, readField());
            skipBlank();
            plantasFuera.get(plantasFuera.size() - 1).add(readField());
            skipBlank();
            temp = readField();
        }
        return plantasFuera;
    }

    public ArrayList<ArrayList<String>> obtenerProductos() {
        ArrayList<ArrayList<String>> productos = new ArrayList<>();
        String sub = "PRODUCTOS";
        index = text.indexOf(sub) + sub.length();
        sub = "AGREGACIÓN";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String temp = readField();
        while (!"Nº".equals(temp)) {
            if (CharUtils.isAsciiNumeric(temp.charAt(0))) {
                productos.add(new ArrayList<>(5));
                while (CharUtils.isAsciiNumeric(temp.charAt(0)) || temp.charAt(0) == ' ') {
                    index++;
                    temp = temp.substring(1);
                }
                productos.get(productos.size() - 1).add(temp);
                skipBlank();
                productos.get(productos.size() - 1).add(readField());
                skipBlank();
                productos.get(productos.size() - 1).add(readField());
                skipBlank();
                productos.get(productos.size() - 1).add(readField());
                skipBlank();
                productos.get(productos.size() - 1).add(readField());
                skipBlank();
                temp = readField();
            } else {
                productos.add(new ArrayList<>(5));
                skipBlank();
                while (CharUtils.isAsciiNumeric(text.charAt(index))) {
                    index++;
                }
                skipBlank();
                productos.get(productos.size() - 1).add(readField());
                skipBlank();
                productos.get(productos.size() - 1).add(readField());
                skipBlank();
                productos.get(productos.size() - 1).add(readField());
                skipBlank();
                productos.get(productos.size() - 1).add(readField());
                skipBlank();
                temp += readField();
                productos.get(productos.size() - 1).add(temp);
                skipBlank();
                temp = readField();
            }
            if (temp.contains("Firma")) {
                sub = "(342) 5112121";
                index = text.indexOf(sub, index) + sub.length();
                skipBlank();
                temp = readField();
            }
        }
        sub = "DE PRODUCTO";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        for (Integer i = 0; i < productos.size(); i++) {
            readField();
            skipBlank();
            productos.get(i).add(readField());

            if ("Otro".equals(productos.get(i).get(5))) {
                skipBlank();
                readField();
            }
            skipBlank();
        }
        return productos;
    }

    public ArrayList<ArrayList<String>> obtenerSubproductos() {
        ArrayList<ArrayList<String>> subproductos = new ArrayList<>();
        String sub = "SUBPRODUCTOS";
        index = text.indexOf(sub) + sub.length();
        sub = "AGREGACIÓN";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String temp = readField();
        while (!temp.contains("MATERIAS")) {
            if (CharUtils.isAsciiNumeric(temp.charAt(0))) {
                subproductos.add(new ArrayList<>(5));
                if (!StringUtils.isNumeric(temp)) {
                    while (CharUtils.isAsciiNumeric(temp.charAt(0)) || temp.charAt(0) == ' ') {
                        index++;
                        temp = temp.substring(1);
                    }
                    subproductos.get(subproductos.size() - 1).add(temp);
                } else {
                    skipBlank();
                    subproductos.get(subproductos.size() - 1).add(readField());
                }
                skipBlank();
                subproductos.get(subproductos.size() - 1).add(readField());
                skipBlank();
                subproductos.get(subproductos.size() - 1).add(readField());
                skipBlank();
                temp = "";
                while (text.charAt(index) != ' ') {
                    temp += text.charAt(index);
                    index++;
                }
                subproductos.get(subproductos.size() - 1).add(temp);
                skipBlank();
                subproductos.get(subproductos.size() - 1).add(readField());
                skipBlank();
                temp = readField();
            } else {
                subproductos.add(new ArrayList<>(5));
                skipBlank();
                readField();
                skipBlank();
                subproductos.get(subproductos.size() - 1).add(readField());
                skipBlank();
                subproductos.get(subproductos.size() - 1).add(readField());
                skipBlank();
                subproductos.get(subproductos.size() - 1).add(readField());
                skipBlank();
                subproductos.get(subproductos.size() - 1).add(readField());
                skipBlank();
                temp += readField();
                subproductos.get(subproductos.size() - 1).add(temp);
                skipBlank();
                temp = readField();
            }
            if (temp.contains("Firma")) {
                sub = "(342) 5112121";
                index = text.indexOf(sub, index) + sub.length();
                skipBlank();
                temp = readField();
            }
        }
        return subproductos;
    }

    ArrayList<ArrayList<String>> obtenerMateriasPrimas() {
        ArrayList<ArrayList<String>> materias = new ArrayList<>();
        String sub = "MATERIAS";
        index = text.indexOf(sub) + sub.length();
        sub = "PRIMAS";
        index = text.indexOf(sub, index) + sub.length();
        sub = "AGREGACIÓN";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String temp = readField();
        while (!temp.contains("INSUMOS")) {
            if (CharUtils.isAsciiNumeric(temp.charAt(0))) {
                materias.add(new ArrayList<>(5));
                if (!StringUtils.isNumeric(temp)) {
                    while (CharUtils.isAsciiNumeric(temp.charAt(0)) || temp.charAt(0) == ' ') {
                        index++;
                        temp = temp.substring(1);
                    }
                    materias.get(materias.size() - 1).add(temp);
                } else {
                    skipBlank();
                    materias.get(materias.size() - 1).add(readField());
                }
                skipBlank();
                materias.get(materias.size() - 1).add(readField());
                skipBlank();
                materias.get(materias.size() - 1).add(readField());
                skipBlank();
                temp = "";
                while (text.charAt(index) != ' ') {
                    temp += text.charAt(index);
                    index++;
                }
                materias.get(materias.size() - 1).add(temp);
                skipBlank();
                materias.get(materias.size() - 1).add(readField());
                skipBlank();
                temp = readField();
            } else {
                materias.add(new ArrayList<>(5));
                skipBlank();
                readField();
                skipBlank();
                materias.get(materias.size() - 1).add(readField());
                skipBlank();
                materias.get(materias.size() - 1).add(readField());
                skipBlank();
                materias.get(materias.size() - 1).add(readField());
                skipBlank();
                materias.get(materias.size() - 1).add(readField());
                skipBlank();
                temp += readField();
                materias.get(materias.size() - 1).add(temp);
                skipBlank();
                temp = readField();
            }
            if (temp.contains("Firma")) {
                sub = "(342) 5112121";
                index = text.indexOf(sub, index) + sub.length();
                skipBlank();
                temp = readField();
            }
        }
        return materias;
    }
    
    /**
     * Método para obtener la lista de insumos utilizados por la planta de producción
     * @return
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
   
    /**
     * 
     * @return 
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
   * @return
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
   
    /**
     * Método para obtener el domicilio real de la planta
     * @return 
     */
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
   
    /**
     * Método para obtener los inmuebles anexos de la planta con sus respectivas actividades.
     * @return 
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
   
    /**
     * Método para obtener las dimensiones de la planta
     * @return
     */
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
   
    /**
     * Método para obtener la conformación del personal de la planta
     * @return
     */
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
    * @return 
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
    * combustibles líquidos.
    * @return
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
       //System.out.println("Aux: " + aux);

        switch(aux.replace(" ","")){

            case "FirmayAclaración": //2, 5 y 6
                skipFooter();
                skipBlank();
                aux = readField();
                if (aux.replace(" ","").equals("EMISIÓN")){

                    sub = "TRATAMIENTO";
                    index = text.indexOf(sub,index) + sub.length();
                    skipBlank();
                    aux = readField(); //Emision 3
                    //System.out.println("Aux 2, 5 y 6: " + aux);
                    //promptEnterKey();
                    //index = index - aux.length();
                    //caso pdfs 2 y 5
                    if(aux.length() < 30){
                        while(!aux.replace(" ","").equals("Agregarfila")){
                        ArrayList<String> fila = new ArrayList<>();
                        //index = index - aux.length();
                        emision = aux;
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
                            //index = index - aux.length();
                            //skipBlank();
                            //aux = readField();
                            strSplit = aux.split("\\s");
                            emision = strSplit[0];
                            //System.out.println("emision: " + emision);
                            proceso = strSplit[1];
                            //System.out.println("proceso: " + proceso);
                            tratamiento = strSplit[2];
                            //System.out.println("tratamiento: " + tratamiento);
                            skipBlank();
                            emision += readField();
                            //System.out.println("emisionf: " + emision);
                            skipBlank();
                            proceso += readField();
                            //System.out.println("procesof: " + proceso);
                            skipBlank();
                            tratamiento +=readField();
                            //System.out.println("tratamientof: " + tratamiento);
                            skipBlank();
                            aux = readField();
                            //System.out.println("Aux al final del loop: " + aux);

                            fila.add(emision);
                            fila.add(proceso);
                            fila.add(tratamiento);
                            emisionGas.add(fila);
                        }
                    }

                }
                break;

            case "EMISIÓN": //1 y 4
                sub = "TRATAMIENTO";
                index = text.indexOf(sub,index) + sub.length();
                skipBlank();
                aux = readField();
                //System.out.println("Aux caso 1 y 4: " + aux);
                if(aux.replace(" ","").equals("FirmayAclaración")){
                    skipFooter();
                    skipBlank();
                    aux = readField();
                    //System.out.println("Aux caso 1 y 4 dentro de skipfooter: " + aux);
                    skipBlank();

                }
                //caso pdf1 
                if(aux.length() > 30){
                    while(!aux.replace(" ","").equals("Agregarfila")){
                        ArrayList<String> fila = new ArrayList<>();
                        //index = index - aux.length();
                        //skipBlank();
                        //aux = readField();
                       // System.out.println("Aux dentro del while: " + aux);
                        strSplit = aux.split("\\s");
                        emision = strSplit[0];
                        //System.out.println("Emision: " + emision);
                        proceso = strSplit[2];//se saltea una posicion porque guarda un caracter vacio
                        //System.out.println("Proceso: " + proceso);
                        tratamiento = strSplit[3];
                        //System.out.println("Tratamiento: " + tratamiento);
                        skipBlank();
                        emision += readField();
                        //System.out.println("Emision1: " + emision);
                        skipBlank();
                        proceso += readField();
                        //System.out.println("Proceso1: " + proceso);
                        skipBlank();
                        tratamiento +=readField();
                        //System.out.println("Tratamiento1: " + tratamiento);
                        skipBlank();
                        aux = readField();
                        //System.out.println("Aux fin de loop: " + tratamiento);
                        skipBlank();
                        fila.add(emision);
                        fila.add(proceso);
                        fila.add(tratamiento);
                        emisionGas.add(fila);
                    }
                }
                else { //caso pdf 4 //por ahora funciona
                    while(!aux.replace(" ","").equals("Agregarfila")){
                        //System.out.println("Entro en el caso 4");
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

    /**
     * Método que retorna la lista de gases emitidos no contemplados en el pdf
     * @return
     */
    public ArrayList<ArrayList<String>> obtenerEmisionGasNoContemplado(){
        ArrayList<ArrayList<String>> emisionGas = new ArrayList<>();
        String sub, aux, strArray[], proceso, componentes, tratamiento;

        //me posiciono en la zona
        sub = "anteriores? (*)";
        index = text.indexOf(sub) + sub.length();
        sub = "No";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        aux = readField();

        switch (aux.replace(" ","")){
            case "¿Enelestablecimientosegeneranefluentesoresiduoslíquidos?(*)": //caso 3
                break;

            case "PROCESO": //casos 1, 2 y 4
                sub = "TRATAMIENTO";
                index = text.indexOf(sub, index) + sub.length();
                skipBlank();
                aux = readField();
                //System.out.println("Aux caso 1 antes del if: " + aux);
                if(aux.length() > 32){ //caso 1
                    while(!aux.replace(" ","").equals("Agregarfila")){
                        ArrayList<String> fila = new ArrayList<>();
                        strArray = aux.split("\\s");
                        proceso = strArray[0];
                        componentes = strArray[1];
                        tratamiento = strArray[2];
                        skipBlank();
                        proceso += readField();
                        skipBlank();
                        componentes += readField();
                        skipBlank();
                        tratamiento += readField();
                        skipBlank();
                        aux = readField();

                        fila.add(proceso);
                        fila.add(componentes);
                        fila.add(tratamiento);
                        emisionGas.add(fila);
                        }
                }
                else{
                    //System.out.println("Entro a los casos 2 o 4.");
                    while(!aux.replace(" ","").equals("Agregarfila")){ //caso 2 y 4
                        ArrayList<String> fila = new ArrayList<>();
                        proceso = aux;
                        //System.out.println("Proceso :" + proceso);
                        skipBlank();
                        componentes = readField();
                        //System.out.println("Componentes: " + componentes);
                        skipBlank();
                        tratamiento = readField();
                        //System.out.println("Tratamiento: " + tratamiento);
                        skipBlank();
                        aux = readField();

                        fila.add(proceso);
                        fila.add(componentes);
                        fila.add(tratamiento);
                        emisionGas.add(fila);
                    }
                }
                break;
           
            case "PROCESOQUELOGENERA": //casos 5 y 6

                sub = "TRATAMIENTO";
                index = text.indexOf(sub, index) + sub.length();
                skipBlank();
                aux = readField();

                if(aux.length() > 32){ //caso 6
                    while(!aux.replace(" ","").equals("Agregarfila")){
                        ArrayList<String> fila = new ArrayList<>();
                        strArray = aux.split("\\s");
                        proceso = strArray[0];
                        componentes = strArray[1];
                        tratamiento = strArray[2];
                        skipBlank();
                        proceso += readField();
                        skipBlank();
                        componentes += readField();
                        skipBlank();
                        tratamiento += readField();
                        skipBlank();
                        aux = readField();

                        if(aux.replace(" ","").equals("FirmayAclaración")){
                            skipFooter();
                            skipBlank();
                            aux = readField();
                        }

                        fila.add(proceso);
                        fila.add(componentes);
                        fila.add(tratamiento);
                        emisionGas.add(fila);
                    }
                }
                else{
                    while(!aux.replace(" ","").equals("Agregarfila")){ //caso 5
                        ArrayList<String> fila = new ArrayList<>();
                        proceso = aux;
                        skipBlank();
                        componentes = readField();
                        skipBlank();
                        tratamiento = readField();
                        skipBlank();
                        aux = readField();

                        fila.add(proceso);
                        fila.add(componentes);
                        fila.add(tratamiento);
                        emisionGas.add(fila);
                    }
                }
                break;
        }
      return emisionGas;
    }
    
    /**
     * Método que retorna la lista de efluentes no peligrosos emitidos por la planta
     * @return
     */
    public ArrayList<ArrayList<String>> obtenerEfluenteNoPeligroso(){
      
        ArrayList<ArrayList<String>> efluentes = new ArrayList<>();
        String sub, aux, proceso, componentes, valor, volumen, unidadTiempo, gestion, cuerpoReceptor;

        sub = "https://www.santafe.gob.ar/index.php/content/view/full/10817/)";
        index = text.indexOf(sub) + sub.length();
        sub = "No";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        aux = readField();
        //System.out.println("aux antes del switch: " + aux);

        switch(aux.replace(" ","")){

            case "¿Loslíquidoscontienenresiduospeligrosopuedengenerarresiduospeligrosos?(*)":
                  //caso 1 y 6
                  break;

            case "FirmayAclaración":
                //caso 2
                skipFooter();
                skipBlank();
                aux = readField();
                //System.out.println("aux de case firma: " + aux);

                if(aux.replace(" ","").equals("¿Loslíquidoscontienenresiduospeligrosopuedengenerarresiduospeligrosos?(*)")){
                    break;
                }

                if(aux.equals("1X")){
                    //System.out.println("entro al if de 1X dentro de case firma");
                    while(!aux.replace(" ","").equals("Agregarefluente")){
                        ArrayList fila = new ArrayList<>();
                        sub = "GENERA";
                        index = text.indexOf(sub, index) + sub.length();
                        skipBlank();
                        proceso = readField();
                        //System.out.println("proceso " + proceso);
                        skipBlank();
                        skipWord();
                        skipBlank();
                        componentes = readField();
                        //System.out.println("componentes " + componentes);
                        sub = "CANTIDAD";
                        index = text.indexOf(sub, index) + sub.length();
                        skipBlank();
                        valor = readField();
                        //System.out.println("valor " + valor);
                        skipBlank();
                        volumen = readField();
                        //System.out.println("volumen " + volumen);
                        skipBlank();
                        unidadTiempo = readField();
                        //System.out.println("unidadTiempo " + unidadTiempo);
                        sub = "CUERPO";
                        index = text.indexOf(sub, index) + sub.length();
                        skipBlank();
                        cuerpoReceptor = readField();
                        //System.out.println("cuerpoReceptor " + cuerpoReceptor);
                        skipBlank();
                        skipWord();
                        skipBlank();
                        aux = readField();
                        //System.out.println("aux antes de volver a loopear " + aux);
                        

                        fila.add(proceso);
                        fila.add(componentes);
                        fila.add(valor);
                        fila.add(volumen);
                        fila.add(unidadTiempo);
                        fila.add(cuerpoReceptor);
                        efluentes.add(fila);

                        if(aux.replace(" ","").equals("FirmayAclaración")){
                            
                                skipFooter();
                                skipBlank();
                                aux = readField();
                        }  
                    }
                }

                  break;

            case "1X":

                  while(!aux.replace(" ","").equals("Agregarefluente")){
                        ArrayList fila = new ArrayList<>();
                        sub = "GENERA";
                        index = text.indexOf(sub, index) + sub.length();
                        skipBlank();
                        proceso = readField();
                        //System.out.println("Proceso: " + proceso);
                        skipBlank();
                        skipWord();
                        skipBlank();
                        componentes = readField();
                        //System.out.println("Componentes: " + componentes);
                        sub = "CANTIDAD";
                        index = text.indexOf(sub, index) + sub.length();
                        skipBlank();
                        valor = readField();
                        //System.out.println("Valor: " + valor);
                        skipBlank();
                        volumen = readField();
                        //System.out.println("Volumen: " + volumen);
                        skipBlank();
                        unidadTiempo = readField();
                        //System.out.println("unidadTiempo: " + unidadTiempo);
                        sub = "CUERPO";
                        index = text.indexOf(sub, index) + sub.length();
                        skipBlank();
                        cuerpoReceptor = readField();
                        //System.out.println("cuerpoReceptor: " + cuerpoReceptor);
                        skipBlank();
                        skipWord();
                        skipBlank();
                        aux = readField();

                        fila.add(proceso);
                        fila.add(componentes);
                        fila.add(valor);
                        fila.add(volumen);
                        fila.add(unidadTiempo);
                        fila.add(cuerpoReceptor);
                        efluentes.add(fila);

                        if(aux.replace(" ","").equals("FirmayAclaración")){
                              skipFooter();
                              skipBlank();
                              aux = readField();
                        }

                  }

                  break;
       }
    return efluentes;
    }
}