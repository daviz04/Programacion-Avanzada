package pollitos;

import static java.lang.Thread.sleep;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author UAH
 */
public class Estancia extends Thread{
    private String nombre;
    private int capacidad;
    Lock candado = new ReentrantLock();
    Condition condEspera;
    
    public Estancia(String nombre, int capacidad){
        this.nombre = nombre;
        this.capacidad = capacidad;
    }
    
     public void entrar(){
        candado.lock();
        try {
            while(capacidad <= 0){
                condEspera.await();
            }
          capacidad--;
        } catch (Exception e) {
        }finally{
            candado.unlock();
        }
    }
        
        public void salir(){
            candado.lock();
            try {
                capacidad++;
                //Se usa signal porque hay una condicion y vayan saliendo de uno
                //en uno 
                condEspera.signal();
            } catch (Exception e) {
            } finally {
                candado.unlock();
            }   
    }
       
    
 }


