package Vetor;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author calvo
 */
public class main {
    public static void main(String[] args){

        int[] nums = new int[10];
        int[] nums2 = new int[10];
        int[] numsres = new int[10];
        
        Scanner leia = new Scanner(System.in);
        for(int i = 0; i< nums.length; i++){
            int a = leia.nextInt();
            nums[i] = a;
        }
        for(int i = 0; i< nums.length; i++){
            int a = leia.nextInt();
            nums2[i] = a;
            numsres[i] = nums[i] - nums2[i];
        }
        for(int i = 0; i < numsres.length; i++){
            System.out.println(numsres[i]);
        }
        
    }
}
