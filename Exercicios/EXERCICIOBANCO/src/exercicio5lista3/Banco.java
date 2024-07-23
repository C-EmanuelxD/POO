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
public class Banco {
    ArrayList<ContaCorrente> Contas = new ArrayList();
    private int nmrcontanovo = 0;
    
    
    public void abrirConta(boolean status, int limite){
        int nmr = nmrcontanovo;
        System.out.println("Conta de número: "+nmrcontanovo+" criada com sucesso!!");
        Contas.add(new ContaCorrente(nmr,0,limite,status));
        
        
        this.nmrcontanovo +=1;
      
    }
    
    public void excluirConta(int nmrConta){
        ContaCorrente conta = buscaConta(nmrConta);
        Contas.remove(conta);
        System.out.println("Conta excluida!!");
    }
    
    public void fazerSaque(int nmrConta, int valor, String tipo){
        ContaCorrente conta = buscaConta(nmrConta);
        conta.AdicionarMovimentacao("Saque", valor, tipo);
        
        conta.setSaldo(conta.getSaldo()-valor);
        if(tipo.equalsIgnoreCase("debito")){
            
            if(conta.getSaldo() < valor){
                
                System.out.println("Salo indisponivel");
                
            }else{
                
                conta.setSaldo(conta.getSaldo()-valor);
                System.out.println("Saque efetuado!!");
            }
        }else{
            
            if(tipo.equalsIgnoreCase("credito")){
                
                if(conta.getLimite() < valor){
                    
                    System.out.println("Sem limite para saque");
                    
                }else{
                    
                    conta.setLimite(conta.getLimite() - valor);
                    System.out.println("Saque efetuado!!");
                    
                }
            }
        }
    }
    
    public void fazerDeposito(int nmrConta, int valor){
        ContaCorrente conta = buscaConta(nmrConta);
        conta.setSaldo(conta.getSaldo()+valor);
        conta.AdicionarMovimentacao("Depósito", valor, "");
        System.out.println("Deposito efetuado!!");
    }
    
    public void fazerTransferencia(int nConta1, int nConta2, int valor){
        ContaCorrente conta1 = buscaConta(nConta1);
        ContaCorrente conta2 = buscaConta(nConta2);
        
        
        if(conta1.getSaldo() < valor){
            System.out.println("Sem saldo suficiente");
        }else{
            conta1.setSaldo(conta1.getSaldo()-valor);
            conta1.AdicionarMovimentacao("Transferencia: Saida", valor, "");
            conta2.setSaldo(conta2.getSaldo()+valor);
            conta2.AdicionarMovimentacao("Transferencia: Entrada", valor, "");
            System.out.println("Transferido com sucesso!!");
        }
        
        
    }
    
    public void emitirSaldo(int nmrConta){
        ContaCorrente conta = buscaConta(nmrConta);
        
        System.out.println("Saldo total:" + conta.getSaldo());
        
    }
    
    public void FazerExtrato(int nmrConta){
        ContaCorrente conta = buscaConta(nmrConta);
        
        for(Movimentacao x: conta.getMovimentacoes()){
            System.out.println(x.toString());
        }
        
    }
    
    public ContaCorrente buscaConta(int nmr){
        for(ContaCorrente x : Contas){
            if(x.getNmrConta() == nmr){
                return x;
            }
        }
        return null;
    }
    
    
    
    
    
    public ArrayList<ContaCorrente> getContas() {
        return Contas;
    }

    public void setContas(ArrayList<ContaCorrente> Contas) {
        this.Contas = Contas;
    }

    public int getNmrcontanovo() {
        return nmrcontanovo;
    }

    public void setNmrcontanovo(int nmrcontanovo) {
        this.nmrcontanovo = nmrcontanovo;
    }
    
    
    
    
    
}
