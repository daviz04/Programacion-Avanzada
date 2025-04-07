/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tenis;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UAH
 */
public class Pista {
    private Tenista tenista1;
    private Tenista tenista2;
    Semaphore semaforo;
    private boolean finPartido;
    
    Pista(){
        semaforo = new Semaphore(2, true);
    }
    
    public synchronized void entrar(Tenista tenista){
        while(true){
        if(estaVacia()){
            tenista1 = tenista;
            System.out.println("El tenista " + tenista1.IdTenista() + " de sexo " + tenista1.getSexo() +
                    " ha entrado en la pista y espera por contrincante.");
            try {
                semaforo.acquire();
               wait();
            } catch (InterruptedException ex) {}
            return;
        } else{
            tenista2 = tenista;
            if(tenista1.getSexo() == tenista2.getSexo()){
                try {
                    semaforo.acquire();
                    System.out.println("El tenista de id " + tenista2.IdTenista() + " y sexo " + tenista2.getSexo() +
                    " ha entrado en pista y se disponen a jugar un partido con el tenista " + tenista1.IdTenista() + 
                            " de sexo " + tenista1.getSexo());
                    int tiempo = (int) (Math.random()+501) + 500;
                    Thread.sleep(tiempo);
                    finPartido = true;
                    System.out.println("El partido de el tenista " + tenista2.IdTenista() + " y " + tenista1.IdTenista() +
                            " ha terminado.");   
                    notifyAll();
                    break;
                } catch (Exception e) {}   
            } else{
                try {
                    System.out.println("El tenista " + tenista2.IdTenista() + " de sexo " + tenista2.getSexo() + " espera su turno.");
                    wait();
                } catch (InterruptedException ex) {}
            }
        }
        }
    }
    
    public synchronized void salir(Tenista tenista){
        if(finPartido){
        semaforo.release(2);
        tenista1 = null;
        tenista2 = null;
        finPartido = false;
        notifyAll(); // notifica a los tenistas en espera
        }
    }
    
    public boolean estaVacia(){
        if(semaforo.availablePermits() == 2){
            return true;
        }
        return false;
    }
}
