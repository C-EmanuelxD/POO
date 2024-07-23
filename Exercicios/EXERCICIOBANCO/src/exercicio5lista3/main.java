/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio5lista3;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author Emanuel
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Banco bb = new Banco();
        
        int op = 10;
        Scanner leia = new Scanner(System.in);
        while(op != -1){
        System.out.println("Escolha sua opção: ");
        
        System.out.println("1 - Criar Conta");
        System.out.println("2 - Fazer Depósito");
        System.out.println("3 - Fazer Saque");
        System.out.println("4 - Fazer Transferência");
        System.out.println("5 - Emitir Saldo");
        System.out.println("6 - Emitir Extrato");
        System.out.println("7 - Excluir Conta");
        System.out.println("8 - Sair");
        
        op = leia.nextInt();
        
        switch(op){
            
            case 1:
                System.out.println("Escreva o Limite inicial da conta: ");
                int valor = leia.nextInt();
                
                bb.abrirConta(false, valor);
                break;
            case 2:
                System.out.println("Escreva o numero da conta: ");
                int nmrConta = leia.nextInt();
                System.out.println("Escreva o valor do depósito: ");
                valor = leia.nextInt();
                
                bb.fazerDeposito(nmrConta, valor);
                break;
            case 3:
                System.out.println("Escreva o numero da conta: ");
                nmrConta = leia.nextInt();
                System.out.println("Escreva o valor a sacar: ");
                valor = leia.nextInt();
                System.out.println("Escreva o tipo do saque: (créito ou débito)");
                String tipo = leia.nextLine();
                String buffer = leia.next();
                
                bb.fazerSaque(nmrConta, valor, tipo);
                break;
            case 4:
                System.out.println("Escreva em sequencia o numero das contas a transferir:");
                int nmrConta1 = leia.nextInt();
                int nmrConta2 = leia.nextInt();
                System.out.println("Escreva o valor a ser transferido:");
                valor = leia.nextInt();
                
                bb.fazerTransferencia(nmrConta1, nmrConta2, valor);
                break;
            case 5:
                System.out.println("Escreva o numero da conta: ");
                nmrConta = leia.nextInt();
                
                bb.emitirSaldo(nmrConta);
                break;
            case 6:
                System.out.println("Escreva o numero da conta: ");
                nmrConta = leia.nextInt();
                
                bb.FazerExtrato(nmrConta);
                break;
            case 7:
                System.out.println("Escreva o numero da conta a ser excluida: ");
                nmrConta = leia.nextInt();
                bb.excluirConta(nmrConta);
                break;
            case 8:
                op = -1;
                break;
        }
        
        }
        
        
        
        
    }
    
}
