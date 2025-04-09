/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej1;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;
import java.util.concurrent.Callable;

/**
 *
 * @author UAH
 */
public class TramitadoresTarea implements Callable<Documentos>{
    private Documentos doc;

    TramitadoresTarea(Documentos doc) {
        this.doc = doc;
    }
    
    public Documentos call(){
        System.out.println("El tramitador " + currentThread().getName() + " empieza a procesar el documento " + doc.getId());
        try {
            sleep(tAleatorio());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("El documento " + doc.getId() + " ha sido procesado por " + currentThread().getName());
        return doc;
    }
    
    public int tAleatorio(){
        int t = (int) (Math.random()*1001) +1000;
        return t;
    }
}
