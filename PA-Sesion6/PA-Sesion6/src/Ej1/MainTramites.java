/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author UAH
 */
public class MainTramites {
    private static final int Tramitadores = 3;
    private static final int docsNum = 600;
    public static void main(String[] args){  
        
        ArrayList<Documentos> docs = new ArrayList<Documentos>();
        int[] documentos = new int[docsNum];
        for(int i=0; i < docsNum; i++){
            documentos[i] = i+1;
            docs.add(new Documentos(documentos[i]));
        }
        
        ExecutorService executor = Executors.newFixedThreadPool(docsNum);
          for (int i = 0; i < docs.size(); i++)
        {
            Tramitadores tarea = new Tramitadores(docs.get(i));
            executor.execute(tarea);
        }
        executor.shutdown();  // Voy terminando el pool
        
         try {
            // Espero a que terminen de ejecutarse todas las tareas
            // para pasar a las siguientes instrucciones
            executor.awaitTermination(24, TimeUnit.HOURS);
        } catch (InterruptedException ex) {
            
        }
    }
}
