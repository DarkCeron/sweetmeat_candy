pila segment para stack 'stack'
pila ends
datos segment para public 'data'
imp1     db      "Dame valor$"
imp2     db      "Dame valor 2$"
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