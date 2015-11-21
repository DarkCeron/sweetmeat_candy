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

/**
 *
 * @author ceron
 */
//Metodo para hacer validaciones de las palabras reservadas
public class ValidaPalReserv {
    private int id;
    public String vaciatabla, identificador,varAConcat,TablaVaciandoVT, TablaVaciandoID, separParen[],separIgual[];
    public boolean noEncontrado = false;
    Test t = new Test();
    public Variables var = new Variables();
    ValidaIDIgualacion vIDI = new ValidaIDIgualacion();
    Operaciones operac = new Operaciones();
    public boolean ValidaPalabra(String obtenLinea, int linea){
                String varAConca[]  = obtenLinea.split(" ");
                if(ValSiEsPalReserv(varAConca[0])){
                    identificador = Concatenaciones(varAConca);
                    separParen = identificador.split(" ");
                    
                    if(ValSiEsPalReserv(varAConca[0]) && !ValSiEsPalReserv(separParen[1])){
                        if(separParen[1].matches("([a-zA-Z0-9])+")){
                        var.setAgregaIdentificador(separParen[1], varAConca[0], var.retValPorDefecto(varAConca[0]), "ID"+linea, linea, "N");
                        noEncontrado = true;
                        }
                        else if(separParen[1].matches("([a-zA-Z])+[=]([0-9])+")){
                            separIgual = separParen[1].split("=");
                            var.setAgregaIdentificador(separIgual[0], varAConca[0], separIgual[1], "ID"+linea, linea, "N");
                        }
                        else if(separParen[1].matches("[a-zA-Z]+[=][vainilla|frutsi]")){
                            System.out.println("holaaaa");
                            
                        }
                        else if(separParen[1].matches("([a-zA-Z])+[=]([a-zA-Z])+")){
                            separIgual = separParen[1].split("=");
                            var.setAgregaIdentificador(separIgual[0], varAConca[0], var.retValPorDefecto(varAConca[0]), "ID"+linea, linea, "N");
                            var.BuscID(separIgual[0], separIgual[1], linea);
                        }
                        else if(separParen[1].matches("([a-zA-Z])+[=](\"|\')([a-zA-Z])+(\"|\')")){
                            separIgual = separParen[1].split("=");
                            var.setAgregaIdentificador(separIgual[0], varAConca[0], var.retValPorDefecto(varAConca[0]), "ID"+linea, linea, "N");
                            var.ModificaValIdentificador(separIgual[0], separIgual[1], "N");
                        }
                        
                    }
                    else{
                        System.err.println("Error, la variable'"+separParen[1]+"' es una palabra reservada. Linea: "+linea);
                    }
                    
                }
                else if((!obtenLinea.matches("[\\s]+")|| !obtenLinea.equals("")) && obtenLinea.contains("=")){
                    if(!obtenLinea.contains("vainilla") && !obtenLinea.contains("frutsi") && operac.operacMate(obtenLinea, linea, var.llist, "N")){
                    noEncontrado = true;
                    }
                    else{
                        String []val = vIDI.separaTodo(obtenLinea);
                        var.ModificaValIdentificador(val[0], val[1], "N");
                        noEncontrado = true;
                    }
                }
                else if(vIDI.ValidaID(obtenLinea, linea) && (!obtenLinea.matches("[\\s]+")|| !obtenLinea.equals(""))){
                        String []val = vIDI.separaTodo(obtenLinea);
                        var.BuscID(val[0], val[1], linea);
                        noEncontrado = true;
                }
                else if(vIDI.ValidaVal(obtenLinea, linea) && (!obtenLinea.matches("[\\s]+")|| !obtenLinea.equals(""))){
                       String[] val = vIDI.separaTodo(obtenLinea);
                       var.ModificaValIdentificador(val[0], val[1], "N");
                       noEncontrado = true;
                }
                else if((obtenLinea.matches("[\\s]+")|| obtenLinea.equals(""))){
                    noEncontrado = true;
                }
                return noEncontrado;
    }
    public boolean ValidaEIguala(String obtenLinea, int linea){
        boolean ban = false;
        String sep[];
        String varAConca[]  = obtenLinea.split(" ");
                if(ValSiEsPalReserv(varAConca[0])){
                    identificador = Concatenaciones(varAConca);
                    sep = identificador.split(" ");
                    if(ValSiEsPalReserv(varAConca[0]) && !ValSiEsPalReserv(sep[1])){
                        if(sep[1].matches("[a-zA-Z]+[=][a-zA-Z]")){
                            System.out.println(sep[1]+"    "+!ValSiEsPalReserv(sep[1]));
                        }
                    }
                    
                }
        return ban;
    }
    
    //Obtiene la url o direccion de la tabla de nuestro archivo txt de palabras reservadas
    public void setVaciatabla(String vaciatabla) {
        this.vaciatabla = vaciatabla;
    }
    
    //Metodo para hacer cualquier concatenacion necesaria
    public String Concatenaciones(String [] array){
        String concat = " ";
        for(int x = 1; x < array.length;x++){
            concat += array[x];
        }
        String []c = concat.split(";");
        return c[0];
    }
    public boolean ValSiEsPalReserv(String valor){
        boolean banVac = false;
        try {
            
            FileReader file_nf = new FileReader(vaciatabla);
            BufferedReader lect = new BufferedReader(file_nf);
            while((TablaVaciandoVT = lect.readLine()) != null){
                if(valor.equals(TablaVaciandoVT)){
                    banVac = true;
                    break;
                }
            }

            
            //var.ImpTabSimbolos();
        } 
        catch(FileNotFoundException fnfe){
            System.err.println("No se encuentra el archivo especificado, ERROR: "+fnfe.getMessage());
        }
        catch (IOException ex) {
            System.err.println("Error en variables de entrada y salida, ERROR: "+ex.getMessage());
        }
        if(banVac) return true;
        else{ return false;}
    }
    
}
