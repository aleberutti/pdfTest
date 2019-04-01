/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Administrador
 */
enum TipoPersona{ PERSONA_FISICA, SOCIEDAD_DE_HECHO, PERSONA_JURIDICA}

public class Form_Presentacion {
    ArrayList<String> datos = new ArrayList<>();
    //Tipo de persona de la empresa
    private TipoPersona tipo;
    //Indice de archivos a presentar en ventanilla
    private boolean contrato;
    private boolean actas;
    private boolean fotoc;
    private boolean constancia;
    private boolean api;
    private boolean certificado;
    private boolean otro;
    //Clasificacion de actividad
    private boolean plantas;
    private boolean tanque;
    private boolean combustible;
    private boolean gas;
    private boolean aceites;
    private boolean aire;
    //Existen inmuebles anexos?
    private boolean inmuebles;
    //Servicios
    private boolean electricidad;
    private boolean gas_natural;
    private boolean agua;
    private boolean cloacas;
    //Emisiones, efluentes y residuos
            //Emisiones gaseosas
    private boolean emision_naturales;
    private boolean emisiones_gases;
    private boolean emisiones_no;
            //Efluentes y/o residuos liquidos
    private boolean efluentes;
    private boolean efluente_agua;
    private boolean efluente_peligroso;
    private boolean residuos_peligrosos;
    private boolean efluentes_trat;
            //Residuos solidos y/o semisolidos
    private boolean asimilables;
    private boolean no_peligrosos;
    private boolean solido_peligrosos;
    //Riesgo presunto
    private boolean ruidos;
    private boolean presion;
    private boolean sustancias;
    private boolean explosion;
    private boolean incendio;
    private boolean riesgo;
    
   public Form_Presentacion(String path) throws IOException{
       this.init(path);
        //Indice de archivos a presentar en ventanilla
        this.contrato = datos.get(0).equals("1");
        this.actas = datos.get(1).equals("1");
        this.fotoc = datos.get(2).equals("1");
        this.constancia = datos.get(3).equals("1");
        this.api = datos.get(4).equals("1");
        this.certificado = datos.get(5).equals("1");
        this.otro = datos.get(6).equals("1");
        //Clasificacion de actividad
        this.plantas = datos.get(7).equals("0");
        this.tanque = datos.get(8).equals("0");
        this.combustible = datos.get(9).equals("0");
        this.gas = datos.get(10).equals("0");
        this.aceites = datos.get(11).equals("0");
        this.aire = datos.get(12).equals("0");
        //Innmuebles anexos
        this.inmuebles = datos.get(13).equals("0");
        //Servicios
        this.electricidad = datos.get(14).equals("0");
        this.gas_natural = datos.get(15).equals("0");
        this.agua = datos.get(16).equals("0");
        this.cloacas = datos.get(17).equals("0");
        //Emisiones, efluentes y residuos
        this.emision_naturales = datos.get(18).equals("0");
        this.emisiones_gases = datos.get(19).equals("0");
        this.emisiones_no = datos.get(20).equals("0");
        this.efluentes = datos.get(21).equals("0");
        this.efluente_agua = datos.get(22).equals("0");
        this.efluente_peligroso = datos.get(23).equals("0");
        this.residuos_peligrosos = datos.get(24).equals("0");
        this.efluentes_trat = datos.get(25).equals("0");
        this.asimilables = datos.get(26).equals("0");
        this.no_peligrosos = datos.get(27).equals("0");
        this.solido_peligrosos = datos.get(28).equals("0");
        //Riesgos
        this.ruidos = datos.get(29).equals("0");
       this.presion = datos.get(30).equals("0");
       this.sustancias = datos.get(31).equals("0");
       this.explosion = datos.get(32).equals("0");
       this.incendio = datos.get(33).equals("0");
       this.riesgo = datos.get(34).equals("0");
       
       
   }
   
   public void init(String path) throws IOException{
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
           if(linea.contains("P1P1")){
               switch(dato){
                   case "0": this.tipo=TipoPersona.PERSONA_FISICA;
                   break;
                   case "1": this.tipo=TipoPersona.SOCIEDAD_DE_HECHO;
                   break;
                   case "2": this.tipo=TipoPersona.PERSONA_JURIDICA;
                   break;
               }
           }
           else{
               if (linea.contains("CheckBox") || linea.contains("RB")){
                   this.datos.add(dato.replace(" ", ""));
               }
           }
       }
       System.out.println(datos.size());
   }
   
   public String toString(){
       StringBuilder string= new StringBuilder();
    //Tipo de sociedad   
       string.append("Tipo de sociedad de la empresa: "+ tipo.toString() +".\n\n");
    //Indice de archivos a presentar en ventanilla
    
    string.append("Índice de archivos a presentar junto con este formulario: \n");
    if(contrato) string.append("Contrato Social o Estatutos Inscriptos.\n"); 
    if(actas) string.append("Actas Societarias.\n");
    if(fotoc) string.append("Fotocopia Documento de Identidad correspondiente "
            + "a las personas físicas detalladas en 4,5 y 6.\n");
    if(constancia) string.append("Constancia N° de C.U.I.T.\n");
    if(api) string.append("Impuesto Inmobiliario.\n");
    if(certificado) string.append("Certificado de uso conforme de suelo para "
            + "la actividad otorgado por la autoridad municipal o local que corresponda.\n");
    if(otro) string.append("Otro:En caso de existir otra información que considere importante presentarla.\n\n");
    //Clasificacion de actividad
    string.append("\n¿Posee otras plantas ubicadas fuera de la provincia? ");
    if(plantas) string.append("Si.\n\n"); else string.append("No.\n\n");
    
    string.append("¿Posee/Proyecta tanques o cisternas? ");
    if(tanque) string.append("Si.\n"); else string.append("No.\n");
    string.append("Combustibles líquidos: ");
    if(combustible) string.append("Si.\n"); else string.append("No.\n");
    string.append("Gas natural: ");
    if(gas) string.append("Si.\n"); else string.append("No.\n");
    string.append("Aceites y lubricantes: ");
    if(aceites) string.append("Si.\n"); else string.append("No.\n");
    string.append("Aire comprimido: ");
    if(aire) string.append("Si.\n\n"); else string.append("No.\n\n");
    
    //Existen inmuebles anexos?
    string.append("¿Existen inmuebles anexos? ");
    if(inmuebles) string.append("Si.\n\n"); else string.append("No.\n\n");
    
    //Servicios
    string.append("Servicios:  \n");
    string.append("Energía eléctrica: ");
    if(electricidad) string.append("Si.\n"); else string.append("No.\n");
    string.append("Gas natural: ");
    if(gas_natural) string.append("Si.\n"); else string.append("No.\n");
    string.append("Agua de red: ");
    if(agua) string.append("Si.\n"); else string.append("No.\n");
    string.append("Cloacas: ");
    if(cloacas) string.append("Si.\n\n"); else string.append("No.\n\n");

    //Emisiones, efluentes y residuos
    string.append("Emisiones, efluentes y residuos: \n");
            //Emisiones gaseosas
    string.append("\tEmisiones gaseosas:\n");
    string.append("¿Posee emisiones de componentes naturales del aire incluido vapor de agua o productos de combustión de gas natural? ");
    if(emision_naturales) string.append("Si.\n"); else string.append("No.\n");
    string.append("¿Posee emisiones de gases de combustión de combustibles líquidos? ");
    if(emisiones_gases) string.append("Si.\n"); else string.append("No.\n");
    string.append("¿Posee emisiones de gases no contemplados en las preguntas anteriores? ");
    if(emisiones_no) string.append("Si.\n\n"); else string.append("No.\n\n");

            //Efluentes y/o residuos liquidos
    string.append("\tEfluentes y/o residuos líquidos:\n");
    string.append("¿En el establecimiento se generan efluentes o residuos líquidos? ");
    if(efluentes) string.append("Si.\n"); else string.append("No.\n");
    string.append("¿El efluente es únicamente agua a tempperatura ambiente? ");
    if(efluente_agua) string.append("Si.\n"); else string.append("No.\n");
    string.append("¿Los efluentes están constituidos especialmente por agua de lavado o de procesos que no contengan residuos peligrosos ni que"
            + "pudieran dar origen a residuos peligrosos por su tratamiento? ");
    if(efluente_peligroso) string.append("Si.\n"); else string.append("No.\n");
    string.append("¿Los líquidos contienen residuos peligrosos o pueden generar residuos peligrosos? ");
    if(residuos_peligrosos) string.append("Si.\n"); else string.append("No.\n");
    string.append("¿Los efluentes líquidos requieren más de un tratamiento para poder ser vertidos? ");
    if(efluentes_trat) string.append("Si.\n\n"); else string.append("No.\n\n");

            //Residuos solidos y/o semisolidos
    string.append("\tResiduos sólidos y/o semisólidos:\n");
    string.append("¿Son todos los residuos sólidos y semisólidos generados en el establecimiento asimilables a docimiliarios? ");
    if(asimilables) string.append("Si.\n"); else string.append("No.\n");
    string.append("¿En los procesos industriales, actividades auxiliares, de servicio, tratamiento de efluentes u otras, se generan residuos sólidos o semisólidos no peligrosos? ");
    if(no_peligrosos) string.append("Si.\n"); else string.append("No.\n");
    string.append("¿Existen residuos sólidos o semisólidos peligrosos, o podrían éstos contener o generar residuos peligrosos? ");
    if(solido_peligrosos) string.append("Si.\n\n"); else string.append("No.\n\n");
    
    //Riesgo presunto
    string.append("Riesgo presunto:  \n");
    string.append("¿Existen fuentes móviles o fijas que pudieran generar ruidos por encima de lo permitido por las normas aplicables? ");
    if(ruidos) string.append("Si.\n"); else string.append("No.\n");
    string.append("¿Posee la empresa aparatos sometidos a presión? ");
    if(presion) string.append("Si.\n"); else string.append("No.\n");
    string.append("¿La empresa manipula sustancias químicas? ");
    if(sustancias) string.append("Si.\n"); else string.append("No.\n");
    string.append("¿Existe en la empresa riesgo de explosión? ");
    if(explosion) string.append("Si.\n"); else string.append("No.\n");
    string.append("¿Existe en la empresa riesgo de incendio? ");
    if(incendio) string.append("Si.\n"); else string.append("No.\n");
    string.append("¿Existe algún otro tipo de riesgo no mencionado anteriormente? ");
    if(riesgo) string.append("Si.\n\n"); else string.append("No.\n\n");
    
       return string.toString();
   }
    
}
