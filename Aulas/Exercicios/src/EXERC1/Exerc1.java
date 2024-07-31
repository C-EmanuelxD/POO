/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXERC1;

import java.util.Scanner;

/**
 *
 * @author calvo
 */
public class Exerc1 {
    public static void main(String[] args){
        Registro reg;
        reg = new Registro();
        Scanner leia = new Scanner(System.in);
        System.out.println("Coloque suas informacoes: ");
        System.out.println("Seu nome:");
        String nome = leia.nextLine();
        reg.setNome(nome);
        System.out.println("O ano que está: ");
        int ano = leia.nextInt();
        reg.setAno(ano);
        System.out.println("Seu Registro Academico: ");
        int ra = leia.nextInt();
        reg.setRa(ra);
        
        int i = 0;
        
        System.out.println("Adicione as disciplina: ");
        String disc = leia.nextLine();
        reg.AddDisc(disc);
        while(i!=4){
            disc = leia.nextLine();
            reg.AddDisc(disc);
            i++;
        }
        
        
        System.out.print("Deseja ver suas informações? (S/N)");
        char opcao = leia.next().charAt(0);
        if(opcao == 'S'){
            System.out.println("Ra: "+reg.getRa()+"\nNome: "+reg.getNome()+"\nAno: "+reg.getAno());
            System.out.println("\nDisciplinas = "+reg.retDisc());
        }else{
            System.out.println("Fechando...");
        }
        
    }
}
