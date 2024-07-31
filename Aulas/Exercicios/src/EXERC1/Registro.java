/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXERC1;

/**
 *
 * @author calvo
 */
public class Registro {
    
    private int ra, ano, PosI;
    private String nome;

    public String discipl[] = new String[5];

       
    
        
        
    
    
    public Registro(){
        
    }
    
    public void AddDisc(String DiscAdicionada){
        this.discipl[this.PosI] = DiscAdicionada;
        this.PosI += 1;
        
    }
    
    public String retDisc(){
        String ret = "";
        for(int i = 0;i<5;i++){
            ret = ret+", "+this.discipl[i];
        }
        return ret;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
