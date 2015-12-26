/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisLexico;

import static AnalisisLexico.TablasMatematicas.statesr;
import Repositorio.Variables;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author ceron
 */
public class Operaciones {
    private String[] resultados = new String[]{"","","","","","","","","",""};
    public int c = 0, temporalNo = 1, borraValores = 0, posValor, auxPosValor;
    public boolean aceptacion = false, romp = false, divE = false, haztemp = false, retorna_operacion = false;
    public String cadena = "", ID = "", desp = "", aux, valorIgual = "", tempo = "", variable;
    public int x = 0;
    public Map<Integer, Integer> pila = new HashMap<Integer, Integer>();
    public Map<Integer, String> pilaValor = new HashMap<Integer, String>();
    private Map<Integer, String> espejoLista = new HashMap<Integer, String>();
    public TablasMatematicas tm = new TablasMatematicas();
    public logica tl = new logica();
    public LinkedList llist;
    public LinkedList temporales = new LinkedList();
    private Variables varia = new Variables();
    private Codigo_intermedio codeint = new Codigo_intermedio();
    String supm []={"Pastelito","MedioPastelito","Paleta.Payaso", "Dulce de chocolate(){", "paletita", "Postre"};
    /*METODO PRINCIPAL PARA VERIFICAR OPERACIONES LOGICAS Y MATEMATICAS*/
    public void  algoritmoComplejo(Map obj, int linea, String signo, int LoM, String LectORNoLect) throws FileNotFoundException, IOException {
        boolean salR = true;
        String cadena;
        Map<Integer, String> hm = new HashMap<Integer, String>();
        Map<Integer, String> tab = new HashMap<Integer, String>();
        do{
        hm = obj;
            desp = hm.get(pila.get(c))+"";
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
               if(pililla == 3 && pilaValor.size() >= 2){
                   if(LoM == 1){
                        RealizaOperacion();
                   }
                   
                   else{
                        opLog(linea);
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
            }
            else if(desp.equals("ACEPT")){
                if(LoM == 1){
                    System.out.println("La cadena matematica ha sido aceptada.  Valor: "+pilaValor.get(0));
                    if(divE == false){
                        varia.ModificaValIdentificador(aux, pilaValor.get(0), LectORNoLect);
                       temporales.add(codeint.hazTemporal(espejoLista.get(espejoLista.size()-1), signo, variable, temporalNo, temporales, 5, 0, 0));
                        for (int x = 0; x < temporales.size() ;x++) {
                            System.out.println(temporales.get(x));
                            tempo = (String)temporales.get(x)+"\\n";
                        }
                        
                        retorna_operacion = true;
                    }
                }
                else{
                    if(divE == false){
                    System.out.println("La cadena logica ha sido aceptada.  Valor: "+pilaValor.get(0));
                    }
                    else
                        System.out.println("La cadena logica ha sido aceptada.");
                }
                
                salR = false;
            }
            else {
                System.err.println("ERROR FATAL en un "+signo+". Error en la linea: "+linea);
                salR = false;
                romp = true;
            }
            
            c = pila.size()-1;
        }while(salR);
        //Verifica si es numero o ID y que sea distinto a "(" o ")"
        if(!signo.equals("(") && !signo.equals(")")){
            //Verifica que sea igual a un ID y distinto a una palabra reservada booleana
            if(signo.matches("[A-Za-z]+") && !signo.matches("vainilla") && !signo.matches("frutsi")){
                ID = signo;
                valorIgual = ID;
                signo=varia.obtieneValor(signo);
                if(varia.ObtieneLeerORNoLeer(ID)) espejoLista.put(espejoLista.size(),ID);
                else espejoLista.put(espejoLista.size(),signo);
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
                ID = "";
            }
            //Si es digito lo agrega al EspejoLista
            else{
            espejoLista.put(espejoLista.size(), signo);
            pilaValor.put(pilaValor.size(), signo);
            }
        }
    }
    /*TERMINA METODO PRINCIPAL PARA VERIFICAR OPERACIONES LOGICAS Y MATEMATICAS*/

    /*AQUI COMIENZAN LOS METODOS PARA ANALIZAR UNA OPERACION MATEMATICA*/
    //Metodo del algoritmo
    public boolean algoritmoAceptacion(String obtenLinea, int linea, String Lect) throws FileNotFoundException, IOException {
        romp = false;
        haztemp = false;
        pila = new HashMap<Integer, Integer>();
        x = 0;
        c = 0;
        pila.put(pila.size(), 0);
        String oldtable = obtenLinea.replaceAll("  ", " ");
        String [] tabla = oldtable.split(" ");
        for(int v = 0; v < tabla.length; v++)
            if(varia.ObtieneLeerORNoLeer(tabla[v])){
                haztemp = true;
                posValor = v;
                break;
            }
        while(x < tabla.length){
          auxPosValor = x;
          if(romp == false){
            if(tabla[x].matches("[0-9]+")){
                algoritmoComplejo(tm.numero(), linea, tabla[x], 1, Lect);
            }
            else if(tabla[x].matches("[A-Za-z]+") && !varia.buscIgualdad(tabla[x])){
                algoritmoComplejo(tm.identificador(), linea, tabla[x], 1, Lect);
            }
            else if(tabla[x].matches("[*]")){
                algoritmoComplejo(tm.multiplicacion(), linea, tabla[x], 1, Lect);
            }
            else if(tabla[x].matches("[/]")) {
                algoritmoComplejo(tm.division(), linea, tabla[x], 1, Lect);
            }
            else if (tabla[x].matches("[+]")) {
                algoritmoComplejo(tm.suma(), linea, tabla[x], 1, Lect);
            } 
            else if(tabla[x].matches("[\\-]")) {
                algoritmoComplejo(tm.resta(), linea, tabla[x], 1, Lect);
            } 
            else if(tabla[x].matches("[\\(]")) {
                algoritmoComplejo(tm.parabierto(), linea, tabla[x], 1, Lect);
            }
            else if(tabla[x].matches("[\\)]")) {
                algoritmoComplejo(tm.paracerrado(), linea, tabla[x], 1, Lect);
            }
            else if(tabla[x].matches("[$]")) {
                algoritmoComplejo(tm.signPesos(), linea, tabla[x], 1, Lect);
            }
            else if(!varia.buscIgualdad(tabla[x]) && (!tabla[x].matches("[\\s]+")|| !tabla[x].equals(""))){
                System.err.println("Error, la variable '"+tabla[x]+"' no ah sido inicializada. Error en la linea: "+linea);
                x  = tabla.length;
                aceptacion = false;
            }
          }
            x++;
        }
       // romp = false;
        for (int limpia = 1; limpia < resultados.length; limpia++) {
            resultados[limpia] = "";
        }
        espejoLista.clear();
        pila.clear();
        pilaValor.clear();
        haztemp = false;
        return aceptacion;
    }
    
    //Metodo, verifica si es una operacion matematica numerica o con identificadores
    public boolean operacMate(String obtenLinea, int linea, LinkedList llis, String Lectura) throws FileNotFoundException, IOException {
        haztemp = false;
        varia.setIdentificadores(llis);
        if(!obtenLinea.contains(supm[0]) && !obtenLinea.contains(supm[1]) && !obtenLinea.contains(supm[2]) && 
           !obtenLinea.contains(supm[3]) && !obtenLinea.contains(supm[4]) && !obtenLinea.contains(supm[5])){
        String cad = obtenLinea.replaceAll("\\s", "");
        String[] cadnew = cad.split("=");
        variable = cadnew[0];
        String[] cadl = cadnew[1].split(";");
        aux = cadnew[0]+"";
        if(cadl[0].matches("[[\\(|\\)]*[\\d]*[*|\\-|+|/]{1}[\\d]*[\\(|\\)]]+")||
           cadl[0].matches("[[\\(|\\)]*[\\w]*[*|\\-|+|/]{1}[\\w]*[\\(|\\)]]+")){

            if(aceptarOperacionMate(cadl[0], linea)){
                if(algoritmoAceptacion(cadena, linea, Lectura)){
                    aceptacion = true;
                    cadena = "";
                }
                else aceptacion = false;
            }
        }
        else{
            System.err.println("Eror de sintaxis. Imposible hacer operacion, linea: "+linea);
            aceptacion = false;
        }
        }
        //pila = null;
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
    
    //Metodo realiza la operacion y agrega temporales a espejoLista
    public void RealizaOperacion(){
        Integer auxiliar = 0;
        
        if(pilaValor.size() >= 3){
           char valor[] = (pilaValor.get(pilaValor.size()-2)).toCharArray();
            switch(valor[0]){
                case '+':{
                  if(haztemp == true){
                  verificacionTemporales(espejoLista.get(espejoLista.size()-3), Character.toString(valor[0]), espejoLista.get(espejoLista.size()-1));
                  String aux = (String)temporales.get(temporales.size()-1);
                  String auxLast[] = aux.split(" ");
                  elimYAgregaValorEspejo(auxLast[0]);
                  resultados[temporalNo] = auxLast[0]+"";
                    temporalNo++;
                  }
                  auxiliar = Integer.parseInt(pilaValor.get(pilaValor.size()-1)) + Integer.parseInt(pilaValor.get(pilaValor.size()-3));
                  elimYAgregaValor(auxiliar.toString());
                    break;
                }
                case '-':{
                  if(haztemp == true){
                  verificacionTemporales(espejoLista.get(espejoLista.size()-3), Character.toString(valor[0]), espejoLista.get(espejoLista.size()-1));
                  String aux = (String)temporales.get(temporales.size()-1);
                  String auxLast[] = aux.split(" ");
                  elimYAgregaValorEspejo(auxLast[0]);
                  resultados[temporalNo] = auxLast[0]+"";
                    temporalNo++;
                  }
                  auxiliar = Integer.parseInt(pilaValor.get(pilaValor.size()-1)) - Integer.parseInt(pilaValor.get(pilaValor.size()-3));
                  elimYAgregaValor(auxiliar.toString());
                    break;
                }
                case '*':{
                  if(haztemp == true){
                  verificacionTemporales(espejoLista.get(espejoLista.size()-3), Character.toString(valor[0]), espejoLista.get(espejoLista.size()-1));
                  String aux = (String)temporales.get(temporales.size()-1);
                  String auxLast[] = aux.split(" ");
                  elimYAgregaValorEspejo(auxLast[0]);
                  resultados[temporalNo] = auxLast[0]+"";
                    temporalNo++;
                  }
                  auxiliar = Integer.parseInt(pilaValor.get(pilaValor.size()-1)) * Integer.parseInt(pilaValor.get(pilaValor.size()-3));
                  elimYAgregaValor(auxiliar.toString());
                    break;
                }
                case '/':{
                  if(Integer.parseInt(pilaValor.get(pilaValor.size()-3)) != 0 || espejoLista.get(espejoLista.size()-3).matches("[a-zA-Z]+")){
                  if(haztemp == true){
                  verificacionTemporales(espejoLista.get(espejoLista.size()-3), Character.toString(valor[0]), espejoLista.get(espejoLista.size()-1));
                  String aux = (String)temporales.get(temporales.size()-1);
                  String auxLast[] = aux.split(" ");
                  elimYAgregaValorEspejo(auxLast[0]);
                  resultados[temporalNo] = auxLast[0]+"";
                    temporalNo++;
                  }
                  auxiliar = Integer.parseInt(pilaValor.get(pilaValor.size()-3)) / Integer.parseInt(pilaValor.get(pilaValor.size()-1));
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
    
    //Metodo verifica los temporales, para guardar la operacion del temporal
        public void verificacionTemporales(String valor1, String signo, String valor2){
        int tem1 = 0, tem2 = 0;
        boolean ban1 = false, ban2 = false;
        if(haztemp == true){
            
            for (int rev = borraValores; rev < resultados.length; rev++) {
                if(!resultados[rev].equals(valor1))
                    ban1 = true;    
                else{
                    ban1 = false;
                    tem1 = rev;
                    break;
                }
            }
            for (int rev = 1; rev < resultados.length; rev++) {
                if(!resultados[rev].equals(valor2))
                    ban2 = true;
                else{
                    ban2 = false;
                    tem2 = rev;
                    break;
                }
            }
            if (ban1 == true && ban2 == true){
                temporales.add(codeint.hazTemporal(valor1, signo, valor2, temporalNo, temporales, 1,  0 , 0));
            }
            else if(ban1 == false && ban2 == true){ 
                temporales.add(codeint.hazTemporal(valor1, signo, valor2, temporalNo, temporales, 2, tem1, 0));
            }
            else if(ban1 == true && ban2 == false){
                temporales.add(codeint.hazTemporal(valor1, signo, valor2, temporalNo, temporales, 3,  0  , tem1));
            }
            else{
                temporales.add(codeint.hazTemporal(valor1, signo, valor2, temporalNo, temporales, 4, tem1, tem2));
                borraValores += 2;
            }
        }
    }
     
    //Metodo elimina y agrega valor para operacion    
    public void elimYAgregaValor(String aux){
        pilaValor.remove(pilaValor.size()-1);
        pilaValor.remove(pilaValor.size()-1);
        pilaValor.put(pilaValor.size()-1, aux);
    }
    //Metodo elimina y agrega valor para temporal
    public void elimYAgregaValorEspejo(String aux){
        espejoLista.remove(espejoLista.size()-1);
        espejoLista.remove(espejoLista.size()-1);
        espejoLista.put(espejoLista.size()-1, aux);
    }
    //Obtiene el temporal del linkedList de esta clase
    public LinkedList ObtenTemporales(){
        return this.temporales;
    }
    /*AQUI TERMINAN LOS METODOS PARA ANALIZAR UNA OPERACION MATEMATICA*/
    
    /*AQUI INICIA METODOS PARA REALIZAR UNA OPERACION LOGICA*/
//Metodo del algoritmo
    public boolean algoritmoAceptacionlogica(String obtenLinea, int linea, String Lect) throws FileNotFoundException, IOException {
        romp = false;
        pila = new HashMap<Integer, Integer>();
        x = 0;
        c = 0;
        pila.put(pila.size(), 0);
        String [] tabla = obtenLinea.split(" ");
        while(x < tabla.length){
          if(romp == false)
            if (tabla[x].matches("&")) {
                algoritmoComplejo(tl.and(), linea, tabla[x], 0, Lect);
            }
            else if(tabla[x].matches("[|]")){
                algoritmoComplejo(tl.or(), linea, tabla[x], 0, Lect);
            }
            else if(tabla[x].matches("[%]")) {
                algoritmoComplejo(tl.igual(), linea, tabla[x], 0, Lect);
            }
            else if(tabla[x].matches("[¬]")) {
                algoritmoComplejo(tl.diferente(), linea, tabla[x], 0, Lect);
            }
             else if(tabla[x].matches("[>]")) {
                algoritmoComplejo(tl.mayor(), linea, tabla[x], 0, Lect);
            }
             else if(tabla[x].matches("[<]")) {
                algoritmoComplejo(tl.menor(), linea, tabla[x], 0, Lect);
            }
             else if(tabla[x].matches("[\\^]")) {
                algoritmoComplejo(tl.negacion(), linea, tabla[x], 0, Lect);
            }
            else if(tabla[x].matches("vainilla")) {
                algoritmoComplejo(tl.verdad(), linea, tabla[x], 0, Lect);
            }
            else if(tabla[x].matches("frutsi")) {
                algoritmoComplejo(tl.falso(), linea, tabla[x], 0, Lect);
            }
            else if(!varia.buscIgualdad(tabla[x])){
                algoritmoComplejo(tl.id(), linea, tabla[x], 0, Lect);
            }
            else if(tabla[x].matches("[0-9]+")){
                algoritmoComplejo(tl.num(), linea, tabla[x], 0, Lect);
            }
            else if(tabla[x].matches("[\\(]")) {
                algoritmoComplejo(tl.parenabre(), linea, tabla[x], 0, Lect);
            }
            else if(tabla[x].matches("[\\)]")) {
                algoritmoComplejo(tl.parencierra(), linea, tabla[x], 0, Lect);
            }
            else if(tabla[x].matches("[$]")){
                algoritmoComplejo(tl.pesos(), linea, tabla[x], 0, Lect);
            }         
            x++;
        }
//        romp = false;
        pila.clear();
        pilaValor.clear();
        return aceptacion;
    }
    
    //Metodo, verifica si es una operacion logica numerica o con identificadores
    public boolean operacLogic(String obtenLinea, int linea, String palres, LinkedList llist, String Lectura) throws FileNotFoundException, IOException {
        this.llist = llist;
        varia.setIdentificadores(llist);
        String separa[] = obtenLinea.split("\\("), valor = "";
        
        if(separa[0].equals(palres) && 
          (separa[0].matches("[[\\(|\\)]*[\\d]*[&|[\\|]|==|!=|>|<|^|vainilla|frutsi]{1}[\\d]*[\\(|\\)]]+")||
           separa[0].matches("[[\\(|\\)]*[\\w]*[&|[\\|]|==|!=|>|<|^|vainilla|frutsi]{1}[\\w]*[\\(|\\)]]+"))){
                    valor = obtenLinea.replaceAll(palres, "") + "";
                if(obtenLinea.contains("{")){
                    valor = valor.replaceAll("\\{", "") + "";
                }
                if(obtenLinea.contains("}")){
                    valor = valor.replaceAll("\\}", "") + "";
                }
            String cad = valor.replaceAll("\\s", "");
            
            if(aceptarOperacionLogic(cad, linea)){
                if(algoritmoAceptacionlogica(cadena, linea, Lectura)){
                    aceptacion = false;
                    cadena = "";
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
           cadena.charAt(linea) == '¬' || cadena.charAt(linea) == '%'||
           cadena.charAt(linea) == '(' || cadena.charAt(linea) == ')'){
            aceptacion = true;
        }
        else{
            aceptacion = false;
        }
        return aceptacion;
    }
    
    public void opLog(int linea){
        boolean  apoyoA = false, apoyoB = false;
        if(pilaValor.get(pilaValor.size()-1).matches("(vainilla|frutsi)") && pilaValor.get(pilaValor.size() - 2).contains("^")){
               if(pilaValor.get(pilaValor.size()-1).equals("vainilla"))
                   apoyoA = true;
               if(!apoyoA){
               pilaValor.remove(pilaValor.size()-1);
               pilaValor.put(pilaValor.size()-1, "vainilla");
                }
               else{
                   pilaValor.remove(pilaValor.size()-1);
                   pilaValor.put(pilaValor.size()-1, "vainilla");
                }
           }
        else if(pilaValor.get(pilaValor.size() - 1).matches("[0-9]+") && pilaValor.get(pilaValor.size()-3).matches("[0-9]+")){
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
           
       }
       else{
           System.err.println("Error, imposible comparar operacion. Linea: "+linea);
           divE = true;
       }
    }
    /*AQUI TERMINAN LOS METODOS PARA REALIZAR UNA OPERACION LOGICA*/

    void setCad(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setOperaciones(LinkedList llis, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
