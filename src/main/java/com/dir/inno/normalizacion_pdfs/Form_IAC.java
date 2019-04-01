/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Administrador
 */
public class Form_IAC {
    ArrayList<String> datos = new ArrayList<>();
    //Uso de recursos naturales
    //Captacion de agua subterranea
    public boolean agua_sub;
    //Captacion de agua superficial
    public boolean agua_sup;
    //Captacion de agua de red publica
    public boolean agua_pub;
    //Suelo como materia prima
    public boolean suelo;
    public boolean extraccion;
    //Uso de la energia
    //Energia electrica adquirida
    public boolean electrica;
    //Energia electrica por generacion propia
    public boolean electrica_prop;
    //Gas
    public boolean gas;
    //Otro tipo de fuente de energia
    public boolean otro;
    //Identificacion de impactos
    //Sobre el suelo
    public boolean impacto_suelo;
    //Sobre el agua subterranea
    public boolean impacto_agua;
    //Sobre el aire
    public boolean impacto_aire;
    //Sobre el agua superficial o cuerpo receptor
    public boolean impacto_cuerpo;
    //Otros impactos
    public boolean impacto_otros;
    //Generacion de residuos, efluentes y emisiones
    //Residuos peligrosos
    public boolean residuos_peligrosos;
    //Residuos industriales no peligrosos
    public boolean residuos_no_peligrosos;
    //Efluentes liquidos industriales
    public boolean efluentes;
    //Emisiones puntuales
    public boolean emisiones_puntuales;
    //Emisiones difusas
    public boolean emisiones_difusas;
   
    public Form_IAC(String path) throws IOException{
        this.init(path);
        this.agua_sub=this.datos.get(0).equals("1");
        this.agua_sup=this.datos.get(1).equals("1");
        this.agua_pub=this.datos.get(2).equals("1");
        this.suelo=this.datos.get(3).equals("0");
        this.extraccion=this.datos.get(4).equals("0");
        this.electrica=this.datos.get(5).equals("0");
        this.electrica_prop=this.datos.get(6).equals("0");
        this.gas=this.datos.get(7).equals("0");
        this.otro=this.datos.get(8).equals("0");
        this.impacto_suelo=this.datos.get(9).equals("0");
        this.impacto_agua=this.datos.get(10).equals("0");
        this.impacto_aire=this.datos.get(11).equals("0");
        this.impacto_cuerpo=this.datos.get(12).equals("0");
        this.impacto_otros=this.datos.get(13).equals("0");
        this.residuos_peligrosos=this.datos.get(14).equals("0");
        this.residuos_no_peligrosos=this.datos.get(15).equals("0");
        this.efluentes=this.datos.get(16).equals("0");
        this.emisiones_puntuales=this.datos.get(17).equals("0");
        this.emisiones_difusas=this.datos.get(18).equals("0");

    }
    
    
    
    
    
    public void init(String path) throws FileNotFoundException, IOException{
       File info = new File(path);
       FileReader fr = new FileReader(info);
       BufferedReader br = new BufferedReader(fr);
       String linea;
       while ((linea=br.readLine())!=null){
           StringTokenizer st = new StringTokenizer(linea);
           String n = null;
           while(st.hasMoreTokens()){
               n =st.nextToken(".");
           }
           String dato= n.substring(n.length()-1);
           
           this.datos.add(dato.replace(" ", ""));
       }
       System.out.println(datos.size());
   }
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("Uso de los recursos naturales.\n");
        output.append("AGUA.\n");
        output.append("Captación de agua subterránea. ");
        if(agua_sub) output.append("Si.\n"); else output.append("No.\n");
        output.append("Captación de agua superficial. ");
        if(agua_sup) output.append("Si.\n"); else output.append("No.\n");
        output.append("Captación de agua de red publica. ");
        if(agua_pub) output.append("Si.\n\n"); else output.append("No.\n\n");
        
        output.append("Uso del suelo como materia primar. ");
        if(suelo) output.append("Si.\n"); else output.append("No.\n");
        output.append("Extracción");
        if(extraccion) output.append("Si.\n\n"); else output.append("No.\n\n");
        
        output.append("Uso de la energía.");
        output.append("Energía eléctrica adquirida. ");
        if(electrica) output.append("Si.\n"); else output.append("No.\n");
        output.append("Energía eléctrica por generación propia. ");
        if(electrica_prop) output.append("Si.\n"); else output.append("No.\n");
        output.append("Gas (GN, GLP. )");
        if(gas) output.append("Si.\n"); else output.append("No.\n");
        output.append("Otro tipo de fuente de energia. ");
        if(otro) output.append("Si.\n\n"); else output.append("No.\n\n");
        
        output.append("Identificación de impactos.\n");
        output.append("Impacto sobre el suelo. ");
        if(impacto_suelo) output.append("Si.\n"); else output.append("No.\n");
        output.append("Sobre el agua subterránea. ");
        if(impacto_agua) output.append("Si.\n"); else output.append("No.\n");
        output.append("Impacto sobre el aire. ");
        if(impacto_aire) output.append("Si.\n"); else output.append("No.\n");
        output.append("Impacto sobre el agua superficial o cuerpo receptor. ");
        if(impacto_cuerpo) output.append("Si.\n"); else output.append("No.\n");
        output.append("Otros impactos. ");
        if(impacto_otros) output.append("Si.\n\n"); else output.append("No.\n\n");
        
        output.append("Generación de residuos, efluentes y emisiones.\n");
        output.append("Residuos peligrosos. ");
        if(residuos_peligrosos)output.append("Si.\n"); else output.append("No.\n");
        output.append("Residuos industriales no peligrosos. ");
        if(residuos_no_peligrosos) output.append("Si.\n"); else output.append("No.\n");
        output.append("Efluentes líquidos industriales. ");
        if(efluentes) output.append("Si.\n"); else output.append("No.\n");
        output.append("Emisiones puntuales. ");
        if(emisiones_puntuales) output.append("Si.\n"); else output.append("No.\n");
        output.append("Emisiones difusas. ");
        if(emisiones_difusas) output.append("Si.\n"); else output.append("No.\n");
        
        
        return output.toString();
    }
}
