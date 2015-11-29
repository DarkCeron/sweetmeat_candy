/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisLexico;

import Repositorio.Variables;
import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import com.sun.org.apache.xalan.internal.lib.ExsltStrings;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ceron
 */
public class DesCicloMain {
    public boolean bandera = true, banMate = false;
    private Variables varia;
    Operaciones ope = new Operaciones();
    LinkedList llist = new LinkedList();
    public LinkedList temporal = new LinkedList();
    Scanner var = new Scanner(System.in);
    String supm []={"Pastelito","MedioPastelito","Paleta.Payaso", "Dulce de chocolate", "paletita", "Postre"};  
    
        public boolean EvaluaBloques(String obtenLinea, int linea, LinkedList lli)throws FileNotFoundException, IOException{
        this.llist = lli;
        if(Desicion(obtenLinea, linea)){
            bandera  = true;
        }
        else if(DesisionSino(obtenLinea, linea)){
            bandera  = true;
        }
        else if(Impresion(obtenLinea, linea)){
            bandera  = true;
        }
        else if(Ciclo(obtenLinea, linea)){
            bandera  = true;
        }
        else if(Main(obtenLinea, linea)){
            bandera  = true;
        }
        else if(Lectura(obtenLinea, linea)){
            bandera = true;
        }
        else{
            bandera = true;
        }
        //varia = null;
        return bandera;
    }
    
    public boolean Desicion(String obtenLinea, int linea)throws FileNotFoundException, IOException{
        String aux[] = obtenLinea.split("\\(");
        if(aux[0].equals(supm[0])){
        if(ope.operacLogic(obtenLinea, linea, supm[0], llist, "N")){
            bandera = false;
        }
        else {
            bandera = true;
        }
        }
        else{
            bandera = false;
        }
        
        return bandera;
    }
    
    public boolean Main(String obtenLinea, int linea)throws FileNotFoundException, IOException{
        
        String aux[] = obtenLinea.split("\\(");
        if(aux[0].equals(supm[3])){
        if(ope.operacLogic(obtenLinea, linea, supm[3], llist, "N")){
            bandera = false;
        }
        else {
            bandera = true;
        }
        }
        else{
            bandera = false;
        }
        
        return bandera;
    }
    
    public boolean DesisionSino(String obtenLinea, int linea)throws FileNotFoundException, IOException{
        
        String aux[] = obtenLinea.split("\\(");
        if(aux[0].equals(supm[1])){
        if(ope.operacLogic(obtenLinea, linea, supm[1], llist, "N")){
            bandera = false;
        }
        else {
            bandera = true;
        }
        }
        else{
            bandera = false;
        }
        return bandera;
    }
    
    public boolean Impresion(String obtenLinea, int linea)throws FileNotFoundException, IOException{
        
       String aux[] = obtenLinea.split("\\(");
        if(aux[0].equals(supm[2])){
        if(ope.operacLogic(obtenLinea, linea, supm[2], llist, "N")){
            bandera = false;
        }
        else {
            bandera = true;
        }
        }
        else{
            bandera = false;
        }
        
        return bandera;
    }
    
    public boolean Ciclo(String obtenLinea, int linea)throws FileNotFoundException, IOException{
        
        String aux[] = obtenLinea.split("\\(");
        if(aux[0].equals(supm[4])){
        if(ope.operacLogic(obtenLinea, linea, supm[4], llist, "N")){
            
            bandera = false;
        }
        else {
            bandera = true;
        }
        }
        else{
            bandera = false;
        }
        
        return bandera;
    }
    
    public boolean Lectura(String obtenLinea, int linea){
       varia = new Variables();
       varia.setIdentificadores(llist);
       String aux[] = obtenLinea.split("\\(");
       String variable;
       boolean ban = true;
        if(aux[0].equals(supm[5])){
        if(aux[1].matches("[a-zA-Z]+[\\)][;]")){
            String valor = aux[1].replaceAll("\\);", "");
            if(!varia.buscIgualdad(valor)){
            varia.ModificaValIdentificador(valor.toLowerCase(), "0", "L");
            bandera = true;
            }
            else{
                System.err.println("Imposible leer "+valor.toUpperCase()+" Error en la linea:"+linea);
            }
        }
        else {
            bandera = false;
        }
        }
        else{
            bandera = false;
        }
        return bandera; 
    }
    
    public boolean Buscsupm(String verLinea){
        boolean ban = true;
        String borra = verLinea.replaceAll("[\\s]", "");
            for (int i = 0; i < 10; i++) {
            
        }
        
        return ban;
    }
    public LinkedList getLLisDesc(){
    LinkedList ll = new LinkedList();
        ll = this.llist;
        return ll;
    }
}
