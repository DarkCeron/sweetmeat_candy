/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisLexico;

import java.util.LinkedList;

/**
 *
 * @author Cesar
 */
public class Codigo_intermedio {
    
    public LinkedList lista;
    public String hazTemporal(String Valor1, String signo, String Valor2, int NoDeTemporal, LinkedList lista, int ban, int temp1, int temp2){
        this.lista = lista;
        String temporal = "";
        switch(ban){
            case 1:{
                temporal = "T"+NoDeTemporal+" = "+Valor1+" "+signo+" "+Valor2;
                break;
            }
            case 2:{
                temporal = "T"+NoDeTemporal+" = "+" T"+temp1+" "+signo+" "+Valor2;
                break;
            }
            case 3:{
                temporal = "T"+NoDeTemporal+" = "+Valor1+" "+signo+" T"+temp2;
                break;
            }
            case 4:{
                temporal = "T"+NoDeTemporal+" = "+" T"+temp1+" "+signo+" T"+temp2;
            }
        }
           
        return temporal;
    }
    public boolean verificaTemporal(){
        boolean ban = false;
        
        return ban;
    }
    
}
