/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisLexico;

import Colors.MiConsole;
import CompiladorPrincipal.Principal;
import Repositorio.Variables;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author USUARIO
 */
public class Test {
//comentario
    String a = "a";
    private static String s = "choco";
    private static String name = "ho";
    private static int tope = 0;
    private static String var[];
    private static LinkedList llist;
//comentario
    //otro comentario
    
    public static Principal prin = new Principal();
    public static ValidaPalReserv valpalreserv = new ValidaPalReserv();

    public static void main(String[] args) throws IOException, Exception {
        analizador_v1 av1 = new analizador_v1();
        av1.setName(name);
        /*Direcciones URL para Windows*/
        av1.setArchivo("C:\\Users\\Ceron\\Documents\\sweetmeat_candy\\src\\Archivos\\Programa.Candy");
        String direccion1 = "C:\\Users\\Ceron\\Documents\\sweetmeat_candy\\src\\Archivos\\ho.Candy";
        String direccion2 = "C:\\Users\\Ceron\\Documents\\sweetmeat_candy\\src\\Archivos\\CandyReservID.Candy.txt";
        /*Direcciones URL para Windows*/
        
        /*Direcciones URL para Ubuntu*/
//        av1.setArchivo("/home/ceron/Documentos/sweetmeat_candy/src/Archivos/Programa.Candy");
//        String direccion1 = "/home/ceron/Documentos/sweetmeat_candy/src/Archivos/ho.Candy";
//        String direccion2 = "/home/ceron/Documentos/sweetmeat_candy/src/Archivos/CandyReservID.Candy.txt";
        /*Direcciones URL para Ubuntu*/
        prin.ObtieneLineas(direccion1, direccion2);
        Variables var = new Variables();
        ImpTabSimbolos();
        valpalreserv = null;
    }

    //Metodo para obtener la tabla de la clase variables
    public static void setLlist(LinkedList llist) {
        Test.llist = llist;
    }

    //Imprime la tabla de simbolos
    public static void ImpTabSimbolos() {
        MiConsole.println(MiConsole.ANSI_BLUE, "=================TABLA DE SIMBOLOS===================");
        if (llist != null) {
            for (int x = 0; x < llist.size(); x++) {
                MiConsole.println(MiConsole.ANSI_YELLOW, ((String) llist.get(x)));
            }
        } else {
            llist = prin.llis;
            for (int y = 0; y < llist.size(); y++) {
                MiConsole.println(MiConsole.ANSI_YELLOW, (String) llist.get(y));
            }
        }

    }
}
