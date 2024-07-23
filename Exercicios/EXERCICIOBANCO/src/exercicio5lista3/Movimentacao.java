/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio5lista3;

/**
 *
 * @author Emanuel
 */
public class Movimentacao {
    private String descricao;
    private int valor;
    private String tipo;

    
    public Movimentacao(String desc, int valor, String tipo){
        this.descricao = desc;
        this.tipo = tipo;
        this.valor = valor;
    }
    
    
    
    
    
    
    
    @Override
    public String toString(){
        return "[|Descrição: "+this.descricao+"| |tipo: "+this.tipo+"| |valor: "+this.valor+"|]";
    }
    
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
