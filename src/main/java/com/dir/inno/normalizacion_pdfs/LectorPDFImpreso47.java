/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import com.snowtide.PDF;
import com.snowtide.pdf.Document;
import com.snowtide.pdf.OutputTarget;
import java.io.IOException;
import static java.lang.Character.isLetter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author MODERNIZACION05
 */
public class LectorPDFImpreso47 {
    
    protected Integer index;
    protected StringBuilder text;
    
    public LectorPDFImpreso47(StringBuilder text){
        this.text = text;
    }
    
    
    /*Obtener versión del documento
     */
    public String obtenerVersion() {
        String sub = "VERSIÓN", version = "", aux;
        //String[] texto = text.split("\n");
        
        Pattern patron = Pattern.compile("[[v|V]{1}[1-4]{1}\\.{1}[0-9]\\*]{1}");
        Matcher matcher = patron.matcher(text);
        while(matcher.find()){
            version += matcher.group(0);
        }
//        String sub = "VERSIÓN";
//        index = text.indexOf(sub) + sub.length();
//        while (text.charAt(index) == ' ') {
//            index++;
//        }
//        String version = text.substring(index, index + 3);
//        return version;
        
        /*index = text.indexOf(sub);
        if(!(index == -1)){
            index += sub.length();
            skipBlank();
            aux = readField();
            Matcher matcher = patron.matcher(aux);
            while(matcher.find()){
                version += matcher.group(0);
            }
        }
        else{
            Matcher matcher = patron.matcher(text);
            while(matcher.find()){
                version += matcher.group(0);
            }
        }*/
        return version; 
    }

    /*Obtener nombre/Razon social
     */
    public String obtenerNombre() {
        String sub = "NOMBRE COMPLETO / RAZÓN SOCIAL (*)";
        index = text.indexOf(sub) + sub.length();
        skipBlank();
        String nombre = new String();
        while ((text.charAt(index) != ' ' && text.charAt(index) != '\r')
                || ((text.charAt(index) == ' ')
                && (text.charAt(index + 1) != ' ' || text.charAt(index + 1) != '\r'))) {
            nombre += text.charAt(index);
            index++;
        }
        return nombre;
    }

    /*Obtener CUIT de la empresa
     */
    public Long obtenerCuit() {
        String sub = "ACTIVIDADES DE LA EMPRESA: (*)";
        index = text.indexOf(sub) + sub.length();
        skipBlank();
        String cuit = readField();
        skipBlank();
        cuit += readField();
        skipBlank();
        cuit += readField();
        Long cuitN = Long.parseLong(cuit);
        return cuitN;
    }

    /*Fecha de inicio de actividades, formato Date
     */
    public Date obtenerFechaInicioAct() throws ParseException {
        String sub = "ACTIVIDADES DE LA EMPRESA: (*)";
        index = text.indexOf(sub) + sub.length();
        skipBlank();
        index += 17;
        String dateString = new String();
        while (text.charAt(index) != '\r') {
            dateString += text.charAt(index);
            index++;
        }
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        return date;
    }

    /*Devuelve un Array de enteros conteniendo los códigos CUACM
    correspondientes a las actividades de la empresa.
     */
    public ArrayList<Integer> obtenerActividades() {
        ArrayList<Integer> actividadesEmpresa = new ArrayList<>();
        
        String sub = "CUACM";
        index = 0;
        do {
            index = text.indexOf(sub, index) + sub.length();
            skipBlank();
            String codigoString = readField();
            if (StringUtils.isNumeric(codigoString)) {
                Integer codigo = Integer.parseInt(codigoString);
                if (!actividadesEmpresa.contains(codigo)) {
                    actividadesEmpresa.add(codigo);
                }
            }
        } while (index != -1 && index < 8000);
        
        return actividadesEmpresa;
    }

    /*Funcion para mover el cursor hasta la proxima palabra ignorando espacios
    y saltos de linea*/
    protected Integer skipBlank() {
        Integer skipped = 0;
        while (text.charAt(index) == ' ' || text.charAt(index) == '\r' || text.charAt(index) == '\n') {
            index++;
            skipped++;
        }
        return skipped;
    }

    /*Método para leer un campo que puede contener espacios
    hasta encontrar un salto de linea o mas de un espacio, 
    dada una posicion de indice y el texto como parametros.
     */
    protected String readField() {
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

    /*Obtener los datos del representante legal (nombre, apellido, dni)
     */
    public String obtenerRepLegal() {
        
        String sub = "REPRESENTANTE LEGAL";
        index = text.indexOf(sub) + sub.length();
        sub = "N° DOCUMENTO";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String apellido = readField();
        apellido = WordUtils.capitalizeFully(apellido);
        
        skipBlank();
        String nombre = WordUtils.capitalizeFully(readField());
        
        skipBlank();
        String dniString = readField();
        Integer dni = Integer.parseInt(dniString);
        
        String rep = apellido + ' ' + nombre + ", " + dniString;
        return rep;
    }

    /* Permite obtener los datos del consultor, experto o perito;
    nombre y apellido, titulo y matrícula
     */
    public String obtenerConsultor() {
        String sub = "Si el consultor, perito o experto no se encuentra en el desplegable";
        index = text.indexOf(sub) + sub.length();
        sub = "REGISTRO";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String consultor = readField();
        if ("*".equals(consultor)) {
            skipBlank();
            consultor = readField();
        }
        consultor += ", ";
        consultor = WordUtils.capitalizeFully(consultor);
        skipBlank();
        consultor += readField() + ", ";
        skipBlank();
        consultor += readField();
        return consultor;
    }
    
    public String obtenerNombreArchivoFotoSat() {
        String sub = "Nombre del archivo correspondiente a la foto satelital de ubicación";
        index = text.indexOf(sub) + sub.length();
        sub = "digital y en papel)";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String nombre = readField();
        return nombre;
    }
    
    
    /*Saltea los caracteres hasta llegar a un salto de linea
    y posiciona el índice por delante del mismo
    */
    public Integer skipLine(){
        
        while(text.charAt(index) != '\n'){
            index++;
        }
        index++;
        return index;
    }
    /*Saltea caracteres y espacios de un caracter de tamaño,
    hasta llegar a un salto de línea o a un espacio mayor a un caracter.
    */
    public Integer skipWord(){

        while ((text.charAt(index) != ' ' && text.charAt(index) != '\r')
                || ((text.charAt(index) == ' ')
                && (text.charAt(index + 1) != ' ' && (
                text.charAt(index + 1) != '\r' || text.charAt(index + 1) != '\n')))) {
            index++;
        }
        return index;
    }
    
    public Integer skipFooter(){
        String sub = "(03482) 449189 | (342) 5112121";
        index = text.indexOf(sub,index) + sub.length();
    
        return index;
    }
    
    public void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }//usado para debuguear

}
