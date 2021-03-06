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
}
