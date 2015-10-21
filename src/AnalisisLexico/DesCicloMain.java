/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisLexico;

import Repositorio.Variables;
import java.util.LinkedList;

/**
 *
 * @author ceron
 */
public class DesCicloMain {
    public boolean bandera = true;
    private Variables varia;
    Operaciones ope = new Operaciones();
    LinkedList llist;
    String supm []={"Pastelito","MedioPastelito","Paleta.Payaso", "Dulce de chocolate(){", "paletita"};  
    
        public boolean EvaluaBloques(String obtenLinea, int linea, LinkedList lli){
        llist = lli;
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
        else if(!obtenLinea.equals("")){
            System.err.println("Error de sintaxis '"+obtenLinea+"'. ERROR en la linea "+linea);
            bandera = true;
        }
        //varia = null;
        return bandera;
    }
    
    public boolean Desicion(String obtenLinea, int linea){
        
        
        if(ope.operacLogic(obtenLinea, linea, supm[0], llist)){
            bandera = false;
        }
        else {
            bandera = true;
        }
        
        return bandera;
    }
    
    public boolean Main(String obtenLinea, int linea){
        
        String separa[] = obtenLinea.split("\\(");
        if(obtenLinea.matches("Dulce de chocolate[\\(][a-zA-Z0-9]?[\\)]")){
            bandera = false;
        }
        return bandera;
    }
    
    public boolean DesisionSino(String obtenLinea, int linea){
        
        String separa[] = obtenLinea.split("\\(");
        if(obtenLinea.matches("MedioPastelito[\\(][a-zA-Z0-9]?[\\)]")){
            bandera = false;
        }
        return bandera;
    }
    
    public boolean Impresion(String obtenLinea, int linea){
        
        String separa[] = obtenLinea.split("\\(");
        if(obtenLinea.matches("Paleta.Payaso[\\(][a-zA-Z0-9]?[\\)]")){
            bandera = false;
        }
        return bandera;
    }
    
    public boolean Ciclo(String obtenLinea, int linea){
        
        String separa[] = obtenLinea.split("\\(");
        if(obtenLinea.matches("paletita[\\(][a-zA-Z0-9]?[\\)]")){
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
