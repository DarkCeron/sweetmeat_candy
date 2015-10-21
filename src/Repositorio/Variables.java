/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import AnalisisLexico.Test;
import java.util.LinkedList;
import Colors.*;
/**
 *
 * @author ceron
 */
public class Variables {
  
    public LinkedList llist = new LinkedList();
    int linea = 0;
    /*METODOS DE LOS IDENTIFICADORES*/
    public void setIdentificadores(LinkedList lis){
        this.llist = lis;
    }
    public LinkedList getIdentificadores(){
    Test t = new Test();
        
        return llist;
    }
    
    //Agrega a la tabla de simbolos
    public void setAgregaIdentificador(String ID, String palReserv, String valor, String IDpos, int linea){
        //name+":"+palres+":"+newList[2]+":"+ID
        this.linea = linea;
        if(buscIgualdad(ID)){
            if(ValidaValor(palReserv, valor)){
                llist.add(ID+":"+palReserv+":"+valor+":"+IDpos);
            }
            else{
                System.err.println("Error: la variable no se declaro por que el valor '"+valor+"' no concuerda con el tipo: '"+palReserv+"'. Error en la linea: "+linea);
            }
        }
        else{
            System.err.println("Error: la variable '"+ID+"' no puede ser inicializada por que ya existe en la tabla de simbolos. Error en la linea: "+linea);
        }
        Test.setLlist(llist);
    }
    
    //Modifica valores de la tabla
    public LinkedList ModificaValIdentificador(String ID, String nuevoValor){
        String sacaTabSimb;
        String[] varDTabSimb;
        for(int x = 0 ; x < llist.size() ; x++){
            sacaTabSimb = (String)llist.get(x);
            varDTabSimb = sacaTabSimb.split(":");
            if(ID.equals(varDTabSimb[0])){
                if(ValidaValor(varDTabSimb[1], nuevoValor)){
                    llist.set(x , varDTabSimb[0]+":"+varDTabSimb[1]+":"+nuevoValor+":"+varDTabSimb[3]+":"+this.linea);
                    break;
                }
                else{
                System.err.println("Error: la variable no se declaro por que el valor '"+nuevoValor+"' no concuerda con el tipo: '"+varDTabSimb[1]+"'. Error en la linea: "+linea);
                }
            }
        }
        if(llist.isEmpty()){
            System.err.println("No existen variables declaradas para buscar");
        }
        
        return llist;
    }

    //Busca igualdad
    public boolean buscIgualdad(String ID){
        String sacaTabSim;
        String[] vaSTabSim;
        boolean banIgualdad = true;
        for(int x = 0 ; x < llist.size() ; x++){
            sacaTabSim = (String)llist.get(x);
            vaSTabSim = sacaTabSim.split(":");
            if(ID.equals(vaSTabSim[0])){
                banIgualdad = false;
                break;
            }
        }
        return banIgualdad;
    }
    
    public String obtieneValor(String ID){
        String sacaTabSim;
        String[] vaSTabSim;
        String banIgualdad = "";
        for(int x = 0 ; x < llist.size() ; x++){
            sacaTabSim = (String)llist.get(x);
            vaSTabSim = sacaTabSim.split(":");
            if(ID.equals(vaSTabSim[0])){
                banIgualdad = vaSTabSim[2];
                break;
            }
        }
        return banIgualdad; 
    }
    
    //Obtiene posicion de la variable y retorna un entero
    public int RegresaPosicion(String ID){
        int valor = 1;
        String sacaTabSim;
        String [] vaSTabSim;
        for(int x = 0; x < llist.size() ; x++){
            sacaTabSim = (String)llist.get(x);
            vaSTabSim = sacaTabSim.split(":");
            if(ID.equals((vaSTabSim[0]))){
                valor = x;
                break;
            }
        }
        return valor;
    }
    //Obtiene valor de la variable y retorna un String
    public String RegresaValor(String ID){
        String valor = "";
        String sacaTabSim;
        String [] vaSTabSim;
        for(int x = 0; x < llist.size() ; x++){
            sacaTabSim = (String)llist.get(x);
            vaSTabSim = sacaTabSim.split(":");
            if(ID.equals((vaSTabSim[0]))){
                valor = vaSTabSim[2];
                break;
            }
        }
        return valor;
    }
    
    
    //Obtiene valores de identificadores
    public void BuscID(String ID, String ID2, int linea){
        //ImpTabSimbolos();
        String tabla1 = "", tabla2 = "", Valor1 = "", Valor2 = "", entrega = "", ad = "",id = "";
        String[] vaSTabSim1, vaSTabSim2;
        boolean OK1 = false, OK2 = false;
        int x, puntero1 = 0,puntero2 = 0;
        
        if(!buscIgualdad(ID)){
            puntero1 = RegresaPosicion(ID);
            OK1 = true;
        }
        if(!buscIgualdad(ID2)){
            puntero2 = RegresaPosicion(ID2);
            entrega = RegresaValor(ID2);
            if(ID2.equals("frutsi")){
                Valor2 = (String)llist.get(puntero2);
                vaSTabSim2 = Valor2.split(":");
                ModificaValIdentificador(ID2, "frutsi");
            }
            else if(ID2.equals("vainilla")){
                Valor2 = (String)llist.get(puntero2);
                vaSTabSim2 = Valor2.split(":");
                ModificaValIdentificador(ID2, "vainilla");
            }
            OK2 = true;
        }
        if(OK1 && OK2){
            Valor1 = (String)llist.get(puntero1);
            vaSTabSim1 = Valor1.split(":");
            Valor2 = (String)llist.get(puntero2);
            vaSTabSim2 = Valor2.split(":");
            if(vaSTabSim1[1].equals(vaSTabSim2[1])){
                ModificaValIdentificador(ID, vaSTabSim2[2]);
            }
            else{
                System.err.println("Error, la variable ID '"+vaSTabSim2[0]+"' no es de tipo: "+vaSTabSim1[1]+". Error en la linea "+linea);
            }
        }
        else{
            System.err.println("Error, una de las variables a igualar no existe. Error en la linea: "+linea);
        }
        
    }
    
    //Metodo para imprimir la tabla de simbolos
    public void ImpTabSimbolos(){
         MiConsole.println(MiConsole.ANSI_BLUE, "=================TABLA DE SIMBOLOS===================");
        for(int x = 0 ; x < llist.size() ; x++){
            MiConsole.println(MiConsole.ANSI_YELLOW, ((String)llist.get(x)));
        }
    }
    //Metodo para iniciar los valores por defecto
    public String retValPorDefecto(String palReserv){
       if(palReserv.equals("choco")){
           return "\"\"";
       } 
       else if(palReserv.equals("Bubulubu")){
           return "0";
       }
       else if(palReserv.equals("caramelo")){
           return "\'\'";
       }
       else if(palReserv.equals("bombon")){
           return "frutsi";
       }
       else {
           return "";
       }
        
    }
    
    //Metodo valida si lo que se va a igualar es una variable valida
    public boolean ValidaValor(String palReserv, String valor){
        boolean banValida = false;
        if(palReserv.equals("choco")){
           if(valor.startsWith("\"") && valor.endsWith("\"")){
               banValida = true;
           }
       } 
       else if(palReserv.equals("Bubulubu")){
           if(valor.matches("[0-9]+")){
               banValida = true;
           }
       }
       else if(palReserv.equals("caramelo")){
           if(valor.startsWith("\'") && valor.endsWith("\'") && ((valor.length() == 3)|| (valor.length() == 2))){
               banValida = true;
           }
       }
       else if(palReserv.equals("bombon")){
           if(valor.equals("vainilla") || valor.equals("frutsi")){
               banValida = true;
           }
       }
       else {
           banValida = false;
       }
        return banValida;
    }
    /**FIN DE METODOS DE IDENTIFICADORES*/
    public void eliminar(){
        llist.removeLast();
    }
}
