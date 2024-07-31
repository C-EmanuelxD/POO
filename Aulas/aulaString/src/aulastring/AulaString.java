/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aulastring;

/**
 *
 * @author calvo
 */
public class AulaString {

    public static void main(String[] args) {
        String s1 = "Programação";
        String s2 = "Java";
        
        
        System.out.println(s1.concat(s2));
        System.out.println("Tamanho de s1: "+s1.length());
        System.out.println("Tamanho de s2: "+s2.length());
        System.out.println("Primeiro caractere de s1: "+s1.charAt(0));
        System.out.println("Primeiro caractere de s2: "+s2.charAt(0));
        System.out.println(s1.contains("@"));
        
        System.out.println("");
        StringBuffer s11 = new StringBuffer("Programação");
        StringBuffer s22 = new StringBuffer("Java");
        
        System.out.println(s11.append(s22));
        System.out.println("Tamanho de s11: "+s11.length());
        System.out.println("Tamanho de s22: "+s22.length());
        System.out.println("Primeiro caractere de s11: "+s11.charAt(0));
        System.out.println("Primeiro caractere de s22: "+s22.charAt(0));
        //System.out.println(s11.toString().contains("@"));
        
        if(s11.indexOf("@") != -1){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        
    }
    
}
