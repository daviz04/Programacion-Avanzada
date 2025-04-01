/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej1;

/**
 *
 * @author UAH
 */
public class Tramitadores extends Thread{
    private Documentos documento;
    
    public Tramitadores(Documentos documento){
        this.documento = documento;
    }
    
    public void run(){
        System.out.println("El tramitador " + currentThread().getName() + " comienza a procesar el documento: " + this.documento.getId());
        int tiempo = (int)(Math.random()*1001) + 1000;
        System.out.println("Procesando el documento " + this.documento.getId() + "...");
        try {
            sleep(tiempo);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }         
        System.out.println("El tramitador " + currentThread().getName() + " HA TERMINADO DE PROCESAR el documento " + this.documento.getId());
    }
  
}
