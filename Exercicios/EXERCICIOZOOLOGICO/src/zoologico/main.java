/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologico;

/**
 *
 * @author Emanuel
 */
public class main {
    public static void main(String[] args){
        Papagaio cuco = new Papagaio("cuco", "Hino do corinthia");
        Cachorro rengar = new Cachorro("rengar", 23);
        
        rengar.setLateAlto();
        
        System.out.println(rengar.falar());
        System.out.println(cuco.falar());
        
        
        
        rengar.correr();
        cuco.voar(5);
        
    }
}
