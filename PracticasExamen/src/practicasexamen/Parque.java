/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicasexamen;
import java.util.Random;

/**
 *
 * @author UAH
 */
public class Parque {
    private int tJugar;
    private int tComer;
    private int tCaminar;
    private int tDormir;
    
    public void tiempoJugar(){
        tJugar = (int)(Math.random()*4001 + 3000);
    }   
    
    public void tiempoComer(){
        Random rand = new Random();
        tComer = rand.nextInt(6001) + 2000;
    }
    
    public void tiempoCaminar(){
        Random rand = new Random();
        tCaminar = rand.nextInt(5001) + 9000;
    }
    
    public void tiempoDormir(){
        Random rand = new Random();
        tDormir = rand.nextInt(13001) + 18000;
    }
    
    
    public void run(){
        
    }
    
}
