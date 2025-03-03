/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teoriaclase4;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UAH
 */
public class Pollos extends Thread{
    private int comida, bebida, paseo, dormir;
    private int comedero, bebedero, cama;// Se asignan valores directamente.
    
    public synchronized void Comer(){
        Random random = new Random();
        this.comida = random.nextInt(4001) + 2000; 
        this.comedero++;
        try {
            System.out.println("Un pollo esta comiendo");
            sleep(this.comida); 
        } catch (InterruptedException ex) {
            Logger.getLogger(Pollos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.comedero--;
            notifyAll();
        }     
    }
    
    public synchronized void Beber(){
        Random random = new Random();
        this.bebida = random.nextInt(2001) + 1000; 
        this.bebedero++;
        try {
            sleep(this.bebida);
            System.out.println("Un pollo esta bebiendo");
        } catch (InterruptedException ex) {
            Logger.getLogger(Pollos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.bebedero--;
            notifyAll();
        }
        
    }
        
     public synchronized void Pasear(){
        Random random = new Random();
        this.paseo = random.nextInt(4001) + 5000; 
        try {
            System.out.println("Un pollo esta paseando"); 
            sleep(this.paseo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pollos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            notifyAll();
        }
    }
     
     public synchronized void Durmiendo(){
        notifyAll();
        Random random = new Random();
        this.dormir = random.nextInt(4001) + 15000;
        this.cama++;
        try {
            System.out.println("Un pollo esta durmiendo");
            sleep(this.dormir);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pollos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cama--;
            notifyAll();
        }  
     }
     
     public boolean PuedeComer(){
         return this.comedero <= 4;
     }
     
     public boolean PuedeBeber(){
         return this.bebedero <= 8;
     }
     
     public boolean PuedeDormir(){
         return this.cama <= 10;
     }
     
    public void start(){
        while(true){
            Random random = new Random();
            int num = random.nextInt(4) + 1;
            if(num == 1){
                if(PuedeComer()){
                    Comer();
                }
            } else if(num == 2){
                if(PuedeBeber()){
                    Beber();
                }
            }else if(num == 3){
                Pasear();
            }else {
                if(PuedeDormir()){
                    Durmiendo();
                }
            }
        }
    } 
}
