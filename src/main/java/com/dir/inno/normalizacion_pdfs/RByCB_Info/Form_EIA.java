/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs.RByCB_Info;

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
public class Form_EIA {
    ArrayList<String> datos = new ArrayList<>();
    //Plan de gestion ambiental
    //Gestion de residuos peligrosos
    public boolean residuos_peligrosos;
    //Residuos no peligrosos industriales
    public boolean residuos_nopeligrosos;
    //Gestion de residuos patologicos
    public boolean residuos_patologicos;
    //Gestion de otros residuos
    public boolean residuos_otros;
    //Gestion de efluentes liquidos
    public boolean residuos_efluentes;
    //Gestion de emisiones al aire
    public boolean residuos_emisiones;
    //Gestion de emisiones difusas
    public boolean residuos_difusas;
    
    public Form_EIA(String path) throws IOException{
        this.init(path);
        this.residuos_peligrosos= this.datos.get(0).equals("0");
        this.residuos_nopeligrosos= this.datos.get(1).equals("0");
        this.residuos_patologicos= this.datos.get(2).equals("0");
        this.residuos_otros=this.datos.get(3).equals("0");
        this.residuos_efluentes=this.datos.get(4).equals("0");
        this.residuos_emisiones=this.datos.get(5).equals("0");
        this.residuos_difusas=this.datos.get(6).equals("0");
        
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
   }
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("Formulario EIA: \n\n");
        
        output.append("Plan de gestión ambiental.\n");
        
        output.append("Gestión de residuos.\n");
        output.append("¿Posee residuos peligrosos? ");
        if(residuos_peligrosos) output.append("Si.\n"); else output.append("No.\n");
        output.append("¿Posee residuos no peligrosos industriales o de actividades de servicios? ");
        if(residuos_nopeligrosos) output.append("Si.\n"); else output.append("No.\n");
        output.append("¿Posee residuos patológicos o provenientes de catering de buques o aeronaves? ");
        if(residuos_patologicos)output.append("Si.\n"); else output.append("No.\n");
        output.append("¿Posee otros residuos? ");
        if(residuos_otros)output.append("Si.\n"); else output.append("No.\n");
        output.append("¿Posee gestión de efluentes líquidos? ");
        if(residuos_efluentes) output.append("Si.\n\n"); else output.append("No.\n\n");
        
        output.append("Gestión de emisiones al aire.\n");
        output.append("¿Posee gestión de emisiones de fuentes puntuales? ");
        if(residuos_emisiones)output.append("Si.\n"); else output.append("No.\n");
        output.append("¿Posee gestión de emisiones difusas? ");
        if(residuos_difusas)output.append("Si.\n"); else output.append("No.\n");
        
        return output.toString();
    }
}
