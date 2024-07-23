/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoologico;

/**
 *
 * @author Emanuel
 */
public class Animal {
    private String nome;
    protected String classe;
    
    public Animal(String nome, String classe){
        this.nome = nome;
        this.classe = classe;
    }
    
    
    public String falar(){
        return "";
    }
    
    public String Imprime(){
        return (this.nome + this.classe);
    }
    
    public String getNome(){
        return this.nome;
    }
    
}
