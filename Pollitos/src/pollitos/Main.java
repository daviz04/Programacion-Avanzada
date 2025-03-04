/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pollitos;

import static java.lang.Thread.sleep;
import pollitos.Estancia;

/**
 *
 * @author UAH
 */
 
public class Main {
        public static void main(String[] args) {
        // TODO code application logic here
        Estancia corral = new Estancia("Corral", 28);
        for(int i = 1; i <= 28; i++){
        Pollitos pollo = new Pollitos(i, corral);
        pollo.start();
        }      
    }
}
