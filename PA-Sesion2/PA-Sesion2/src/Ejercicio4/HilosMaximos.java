/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import java.util.ArrayList;

/**
 *
 * @author caice
 */
public class HilosMaximos {
     
     public static void main(String[] x){
        ArrayList<Hilos> pList = new ArrayList<>();
        int id = 1;
        
        for(int i = 0; i < 10000000; i++){   
            Hilos p = new Hilos(id); 
            pList.add(p);
            p.run();
            id++;
            }
        }
    }
