/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pricnipal;

/**
 *
 * @author calvo
 */
public class potencia {
    public float calcPot(int pot, float base){
        for(int i=1;i<pot;i++){
            base *= base;
        }
        return base;
    }
}
