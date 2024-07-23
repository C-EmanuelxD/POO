/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologico;

/**
 *
 * @author Emanuel
 */
public class Ave extends Animal{
    
    
    public Ave(String nome){
        super(nome,"Ave");
    }
    
    
    @Override
    public String falar(){
        return "piu-piu";
    }
    
    public void voar(int vezes){
        for(int i = 0;i<vezes;i++){
            System.out.println("Voando");
        }
    }
    
    
    
    
}
