digToHex macro numero
local salto, conver
mov cx, 0
mov cl, numero[1]
dec cl
mov si, 0
mov ax, 0
cmp cx, 0
je salto
conver:
mov bl, numero[si+2]
add ax, bx
mul di
inc si
loop conver
cmp cx, 0
salto:
mov bl, numero[si+2]
add ax, bx
mov valorDAH, ax
mov numero, valorDAH
endm

leeT macro varAGuar
local regresa, error, acpt
lea dx, varAGuar
mov ah, 0ah
int 21h
mov si, 2
regresa:
cmp[varAGuar+1],'0'
jl error
cmp[varAGuar+si],'9'
jg error
mov bl, 30h
sub[varAGuar+si], 30h
inc si
cmp[varAGuar+si], 0dh
jne regresa
jmp acpt
error:
imprime digito
acpt:
endm

imprime macro cadena
lea dx, cadena
mov ah, 0ah
int 21h
endm

imprimeC macro resu
local imp
imp:
mov dx, resu
add dl, 30h
mov ah, 2
int 21h
loop imp
endm

suma macro var1, var2, resu
mov ax, var1
add ax, var2
mov resu, ax
endm

resta macro var1, var2, resu
mov ax, var1
sub ax, var2
mov resu, ax
endm

multi macro var1, var2, resu
mov ax, var1
mul var2
mov resu, ax
endm

divic macro var1, var2, resu
mov ax, var1
cwd
mov bx, var2
div bx
mov resu, ax
endm

pila segment para stack 'stack'
pila ends
datos segment para public 'data'
digito     db     "Solo se aceptan numeros",10,13, "$"
limite     db     "Es mayor a 65536",10,13, "$"
imp1     db      "Dame valor",10,13, "$"
imp2     db      "Dame valor 2",10,13, "$"
limite    db     6,5,5,3,5
di    dw     0ah
valorDAH    dw     ?
T1     dw     6,?,6 dup(?)
T2     dw     6,?,6 dup(?)
T3     dw     6,?,6 dup(?)
T4     dw     6,?,6 dup(?)
T5     dw     6,?,6 dup(?)
T6     dw     6,?,6 dup(?)
hi   dw    ?
holi   dw    ?
bu   dw    ?
du   dw    ?
datos ends
extra segment para public 'code'
extra ends
codigo segment para public 'code'
      public principal
      assume cs:codigo, es:extra, ds:datos, ss:pila
          principal proc far
              push    ds
              mov     ax, 0
              push    ax
              mov     ax, datos
              mov     ds, ax
              mov     ax, datos
              mov     es, ax

imprime imp1
leeT bu
digToHex bu
imprime imp2
leeT du
digToHex du
multi 10, 13, T1
divic bu, 2, T2
suma T1, T2, T3
suma T3, 30, T4
multi 5, 10, T5
suma T5, bu, T6
ret
      principal endp
codigo ends
          end principal