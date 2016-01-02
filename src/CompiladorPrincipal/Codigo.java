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
    IMP_CARAC macro resul	 
local imp1	  
	  imp1:
	  ;SUGERIR SACAR DE PILA
	  mov dx,resul
	  add dl,30h
	  mov ah,2
	  int 21h
	  loop imp1	 
endm
    lea dx,cadena1
	  mov ah,0ah
	  int 21h
    
    */
    public static final String [] suma = new String[]{"suma macro var1, var2, resu", "mov ax, var1", "add ax, var2", "mov resu, ax", "endm\r\n"};
    public static final String [] resta = new String[]{"resta macro var1, var2, resu", "mov ax, var1", "sub ax, var2", "mov resu, ax", "endm\r\n"};
    public static final String [] multiplicacion = new String[]{"multi macro var1, var2, resu","mov ax, var1", "mul var2", "mov resu, ax" , "endm\r\n"};
    public static final String [] division = new String[]{"divic macro var1, var2, resu", "mov ax, var1","cwd" , 
                                                          "mov bx, var2" , "div bx" , "mov resu, ax" ,"endm\r\n"};
    public static final String [] impresionCar = new String[]{"imprimeC macro resu", "local imp" , "imp:", "mov dx, resu",
                                                              "add dl, 30h", "mov ah, 2", "int 21h", "loop imp", "endm\r\n"};
    public static final String[] impresion = new String[]{"imprime macro cadena", "lea dx, cadena", "mov ah, 0ah", "int 21h", "endm\r\n"};
}
