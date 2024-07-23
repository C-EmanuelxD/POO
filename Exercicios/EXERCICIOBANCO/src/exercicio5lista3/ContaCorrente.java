/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio5lista3;

import java.util.ArrayList;

/**
 *
 * @author Emanuel
 */
public class ContaCorrente {
    private int nmrConta;
    private int Saldo;
    private int limite;
    private ArrayList<Movimentacao> movimentacoes = new ArrayList();
    private boolean especial;

    
    public ContaCorrente(int nmrConta, int Saldo, int limite, boolean especial){
        this.Saldo = Saldo;
        this.especial = especial;
        this.limite = limite;
        this.nmrConta = nmrConta;
    }
    
    
    
    
    
    public void AdicionarMovimentacao(String desc, int valor, String tipo){
        movimentacoes.add(new Movimentacao(desc,valor,tipo));
    }
    
    
    public int getNmrConta() {
        return nmrConta;
    }

    public void setNmrConta(int nmrConta) {
        this.nmrConta = nmrConta;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public ArrayList<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }
    
    
}
