/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Matriz;

import java.util.Scanner;

/**
 *
 * @author calvo
 */
public class main {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        System.out.println("Escreva as linhas e cliunas da matriz A: ");
        int l = leia.nextInt();
        int c = leia.nextInt();
        
        System.out.println("Escreva as linhas e colunas da matriz B: ");
        int l1 = leia.nextInt();
        int c1 = leia.nextInt();
        
        int[][] minhaMatriz = new int[l][c];
        int[][] minhaMatriz1 = new int[l1][c1];
        
        if(c == l1){
            System.out.println("Os componentes são iguais. Multiplicando.");
            
            for(int linhaR = 0; linhaR < l; linhaR++){
                for(int colunaR = 0; colunaR < c1; colunaR++){
                    for(int lc = 0; lc < c; lc++){
                        minhaMatriz[linhaR][colunaR]+=minhaMatriz[linhaR][lc]*minhaMatriz1[lc][colunaR];
                    }
                    System.out.println(minhaMatriz[linhaR][colunaR] + "\t");
                }
            }
            
        }else{
            System.out.println("Não da pra multiplicar!");
        }
        
    }
    
}
