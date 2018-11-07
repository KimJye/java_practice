package javaprojectpractice;
public class Example05 {
	   
    static String removeNonAlphabet(String s) {
       StringBuilder str=new StringBuilder();
       char a;
       
       for(int i=0; i<s.length(); i++) {
          a=s.charAt(i);
          if((int)a>=97 && (int)a<(97+25)) {
             str.append(a);
          }
   
       }
       return str.toString();
    }


   public static void main(String[] args) {
        String s = " a#b.c__d$$$e++++f;;;g...h///i%";
        s = removeNonAlphabet(s);
        System.out.println(s);
    }

}