/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisLexico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author USUARIO
 */
public class CandyProgram {
    private static String name;

    private static boolean bandera = false;
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        analizador_v1 av1 = new analizador_v1();
        do{
        System.out.println("¿Como desea llamar el nuevo documento?");
        name  = scan.readLine();
        if(name.matches("(quit){1}")){
            System.out.println("Has salido satisfactoriamente");
            bandera = true;
        }
        else if(name.matches("([A-Za-z]){1,20}")){
            
            av1.setName(name);
            av1.setArchivo("/home/ceron/Escritorio/Compiladores/src/Archivos/Programa.Candy");
            System.out.println("Documento creado satisfactoriamente");
            bandera = true;
        }
        else{
           
            System.err.println("Grror, no se permiten caracteres o digitos");
        }
        }while(bandera != true);
       
        
    }
    
}
