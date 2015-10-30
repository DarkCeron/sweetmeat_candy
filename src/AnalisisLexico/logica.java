package AnalisisLexico;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class logica{

 
   static String t="";

   
   public static Map pesos(){
      HashMap <Integer, String> pes = new HashMap<Integer, String>();
               
      pes.put(pes.size(),"E");
      pes.put(pes.size(),"ACEPT");
      pes.put(pes.size(),"R3");
      pes.put(pes.size(),"R6");
      pes.put(pes.size(),"R9");
      pes.put(pes.size(),"E");
      pes.put(pes.size(),"E");
      pes.put(pes.size(),"R12");
      pes.put(pes.size(),"R13");
      pes.put(pes.size(),"R14");
      pes.put(pes.size(),"R15");
      pes.put(pes.size(),"E");
      pes.put(pes.size(),"E");
      pes.put(pes.size(),"E");
      pes.put(pes.size(),"E");
      pes.put(pes.size(),"E");
      pes.put(pes.size(),"E");
      pes.put(pes.size(),"R10");
      pes.put(pes.size(),"E");
      pes.put(pes.size(),"R1");
      pes.put(pes.size(),"E");
      pes.put(pes.size(),"R4");
      pes.put(pes.size(),"R5");
      pes.put(pes.size(),"R7");
      pes.put(pes.size(),"R8");
      pes.put(pes.size(),"R11");//
      return pes;
   }
   
   public static Map and(){
      HashMap <Integer,String> and = new HashMap <Integer,String>();
      
             
      and.put(and.size(),"E");
      and.put(and.size(),"S11");
      and.put(and.size(),"R3");
      and.put(and.size(),"R6");
      and.put(and.size(),"R9");
      and.put(and.size(),"E");
      and.put(and.size(),"E");
      and.put(and.size(),"R12");
      and.put(and.size(),"R13");
      and.put(and.size(),"R14");
      and.put(and.size(),"R15");
      and.put(and.size(),"E");
      and.put(and.size(),"E");
      and.put(and.size(),"E");
      and.put(and.size(),"E");
      and.put(and.size(),"E");
      and.put(and.size(),"E");
      and.put(and.size(),"R10");
      and.put(and.size(),"S11");
      and.put(and.size(),"R1");
      and.put(and.size(),"R2");
      and.put(and.size(),"R4");
      and.put(and.size(),"R5");
      and.put(and.size(),"R7");
      and.put(and.size(),"R8");
      and.put(and.size(),"R11");   
      return and;
   
   }
   
   public static Map or(){
      HashMap <Integer,String> or = new HashMap <Integer,String>();
      
               
      or.put(or.size(),"E");
      or.put(or.size(),"S12");
      or.put(or.size(),"R3");
      or.put(or.size(),"R6");
      or.put(or.size(),"R9");
      or.put(or.size(),"E");
      or.put(or.size(),"E");
      or.put(or.size(),"R12");
      or.put(or.size(),"R13");
      or.put(or.size(),"R14");
      or.put(or.size(),"R15");
      or.put(or.size(),"E");
      or.put(or.size(),"E");
      or.put(or.size(),"E");
      or.put(or.size(),"E");
      or.put(or.size(),"E");
      or.put(or.size(),"E");
      or.put(or.size(),"R10");
      or.put(or.size(),"S12");
      or.put(or.size(),"R1");
      or.put(or.size(),"R2");
      or.put(or.size(),"R4");
      or.put(or.size(),"R5");
      or.put(or.size(),"R7");
      or.put(or.size(),"R8");
      or.put(or.size(),"R11");
      return or;
   
   }
 
   public static Map igual(){
      HashMap <Integer,String> equal = new HashMap <Integer,String>();
               
      equal.put(equal.size(),"E");
      equal.put(equal.size(),"E");
      equal.put(equal.size(),"S13");
      equal.put(equal.size(),"R6");
      equal.put(equal.size(),"R9");
      equal.put(equal.size(),"E");
      equal.put(equal.size(),"E");
      equal.put(equal.size(),"R12");
      equal.put(equal.size(),"R13");
      equal.put(equal.size(),"R14");
      equal.put(equal.size(),"R15");
      equal.put(equal.size(),"E");
      equal.put(equal.size(),"E");
      equal.put(equal.size(),"E");
      equal.put(equal.size(),"E");
      equal.put(equal.size(),"E");
      equal.put(equal.size(),"E");
      equal.put(equal.size(),"R10");
      equal.put(equal.size(),"E");
      equal.put(equal.size(),"S13");
      equal.put(equal.size(),"S13");
      equal.put(equal.size(),"R4");
      equal.put(equal.size(),"R5");
      equal.put(equal.size(),"R7");
      equal.put(equal.size(),"R8");
      equal.put(equal.size(),"R11");  
      return equal;
   }
   
   public static Map diferente(){
      HashMap <Integer,String> dif = new HashMap <Integer,String>();
      
                  
      dif.put(dif.size(),"E");
      dif.put(dif.size(),"E");
      dif.put(dif.size(),"S14");
      dif.put(dif.size(),"R6");
      dif.put(dif.size(),"R9");
      dif.put(dif.size(),"E");
      dif.put(dif.size(),"E");
      dif.put(dif.size(),"R12");
      dif.put(dif.size(),"R13");
      dif.put(dif.size(),"R14");
      dif.put(dif.size(),"R15");
      dif.put(dif.size(),"E");
      dif.put(dif.size(),"E");
      dif.put(dif.size(),"E");
      dif.put(dif.size(),"E");
      dif.put(dif.size(),"E");
      dif.put(dif.size(),"E");
      dif.put(dif.size(),"R10");
      dif.put(dif.size(),"E");
      dif.put(dif.size(),"S14");
      dif.put(dif.size(),"S14");
      dif.put(dif.size(),"R4");
      dif.put(dif.size(),"R5");
      dif.put(dif.size(),"R7");
      dif.put(dif.size(),"R8");
      dif.put(dif.size(),"R11"); 
      return dif;
   }


   public static Map  mayor(){
      HashMap <Integer,String> may = new HashMap <Integer,String>();
      
      may.put(may.size(),"E");
      may.put(may.size(),"E");
      may.put(may.size(),"E");
      may.put(may.size(),"S15");
      may.put(may.size(),"R9");
      may.put(may.size(),"E");
      may.put(may.size(),"E");
      may.put(may.size(),"R12");
      may.put(may.size(),"R13");
      may.put(may.size(),"R14");
      may.put(may.size(),"R15");
      may.put(may.size(),"E");
      may.put(may.size(),"E");
      may.put(may.size(),"E");
      may.put(may.size(),"E");
      may.put(may.size(),"S3");//REVISAR AQUI
      may.put(may.size(),"E");
      may.put(may.size(),"R10");
      may.put(may.size(),"E");
      may.put(may.size(),"E");
      may.put(may.size(),"E");
      may.put(may.size(),"E");
      may.put(may.size(),"E");
      may.put(may.size(),"R7");
      may.put(may.size(),"R8");
      may.put(may.size(),"R11");  
      return may;
   
   }

   public static Map menor(){
      HashMap <Integer,String> men = new HashMap <Integer,String>();
      
      men.put(men.size(),"E");
      men.put(men.size(),"E");
      men.put(men.size(),"E");
      men.put(men.size(),"S16");
      men.put(men.size(),"R9");
      men.put(men.size(),"E");
      men.put(men.size(),"E");
      men.put(men.size(),"R12");
      men.put(men.size(),"R13");
      men.put(men.size(),"R14");
      men.put(men.size(),"R15");
      men.put(men.size(),"E");
      men.put(men.size(),"E");
      men.put(men.size(),"E");
      men.put(men.size(),"E");
      men.put(men.size(),"E");//REVISAR AQUI
      men.put(men.size(),"E");
      men.put(men.size(),"R10");
      men.put(men.size(),"E");
      men.put(men.size(),"E");
      men.put(men.size(),"E");
      men.put(men.size(),"E");
      men.put(men.size(),"E");
      men.put(men.size(),"R7");
      men.put(men.size(),"R8"); 
      men.put(men.size(),"R11");
      return men;
   
   }
   
   
   public static Map negacion(){
      HashMap <Integer,String> neg = new HashMap <Integer,String>();
      
          
      neg.put(neg.size(),"S5");
      neg.put(neg.size(),"E");
      neg.put(neg.size(),"E");
      neg.put(neg.size(),"E");
      neg.put(neg.size(),"E");
      neg.put(neg.size(),"S5");
      neg.put(neg.size(),"S5");
      neg.put(neg.size(),"E");
      neg.put(neg.size(),"E");
      neg.put(neg.size(),"E");
      neg.put(neg.size(),"E");
      neg.put(neg.size(),"S5");
      neg.put(neg.size(),"S5");
      neg.put(neg.size(),"S5");
      neg.put(neg.size(),"S5");
      neg.put(neg.size(),"S5");//REVISAR AQUI
      neg.put(neg.size(),"S5");
      neg.put(neg.size(),"S5");
      neg.put(neg.size(),"E");
      neg.put(neg.size(),"E");
      neg.put(neg.size(),"E");
      neg.put(neg.size(),"E");
      neg.put(neg.size(),"E");
      neg.put(neg.size(),"E");
      neg.put(neg.size(),"E");
      neg.put(neg.size(),"E");
      return neg;
   
   }
 
   public static Map parenabre(){
      HashMap <Integer,String> para = new HashMap <Integer,String>();
      
          
      para.put(para.size(),"S6");
      para.put(para.size(),"E");
      para.put(para.size(),"E");
      para.put(para.size(),"E");
      para.put(para.size(),"E");
      para.put(para.size(),"S6");
      para.put(para.size(),"S6");
      para.put(para.size(),"E");
      para.put(para.size(),"E");
      para.put(para.size(),"E");
      para.put(para.size(),"E");
      para.put(para.size(),"S6");
      para.put(para.size(),"S6");
      para.put(para.size(),"S6");
      para.put(para.size(),"S6");
      para.put(para.size(),"S6");//REVISAR AQUI
      para.put(para.size(),"S6");
      para.put(para.size(),"S6");
      para.put(para.size(),"E");
      para.put(para.size(),"E");
      para.put(para.size(),"E");
      para.put(para.size(),"E");
      para.put(para.size(),"E");
      para.put(para.size(),"E");
      para.put(para.size(),"E");
      para.put(para.size(),"E");
      return para;
   
   }

   public static Map parencierra(){
      HashMap <Integer,String> parci = new HashMap <Integer,String>();
      
          
      parci.put(parci.size(),"E");
      parci.put(parci.size(),"E");
      parci.put(parci.size(),"R3");
      parci.put(parci.size(),"R6");
      parci.put(parci.size(),"R9");
      parci.put(parci.size(),"E");
      parci.put(parci.size(),"E");
      parci.put(parci.size(),"R12");
      parci.put(parci.size(),"R13");
      parci.put(parci.size(),"R14");
      parci.put(parci.size(),"R15");
      parci.put(parci.size(),"E");
      parci.put(parci.size(),"E");
      parci.put(parci.size(),"E");
      parci.put(parci.size(),"E");
      parci.put(parci.size(),"E");//REVISAR AQUI
      parci.put(parci.size(),"E");
      parci.put(parci.size(),"R10");
      parci.put(parci.size(),"S25");
      parci.put(parci.size(),"R1");
      parci.put(parci.size(),"R2");
      parci.put(parci.size(),"R4");
      parci.put(parci.size(),"R5");
      parci.put(parci.size(),"R7");
      parci.put(parci.size(),"R8");
      parci.put(parci.size(),"R11");
      return parci;
   
   }

   public static Map verdad(){
      HashMap <Integer,String> ver = new HashMap <Integer,String>();
      
          
      ver.put(ver.size(),"S7");
      ver.put(ver.size(),"E");
      ver.put(ver.size(),"E");
      ver.put(ver.size(),"E");
      ver.put(ver.size(),"E");
      ver.put(ver.size(),"S7");
      ver.put(ver.size(),"S7");
      ver.put(ver.size(),"E");
      ver.put(ver.size(),"E");
      ver.put(ver.size(),"E");
      ver.put(ver.size(),"E");
      ver.put(ver.size(),"S7");
      ver.put(ver.size(),"S7");
      ver.put(ver.size(),"S7");
      ver.put(ver.size(),"S7");
      ver.put(ver.size(),"S7");//REVISAR AQUI
      ver.put(ver.size(),"S7");
      ver.put(ver.size(),"S7");
      ver.put(ver.size(),"E");
      ver.put(ver.size(),"E");
      ver.put(ver.size(),"E");
      ver.put(ver.size(),"E");
      ver.put(ver.size(),"E");
      ver.put(ver.size(),"E");
      ver.put(ver.size(),"E");
      ver.put(ver.size(),"E");
      return ver;
   
   }

   public static Map falso(){
      HashMap <Integer,String> fal = new HashMap <Integer,String>();
      
          
      fal.put(fal.size(),"S8");
      fal.put(fal.size(),"E");
      fal.put(fal.size(),"E");
      fal.put(fal.size(),"E");
      fal.put(fal.size(),"E");
      fal.put(fal.size(),"S8");
      fal.put(fal.size(),"S8");
      fal.put(fal.size(),"E");
      fal.put(fal.size(),"S8");
      fal.put(fal.size(),"E");
      fal.put(fal.size(),"E");
      fal.put(fal.size(),"S8");
      fal.put(fal.size(),"S8");
      fal.put(fal.size(),"S8");
      fal.put(fal.size(),"S8");
      fal.put(fal.size(),"S8");//REVISAR AQUI
      fal.put(fal.size(),"S8");
      fal.put(fal.size(),"S8");
      fal.put(fal.size(),"E");
      fal.put(fal.size(),"E");
      fal.put(fal.size(),"E");
      fal.put(fal.size(),"E");
      fal.put(fal.size(),"E");
      fal.put(fal.size(),"E");
      fal.put(fal.size(),"E");
      fal.put(fal.size(),"E");
      return fal;
   
   }

   public static Map id(){
      HashMap <Integer,String> ide = new HashMap <Integer,String>();
      
          
      ide.put(ide.size(),"S9");
      ide.put(ide.size(),"E");
      ide.put(ide.size(),"E");
      ide.put(ide.size(),"E");
      ide.put(ide.size(),"E");
      ide.put(ide.size(),"S9");
      ide.put(ide.size(),"S9");
      ide.put(ide.size(),"E");
      ide.put(ide.size(),"E");
      ide.put(ide.size(),"E");
      ide.put(ide.size(),"E");
      ide.put(ide.size(),"S9");
      ide.put(ide.size(),"S9");
      ide.put(ide.size(),"S9");
      ide.put(ide.size(),"S9");
      ide.put(ide.size(),"S9");//REVISAR AQUI
      ide.put(ide.size(),"S9");
      ide.put(ide.size(),"S9");
      ide.put(ide.size(),"E");
      ide.put(ide.size(),"E");
      ide.put(ide.size(),"E");
      ide.put(ide.size(),"E");
      ide.put(ide.size(),"E");
      ide.put(ide.size(),"E");
      ide.put(ide.size(),"E");
      ide.put(ide.size(),"E");
      return ide;
   
   }

   public static Map num(){
       HashMap <Integer,String> nu = new HashMap <Integer,String>();
       
      nu.put(nu.size(),"S10");
      nu.put(nu.size(),"E");
      nu.put(nu.size(),"E");
      nu.put(nu.size(),"E");
      nu.put(nu.size(),"E");
      nu.put(nu.size(),"S10");
      nu.put(nu.size(),"S10");
      nu.put(nu.size(),"E");
      nu.put(nu.size(),"E");
      nu.put(nu.size(),"E");
      nu.put(nu.size(),"E");
      nu.put(nu.size(),"S10");
      nu.put(nu.size(),"S10");
      nu.put(nu.size(),"S10");
      nu.put(nu.size(),"S10");
      nu.put(nu.size(),"S10");
      nu.put(nu.size(),"S10");
      nu.put(nu.size(),"S10");
      nu.put(nu.size(),"E");
      nu.put(nu.size(),"E");
      nu.put(nu.size(),"E");
      nu.put(nu.size(),"E");
      nu.put(nu.size(),"E");
      nu.put(nu.size(),"E");
      nu.put(nu.size(),"E");
      nu.put(nu.size(),"E");
       return nu;
   }


   public static Map A(){
      HashMap <Integer,String> a = new HashMap <Integer,String>();
      
          
      a.put(a.size(),"1");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"18");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"E");//REVISAR AQUI
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"6");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      a.put(a.size(),"E");
      return a;
   
   }

 
   public static Map B(){
      HashMap <Integer,String> b = new HashMap <Integer,String>();
      
          
      b.put(b.size(),"2");
      b.put(b.size(),"E");
      b.put(b.size(),"E");
      b.put(b.size(),"E");
      b.put(b.size(),"E");
      b.put(b.size(),"E");
      b.put(b.size(),"2");
      b.put(b.size(),"E");
      b.put(b.size(),"E");
      b.put(b.size(),"E");
      b.put(b.size(),"E");
      b.put(b.size(),"19");
      b.put(b.size(),"20");
      b.put(b.size(),"E");
      b.put(b.size(),"E");
      b.put(b.size(),"E");//REVISAR AQUI
      b.put(b.size(),"E");
      b.put(b.size(),"2");
      b.put(b.size(),"E");
      b.put(b.size(),"11");
      b.put(b.size(),"E");
      b.put(b.size(),"E");
      b.put(b.size(),"E");
      b.put(b.size(),"E");
      b.put(b.size(),"E");
      b.put(b.size(),"E");
      return b;
   
   }

   
   public static Map C(){
      HashMap <Integer,String> c = new HashMap <Integer,String>();
      
          
      c.put(c.size(),"3");
      c.put(c.size(),"E");
      c.put(c.size(),"E");
      c.put(c.size(),"E");
      c.put(c.size(),"E");
      c.put(c.size(),"E");
      c.put(c.size(),"3");
      c.put(c.size(),"E");
      c.put(c.size(),"E");
      c.put(c.size(),"E");
      c.put(c.size(),"E");
      c.put(c.size(),"3");
      c.put(c.size(),"3");
      c.put(c.size(),"21");
      c.put(c.size(),"22");
      c.put(c.size(),"E");//REVISAR AQUI
      c.put(c.size(),"E");
      c.put(c.size(),"3");
      c.put(c.size(),"E");
      c.put(c.size(),"E");
      c.put(c.size(),"E");
      c.put(c.size(),"E");
      c.put(c.size(),"E");
      c.put(c.size(),"E");
      c.put(c.size(),"E");
      c.put(c.size(),"E");
      return c;
   
   }

   public static Map D(){
      HashMap <Integer,String> d = new HashMap <Integer,String>();
      
          
      d.put(d.size(),"4");
      d.put(d.size(),"E");
      d.put(d.size(),"E");
      d.put(d.size(),"E");
      d.put(d.size(),"E");
      d.put(d.size(),"17");
      d.put(d.size(),"4");
      d.put(d.size(),"E");
      d.put(d.size(),"E");
      d.put(d.size(),"E");
      d.put(d.size(),"E");
      d.put(d.size(),"4");
      d.put(d.size(),"4");
      d.put(d.size(),"4");
      d.put(d.size(),"4");
      d.put(d.size(),"23");//REVISAR AQUI
      d.put(d.size(),"24");
      d.put(d.size(),"4");
      d.put(d.size(),"E");
      d.put(d.size(),"E");
      d.put(d.size(),"E");
      d.put(d.size(),"E");
      d.put(d.size(),"E");
      d.put(d.size(),"E");
      d.put(d.size(),"E");
      d.put(d.size(),"E");
      return d;
   
   }
   public static Map E () {
        HashMap <Integer,String> e = new HashMap <Integer,String>();
             
             e.put(e.size(), "5");
             e.put(e.size(), "E");
             e.put(e.size(), "E");
             e.put(e.size(), "E");
             e.put(e.size(), "E");
             e.put(e.size(), "E");
             e.put(e.size(), "5");
             e.put(e.size(), "E");
             e.put(e.size(), "5");
             e.put(e.size(), "E");
             e.put(e.size(), "E");
             e.put(e.size(), "E");
             e.put(e.size(), "E");
             e.put(e.size(), "5");
             e.put(e.size(), "5");
             e.put(e.size(), "5");
             e.put(e.size(), "5");
             e.put(e.size(), "25");
             e.put(e.size(), "26");
             e.put(e.size(), "E");
             e.put(e.size(), "E");
             e.put(e.size(), "E");
             e.put(e.size(), "E");
             e.put(e.size(), "E");
             e.put(e.size(), "E");
             e.put(e.size(), "E");
             e.put(e.size(), "E");
             e.put(e.size(), "E");
             return e;
   }
   
   public static Map statesr(){
       HashMap <Integer,String> str = new HashMap <Integer,String>();
        str.put((str.size()+1), "A 3"); //a -- a or b
        str.put((str.size()+1), "A 3"); //a -- b
        str.put((str.size()+1), "A 1"); //b -- b and a
        str.put((str.size()+1), "B 3"); //b -- c
        str.put((str.size()+1), "B 3"); //c -- c != d
        str.put((str.size()+1), "B 1"); //c -- c == d
        str.put((str.size()+1), "C 3"); //c -- d
        str.put((str.size()+1), "C 3"); //d -- d > e
        str.put((str.size()+1), "C 1"); //d -- d < e
        str.put((str.size()+1), "D 2"); //d -- e
        str.put((str.size()+1), "D 3"); //e -- !e
        str.put((str.size()+1), "D 1"); //e -- f
        str.put((str.size()+1), "D 1"); //e -- (a)
        str.put((str.size()+1), "D 1"); //e -- num
        str.put((str.size()+1), "D 1");
       return str;
   }


}