/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comensales;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author UAH
 */
public class Esteanteria extends Thread{
    Camareros camarero;
    Cocineros cocinero;
    String comandas;
    int maxComand = 20;
    int comandActuales;
    Lock cerrojo = new ReentrantLock();
    private Condition parar = cerrojo.newCondition();
    
    public void dejarComanda(String comanda){
        cerrojo.lock();
        try {
           
        } catch(Exception e) {
        }finally{
            
        }
    }
    
}
