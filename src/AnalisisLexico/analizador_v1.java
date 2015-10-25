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

/**
 *
 * @author USUARIO
 */
public class analizador_v1 extends AllComparations{
    private String formato[];
    private String archivo;
    private String auxiliar;
    private int inc = 0;
    private File f_write;
    private String name;
    private int i =1;
    public void setName(String name) {
        this.name = name;
    }
    
/*Metodo para obtener el archivo*/
    public void setArchivo(String archivo) throws FileNotFoundException, IOException {
        this.archivo = archivo;
        //Objetos para leer archivos
        FileReader file_nf = new FileReader(this.archivo);
        BufferedReader lect = new BufferedReader(file_nf);
        
        //Objeto para guardar el archivo
        f_write = new File("/home/ceron/Documentos/sweetmeat_candy/src/Archivos/"+this.name+".Candy");
        
       try{
           //Objetos para escribir en el nuevo documento
           FileWriter f_writ = new FileWriter(f_write);
           BufferedWriter fn_write = new BufferedWriter(f_writ);
           PrintWriter print_line = new PrintWriter(f_writ);
        
        //Ciclo para leer el documento anterior y escribir en el nuevo documento
        while((auxiliar = lect.readLine()) != null){

         //Desicion, para encontrar posibles lineas vacias
            if(auxiliar.matches("()*")){
              auxiliar = "";
              print_line.write(auxiliar);
              print_line.append("\r\n");
             
         }  
            else if(auxiliar.matches("[ ]*[A-Za-z |( )]+[/]+[A-Za-z |( )]+")){
              String nombre[] = auxiliar.split("//");
              auxiliar = nombre[0];
              print_line.write(auxiliar);
              print_line.append("\r\n");
            }
            else if(auxiliar.matches("[ ]*[\\s]+[(//) | (/)]+[A-Za-z |( )]+")){
              
              auxiliar = "";
              print_line.write(auxiliar);
              print_line.append("\r\n");
            }

         
         //Desicion para encontrar comentarios o tabulaciones
         else if((auxiliar.charAt(0) == '/') || (auxiliar.charAt(0) == '\t')){
            for (int rev_cod = 0; rev_cod < auxiliar.length(); rev_cod++) {
                auxiliar.replace("\t", "");
//                Desiciones para eliminar los comentarios
                if((auxiliar.charAt(rev_cod) == '/') && (auxiliar.charAt(rev_cod+1) == '/')){
                    for (int c_blanc = 0; c_blanc < auxiliar.length(); c_blanc++) {
                        auxiliar = "";
                        print_line.write(auxiliar);
                        print_line.append("\r\n");
                    }
                }
                
                //Desiciones para eliminar las tabulaciones
                else if(auxiliar.charAt(rev_cod) == '\t'){
                    for (int c_tab = 0; c_tab < auxiliar.length(); c_tab++) {
                        if(auxiliar.charAt(c_tab) == '\t'){
                            auxiliar = auxiliar.replace("\t", "");
                            print_line.write(auxiliar);
                            print_line.append("\r\n");
                        }
                       
                    }
                    if((auxiliar.charAt(0) == '/') && (auxiliar.charAt(1) == '/')){
                            for (int c_blanc = 0; c_blanc < auxiliar.length(); c_blanc++) {
                        auxiliar = "";
                        print_line.write(auxiliar);
                        //print_line.append("\r\n");
                    }
                        }
                }
            }
          }
         //Ultima desicion, si se encuentra algo diferente a lo anterior
          else {
              print_line.write(auxiliar);
              print_line.append("\r\n");
          } 
            
            //Impresion de todo el archivo ya modificado
            System.out.println((i++)+"||||"+auxiliar);
        }
        
        //Variables para cerrar los archivos abiertos
        lect.close();
        print_line.close();
        fn_write.close();
        f_writ.close();
       }
        catch(IOException e){
                System.err.println(e.getMessage()+" error");
        }
        catch(Exception ex){
            
        }
    }
    
}
