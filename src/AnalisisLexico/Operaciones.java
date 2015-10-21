/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisLexico;

import static AnalisisLexico.TablasMatematicas.statesr;
import Repositorio.Variables;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author ceron
 */
public class Operaciones {
    public int c = 0;
    public boolean aceptacion = false, romp = false, divE = false;
    public String cadena = "", ID = "";
    public int x = 0;
    public Map<Integer, Integer> pila = new HashMap<Integer, Integer>();
    public Map<Integer, String> pilaValor = new HashMap<Integer, String>();
    public TablasMatematicas tm = new TablasMatematicas();
    public logica tl = new logica();
    public LinkedList llist;
    private Variables varia = new Variables();
    String supm []={"Pastelito","MedioPastelito","Paleta.Payaso", "Dulce de chocolate(){", "paletita"};
    /*METODO PRINCIPAL PARA VERIFICAR OPERACIONES LOGICAS Y MATEMATICAS*/
    public void  algoritmoComplejo(Map obj, int linea, String signo, int LoM){
        boolean salR = true;
        String cadena;
        Map<Integer, String> hm = new HashMap<Integer, String>();
        Map<Integer, String> tab = new HashMap<Integer, String>();
        do{
        hm = obj;
            String desp = hm.get(pila.get(c));
            if(desp.startsWith("S")){
               cadena=desp.replace("S", "");
               pila.put(pila.size(), Integer.parseInt(cadena));
               salR = false;
            }
            else if (desp.startsWith("R")) {
               cadena=desp.replace("R", ""); 
               if(LoM == 1){
                   tab = tm.statesr();
                   }
                   else tab = tl.statesr();
               String [] sep = (tab.get(Integer.parseInt(cadena))).split(" ");
               int pililla = Integer.parseInt(sep[1]);
               int pilaAux = 0;
               for(int x = 0; x < pililla;x++){
                   this.pila.remove(pila.size()-1);
               }
               //Realiza operación
               if(pililla == 3 || pililla == 2){
                   if(LoM == 1){
                        RealizaOperacion();
                   }
                   
                   else{
                        opLog();
                   }
               }
               //tab.clear();
               if(sep[0].equals("A")){
                   if(LoM == 1){
                   tab = tm.A();
                   }
                   else tab = tl.A();
                   if(tab.get(pila.get(pila.size()-1)) != "E"){
                       pilaAux = Integer.parseInt(tab.get(pila.get(pila.size()-1)));
                       pila.put(pila.size(), pilaAux);
                   }
               }
               else if(sep[0].equals("B")){
                   if(LoM == 1){
                   tab = tm.B();
                   }
                   else tab = tl.B();
                   if(tab.get(pila.get(pila.size()-1)) != "E"){
                       pilaAux = Integer.parseInt(tab.get(pila.get(pila.size()-1)));
                       pila.put(pila.size(), pilaAux);
                   }
               }
               else if(sep[0].equals("C")){
                   if(LoM == 1){
                   tab = tm.C();
                   }
                   else tab = tl.C();
                   if(tab.get(pila.get(pila.size()-1)) != "E"){
                       pilaAux = Integer.parseInt(tab.get(pila.get(pila.size()-1)));
                       pila.put(pila.size(), pilaAux);
                   }
               }
               else if(sep[0].equals("D")){
                   if(LoM == 0){
                   tab = tl.D();
                   }
                   if(tab.get(pila.get(pila.size()-1)) != "E"){
                       pilaAux = Integer.parseInt(tab.get(pila.get(pila.size()-1)));
                       pila.put(pila.size(), pilaAux);
                   }
               }
               else if(sep[0].equals("E")){
                   if(LoM == 0){
                   tab = tl.E();
                   }
                   if(tab.get(pila.get(pila.size()-1)) != "E"){
                       pilaAux = Integer.parseInt(tab.get(pila.get(pila.size()-1)));
                       pila.put(pila.size(), pilaAux);
                   }
               }
//               else if(sep[0].equals("F")){
//                   if(LoM == 0){
//                   tab = tl.F();
//                   }
//                   if(tab.get(pila.get(pila.size()-1)) != "E"){
//                       pilaAux = Integer.parseInt(tab.get(pila.get(pila.size()-1)));
//                       pila.put(pila.size(), pilaAux);
//                   }
//               }
            }
            else if(desp.equals("ACEPT")){
                if(LoM == 1){
                    System.out.println("La cadena matematica ha sido aceptada.  Valor: "+pilaValor.get(0));
                    if(divE == false){
                        varia.ModificaValIdentificador(ID, pilaValor.get(0));
                    }
                }
                else{
                    System.out.println("La cadena logica ha sido aceptada.  Valor: "+pilaValor.get(0));
                }
                
                salR = false;
            }
            else {
                System.err.println("ERROR FATAL en un "+signo+". Error en la linea: "+linea);
                salR = false;
                romp = true;
            }
            hm = null;
            tab = null;
            tm = null;
            c = pila.size()-1;
        }while(salR);
        if(!signo.equals("(") && !signo.equals(")")){
            if(signo.matches("[A-Za-z]+") && !signo.matches("vainilla") && !signo.matches("frutsi")){
                ID = signo;
                signo=varia.obtieneValor(signo);
                if(signo.matches("[0-9]+")){
                  pilaValor.put(pilaValor.size(), signo); 
                }
                else if((signo.matches("frutsi") || signo.matches("vainilla")) && LoM == 0){
                    pilaValor.put(pilaValor.size(), signo);
                }
                else {
                    System.err.println("Error, el valor "+signo+" No es de tipo entero");
                    romp= true;
                }
            }
            else{
                
            pilaValor.put(pilaValor.size(), signo);
            }
        }
    }
    /*TERMINA METODO PRINCIPAL PARA VERIFICAR OPERACIONES LOGICAS Y MATEMATICAS*/

    /*AQUI COMIENZAN LOS METODOS PARA ANALIZAR UNA OPERACION MATEMATICA*/
    //Metodo del algoritmo
    public boolean algoritmoAceptacion(String obtenLinea, int linea){
        pila.put(pila.size(), 0);
        String oldtable = obtenLinea.replaceAll("  ", " ");
        String [] tabla = oldtable.split(" ");
        while(x < tabla.length){
          
          if(romp == false){
            if(tabla[x].matches("[0-9]+")){
                algoritmoComplejo(tm.numero(), linea, tabla[x], 1);
            }
            else if(tabla[x].matches("[A-Za-z]+") && !varia.buscIgualdad(tabla[x])){
                algoritmoComplejo(tm.identificador(), linea, tabla[x], 1);
            }
            else if(tabla[x].matches("[*]")){
                algoritmoComplejo(tm.multiplicacion(), linea, tabla[x], 1);
            }
            else if(tabla[x].matches("[/]")) {
                algoritmoComplejo(tm.division(), linea, tabla[x], 1);
            }
            else if (tabla[x].matches("[+]")) {
                algoritmoComplejo(tm.suma(), linea, tabla[x], 1);
            } 
            else if(tabla[x].matches("[\\-]")) {
                algoritmoComplejo(tm.resta(), linea, tabla[x], 1);
            } 
            else if(tabla[x].matches("[\\(]")) {
                algoritmoComplejo(tm.parabierto(), linea, tabla[x], 1);
            }
            else if(tabla[x].matches("[\\)]")) {
                algoritmoComplejo(tm.paracerrado(), linea, tabla[x], 1);
            }
            else if(tabla[x].matches("[$]")) {
                algoritmoComplejo(tm.signPesos(), linea, tabla[x], 1);
            }
            else if(!varia.buscIgualdad(tabla[x]) && (!tabla[x].matches("[\\s]+")|| !tabla[x].equals(""))){
                System.err.println("Error, la variable '"+tabla[x]+"' no ah sido inicializada. Error en la linea: "+linea);
                x  = tabla.length;
                aceptacion = false;
            }
          }
            x++;
        }
        romp = false;
        return aceptacion;
    }
    
    //Metodo, verifica si es una operacion matematica numerica o con identificadores
    public boolean operacMate(String obtenLinea, int linea, LinkedList llis){
        //this.varia = variable;
        varia.setIdentificadores(llis);
        if(!obtenLinea.contains(supm[0]) && !obtenLinea.contains(supm[1]) && !obtenLinea.contains(supm[2]) && 
           !obtenLinea.contains(supm[3]) && !obtenLinea.contains(supm[4])){
        String cad = obtenLinea.replaceAll("\\s", "");
        String[] cadnew = cad.split("=");
        String[] cadl = cadnew[1].split(";");
        if(cadl[0].matches("[[\\(|\\)]*[\\d]*[*|\\-|+|/]{1}[\\d]*[\\(|\\)]]+")||
           cadl[0].matches("[[\\(|\\)]*[\\w]*[*|\\-|+|/]{1}[\\w]*[\\(|\\)]]+")){

            if(aceptarOperacionMate(cadl[0], linea)){
                if(algoritmoAceptacion(cadena, linea)){
                    aceptacion = true;
                }
                else aceptacion = false;
            }
        }
        else{
            System.err.println("Eror de sintaxis. Imposible hacer operacion, linea: "+linea);
            aceptacion = false;
        }
        }
        pila = null;
        return aceptacion;
    }
    
    //Metodo, acepta y concatena la linea matematica para poder hacer un split en tabla matematica 
    public boolean aceptarOperacionMate(String obtenLinea, int linea){

            for (int x = 0; x <= obtenLinea.length(); x++) {
                    if(x == obtenLinea.length()){
                       cadena = cadena + " $";
                       aceptacion = true;
                    }
                    else if(!signosMate(obtenLinea, x)){
                        cadena = cadena + obtenLinea.charAt(x);
                    }
                    else if(signosMate(obtenLinea, x)){
                       cadena = cadena+" "+obtenLinea.charAt(x) +" ";
                    }
                    
            }
        
        return aceptacion;
    }
    
    //Metodo que verifica si hay operadores, sino en metodo aceptarOperacion retorna un false para no concatenar
    public boolean signosMate(String cadena, int linea){
        if(cadena.charAt(linea) == '*' || cadena.charAt(linea) == '/'|| 
           cadena.charAt(linea) == '+' || cadena.charAt(linea) == '-'||
           cadena.charAt(linea) == '(' || cadena.charAt(linea) == ')'){
            aceptacion = true;
        }
        else{
            aceptacion = false;
        }
        return aceptacion;
    }
    
    public void RealizaOperacion(){
        Integer auxiliar = 0;
        if(pilaValor.size() >= 3){
           char valor[] = (pilaValor.get(pilaValor.size()-2)).toCharArray();
            switch(valor[0]){
                case '+':{
                  auxiliar = Integer.parseInt(pilaValor.get(pilaValor.size()-1)) + Integer.parseInt(pilaValor.get(pilaValor.size()-3));
                    elimYAgregaValor(auxiliar.toString());
                    break;
                }
                case '-':{
                  auxiliar = Integer.parseInt(pilaValor.get(pilaValor.size()-1)) - Integer.parseInt(pilaValor.get(pilaValor.size()-3));
                  elimYAgregaValor(auxiliar.toString());
                    break;
                }
                case '*':{
                  auxiliar = Integer.parseInt(pilaValor.get(pilaValor.size()-1)) * Integer.parseInt(pilaValor.get(pilaValor.size()-3));
                  elimYAgregaValor(auxiliar.toString());
                    break;
                }
                case '/':{
                  if(Integer.parseInt(pilaValor.get(pilaValor.size()-1)) != 0 && Integer.parseInt(pilaValor.get(pilaValor.size()-3)) != 0){
                  auxiliar = Integer.parseInt(pilaValor.get(pilaValor.size()-1)) / Integer.parseInt(pilaValor.get(pilaValor.size()-3));
                  elimYAgregaValor(auxiliar.toString());
                  }
                  else{
                      System.err.println("Imposible hacer división por 0");
                      divE = true;
                  }
                    break;
                }

            }
            
            
        }
    }
    
    public void elimYAgregaValor(String aux){
        pilaValor.remove(pilaValor.size()-1);
        pilaValor.remove(pilaValor.size()-1);
        pilaValor.put(pilaValor.size()-1, aux);
    }
    /*AQUI TERMINAN LOS METODOS PARA ANALIZAR UNA OPERACION MATEMATICA*/
    
    /*AQUI INICIA METODOS PARA REALIZAR UNA OPERACION LOGICA*/
//Metodo del algoritmo
    public boolean algoritmoAceptacionlogica(String obtenLinea, int linea){
        pila.put(pila.size(), 0);
        String [] tabla = obtenLinea.split(" ");
        while(x < tabla.length){
          if(romp == false)
            if (tabla[x].matches("&")) {
                algoritmoComplejo(tl.and(), linea, tabla[x], 0);
            }
            else if(tabla[x].matches("[|]")){
                algoritmoComplejo(tl.or(), linea, tabla[x], 0);
            }
            else if(tabla[x].matches("[%]")) {
                algoritmoComplejo(tl.igual(), linea, tabla[x], 0);
            }
            else if(tabla[x].matches("[¬]")) {
                algoritmoComplejo(tl.diferente(), linea, tabla[x], 0);
            }
             else if(tabla[x].matches("[>]")) {
                algoritmoComplejo(tl.mayor(), linea, tabla[x], 0);
            }
             else if(tabla[x].matches("[<]")) {
                algoritmoComplejo(tl.menor(), linea, tabla[x], 0);
            }
             else if(tabla[x].matches("[\\^]")) {
                algoritmoComplejo(tl.negacion(), linea, tabla[x], 0);
            }
            else if(tabla[x].matches("vainilla")) {
                algoritmoComplejo(tl.verdad(), linea, tabla[x], 0);
            }
            else if(tabla[x].matches("frutsi")) {
                algoritmoComplejo(tl.falso(), linea, tabla[x], 0);
            }
            else if(!varia.buscIgualdad(tabla[x])){
                algoritmoComplejo(tl.id(), linea, tabla[x], 0);
            }
            else if(tabla[x].matches("[0-9]+")){
                algoritmoComplejo(tl.num(), linea, tabla[x], 0);
            }
            else if(tabla[x].matches("[\\(]")) {
                algoritmoComplejo(tl.parenabre(), linea, tabla[x], 0);
            }
            else if(tabla[x].matches("[\\)]")) {
                algoritmoComplejo(tl.parencierra(), linea, tabla[x], 0);
            }
            else if(tabla[x].matches("[$]")){
                algoritmoComplejo(tl.pesos(), linea, tabla[x], 0);
            }         
            x++;
        }
        romp = false;
        return aceptacion;
    }
    
    //Metodo, verifica si es una operacion logica numerica o con identificadores
    public boolean operacLogic(String obtenLinea, int linea, String palres, LinkedList llist){
        this.llist = llist;
        varia.setIdentificadores(llist);
        String separa[] = obtenLinea.split("\\(");
        
        if(separa[0].equals(palres) && 
          (separa[0].matches("[[\\(|\\)]*[\\d]*[&|[\\|]|==|!=|>|<|^|vainilla|frutsi]{1}[\\d]*[\\(|\\)]]+")||
           separa[0].matches("[[\\(|\\)]*[\\w]*[&|[\\|]|==|!=|>|<|^|vainilla|frutsi]{1}[\\w]*[\\(|\\)]]+"))){
            
            String cad = separa[1].replaceAll("\\s", "");
            String[]  analizar = cad.split("\\)");
            if(aceptarOperacionLogic(analizar[0], linea)){
                if(algoritmoAceptacionlogica(cadena, linea)){
                    aceptacion = false;
                }
            }
        }

        
        return aceptacion;
    }
    
    //Metodo, acepta y concatena la linea logica para poder hacer un split en tabla logica 
    public boolean aceptarOperacionLogic(String obtenLinea, int linea){

            for (int x = 0; x <= obtenLinea.length(); x++) {
                    if(x == obtenLinea.length()){
                       cadena = cadena + " $";
                       aceptacion = true;
                    }
                    else if(!signosLogicos(obtenLinea, x)){
                        cadena = cadena + obtenLinea.charAt(x);
                    }
                    else if(signosLogicos(obtenLinea, x)){
                       cadena = cadena + " " + obtenLinea.charAt(x) + " ";
                    }
                    else if(obtenLinea.contains("vainilla")){
                        cadena = cadena + " ";
                        for(int y = 0; y < 8; y++){
                            cadena = cadena + obtenLinea.charAt(y);
                            x++;
                        }
                        cadena = cadena + " ";
                        
                    }
                    else if(obtenLinea.contains("frutsi")){
                        cadena = cadena + " ";
                        for(int y = 0; y < 6; y++){
                            cadena = cadena + obtenLinea.charAt(y);
                            x++;
                        }
                        cadena = cadena + " ";
                    }
                    
                    
            }
        
        return aceptacion;
    }
    
    //Metodo que verifica si hay operadores, sino en metodo aceptarOperacion retorna un false para no concatenar
    public boolean signosLogicos(String cadena, int linea){
        if(cadena.charAt(linea) == '&' || cadena.charAt(linea) == '|'|| 
           cadena.charAt(linea) == '>' || cadena.charAt(linea) == '<'||
           cadena.charAt(linea) == '¬' || cadena.charAt(linea) == '%'){
            aceptacion = true;
        }
        else{
            aceptacion = false;
        }
        return aceptacion;
    }
    
    public void opLog(){
        boolean  apoyoA = false, apoyoB = false;
       if(pilaValor.get(pilaValor.size() - 1).matches("[0-9]+") && pilaValor.get(pilaValor.size()-3).matches("[0-9]+")){
            if(pilaValor.get(pilaValor.size() - 2).equals(">")){
                if(Integer.parseInt(pilaValor.get(pilaValor.size() - 3)) > Integer.parseInt(pilaValor.get(pilaValor.size()-1))){
                   elimYAgregaValor("vainilla"); 
                }
                else {
                   elimYAgregaValor("frutsi"); 
                }
            }
            else  if(pilaValor.get(pilaValor.size() - 2).equals("<")){
                if(Integer.parseInt(pilaValor.get(pilaValor.size() - 3)) < Integer.parseInt(pilaValor.get(pilaValor.size()-1))){
                   elimYAgregaValor("vainilla"); 
                }
                else {
                   elimYAgregaValor("frutsi"); 
                }
            }
            
            else  if(pilaValor.get(pilaValor.size() - 2).equals("%")){
                if(Integer.parseInt(pilaValor.get(pilaValor.size() - 3)) == Integer.parseInt(pilaValor.get(pilaValor.size()-1))){
                   elimYAgregaValor("vainilla"); 
                }
                else {
                   elimYAgregaValor("frutsi"); 
                }
            }
            
            else if(pilaValor.get(pilaValor.size() - 2).equals("¬")){
                if(Integer.parseInt(pilaValor.get(pilaValor.size() - 3)) != Integer.parseInt(pilaValor.get(pilaValor.size()-1))){
                   elimYAgregaValor("vainilla"); 
                }
                else {
                   elimYAgregaValor("frutsi"); 
                }
            }
             
        }
       else if (pilaValor.get(pilaValor.size()-1).matches("(vainilla|frutsi)") && pilaValor.get(pilaValor.size()-3).matches("(vainilla|frutsi)")){
           if(pilaValor.get(pilaValor.size() - 2).equals("|")){
               
               if(pilaValor.get(pilaValor.size()-1).equals("vainilla"))
                   apoyoA = true;
               if(pilaValor.get(pilaValor.size()-3).equals("vainilla"))
                   apoyoB = true;
               if(apoyoA || apoyoB)
                   elimYAgregaValor("vainilla");
               else
                   elimYAgregaValor("frutsi");
               
           }
           else if(pilaValor.get(pilaValor.size() - 2).equals("&")){
               if(pilaValor.get(pilaValor.size()-1).equals("vainilla"))
                   apoyoA = true;
               if(pilaValor.get(pilaValor.size()-3).equals("vainilla"))
                   apoyoB = true;
               if(apoyoA && apoyoB)
                   elimYAgregaValor("vainilla");
               else
                   elimYAgregaValor("frutsi");
           }
           else if(pilaValor.get(pilaValor.size() - 2).equals("^")){
               if(pilaValor.get(pilaValor.size()-1).equals("vainilla"))
                   apoyoA = true;
               if(!apoyoA)
                   elimYAgregaValor("vainilla");
               else
                   elimYAgregaValor("frutsi");
           }
       }
       else{
           System.err.println("Error, imposible comparar operacion");
           pilaValor.put(0, "null");
       }
    }
    /*AQUI TERMINAN LOS METODOS PARA REALIZAR UNA OPERACION LOGICA*/
}