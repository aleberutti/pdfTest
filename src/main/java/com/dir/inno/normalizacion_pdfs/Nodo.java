/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dir.inno.normalizacion_pdfs;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Administrador
 */
public class Nodo {
    public Node nodo;
    public String name;
    public String value;
    public NodeList hijos;
    public boolean leaf=false;
    public boolean empty;
    
    public Nodo (Node n){
        this.nodo =n;
        this.name= n.getNodeName();
        if (n.getNodeValue()!=null){
            this.value= n.getNodeValue();
            empty=false;
        }
        else{
            empty=true;
        }
        if (n.hasChildNodes()){
            this.hijos=n.getChildNodes();
        }
        else{
            this.leaf=true;
        }
        
    }

    public Node getNodo() {
        return nodo;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public NodeList getHijos() {
        return hijos;
    }

    public boolean isLeaf() {
        return leaf;
    }
    public boolean isEmpty(){
        return empty;
    }
    
}
