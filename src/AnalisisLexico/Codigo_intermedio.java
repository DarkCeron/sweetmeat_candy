/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisLexico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 *
 * @author Cesar
 */
public class Codigo_intermedio {
    private File f_write; 
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
                temporal = "T"+NoDeTemporal+" ="+" T"+temp1+" "+signo+" "+Valor2;
                break;
            }
            case 3:{
                temporal = "T"+NoDeTemporal+" = "+Valor1+" "+signo+" T"+temp2;
                break;
            }
            case 4:{
                temporal = "T"+NoDeTemporal+" = "+"T"+temp1+" "+signo+" T"+temp2;
                break;
            }
            case 5:{
                temporal = Valor2+" = "+Valor1;
            }
        }
           
        return temporal;
    }
    public void guardaAArchivo(String aux) throws FileNotFoundException, IOException {
        FileReader file_nf = new FileReader("temporales");
        BufferedReader lect = new BufferedReader(file_nf);
        f_write = new File("C:\\Users\\Ceron\\Documents\\sweetmeat_candy\\src\\Archivos\\temporales.txt");
        try{
        //Objetos para escribir en el nuevo documento
           FileWriter f_writ = new FileWriter(f_write);
           BufferedWriter fn_write = new BufferedWriter(f_writ);
           PrintWriter print_line = new PrintWriter(f_writ);
           while((aux = lect.readLine()) != null){
               
               print_line.write(aux);
               print_line.append("\r\n");
               
           }
            
        lect.close();
        print_line.close();
        fn_write.close();
        f_writ.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
}
