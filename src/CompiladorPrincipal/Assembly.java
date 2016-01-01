/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompiladorPrincipal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 *
 * @author Cesar
 */
public class Assembly {
    String var[] = {"Bubulubu", "Postre"};
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    private int contador_imp, contador_lect, contador_temp, contador_var, contador_res;
    String URL = "C:\\Users\\Ceron\\Documents\\sweetmeat_candy\\src\\Archivos\\";
    private String []    valor1 = new String[10];
    private String []    operacion = new String[10];
    private String []    valor2 = new String[10];
    private String []    impresiones = new String[10];
    private String []    lect = new String[10];
    private LinkedList tempo = new LinkedList();
    private LinkedList resul = new LinkedList();
    /*Metodo obtiene todas las lineas del metodo y las guarda en un hashMap para regresar lo leido del archivo*/
    public LinkedList getProgram(String URL){
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
    }
    /*Fin de metodo que obtiene lineas*/
    
    /*Metodo lee el programa y hace un conteo para agregar variables al ensamblador*/
    public void leeListaProgram(LinkedList programa){
        String programaDec;
        inicializaciones();
        for(int pos = 0; pos < programa.size(); pos++){
            programaDec = (String) programa.get(pos);
            String []programaNDec = programaDec.split(" ");
            String []programaimp = programaDec.split("\\(");
            if(programaNDec[0].equals(var[0])){
                contador_var++;
            }
            else if(programaNDec[0].matches("[T][0-9]+")){
                contador_temp++;
                tempo.add(programaNDec[0]);
            }
            else if(programaDec.matches("[a-zA-Z0-9]+[ ][=][ ][T][0-9]+")){
                contador_res++;
                resul.add(programaNDec[0]);
            }
            else if(programaimp[0].equals("Paleta.payaso")){
                String[] imp = programaimp[1].split("\\)");
                impresiones[contador_imp] = imp[0];
                contador_imp++;
            }
            else if(programaimp[0].equals("Postre")){
                String []lect = programaimp[1].split("\\)");
                this.lect[contador_lect] = lect[0];
                contador_lect++;
            }
        }
        System.out.println("Contador de imp:"+contador_imp+"  "+"Contador de lec:"+contador_lect+"  "+"Contador de res:"+contador_res+"  "+"Contador de temp:"+contador_temp+"  "
            +"Contador de var:"+contador_var+"  ");
       
    }
    /*Fin de metodo*/
    
    public synchronized void imprimeDatosAArchivo(String archivo){
        try{
          File file = new File(URL+archivo+".asm");
          System.out.print("\nCreando archivo");
            for (int i = 0; i < 4; i++) {
              System.out.print(". ");
              wait(200);
              if((i+1) == 4){
                  System.out.println("Documento creado satisfactoriamente...");
              }
            }
          FileWriter f_writ = new FileWriter(file);
          BufferedWriter fn_write = new BufferedWriter(f_writ);
          PrintWriter print_line = new PrintWriter(f_writ);
            /*Aqui codigo para escritura*/
            for(int oper = 0; oper < 22; oper++){
               if(oper < 5)print_line.write(Codigo.suma[oper]+"\r\n"); 
               else if(oper < 10)print_line.write(Codigo.resta[oper-5]+"\r\n"); 
               else if(oper < 15)print_line.write(Codigo.multiplicacion[oper-10]+"\r\n"); 
               else print_line.write(Codigo.division[oper-15]+"\r\n"); 
            }
            print_line.write("pila segment para stack 'stack'\r\n");
            print_line.write("pila ends\r\n");
            print_line.write("datos segment para public 'data'\r\n");
            for(int cont = 0; cont < contador_imp;cont++){
                print_line.write("imp"+(cont+1)+"     db      \""+impresiones[cont].replaceAll("\"", "")+"$\"\r\n");
            }
            for(int contV = 0; contV < contador_temp; contV++){
                print_line.write("T"+(contV+1)+"     dw     6,?,6 dup(?)\r\n");
            }
            for(int contR = 0; contR < contador_res; contR++){
                print_line.write(resul.get(contR)+"   dw    ?\r\n");
            }
            for(int contL = 0; contL < contador_lect; contL++){
                print_line.write(lect[contL]+"   dw    ?\r\n");
            }
            print_line.write("datos ends\r\n");
            print_line.write("extra segment para public 'code'\r\n");
            print_line.write("extra ends\r\n");
            print_line.write("codigo segment para public 'code'\r\n");
            print_line.write("      public principal\r\n");
            print_line.write("      assume cs:codigo, es:extra, ds:datos, ss:pila\r\n");
            print_line.write("          principal proc far\r\n");
            print_line.write("              push    ds\r\n");
            print_line.write("              mov     ax, 0\r\n");
            print_line.write("              push    ax\r\n");
            print_line.write("              mov     ax, datos\r\n");
            print_line.write("              mov     ds, ax\r\n");
            print_line.write("              mov     ax, datos\r\n");
            print_line.write("              mov     es, ax\r\n\r\n");
            /*Codigo importante xD*/
            
            
            
            /*Fin*/
            print_line.write("ret\r\n");
            print_line.write("      principal endp\r\n");
            print_line.write("codigo ends\r\n");
            print_line.write("          end principal");
            //print_line.write("\r\n");
            //print_line.write("\r\n");
                            //print_line.write("Linea a imprimir\r\n");
                            //print_line.append("\r\n");
                        
            /*Fin de codigo*/
            System.out.print("\nEscribiendo en el archivo: "+archivo+".asm"+"\nEspere");
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
    
    /*Inicializa las variables de contador a 0*/
    public void inicializaciones(){
        contador_imp = 0;
        contador_lect = 0;
        contador_temp = 0;
        contador_var = 0;
        contador_res = 0;
    }
    /*Fin de metodo de inicializacion*/
}
