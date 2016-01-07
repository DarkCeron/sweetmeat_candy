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
    boolean valida = false;
    int extension = 10;
    String var[] = {"Bubulubu", "Postre"};
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    private int contador_imp, contador_lect, contador_temp, contador_var, contador_res;
    String URL = "C:\\Users\\Ceron\\Documents\\sweetmeat_candy\\src\\Archivos\\";
    private String []    valor1 = new String[extension];
    private String []    operacion = new String[extension];
    private String []    valor2 = new String[extension];
    private String []    impresiones = new String[extension];
    private String []    lect = new String[extension];
    private String []    TemRes = new String[extension];
    private String []    bubulubu = new String[extension];
    private LinkedList tempo = new LinkedList();
    private LinkedList resul = new LinkedList();
    /*Metodo obtiene todas las lineas del metodo y las guarda en un linkedlist para regresar lo leido del archivo*/
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
    
    /*Metodo obtiene todas las lineas del metodo y las guarda en un linkedlist para regresar lo leido del archivo*/
    public LinkedList getMacros(String URL){
        String auxiliar;
        LinkedList macros = new LinkedList();
        try{
        FileReader file_nf = new FileReader(URL+".txt");
            BufferedReader lect = new BufferedReader(file_nf);
            while((auxiliar = lect.readLine()) != null){
                macros.add(auxiliar);
            }
            
        } 
        catch(FileNotFoundException fnfe){
            System.err.println("No se encuentra el archivo especificado, ERROR: "+fnfe.getMessage());
        }
        catch (IOException ex) {
            System.err.println("Error en variables de entrada y salida, ERROR: "+ex.getMessage());
        }
        return macros;
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
                String tempo[] = programaNDec[1].split(";");
                bubulubu[contador_var] = tempo[0];
                contador_var++;
            }
            else if(programaNDec[0].matches("[T][0-9]+")){
                tempo.add(programa.get(pos));
                contador_temp++;
            }
            else if(programaDec.matches("[a-zA-Z0-9]+[ ][=][ ][T][0-9]+")){
                TemRes[contador_res] = programaNDec[2];
                resul.add(programaNDec[0]);
                contador_res++;
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
    
    public synchronized void imprimeDatosAArchivo(String archivo, LinkedList macros, LinkedList programa){
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
            for(int contL = 0; contL < macros.size(); contL++){
                print_line.write(macros.get(contL)+"\r\n");
            }
            print_line.println("pila  SEGMENT PARA STACK 'STACK' ");
            print_line.println("    db 64h dup(00h)");
            print_line.println("pila  ENDS");
            print_line.println();
            print_line.println("datos SEGMENT PARA PUBLIC 'DATA' ");            
            print_line.println("    lim db 6,5,5,3,5");
            print_line.println("    diez dw 0ah");
            print_line.println("    ERROR db \"ERROR... Ocurrio un error inesperado$\"");            
            print_line.println("    lecdn db 6,?,6 dup(?)");            
            print_line.println("    saltoeti db 10,13,\"$\"");
            for(int cont = 0; cont < contador_imp;cont++){
                print_line.write("imp"+(cont+1)+"     db      \""+impresiones[cont].replaceAll("\"", "")+"\",10,13, \"$\"\r\n");
            }
            for(int contV = 0; contV < contador_temp; contV++){
                print_line.write("T"+(contV+1)+"     dw     ?\r\n");
            }
            for(int contL = 0; contL < contador_var; contL++){
                print_line.write(bubulubu[contL]+"   dw    ?\r\n");
            }
            print_line.println("datos ENDS");
            print_line.println();
            print_line.println("extra SEGMENT PARA PUBLIC 'DATA' ");
            print_line.println("extra ENDS");
            print_line.println("codigo SEGMENT PARA PUBLIC 'CODE'");
            print_line.println("PUBLIC principal");
            print_line.println("principal PROC FAR ");
            print_line.println("ASSUME CS:codigo, DS:datos, SS:pila, ES:extra");
            print_line.println("    PUSH DS");
            print_line.println("    MOV AX,0");
            print_line.println("    PUSH AX ");
            print_line.println("    MOV AX, datos");
            print_line.println("    MOV DS,AX ");
            print_line.println("    MOV AX, extra");
            print_line.println("    MOV ES,AX");  
            
            int num = 1;
             for(int prog = 0 ; prog < programa.size() ; prog++){
                if(prog < programa.size()-1){
                 if(((String)programa.get(prog)).contains("Paleta.payaso")){
                     print_line.write("     imprimir imp"+num+"\r\n");
                     num++;
                 }
                 else if(((String)programa.get(prog)).contains("Postre")){
                     String []te = ((String)programa.get(prog)).split("\\(");
                     String []te1 = te[1].split("\\)");
                     print_line.write("     leenumero lecdn,"+te1[0]+"\r\n");
                 }
                 else if(((String)programa.get(prog)).matches("[a-zA-Z0-9]+( )?=( )?[T][0-9]+")){
                     String []te  = ((String)programa.get(prog)).split("=");
                     print_line.write("     MOV AX, "+te[1]+"\r\n");
                     print_line.write("     MOV "+te[0]+", AX\r\n");
                     print_line.write("     imprimeid "+te[0]+"\r\n");
                 }
                 else{
                     for(int car = 0 ; car < ((String)programa.get(prog)).length() ; car++){
                         String []valores = ((String)programa.get(prog)).split(" ");
                         switch(((String)programa.get(prog)).charAt(car)){
                            case '+':{
                                print_line.write("      suma "+valores[2]+", "+valores[4]+"\r\n");
                                print_line.write("      MOV "+valores[0]+", AX\r\n");
                                valida = true;
                            break;
                            }
                            case '-':{
                                print_line.write("      resta "+valores[2]+", "+valores[4]+"\r\n");
                                print_line.write("      MOV "+valores[0]+", AX\r\n");
                                valida = true;
                            break;
                            }
                            case '*':{
                                print_line.write("      multi "+valores[2]+", "+valores[4]+"\r\n");
                                print_line.write("      MOV "+valores[0]+", AX\r\n");
                                valida = true;
                            break;
                            }
                            case '/':{
                                print_line.write("      divi "+valores[2]+", "+valores[4]+"\r\n");
                                print_line.write("      MOV "+valores[0]+", AX\r\n");
                                valida = true;
                            break;
                            }
                        }
                    }
                 }
                }
             }
            /*Fin*/
            print_line.println("    jmp salir");
            print_line.println("    err:");
            print_line.println("    imprimir ERROR");
            print_line.println("    salir:\r\n");
            print_line.println("RET");
            print_line.println("principal ENDP");
            print_line.println("codigo ENDS");
            print_line.println("END principal");
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
