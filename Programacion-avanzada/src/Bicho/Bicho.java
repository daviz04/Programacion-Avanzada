/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bicho;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author UAH
 */
public class Bicho extends Thread{
    private int generacion;
    private String nombre;
    private static final Random random = new Random();

    public Bicho(int generacion, String nombre) {
        this.generacion = generacion;
        this.nombre = nombre;
    }
    
    @Override
    public void run() {
        long inicio = (new Date()).getTime();
        System.out.println("NACE: " + nombre + " (Generación " + generacion + ")");

        // Espera un tiempo aleatorio entre 500 y 1000 milisegundos
        try {
            Thread.sleep(random.nextInt(501) + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Si la generación es menor que 5, crea un hijo
        Bicho hijo = null;
        if (generacion < 5) {
            String nombreHijo = generarNombre();
            hijo = new Bicho(generacion + 1, nombreHijo);
            hijo.start();

            // Espera a que el hijo termine
            try {
                hijo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Calcula el tiempo de vida
        long fin = (new Date()).getTime();
        long tiempoVida = fin - inicio;
        System.out.println("MUERE: " + nombre + " (Generación " + generacion + ", vivió " + tiempoVida + " ms)");
    }

    // Genera un nombre aleatorio de 4 letras
    private static String generarNombre() {
        char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder nombre = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            nombre.append(letras[random.nextInt(letras.length)]);
        }
        return nombre.toString();
    }
}
