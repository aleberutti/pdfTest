/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

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
        /*
        while (!temp.equals("NOMBRE")) {
            if (StringUtils.isNumeric(temp)) {
                cantidad++;
            } else {
                nomina.add(new ArrayList<>(4));
                nomina.get(cantidad - 1).add(temp);
            }
            skipBlank();
            temp = readField();
        }
        
        sub = "CARGO ASIGNADO";
        index = text.indexOf(sub, index) + sub.length();
        skipBlank();
        for (Integer i = 0; i < cantidad; i++) {
            nomina.get(i).add(readField());
            skipBlank();
        }
        
        for (Integer i = 0; i < cantidad; i++) {
            nomina.get(i).add(readField());
            skipBlank();
        }
        
        for (Integer i = 0; i < cantidad; i++) {
            nomina.get(i).add(readField());
            skipBlank();
        }
         */

        return nomina;
    }

}
