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
imp1     db      "Dame valor$"
imp2     db      "Dame valor 2$"
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

ret
      principal endp
codigo ends
          end principal