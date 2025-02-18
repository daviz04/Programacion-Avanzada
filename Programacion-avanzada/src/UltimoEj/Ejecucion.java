/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UltimoEj;

/**
 *
 * @author UAH
 */
public class Ejecucion {
    public static void main(String[] x){
        int id = 1;
        for(int i = 0; i < 1000; i++){
            Hilos p1 = new Hilos(id);
            p1.start();
            id++;
        }
    }
}
