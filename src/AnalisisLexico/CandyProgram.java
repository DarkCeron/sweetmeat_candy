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
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author USUARIO
 */
public class CandyProgram {
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    boolean ban = false;
    String auxiliar;
    String URL = "C:\\Users\\Cesar\\Documents\\sweetmeat_candy\\src\\Archivos\\";
    private static boolean bandera = false;
    /*Metodo que crea el archivo de texto vacio*/
    public void CreaArchivo(String nombre) throws IOException, InterruptedException {
        
       File archivo = new File(URL+nombre+".Candy");
       BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            
    }
    /*Fin de metodo para crear archivo*/
    
    /*Metodo obtiene todas las lineas del metodo y las guarda en un hashMap para regresar lo leido del archivo*/
    public LinkedList obtieneDatosArchivo(String nombre){
       
        LinkedList programa = new LinkedList();
        try{
        FileReader file_nf = new FileReader(URL+nombre+".Candy");
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
    }
    /*Fin de metodo que obtiene lineas*/
    
    /*Metodo que guarda los datos de lectura y temporales al nuevo archivo ya creado*/
    public synchronized void guardaDatos(String archivo1, String archivo2, LinkedList lineasPrograma, LinkedList temporales){
        try{
            int tope = 0, pos = 0;
          FileReader file_nf = new FileReader(URL+archivo1+".Candy");
          scan = new BufferedReader(file_nf);
          File file = new File(URL+archivo2+".Candy");
          System.out.print("\nCreando archivo");
            for (int i = 0; i < 4; i++) {
              System.out.print(". ");
              wait(200);
              if((i+1) == 4){
                  System.out.println("Documento creado satisfactoriamente...");
              }
            }
            if(file.createNewFile()) System.err.println("Archivo creado");
          FileWriter f_writ = new FileWriter(file);
          BufferedWriter fn_write = new BufferedWriter(f_writ);
          PrintWriter print_line = new PrintWriter(f_writ);
            for (pos = 0; pos < lineasPrograma.size(); pos++) {
                
                for (int pos2 = 0; pos2 < temporales.size(); pos2++) {
                    if(regresaValDePosicion(temporales, 0, pos2).equals(regresaValDePosicion(lineasPrograma, 0, pos))){
                        for (int escLinea = tope; escLinea < pos2+1; escLinea++) {
                            print_line.write((String)temporales.get(escLinea)+"\r\n");
                           // print_line.append("\r\n");
                        }
                        tope = pos2+1;
                        if(pos < lineasPrograma.size()-1)  pos++;
                        break;
                    }
                }
                //tope ++;
                if(pos < lineasPrograma.size()){
                print_line.write((String)lineasPrograma.get(pos));
                print_line.append("\r\n");
                }
            }
            System.out.print("\nEscribiendo en el archivo: "+archivo2+".Candy"+"\nEspere");
            for (int i = 0; i < 4; i++) {
              System.out.print(". ");
              wait(200);
              if((i+1) == 4){
                  System.out.println("\nDocumento escrito satisfactoriamente...");
              }
            }
            scan.close();
            print_line.close();
            fn_write.close();
            f_writ.close();
        }
        catch(FileNotFoundException fnfe){
            System.err.println("No se encuentra el archivo especificado, ERROR: "+fnfe.getMessage());
        }
        catch (IOException ex) {
            System.err.println("Error en variables de entrada y salida, ERROR: "+ex.getMessage());
        }
        catch(InterruptedException ie){
            System.err.println("Error al tratar de hacer un tiempo de espera..."+ie.getMessage());
        }
    }
    /*Fin de metodo que guarda los datos*/
    
    /*Metodo que retorna una frase de la linea*/
    public String regresaValDePosicion(LinkedList Linea, int posicion, int posicionLinea){
        String linea = (String)Linea.get(posicionLinea);
        String[] valor = linea.split(" ");
        return valor[posicion];
    }
    /*Fin de metodo que regresa una frase de una linea*/
}
