/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author UAH
 */
public class Main {
    private static final int tramitadores = 3;
    private static final int docs = 600;
    
     public static void main(String[] args)
    {  
        ExecutorService executor = Executors.newFixedThreadPool(tramitadores);
        for(int i = 1; i <= docs; i++){
            Documentos doc = new Documentos(i);
            TramitadoresTarea tarea = new TramitadoresTarea(doc);
            Future<Documentos> resultado = executor.submit(tarea);
            try {
            // get() bloquea hasta que la tarea termine y devuelve el resultado
            Documentos resultadoFinal = resultado.get();
            System.out.println("Documento procesado correctamente: " + resultadoFinal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
          executor.shutdown();
    }
}
