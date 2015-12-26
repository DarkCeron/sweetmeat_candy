/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompiladorPrincipal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Cesar
 */
public class Assembly {
    String var[] = {"Bubulubu", "Postre"};
    public LinkedList getProgram(String URL){
        /*Metodo obtiene todas las lineas del metodo y las guarda en un hashMap para regresar lo leido del archivo*/
        String auxiliar;
        LinkedList programa = new LinkedList();
        try{
        FileReader file_nf = new FileReader(URL+".Candy");
            BufferedReader lect = new BufferedReader(file_nf);
            while((auxiliar = lect.readLine()) != null){
                programa.add(auxiliar);
            }
            
        } 
        catch(FileNotFoundException fnfe){
            System.err.println("No se encuentra el archivo especificado, ERROR: "+fnfe.getMessage());
        }
        catch (IOException ex) {
            System.err.println("Error en variables de entrada y salida, ERROR: "+ex.getMessage());
        }
        return programa;
    /*Fin de metodo que obtiene lineas*/
    }
    
    public void leeListaProgram(LinkedList programa){
        String programaDec;
        for(int pos = 0; pos < programa.size(); pos++){
            programaDec = (String) programa.get(pos);
            String []programaNDec = programaDec.split(" ");
            if(programaNDec[0].equals(var[0])){
                
            }
            else if(programaNDec[0].matches("[T][0-9]+")){
                
            }
            else if(programaDec.matches("[a-zA-Z0-9]+[ ][=][ ][T][0-9]+")){
                
            }
            else if(programaDec.matches(var[1]+"[\\(][a-zA-Z0-9]+[\\)];")){
                
            }
        }
        
    } 
}
