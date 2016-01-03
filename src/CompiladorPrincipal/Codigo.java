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
  CONASCII macro  ;macro para convertir hexadecimal en decimal 
  local imp1
  imp1:
  div diez
  push dx
  mov dx,0
  inc cx
  cmp ax,0
  jne imp1
endm
    
    */
    public static final String [] suma = new String[]{"suma macro var1, var2, resu", "mov ax, var1", "add ax, var2", "mov resu, ax", "endm\r\n"};
    
    public static final String [] resta = new String[]{"resta macro var1, var2, resu", "mov ax, var1", "sub ax, var2", "mov resu, ax", "endm\r\n"};
    
    public static final String [] multiplicacion = new String[]{"multi macro var1, var2, resu","mov ax, var1", "mul var2", "mov resu, ax" , "endm\r\n"};
    
    public static final String [] division = new String[]{"divic macro var1, var2, resu", "mov ax, var1","cwd" , 
                                                          "mov bx, var2" , "div bx" , "mov resu, ax" ,"endm\r\n"};
    
    public static final String [] impresionCar = new String[]{"imprimeC macro resu", "local imp" , "imp:", "mov dx, resu",
                                                              "add dl, 30h", "mov ah, 2", "int 21h", "loop imp", "endm\r\n"};
    
    public static final String[] impresion = new String[]{"imprime macro cadena", "lea dx, cadena", "mov ah, 0ah", "int 21h", "endm\r\n"};
    
    public static final String[] valida = new String[]{"mov si, 2", "regresa:", "cmp[varAGuar+1],'0'", "jl error", "cmp[varAGuar+si],'9'", "jg error","mov bl, 30h",
                                                       "sub[varAGuar+si], 30h", "inc si", "cmp[varAGuar+si], 0dh", "jne regresa", "jmp acpt","error:",
                                                       "imprime digito", "acpt:", "endm\r\n"};
    
    public static final String[] digAHex = new String[]{"digToHex macro numero", "local salto, conver", "mov cx, 0", "mov cl, numero[1]", "dec cl", "mov si, 0", "mov ax, 0",
                                                        "cmp cx, 0", "je salto", "conver:", "mov bl, numero[si+2]", "add ax, bx", "mul dig", "inc si", "loop conver", "cmp cx, 0",
                                                        "salto:", "mov bl, numero[si+2]", "add ax, bx", "mov valorDAH, ax", "mov numero, valorDAH", "endm\r\n"};
    
    public static final String[] leerNum = new String[]{"leeT macro varAGuar", "local regresa, error, acpt", "lea dx, varAGuar", "mov ah, 0ah", "int 21h"};
    
    public static final String[] Ascii = new String[]{"hexToDig macro"};
    
}
