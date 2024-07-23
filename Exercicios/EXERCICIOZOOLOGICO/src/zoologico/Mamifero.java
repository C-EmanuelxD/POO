/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologico;

/**
 *
 * @author Emanuel
 */
public class Mamifero extends Animal{
    private int velocidade;
    
    public Mamifero(String nome, int velocidade){
        super(nome, "Mamifero");
        this.velocidade = velocidade;
    }
    
    public void correr(){
        for(int i = 0; i<velocidade; i++){
            System.out.println("Correndo");
        }
    }
    
    
}
