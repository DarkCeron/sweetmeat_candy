/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompiladorPrincipal;

import AnalisisLexico.*;
import Repositorio.Variables;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.*;

/**
 *
 * @author ceron
 */
public class Principal {
    ValidaPalReserv valpalreserv = new ValidaPalReserv();
    private String lineaAuxiliar, vis;
    private int linea = 1;
    public static LinkedList llis = new LinkedList();
    Variables var = new Variables();
    ValidaIDIgualacion valiga = new ValidaIDIgualacion();
    DesCicloMain desc = new DesCicloMain();
    Map <Integer, Integer> llaveAb = new HashMap<Integer, Integer>();
    public void ObtieneLineas(String obtenLinea, String direccion2){
        try {
            
            FileReader file_nf = new FileReader(obtenLinea);
            BufferedReader lect = new BufferedReader(file_nf);
            while((lineaAuxiliar = lect.readLine()) != null){
                
                valpalreserv.setVaciatabla(direccion2);
                valiga.setVaciatabla(direccion2);
                valpalreserv.noEncontrado = false;
                if(valpalreserv.ValidaPalabra(lineaAuxiliar, linea));
                else if(desc.EvaluaBloques(lineaAuxiliar, linea, valpalreserv.var.llist));
                else{
                    System.err.println("Error en la linea: "+linea+". Sintaxis no comprendida");
                }
                if(lineaAuxiliar.contains("{")){
                    llaveAb.put(llaveAb.size(), linea);
                }
                else if(lineaAuxiliar.contains("}")){
                    llaveAb.remove(llaveAb.size()-1);
                }
                linea++;
            }
            if(!llaveAb.isEmpty()){
                System.err.println("Error en la linea:"+llaveAb.get(llaveAb.size()-1)+". No se ah serrado una llave");
            }
            llis = var.getIdentificadores();
            var.ImpTabSimbolos();
        } 
        
        catch(FileNotFoundException fnfe){
            System.err.println("No se encuentra el archivo especificado, ERROR: "+fnfe.getMessage());
        }
        catch (IOException ex) {
            System.err.println("Error en variables de entrada y salida, ERROR: "+ex.getMessage());
        }
    }
}