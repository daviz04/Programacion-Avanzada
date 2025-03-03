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
        Estancia bebedero = new Estancia("bebedero", 1);
        Pollitos pollo = new Pollitos(bebedero);
        //Aqui toca poner las demaás
          
       
        pollo.pasear();
        //Decidir a que sitio entra antes
        while(true){
         int tiempo = (int) Math.random()*2000;
         bebedero.entrar();
            try {
               sleep(tiempo);
               bebedero.salir(); 
            } catch (Exception e) {
            }
        }
    }
}
