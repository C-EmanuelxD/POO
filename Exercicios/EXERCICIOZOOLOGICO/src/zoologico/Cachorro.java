/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologico;

/**
 *
 * @author Emanuel
 */
public class Cachorro extends Mamifero{
    private boolean tipoLatido;
    
    public Cachorro(String nome, int velocidade){
        super(nome, velocidade);
    }
    
    
    @Override
    public String falar(){
        
        if(this.tipoLatido = true){
            return "AU-AU";
        }
        else{
            return "au-au";
        }
        
    }
    
    
    public void setLateAlto(){
        this.tipoLatido = true;
    }
    
    public void setLateBaixo(){
        this.tipoLatido = false;
    }
}
