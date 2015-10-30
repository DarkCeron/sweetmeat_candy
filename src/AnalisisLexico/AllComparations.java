/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisLexico;

import java.io.*;
import java.util.LinkedList;


/**
 *
 * @author USUARIO
 */
/**
 *
 * fsdhergoirthro foihrtoirh
 * 
 */
public class AllComparations{
    String VaciadoPalReserv;
    protected String auxiliar;
    protected String date;
    protected int increasse = 0;
    boolean busc;
    File f;
    
    String tableID[];
    LinkedList lil;
    LinkedList LlistGet = new LinkedList();
    int i = 0, id = 0, line = 1;
    String PalReserv[] = new String[]{"choco","bubulubu","caramelo",
                                      "bombon" ,"frutsi" ,"vainilla" ,
                                      "Pastelito" ,"MedioPastelito" ,
                                      "Paleta.payaso" , "Postre"};

    public void getVaciado(String archivo) throws FileNotFoundException, IOException {
        this.VaciadoPalReserv = archivo;
        FileReader file_nf = new FileReader(this.VaciadoPalReserv);
        BufferedReader lect = new BufferedReader(file_nf);
         lil = new LinkedList();
        while((auxiliar = lect.readLine()) != null){
            
            lil.add(auxiliar);

        }
        lect.close();
    }
    
        public void getDateForTable(String archivo, LinkedList lil) throws IOException {
        this.VaciadoPalReserv = archivo;
        FileReader file_nf = new FileReader(this.VaciadoPalReserv);
        BufferedReader lect = new BufferedReader(file_nf);
        lil = new LinkedList();
        while((auxiliar = lect.readLine()) != null){
            for (i = 0; i < PalReserv.length; i++) {
                String pp[] = auxiliar.split("\\(");
                if(pp[0].equals(PalReserv[8])){
                    ObtainPrint(auxiliar, PalReserv[8], id, lil, line);
                }
                String busc[] = auxiliar.split(";");
                String buscn[] = busc[0].split(" ");
                if(buscn[0].equals(PalReserv[i])){
                    getDesiciones(auxiliar,PalReserv[i] , id, lil, line);
                }
                else {
                    getTablaDesicion(auxiliar, this.lil, line);
                }
                id++;
            }
            line++;
        }
        lect.close();
    }
        
    public void getDesiciones(String var,String palres , int ext, LinkedList llis, int line){
        String var1[] = var.split(";");
        String variables[] = var1[0].split(" ");
        for (int j = 0; j < variables.length; j++) {
              if(FormatReserv(variables[j+1]) && variables[1].matches("[a-zA-Z]+")){
                if((!variables[j+1].matches("[ ]+") && !variables[j+1].matches("[()]*")) && variables[j] != ";"){
                    getMoreDates(variables[j+1], variables[j], setPalReserv(palres), "ID"+ext, llis, line);
                    break;
                }
                
                else{
                    System.err.println("ERROR: Hay uno o mas espacios en la variable "+palres +"Linea: "+line);
                    break;
                }
            }
            else if(!FormatReserv(variables[1])){
                  System.err.println("ERROR: La variable "+variables[1]+" es una palabra reservada. Linea: "+line);
                  break;
            }
            else{
                  System.err.println("ERROR: La variable "+variables[1]+" no puede ser inicializada. Linea: "+line);
                  break;
            }    
    }
    }
    public void ObtainPrint(String var,String palres , int ext, LinkedList llis, int line){
        boolean ban  = true;
        String var1[] = var.split("\\(");
        String cad[] = var1[1].split("\\)");
      exit:{
            if(cad[0].startsWith("\"")){
                System.out.println("Paleta.payaso imprimió "+cad[0]);
                break exit;
            }
        for(int obp = 0; obp < llis.size(); obp++){
            String CadTabSim = (String)llis.get(obp);
            String CadTabSimbols[] = CadTabSim.split(":");
            if(cad[0].equals(CadTabSimbols[0])){
                System.out.println("Paleta.payaso imprimió "+CadTabSimbols[2]);
                break exit;
            }
            else if(obp == (llis.size()-2)){
                System.err.println("La variable '"+cad[0]+"' no existe en la tabla de simbolos. Error en la linea: "+line);
                break exit;
        }
        }
      }
        
    }
    
    public void getTablaDesicion(String search, LinkedList Llist, int line){
        String aux = "";
        String busc[] = search.split(";");
        String buscn[] = busc[0].split(" ");
        System.out.println("efrthrerh   "+buscn[0]);
        for(int it = 0; it < buscn.length; it++){
            if(buscn[it].startsWith("\"")){
                for (int j = it; j < buscn.length; j++) {
                    aux +=(buscn[j]+" ");
                }
//                for (int j = it; j > 0; j--) {
//                    if(buscn[j].equals("=")) {
//                        getDeclarTabSim(buscn[0], aux, LlistGet, line); 
//                    }
//                }
            }
            else if(buscn[it].equals("=")){
                
                getDeclarTabSim(buscn[it-1],buscn[it+1],LlistGet,line);
            }
        }
    }
    
    public void getDeclarTabSim(String name, String value, LinkedList llis , int line){
        boolean ban = false;
        Operaciones op = new Operaciones();
//        String val[] = value.split(";");
//        if(val[0].equals(PalReserv[9])) {
//            ban = true;
//        }
        //op.setOperaciones(llis, value);
        Exit: {     
                System.err.println(value);
                op.setCad(value);
                op.setOperaciones(llis, value);
        for (int j = 0; j < llis.size(); j++) {
            String val[] = value.split(";");
            String nuevolist =(String)llis.get(j);
            String newList[] = nuevolist.split(":");
            
            if(newList[0].equals(name)){
                getValidaValor(newList[1], name, val[0], newList[3], llis, j, line);
                ban = true;
                break Exit;
                
            }
            else if(val[0].equals(PalReserv[9])){
                System.out.println("Caracter leido exitosamente");
                ban = true;
                break Exit;
            }
            else if(ban == false)  {
                System.err.println("Caracter invalido '"+val[0]+"'. Error en la linea: "+line);
                break Exit;
            }
            
        }
        }
    }

    public void getValidaValor(String palres, String name, String value, String ID, LinkedList list , int posicion, int line){
        //Palabra reservada CHOCO
        
        if(value.startsWith("\"") && palres.equals(PalReserv[0])){
            if(value.matches("[ ]*[\"]([a-zA-Z0-9 |( )])*[\"][ ]*")){
                String nval[] = value.split("\"");
                list.set(posicion, name+":"+palres+":"+nval[1]+":"+ID);
            }
            else System.err.println("Error de sintaxis ("+PalReserv[0]+"):"+(name+"  "+value)+", cadena invalida. Error en linea: "+line);
        }
        //Palabra reresvada CARAMELO
        else if(value.startsWith("\'") && palres.equals(PalReserv[2])){
            if(value.matches("[ ]*[\'][[a-zA-Z0-9]|( )][\'][ ]*")){
                String nval[] = value.split("\'");
                list.set(posicion, name+":"+palres+":"+nval[1]+":"+ID);
            }
            else System.err.println("Error de sintaxis ("+PalReserv[2]+"):"+(name+" "+value)+", solo puede aceptar 1 caracter. Error en linea: "+line);
        }
        else if(value.equals(PalReserv[4]) || value.equals(PalReserv[5])){
            list.set(posicion, name+":"+palres+":"+value+":"+ID);

        }
        if(value.matches("[0-9]{1,5}")){
           list.set(posicion, name+":"+palres+":"+value+":"+ID); 
            
        }
        
        //Igualacion de variables
        for (int j = 0; j < list.size(); j++) {
            String nuevolist = (String)list.get(j);
            String newList[] = nuevolist.split(":");
            if(newList[0].equals(value)){
                if(newList[1].equals(palres))  list.set(posicion, name+":"+palres+":"+newList[2]+":"+ID);
                else {System.err.println("Error: la variable '"+name+"' no puede igualarse por que no es del mismo tipo. Error en linea: "+line);
                break;}
            }
        }
        
    }
    
    public String []setTable(String name, String value, int line,String arraylength){
        String table[] = new String[2];
        return table;
    }
    
    public void getMoreDates(String name, String type, String val, String ID, LinkedList lil, int line){
        boolean bandera = false;
        int x = 0;
        String varnew[] = new String[lil.size()];
        try{
            for(x = 0;x < varnew.length; x++){
                varnew[x] = (String)lil.get(x);
                String varx[] = varnew[x].split(":");
                if(varx[0].equals(name)){
                    bandera = true;
                    break;
                }
            }
            lil.add(name+":"+type+":"+val+":"+ID);
            setLlist(lil);
            if(bandera == true){
                lil.removeLast();
                System.err.println("La variable '"+name+"' no se declaro por que ya existe en Tabla de Simbolos."
                        + "Type: "+type+" ID: "+ID+". En linea:"+line);
                throw new Exception();
            }
        }
        catch(Exception e){
            
        }
    } 
    
    public void setLlist(LinkedList l){
        this.LlistGet = l;
    }
    
    public void getDates(){
        System.out.println("=========TABLA DE SIMBOLOS===========\n");
        for (int j = 0; j < this.LlistGet.size(); j++) {
            System.out.println(this.LlistGet.get(j));
        }
    }
    
    public boolean FormatReserv(String date){
        boolean fa = true;
        for (int j = 0; j < PalReserv.length; j++) {
            if(PalReserv[j].equals(date)){
                fa = false;
                j = (int)PalReserv.length;
                break;
            }
            else if(fa == true){
                fa = true;
            }
        }
            if(fa != false){
             return true;   
            }
            else{
                return false;
            }
    }
    
    public String setPalReserv(String date){
        
            if(PalReserv[0] == date){
                return "";
            }
            else if(PalReserv[1] == date){
                return "0";
            }
            else if(PalReserv[2] == date){
                return "''";
            }
            else if(PalReserv[3] == date){
                return "frutsi";
            }
            else if(PalReserv[4] == date){
                return "frutsi";
            }
            else if(PalReserv[3] == date){
                return "vainilla";
            }
            else{
                return "";
            }
    }
        
    public void getList(LinkedList lil){
        this.lil = lil;
    }
    
    public LinkedList setList(){
        return lil;
    }
    
    public void setCompare(String archivo, String compar) throws FileNotFoundException, IOException {
        this.VaciadoPalReserv = archivo;
        FileReader file_nf = new FileReader(this.VaciadoPalReserv);
        BufferedReader lect = new BufferedReader(file_nf);
        while((auxiliar = lect.readLine()) != null){
            
        }
        lect.close();
    }  
    
}

