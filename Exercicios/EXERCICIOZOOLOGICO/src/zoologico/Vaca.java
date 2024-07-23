/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologico;

/**
 *
 * @author Emanuel
 */
public class Vaca extends Mamifero{
    private boolean permiteOrdenha;
    
    public Vaca(String nome, int velocidade) {
        super(nome, velocidade);
    }
    
    public void ordenhar(){
        if(this.permiteOrdenha == true){
            System.out.println("Ordenhando");
        }
    }
    
    @Override
    public String falar(){
        return "muuuuuu";
    }
    
}
