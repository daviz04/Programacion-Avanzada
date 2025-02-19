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
public class Hilos extends Thread{
   
    private int id;
   
    public Hilos(int id){
        this.id = id;
    }
    
    @Override
    public void run(){
        System.out.println("Hilo: " + this.id);
    }
}
