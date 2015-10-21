/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisLexico;

import Repositorio.Variables;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
/**
 *
 * @author ceron
 */
public class ValidaIDIgualacion {
    String vaciaTabla, TablaVaciandoVT;
    Test t = new Test();
//    ValidaPalReserv varp = new ValidaPalReserv();
    public boolean ValidaID(String lineaLeida, int linea){
        boolean banvalid = false;
        String[] valor;
        String quitaspacio;
        quitaspacio = lineaLeida.replaceAll("\\s", "");
        if(quitaspacio.matches("([a-zA-Z])+[=]([a-zA-Z])+;")){
            valor  = rompeIgualacion(quitaspacio);
            
                banvalid = true;
        }
        return banvalid;
    }
    public boolean ValidaVal(String lineaLeida, int linea){
        boolean banvalid = false;
        String[] valor;
        String quitaspacio;
        quitaspacio = lineaLeida.replaceAll("\\s", "");
        if(quitaspacio.matches("([a-zA-Z])+[=]([0-9])+[;]")){
            valor = rompeIgualacion(quitaspacio);

                banvalid = true;
        }                
        return banvalid;
    }
    public String[] rompeIgualacion(String val){
        String[] val1,value;
        val1 = val.split(";");
        value = val1[0].split("=");
        return value;
    }
    
    public String[] separaTodo(String valor){
        String [] fin;
        String val = valor.replaceAll("\\s", "");
        fin = rompeIgualacion(val);
        return fin;
    }
        public void setVaciatabla(String vaciaTabla) {
        this.vaciaTabla = vaciaTabla;
    }
}
