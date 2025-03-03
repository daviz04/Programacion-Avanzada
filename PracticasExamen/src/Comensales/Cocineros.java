/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comensales;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author UAH
 */
public class Cocineros extends Thread{
    String comanda;
    Lock cerrojo = new ReentrantLock();
    
    @Override
    public void run(){
        cerrojo.lock();
        try {
            System.out.printf("Comanda recibida");
            sleep(400);
            System.out.printf("Plato preparado");
        } catch (Exception e) {
        }finally{
            cerrojo.unlock();
        }
    }
}
