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
            for(int contDTH = 0; contDTH < Codigo.digAHex.length;contDTH++){
                print_line.write(Codigo.digAHex[contDTH]+"\r\n");
            }
            for(int leeD = 0; leeD < (Codigo.leerNum.length+Codigo.valida.length);leeD++){
                if(leeD < Codigo.leerNum.length)print_line.write(Codigo.leerNum[leeD]+"\r\n");
                else print_line.write(Codigo.valida[leeD-Codigo.leerNum.length]+"\r\n");
            }
            for(int impres = 0 ; impres < (Codigo.impresionCar.length + Codigo.impresion.length); impres++){
                if(impres < Codigo.impresion.length)  print_line.write(Codigo.impresion[impres]+"\r\n");
                else    print_line.write(Codigo.impresionCar[impres-Codigo.impresion.length]+"\r\n");
            }
            for(int oper = 0 ; oper < 22 ; oper++){
               if(oper < 5)     print_line.write(Codigo.suma[oper]+"\r\n"); 
               else if(oper < 10)    print_line.write(Codigo.resta[oper-5]+"\r\n"); 
               else if(oper < 15)    print_line.write(Codigo.multiplicacion[oper-10]+"\r\n"); 
               else      print_line.write(Codigo.division[oper-15]+"\r\n"); 
            }
            print_line.write("pila segment para stack 'stack'\r\n");
            print_line.write("pila ends\r\n");
            print_line.write("datos segment para public 'data'\r\n");
            print_line.write("digito     db     \"Solo se aceptan numeros\",10,13, \"$\"\r\n");
            print_line.write("limite     db     \"Es mayor a 65536\",10,13, \"$\"\r\n");
            for(int cont = 0; cont < contador_imp;cont++){
                print_line.write("imp"+(cont+1)+"     db      \""+impresiones[cont].replaceAll("\"", "")+"\",10,13, \"$\"\r\n");
            }
            print_line.write("limite    db     6,5,5,3,5\r\n");
            print_line.write("di    dw     0ah\r\n");
            print_line.write("valorDAH    dw     ?\r\n");
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
            
            for(int cont = 0; cont < contador_lect;cont++){
                print_line.write("imprime imp"+(cont+1)+"\r\n");
                print_line.write("leeT "+lect[cont]+"\r\n");
                print_line.write("digToHex "+lect[cont]+"\r\n");
            }
            
            int cont = 0;
            String [] signo = new String[5];
            do{ 
                if(valida != true && cont < contador_temp){
                    signo = ((String) tempo.get(cont)).split(" ");
                    System.out.println(tempo.get(cont));
                }
                else signo[3] = "x";
                switch(signo[3]){
                    case "+":{
                        print_line.write("suma "+signo[2]+", "+signo[4]+", "+signo[0]+"\r\n");
                        valida = true;
                        break;
                    }
                    case "-":{
                        print_line.write("resta "+signo[2]+", "+signo[4]+", "+signo[0]+"\r\n");
                        valida = true;
                        break;
                    }
                    case "*":{
                        print_line.write("multi "+signo[4]+", "+signo[2]+", "+signo[0]+"\r\n");
                        valida = true;
                        break;
                    }
                    case "/":{
                        print_line.write("divic "+signo[2]+", "+signo[4]+", "+signo[0]+"\r\n");
                        valida = true;
                        break;
                    }
                    case "x":{
                        /*for(int contVa = 0; contVa < Codigo.valida.length;contVa++){
                        print_line.write(Codigo.valida[contVa]+"\r\n");
                        }*/
                        valida = false;
                        cont++;
                        break;
                    }
                }
                //cont++;
            }while(cont != contador_temp);
            for(int c = 0; c < contador_res;c++){
                System.out.println(TemRes[c]);
            }
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
