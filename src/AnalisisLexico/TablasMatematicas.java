/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisLexico;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author ceron
 */
public class TablasMatematicas {
    /*COLUMNA DE LA SUMA*/
    public static String posicion;
    public static Map suma(){
        HashMap <Integer, String> mas = new HashMap<Integer, String>();
        
        mas.put(mas.size(), "E");
        mas.put(mas.size(), "S7");
        mas.put(mas.size(), "R3");
        mas.put(mas.size(), "R6");
        mas.put(mas.size(), "E");
        mas.put(mas.size(), "R8");
        mas.put(mas.size(), "R9");
        mas.put(mas.size(), "E");
        mas.put(mas.size(), "E");
        mas.put(mas.size(), "E");
        mas.put(mas.size(), "E");
        mas.put(mas.size(), "S7");
        mas.put(mas.size(), "R1");
        mas.put(mas.size(), "R2");
        mas.put(mas.size(), "R4");
        mas.put(mas.size(), "R5");
        mas.put(mas.size(), "R7");
        return mas;
    }
    /*COLUMNA DE LA RESTA*/
    public static Map resta(){
        HashMap <Integer, String> res = new HashMap<Integer, String>();
        
        res.put(res.size(), "E");
        res.put(res.size(), "S8");
        res.put(res.size(), "R3");
        res.put(res.size(), "R6");
        res.put(res.size(), "E");
        res.put(res.size(), "R8");
        res.put(res.size(), "R9");
        res.put(res.size(), "E");
        res.put(res.size(), "E");
        res.put(res.size(), "E");
        res.put(res.size(), "E");
        res.put(res.size(), "S8");
        res.put(res.size(), "R1");
        res.put(res.size(), "R2");
        res.put(res.size(), "R4");
        res.put(res.size(), "R5");
        res.put(res.size(), "R7");
        return res;
    }
    /*COLUMNA DE LA MULTIPLICACIÓN*/
    public static Map multiplicacion(){
        Map <Integer, String> mul = new HashMap<Integer, String>();
        
        mul.put(mul.size(), "E");
        mul.put(mul.size(), "E");
        mul.put(mul.size(), "S9");
        mul.put(mul.size(), "R6");
        mul.put(mul.size(), "E");
        mul.put(mul.size(), "R8");
        mul.put(mul.size(), "R9");
        mul.put(mul.size(), "E");
        mul.put(mul.size(), "E");
        mul.put(mul.size(), "E");
        mul.put(mul.size(), "E");
        mul.put(mul.size(), "E");
        mul.put(mul.size(), "S9");
        mul.put(mul.size(), "S9");
        mul.put(mul.size(), "R4");
        mul.put(mul.size(), "R5");
        mul.put(mul.size(), "R7");
        return mul;
    }
    /*COLUMNA DE LA DIVISION*/
    public static Map division(){
        Map <Integer, String> div = new HashMap<Integer, String>();
        
        div.put(div.size(), "E");
        div.put(div.size(), "E");
        div.put(div.size(), "S10");
        div.put(div.size(), "R6");
        div.put(div.size(), "E");
        div.put(div.size(), "R8");
        div.put(div.size(), "R9");
        div.put(div.size(), "E");
        div.put(div.size(), "E");
        div.put(div.size(), "E");
        div.put(div.size(), "E");
        div.put(div.size(), "E");
        div.put(div.size(), "S10");
        div.put(div.size(), "S10");
        div.put(div.size(), "R4");
        div.put(div.size(), "R5");
        div.put(div.size(), "R7");
        return div;
    }
    /*COLUMNA DEl PARENTESIS ABIERTO*/
    public static Map parabierto(){
        Map <Integer, String> pabi = new HashMap<Integer, String>();
        
        pabi.put(pabi.size(), "S4");
        pabi.put(pabi.size(), "E");
        pabi.put(pabi.size(), "E");
        pabi.put(pabi.size(), "E");
        pabi.put(pabi.size(), "S4");
        pabi.put(pabi.size(), "E");
        pabi.put(pabi.size(), "E");
        pabi.put(pabi.size(), "S4");
        pabi.put(pabi.size(), "S4");
        pabi.put(pabi.size(), "S4");
        pabi.put(pabi.size(), "S4");
        pabi.put(pabi.size(), "S4");
        pabi.put(pabi.size(), "E");
        pabi.put(pabi.size(), "E");
        pabi.put(pabi.size(), "E");
        pabi.put(pabi.size(), "E");
        pabi.put(pabi.size(), "E");
        return pabi;
    }
    /*COLUMNA DEl PARENTESIS CERRADO*/
    public static Map paracerrado(){
        Map <Integer, String> pcer = new HashMap<Integer, String>();
        
        pcer.put(pcer.size(), "E");
        pcer.put(pcer.size(), "E");
        pcer.put(pcer.size(), "R3");
        pcer.put(pcer.size(), "R6");
        pcer.put(pcer.size(), "E");
        pcer.put(pcer.size(), "R8");
        pcer.put(pcer.size(), "R9");
        pcer.put(pcer.size(), "E");
        pcer.put(pcer.size(), "E");
        pcer.put(pcer.size(), "E");
        pcer.put(pcer.size(), "E");
        pcer.put(pcer.size(), "S16");
        pcer.put(pcer.size(), "R1");
        pcer.put(pcer.size(), "R2");
        pcer.put(pcer.size(), "R4");
        pcer.put(pcer.size(), "R5");
        pcer.put(pcer.size(), "R7");
        return pcer;
    }
    /*COLUMNA DE NUM*/
    public static Map numero(){
        Map <Integer, String> num = new HashMap<Integer, String>();
        
        num.put(num.size(), "S5");
        num.put(num.size(), "E");
        num.put(num.size(), "E");
        num.put(num.size(), "E");
        num.put(num.size(), "S5");
        num.put(num.size(), "E");
        num.put(num.size(), "E");
        num.put(num.size(), "S5");
        num.put(num.size(), "S5");
        num.put(num.size(), "S5");
        num.put(num.size(), "S5");
        num.put(num.size(), "E");
        num.put(num.size(), "E");
        num.put(num.size(), "E");
        num.put(num.size(), "E");
        num.put(num.size(), "E");
        num.put(num.size(), "E");
        return num;
    }
    /*COLUMNA DE ID*/
    public static Map identificador(){
        Map <Integer, String> id = new HashMap<Integer, String>();
        
        id.put(id.size(), "S6");
        id.put(id.size(), "E");
        id.put(id.size(), "E");
        id.put(id.size(), "E");
        id.put(id.size(), "S6");
        id.put(id.size(), "E");
        id.put(id.size(), "E");
        id.put(id.size(), "S6");
        id.put(id.size(), "S6");
        id.put(id.size(), "S6");
        id.put(id.size(), "S6");
        id.put(id.size(), "E");
        id.put(id.size(), "E");
        id.put(id.size(), "E");
        id.put(id.size(), "E");
        id.put(id.size(), "E");
        id.put(id.size(), "E");
        return id;
    }
    /*COLUMNA DEl SIGNO DE PESOS*/
    public static Map signPesos(){
        Map <Integer, String> spes = new HashMap<Integer, String>();
        
        spes.put(spes.size(), "E");
        spes.put(spes.size(), "ACEPT");
        spes.put(spes.size(), "R3");
        spes.put(spes.size(), "R6");
        spes.put(spes.size(), "E");
        spes.put(spes.size(), "R8");
        spes.put(spes.size(), "R9");
        spes.put(spes.size(), "E");
        spes.put(spes.size(), "E");
        spes.put(spes.size(), "E");
        spes.put(spes.size(), "E");
        spes.put(spes.size(), "E");
        spes.put(spes.size(), "R1");
        spes.put(spes.size(), "R2");
        spes.put(spes.size(), "R4");
        spes.put(spes.size(), "R5");
        spes.put(spes.size(), "R7");
        return spes;
    }
    /*COLUMNA DEl A*/
    public static Map A(){
        Map <Integer, String> a = new HashMap<Integer, String>();
        
        a.put(a.size(), "1");
        a.put(a.size(), "E");
        a.put(a.size(), "E");
        a.put(a.size(), "E");
        a.put(a.size(), "11");
        a.put(a.size(), "E");
        a.put(a.size(), "E");
        a.put(a.size(), "E");
        a.put(a.size(), "E");
        a.put(a.size(), "E");
        a.put(a.size(), "E");
        a.put(a.size(), "E");
        a.put(a.size(), "E");
        a.put(a.size(), "E");
        a.put(a.size(), "E");
        a.put(a.size(), "E");
        a.put(a.size(), "E");
        return a;
    }
    /*COLUMNA DEL B*/
    public static Map B(){
        Map <Integer, String> b = new HashMap<Integer, String>();
        
        b.put(b.size(), "2");
        b.put(b.size(), "E");
        b.put(b.size(), "E");
        b.put(b.size(), "E");
        b.put(b.size(), "2");
        b.put(b.size(), "E");
        b.put(b.size(), "E");
        b.put(b.size(), "12");
        b.put(b.size(), "13");
        b.put(b.size(), "E");
        b.put(b.size(), "E");
        b.put(b.size(), "E");
        b.put(b.size(), "E");
        b.put(b.size(), "E");
        b.put(b.size(), "E");
        b.put(b.size(), "E");
        b.put(b.size(), "E");
        return b;
    }
    /*COLUMNA DEL C*/
    public static Map C(){
        Map <Integer, String> c = new HashMap<Integer, String>();
        
        c.put(c.size(), "3");
        c.put(c.size(), "E");
        c.put(c.size(), "E");
        c.put(c.size(), "E");
        c.put(c.size(), "3");
        c.put(c.size(), "E");
        c.put(c.size(), "E");
        c.put(c.size(), "3");
        c.put(c.size(), "3");
        c.put(c.size(), "14");
        c.put(c.size(), "15");
        c.put(c.size(), "E");
        c.put(c.size(), "E");
        c.put(c.size(), "E");
        c.put(c.size(), "E");
        c.put(c.size(), "E");
        c.put(c.size(), "E");
        return c;
    }
    
    /*TABLA DE ESTADOS DE R*/
    public static Map statesr(){
        Map <Integer, String> str = new HashMap<Integer, String>();
        
        str.put((str.size()+1), "A 3");
        str.put((str.size()+1), "A 3");
        str.put((str.size()+1), "A 1");
        str.put((str.size()+1), "B 3");
        str.put((str.size()+1), "B 3");
        str.put((str.size()+1), "B 1");
        str.put((str.size()+1), "C 3");
        str.put((str.size()+1), "C 1");
        str.put((str.size()+1), "C 1");
        return str;
    }
}
