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
public abstract class LectorPDFPresent {

    protected Integer index;
    protected final StringBuilder text;

    public LectorPDFPresent(StringBuilder text) {
        this.text = text;
    }

    /*Obtener versión del documento
     */
    public String obtenerVersion() {
        String sub = "VERSIÓN";
        index = text.indexOf(sub) + sub.length();
        skipBlank();
        return readField();
    }

    /*Obtener nombre/Razon social
     */
    public String obtenerNombre() {
        String sub = "NOMBRE COMPLETO";
        index = text.indexOf(sub) + sub.length();
        sub = "RAZÓN SOCIAL";
        index = text.indexOf(sub, index) + sub.length();
        sub = "(*)";
        index = text.indexOf(sub, index) + sub.length();
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
        String sub = "Persona Física";
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
        String sub = "Persona Física";
        index = text.indexOf(sub) + sub.length();
        skipBlank();
        readField();
        skipBlank();
        readField();
        skipBlank();
        readField();
        skipBlank();
        String dateString = readField();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        return date;
    }

    /*Devuelve un Array de enteros conteniendo los códigos CUACM
    correspondientes a las actividades de la empresa.
     */
    public ArrayList<ArrayList<String>> obtenerActividades() {
        ArrayList<ArrayList<String>> actividadesEmpresa = new ArrayList<>();
        String sub = "ESTANDAR";
        index = text.indexOf(sub) + sub.length();
        String temp;
        do {
            skipBlank();
            actividadesEmpresa.add(new ArrayList<>(3));
            actividadesEmpresa.get(actividadesEmpresa.size() - 1).add(readField());
            skipBlank();
            actividadesEmpresa.get(actividadesEmpresa.size() - 1).add(readField());
            skipBlank();
            actividadesEmpresa.get(actividadesEmpresa.size() - 1).add(readField());
            sub = "AMBIENTAL";
            index = text.indexOf(sub, index) + sub.length();
            skipBlank();
            readField();
            skipBlank();
            temp = readField();
            if (temp.contains("Firma")) {
                sub = "Hipólito Yrigoyen 1001 - Reconquista";
                index = text.indexOf(sub, index) + sub.length();
                sub = "(03482) 449189 | (342) 5112121";
                index = text.indexOf(sub, index) + sub.length();
                skipBlank();
                temp = readField();
            }
            sub = "ESTANDAR";
            index = text.indexOf(sub, index) + sub.length();
            if (index == -1 + sub.length()) {
                return actividadesEmpresa;
            }
        } while (!temp.contains("DOMICILIO"));
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

    /*Devuelve el domicilioConstituido como String.
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

    /*Devuelve el domicilioLegal como String.
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

    public ArrayList<ArrayList<String>> obtenerPlantasFueraProv() {
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

    public ArrayList<ArrayList<String>> obtenerSubproductos() {
        ArrayList<ArrayList<String>> subproductos = new ArrayList<>();
        String sub = "SUBPRODUCTOS";
        index = text.indexOf(sub) + sub.length();
        sub = "AGREGACIÓN";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String temp = readField();
        Integer x = index;
        skipBlank();
        String temp2 = readField();
        index = x;
        if (temp2.contains("MATERIAS")) {
            return subproductos;
        }
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

    public ArrayList<ArrayList<String>> obtenerMateriasPrimas() {
        ArrayList<ArrayList<String>> materias = new ArrayList<>();
        String sub = "MATERIAS";
        index = text.indexOf(sub) + sub.length();
        sub = "PRIMAS";
        index = text.indexOf(sub, index) + sub.length();
        sub = "AGREGACIÓN";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        String temp = readField();
        Integer x = index;
        skipBlank();
        String temp2 = readField();
        index = x;
        if (temp2.contains("INSUMOS")) {
            return materias;
        } else {
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
    }
    
    public abstract ArrayList<ArrayList<String>> obtenerProductos();

}
