/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pollitos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UAH
 */
public class Pollitos extends Thread{
    private int id;
    private Estancia estancia;
    Estancia bebedero = new Estancia("Bebedero", 8);
    Estancia comedero = new Estancia("Comedero", 4);
    Estancia cama = new Estancia("Cama", 10);
    
    public Pollitos(int id, Estancia estancia){
        this.id = id;
        this.estancia = estancia;
    }
    
    public void pasear(){
        try {
            System.out.printf("Pollo " + id + " esta paseando\n" );
            sleep((int) (Math.random()*6000) + 2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pollitos.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    public void comer(){
        try {
            comedero.entrar();
            System.out.printf("Pollo " + id + " esta comiedo\n");
            sleep((int) (Math.random()*6000) + 2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pollitos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            comedero.salir();
        }
    }
    
    public void beber(){
        try {
            bebedero.entrar();
            System.out.printf("Pollo " + id + " esta bebiendo\n");
            sleep((int) (Math.random()*3000) + 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pollitos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            bebedero.salir();
        }
    }
    
    public void dormir(){
        try {
            cama.entrar();
            System.out.printf("Pollo " + id + " esta durmiendo\n");
            sleep((int) (Math.random()*19000) + 15000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pollitos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            cama.salir();
        }
    }
    
    @Override
   public void run(){
        pasear();
        int eleccion = (int) (Math.random()*4) + 1;
        
        while(true){
        switch(eleccion){
            case 1: { 
                eleccion = (int) (Math.random()*4) + 1;
                pasear();
                break;
                }
            
            case 2: {
                eleccion = (int) (Math.random()*4) + 1;
                comer();
                break;
            }
            
            case 3: {
                eleccion = (int) (Math.random()*4) + 1;
                beber();
                break;
            }
            
            case 4:{
                eleccion = (int) (Math.random()*4) + 1;
                dormir();
                break;
            }
        }
                  
        }
    }   
}
