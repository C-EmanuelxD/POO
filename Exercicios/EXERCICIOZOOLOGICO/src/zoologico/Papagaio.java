/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologico;

/**
 *
 * @author Emanuel
 */
public class Papagaio extends Ave{
    private String vocabulario;
    
    public Papagaio(String nome, String vocabulario){
        super(nome);
        this.vocabulario = vocabulario;
    }
    
    @Override
    public String falar(){
        return vocabulario;
    }

    
    public void setVocabulario(String vocabulario) {
        this.vocabulario = vocabulario;
    }
    
    
}
