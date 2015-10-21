package Colors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ceron
 */
    public class MiConsole {
  // public static final String BLACK="\033[30m";
  // public static final String RED="\033[31m";
  // public static final String GREEN="\033[32m";
  // public static final String YELLOW ="\033[33m";
  // public static final String BLUE = "\033[34m";
  // public static final String PURPLE = "\033[35m";
  // public static final String CYAN = "\033[36m";
  // public static final String WHITE = "\033[37m";

  /**
   * 
   */
   public static final String ANSI_RESET = "\u001B[0m";
  /**
   * Color Negro, se coloca al inicio de la cadena
   */
   public static final String ANSI_BLACK = "\u001B[30m";
  /**
   * Color Rojo, se coloca al inicio de la cadena
   */
   public static final String ANSI_RED = "\u001B[31m";
  /**
   * Color Verde, se coloca al inicio de la cadena
   */
   public static final String ANSI_GREEN = "\u001B[32m";
  /**
   * Color Amarillo, se coloca al inicio de la cadena
   */
   public static final String ANSI_YELLOW = "\u001B[33m";
  /**
   * Color Azul, se coloca al inicio de la cadena
   */
   public static final String ANSI_BLUE = "\u001B[34m";
  /**
   * Color Purpura, se coloca al inicio de la cadena
   */
   public static final String ANSI_PURPLE = "\u001B[35m";
  /**
   * Color Cyan, se coloca al inicio de la cadena
   */
   public static final String ANSI_CYAN = "\u001B[36m";
  /**
   * Color Blanco, se coloca al inicio de la cadena
   */
   public static final String ANSI_WHITE = "\u001B[37m";

  /**
   * Imprime texto por consola en un determinado color
      * <br/><br/>
      * <b>Ejemplo:<b/><br/><br/>
   * <blockquote>
      * MiConsole.println({@link #ANSI_RED}, "Texto rojo");
      * </blockquote>
      * <br/>
      * @param color el color de la cadena
      * @param txt La cadena de texto a mostrar
      * @see java.io.PrintStream#print(java.lang.String) 
      */
   public static void print(String color, String txt){
     System.out.print(color+txt);
   }

   public static void println(String color, String txt){
     System.out.println(color+txt);
   }

  /**
   * Obtener una cadena en un determinado color
   * @param color el color de la cadena
   * @param txt La cadena de texto a mostrar
   * @return 
   */
   public static String getStringInColor(String color, String txt){
     return color+txt;
   }

}

