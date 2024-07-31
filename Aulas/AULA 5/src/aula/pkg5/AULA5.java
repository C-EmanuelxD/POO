/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aula.pkg5;

/**
 *
 * @author calvo
 */
import java.util.Scanner;
        
public class AULA5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int op;
        float oper1,oper2;
        do{
            System.out.println("*********************");
            System.out.println("(1) Multiplica legal dog");
            System.out.println("(2) Soma legal dog");
            System.out.println("(3) Subtrai legal dog");
            System.out.println("(4) Divide legal dog");
            System.out.println("(0) Sair legal dog");
            System.out.println("*********************");
            op = leia.nextInt();
            switch(op){
                case 1:
                    System.out.println("Escreva os operandos: ");
                    oper1 = leia.nextFloat();
                    oper2 = leia.nextFloat();
                    System.out.println("O result é: "+(oper1*oper2));
                    break;
                case 2:
                    System.out.println("Escreva os operandos: ");
                    oper1 = leia.nextFloat();
                    oper2 = leia.nextFloat();
                    System.out.println("O result é: "+(oper1+oper2));
                    break;
                case 3:
                    System.out.println("Escreva os operandos: ");
                    oper1 = leia.nextFloat();
                    oper2 = leia.nextFloat();
                    System.out.println("O result é: "+(oper1-oper2)+" meu dog");
                    break;
                case 4:
                        System.out.println("Escreva os operandos: (o segundo deve ser diff de 0)");
                        oper1 = leia.nextFloat();
                        oper2 = leia.nextFloat();
                        if(oper2 == 0){
                            System.out.println("Nao existe div por 0");
                            break;
                        }else{
                            System.out.println("O result é: "+oper1/oper2);
                            break;
                        }
                default:
                    if(op!=0)
                    System.out.println("Escreva uma opcao valida dog!!");
                    break;
            }
                
            
        }while (op!=0);
        
        System.out.println("Fim!!");
    }
    
}
