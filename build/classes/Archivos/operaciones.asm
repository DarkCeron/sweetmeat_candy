            imprimir MACRO MSJ;Define macro de impresion de cadenas
                LEA DX,MSJ
                MOV AH,9
                INT 21H
                lea dx,saltoeti
                mov ah,9
                int 21h
            
            ENDM
            
            imprimeid MACRO MSJ;Define macro impresion de id de cadenas
                LOCAL divi1,imp1            
                mov ax,MSJ
                mov cx,0
                mov dx,0
                divi1:
                    div diez
                    push dx
                    mov dx,0
                    inc cx
                    cmp ax,0
                jne divi1
                imp1:
                    pop dx
                    add dl,30h
                    mov ah,2
                    int 21h
                loop imp1
                imprimir saltoeti
            ENDM
            
      
            leenumero MACRO A,B;Define macro lectura de numeros
                LOCAL val1,digParcial1,obvi1,limValida1,impNoValido1,jlimValido1,saleVal1,siValido1,conversion1,brinca1            
                LEA dx,A
                MOV AH, 0AH
                INT 21H
                MOV SI,2
                val1:
                cmp[A+si],'0'
                jl digParcial1
                cmp[A+si],'9'
                jg digParcial1
                mov bl,30h
                sub [A+si],30h
                inc si
                cmp [A+si],0dh
                jne val1
                jmp obvi1
                digParcial1:
                jmp err     
                obvi1:            
                cmp A[1],5
                jl jLimValido1
                mov cx,5
                mov si,0
                mov bx,0
                limValida1:
                mov bl,lim[si]
                mov bh,A[si+2]
                cmp bh,bl
                jg impNoValido1
                jl siValido1
                inc si
                loop limValida1            
                jmp saleVal1
                impNoValido1:
                jmp err
                jlimValido1:
                saleVal1:
                siValido1:            
                mov cx,0
                mov cl,A[1]
                dec cl  
                mov si,0  
                mov ax,0  
                cmp cx,0  
                je brinca1  
                conversion1:  
                mov bl,A[si+2]  
                add ax,bx  
                mul diez
                inc si  
                loop conversion1  
                cmp cx,0              
                brinca1:
                mov bl,A[si+2]
                add ax,bx
                mov B,ax
                imprimir saltoeti
            ENDM
            
 
            leer MACRO A;Define macro lectura
                LEA dx,A
                MOV AH, 0AH
                INT 21H
            ENDM
            
        
            
                suma MACRO A,B;Define macro suma
                    MOV AX, A
                    MOV DX, B
                    ADD AX, DX
                ENDM  
                                          
            
            
                resta MACRO A,B;Define macro resta
                    MOV AX, A
                    MOV DX, B
                    SUB AX, DX
                ENDM 
            
            
            
                multi MACRO A,B;Define macro multiplicacion
                    MOV AX, A
                    MOV DX, B
                    MUL DX
                ENDM 
            
            
            
                divi MACRO A,B;Define macro division
                    MOV AX, A
                    CWD
                    MOV BX, B
                    DIV BX
                ENDM 
            
            
            
            
pila  SEGMENT PARA STACK 'STACK' 
    db 64h dup(00h)
pila  ENDS

datos SEGMENT PARA PUBLIC 'DATA' 
    lim db 6,5,5,3,5
    diez dw 0ah
    ERROR db "ERROR... Ocurrio un error inesperado$"
    lecdn db 6,?,6 dup(?)
    saltoeti db 10,13,"$"
imp1     db      "Dame valor",10,13, "$"
imp2     db      "Dame valor 2",10,13, "$"
T1     dw     ?
T2     dw     ?
T3     dw     ?
T4     dw     ?
T5     dw     ?
T6     dw     ?
bu   dw    ?
hi   dw    ?
holi   dw    ?
otra   dw    ?
datos ENDS

extra SEGMENT PARA PUBLIC 'DATA' 
extra ENDS
codigo SEGMENT PARA PUBLIC 'CODE'
PUBLIC principal
principal PROC FAR 
ASSUME CS:codigo, DS:datos, SS:pila, ES:extra
    PUSH DS
    MOV AX,0
    PUSH AX 
    MOV AX, datos
    MOV DS,AX 
    MOV AX, extra
    MOV ES,AX
     imprimir imp1
     leenumero lecdn,bu
      multi 13, 10
      MOV T1, AX
      divi bu, 2
      MOV T2, AX
      suma T1, T2
      MOV T3, AX
      suma T3, 30
      MOV T4, AX
     MOV AX,  T4
     MOV hi , AX
     imprimeid hi 
     imprimir imp2
     leenumero lecdn,otra
      multi 10, 5
      MOV T5, AX
      suma T5, bu
      MOV T6, AX
     MOV AX,  T6
     MOV holi , AX
     imprimeid holi 
    jmp salir
    err:
    imprimir ERROR
    salir:

RET
principal ENDP
codigo ENDS
END principal
