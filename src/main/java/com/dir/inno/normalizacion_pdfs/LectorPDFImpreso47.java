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
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author MODERNIZACION05
 */
public class LectorPDFImpreso47 {
    
    protected Integer index;
    protected final StringBuilder text;
    
    public LectorPDFImpreso47(StringBuilder text) {
        this.text = text;
    }

    /*Obtener versión del documento
     */
    public String obtenerVersion() {
        String sub = "VERSIÓN";
        index = text.indexOf(sub) + sub.length();
        while (text.charAt(index) == ' ') {
            index++;
        }
        String version = text.substring(index, index + 3);
        return version;
    }

    /*Obtener nombre/Razon social
     */
    public String obtenerNombre() {
        String sub = "NOMBRE COMPLETO / RAZÓN SOCIAL (*)";
        index = text.indexOf(sub) + sub.length();
        index = skipBlank();
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
        index = skipBlank();
        /*
        String cuit = text.substring(index, index + 2);
        index++;
        index += 2;
        while ((text.charAt(index + 1) != ' ' && text.charAt(index + 1) != '\r')
                || ((text.charAt(index + 1) == ' ')
                && (text.charAt(index + 2) != ' ' || text.charAt(index + 2) != '\r'))) {
            cuit += text.charAt(index + 1);
            index++;
        }
        index += 2;
        cuit += text.charAt(index + 1);
        String cuit2 = new String();
        for(Integer i = 0; i<cuit.length(); i++){
            if(Character.isDigit(cuit.charAt(i))) cuit2+=cuit.charAt(i);
        }
        Long cuitN = Long.parseLong(cuit2);
         */
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
        index = skipBlank();
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
        /*
        index = text.indexOf(sub) + sub.length();
        skipBlank();
        String codigoString = readField();
        while (index != -1 && !"ESTANDAR".equals(codigoString)) {
            Integer codigo = Integer.parseInt(codigoString);
            if (!actividadesEmpresa.contains(codigo)) {
                actividadesEmpresa.add(codigo);
            }
            skipBlank();
            codigoString = readField();
            index = text.indexOf(sub, index) + sub.length();
        }
         */
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

    /*Devuelve el domicilioLegal como String.
    Se pueden extraer parametros calle, 
    num, piso, dpto, localidad, depto, provincia, CP, tel y mail
     */
    public String obtenerDomicilioLegal() {
        String domicilio = new String();
        
        String sub = "DEPTO";
        index = text.indexOf(sub) + sub.length();
        index = skipBlank();
        String calle = readField();
        
        index = skipBlank();
        String num = readField();
        
        index = skipBlank();
        String piso = readField();
        
        index = skipBlank();
        String dpto = readField();
        
        if ("PROVINCIA (*)".equals(dpto)) {
            dpto = null;
        }
        
        sub = "LOCALIDAD (*)";
        index = text.indexOf(sub, index) + sub.length();
        index = skipBlank();
        String provincia = readField();
        provincia = WordUtils.capitalizeFully(provincia);
        
        index = skipBlank();
        String depto = readField();
        depto = WordUtils.capitalizeFully(depto);
        
        index = skipBlank();
        String loc = readField();
        loc = WordUtils.capitalizeFully(loc);
        
        sub = "EMAIL (*)";
        index = text.indexOf(sub, index) + sub.length();
        index = skipBlank();
        String cp = readField();
        
        index = skipBlank();
        String tel = readField();
        
        index = skipBlank();
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

    /*Funcion para mover el cursor hasta la proxima palabra ignorando espacios
    y saltos de linea*/
    protected Integer skipBlank() {
        while (text.charAt(index) == ' ' || text.charAt(index) == '\r' || text.charAt(index) == '\n') {
            index++;
        }
        return index;
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

    /*Devuelve el domicilioConstituido como String.
    Se pueden extraer parametros calle, 
    num, piso, dpto, localidad, depto, provincia, CP, tel y mail
     */
    public String obtenerDomicilioConst() {
        String domicilio = new String();
        
        String sub = "DOMICILIO CONSTITUIDO";
        index = text.indexOf(sub) + sub.length();
        sub = "DEPTO";
        index = text.indexOf(sub, index) + sub.length();
        index = skipBlank();
        String calle = readField();
        
        index = skipBlank();
        String num = readField();
        
        index = skipBlank();
        String piso = readField();
        
        index = skipBlank();
        String dpto = readField();
        if ("PROVINCIA".equals(dpto)) {
            dpto = null;
        }
        
        sub = "LOCALIDAD";
        index = text.indexOf(sub, index) + sub.length();
        index = skipBlank();
        String provincia = readField();
        provincia = WordUtils.capitalizeFully(provincia);
        
        index = skipBlank();
        String depto = readField();
        depto = WordUtils.capitalizeFully(depto);
        
        index = skipBlank();
        String loc = readField();
        loc = WordUtils.capitalizeFully(loc);
        
        sub = "EMAIL";
        index = text.indexOf(sub, index) + sub.length();
        index = skipBlank();
        String cp = readField();
        
        index = skipBlank();
        String tel = readField();
        
        index = skipBlank();
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

    /*Devuelve el domicilioConstituido como String.
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
        index = skipBlank();
        String calle = readField();
        
        index = skipBlank();
        String num = readField();
        
        index = skipBlank();
        String piso = null;
        String temp = readField();
        if (!"PROVINCIA (*)".equals(temp)) {
            piso = temp;
        }
        
        index = skipBlank();
        String dpto = null;
        temp = readField();
        if (!"DEPARTAMENTO (*)".equals(temp) && !"PROVINCIA (*)".equals(temp)) {
            dpto = temp;
        }
        
        sub = "LOCALIDAD";
        index = text.indexOf(sub, index) + sub.length();
        sub = "(*)";
        index = text.indexOf(sub, index) + sub.length();
        index = skipBlank();
        String provincia = readField();
        provincia = WordUtils.capitalizeFully(provincia);
        
        index = skipBlank();
        String depto = readField();
        depto = WordUtils.capitalizeFully(depto);
        
        index = skipBlank();
        String loc = readField();
        loc = WordUtils.capitalizeFully(loc);
        
        sub = "TELÉFONO/FAX";
        index = text.indexOf(sub, index) + sub.length();
        index = skipBlank();
        String cp = readField();
        
        index = skipBlank();
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
        
        index = skipBlank();
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
    
    public String obtenerNombreArchivoFotoSat() {
        String sub = "Nombre del archivo correspondiente a la foto satelital de ubicación";
        index = text.indexOf(sub) + sub.length();
        sub = "digital y en papel)";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String nombre = readField();
        return nombre;
    }
    
    ArrayList<ArrayList<String>> obtenerAdministradores() {
        ArrayList<ArrayList<String>> admins = new ArrayList<>();
        
        Integer cantidad = 0;
        
        String sub = "ADMINISTRADORES/REPRESENTANTES";
        index = text.indexOf(sub) + sub.length();
        sub = "APELLIDO";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String temp = readField();
        while (!temp.equals("NOMBRE")) {
            if (StringUtils.isNumeric(temp)) {
                cantidad++;
            } else {
                admins.add(new ArrayList<>(4));
                admins.get(cantidad - 1).add(temp);
            }
            skipBlank();
            temp = readField();
        }
        
        skipBlank();
        for (Integer i = 0; i < cantidad; i++) {
            admins.get(i).add(readField());
            skipBlank();
        }
        
        sub = "DOCUMENTO";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        for (Integer i = 0; i < cantidad; i++) {
            admins.get(i).add(readField());
            skipBlank();
        }
        
        sub = "CARGO ASIGNADO";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        for (Integer i = 0; i < cantidad; i++) {
            admins.get(i).add(readField());
            skipBlank();
        }
        
        return admins;
    }
}
