/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pricnipal;
import java.util.Scanner;


/**
 *
 * @author calvo
 */
public class bhaskara {
    public static void main(String[] args){
        
        potencia pot;
        pot = new potencia();
        float delta,raiz,result1,result2;
        
        Scanner leia = new Scanner(System.in);
        System.out.println("Programa que calcula bhaskara: ");
        System.out.println("digite o a: ");
        float a = leia.nextFloat();
        if(a<0){
            System.out.printf("O valor a = %f, não pode!!",a);
        }
        System.out.println("digite o b: ");
        float b = leia.nextFloat();
        System.out.println("digite o c: ");
        float c = leia.nextFloat();
        
        
        delta = pot.calcPot(2, b)-4*a*c;
        System.out.println(delta);
        Math.sqrt(delta);
        
        
        
    }

 
