/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import java.util.ArrayList;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author MODERNIZACION05
 */
public class LectorPDFPresent_413 extends LectorPDFPresent {

    public LectorPDFPresent_413(StringBuilder text) {
        super(text);
    }

    @Override
    public ArrayList<ArrayList<String>> obtenerProductos() {
        ArrayList<ArrayList<String>> productos = new ArrayList<>();
        String sub = "PRODUCTOS";
        index = text.indexOf(sub) + sub.length();
        sub = "ANUAL";
        index = text.indexOf(sub, index) + sub.length();
        Integer x = index;
        String temp = readField();
        String temp2 = readField();
        if (temp2.contains("Firma")) {
            sub = "(342) 5112121";
            index = text.indexOf(sub, index) + sub.length();
            skipBlank();
            temp2 = readField();
        }
        index = x;
        if (temp2.contains("Nº")) {
            return productos;
        } else {
            while (!temp.contains("Nº")) {
                productos.add(new ArrayList<>());
                if (CharUtils.isAsciiNumeric(temp.charAt(0))) {
                    index = x;
                    readField();
                    skipBlank();
                    productos.get(productos.size() - 1).add(readField());
                    skipBlank();
                    productos.get(productos.size() - 1).add(readField());
                    skipBlank();
                    temp = readField();
                    if (StringUtils.isNumeric(temp)) {
                        productos.get(productos.size() - 1).add(temp);
                        skipBlank();
                        productos.get(productos.size() - 1).add(readField());
                        skipBlank();
                        productos.get(productos.size() - 1).add(readField());
                    } else {
                        productos.get(productos.size() - 1).add(null);
                        productos.get(productos.size() - 1).add(temp);
                        skipBlank();
                        productos.get(productos.size() - 1).add(readField());
                    }
                }
                skipBlank();
                temp = readField();
                if (temp.contains("Firma")) {
                    sub = "(342) 5112121";
                    index = text.indexOf(sub, index) + sub.length();
                    skipBlank();
                    temp = readField();
                }
                
            }
        }
    }

}
