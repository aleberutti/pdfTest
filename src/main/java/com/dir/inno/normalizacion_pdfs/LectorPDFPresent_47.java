/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import java.util.ArrayList;
import org.apache.commons.lang3.CharUtils;

/**
 *
 * @author MODERNIZACION05
 */
public class LectorPDFPresent_47 extends LectorPDFPresent {
    
    public LectorPDFPresent_47(StringBuilder text) {
        super(text);
    }
    
    @Override
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
    
}
