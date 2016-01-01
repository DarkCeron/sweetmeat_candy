/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompiladorPrincipal;

/**
 *
 * @author Ceron
 */
public class Codigo {
    /*
    divi MACRO va1,va2,T
mov ax,va1
         cwd
          mov bx,va2
          
          div bx
          mov T,ax
endm
    */
    public static final String [] suma = new String[]{"suma macro var1, var2, resu", "mov ax, var1", "add ax, var2", "mov resu, ax", "endm\r\n"};
    public static final String [] resta = new String[]{"resta macro var1, var2, resu", "mov ax, var1", "sub ax, var2", "mov resu, ax", "endm\r\n"};
    public static final String [] multiplicacion = new String[]{"multi macro var1, var2, resu","mov ax, var1", "mul var2", "mov resu, ax" , "endm\r\n"};
    public static final String [] division = new String[]{"divic macro var1, var2, resu", "mov ax, var1","cwd" , 
                                                          "mov bx, var2" , "div bx" , "mov resu, ax" ,"endm\r\n"};
}
