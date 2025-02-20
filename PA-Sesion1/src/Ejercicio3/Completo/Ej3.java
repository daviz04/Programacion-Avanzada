/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3.Completo;

import ejemplo1.Primos;
import ejemplo2.PrimosThread;
import java.util.Date;

/**
 *
 * @author UAH
 */
public class Ej3 {
     public static void main(String[] x){
          long t0 = (new Date()).getTime(); //t0=instante de inicio de los cálculos
           Ej3Thread p1 = new Ej3Thread(1,2000);
           Ej3Thread p2 = new Ej3Thread(2001,4000);
           Ej3Thread p3 = new Ej3Thread(4001,6000);
           Ej3Thread p4 = new Ej3Thread(6001,8000);
           Ej3Thread p5 = new Ej3Thread(8001,10000);
           p1.calcular();
           p2.calcular();
           p3.calcular();
           p4.calcular();
           p5.calcular();
           int suma = p1.suma() + p2.suma() + p3.suma() + p4.suma() + p5.suma();
           long n1 = p1.getN1() + p2.getN1() + p3.getN1() + p4.getN1() + p5.getN1();
           
           int suma1 = p1.suma1() + p2.suma1() + p3.suma1() + p4.suma1() + p5.suma1();
           long n2 = p1.getN2() + p2.getN2() + p3.getN2() + p4.getN2() + p5.getN2();
           
           int suma2 = p1.suma2() + p2.suma2() + p3.suma2() + p4.suma2() + p5.suma2();
           long n3 = p1.getN3() + p2.getN3() + p3.getN3() + p4.getN3() + p5.getN3();
           
           long t1 = (new Date()).getTime(); //t1=instante de final de los cálculos
           System.out.println("Número de primos multiplos de 7 entre 1 y 10.000: " + suma + " calculado en "+ n1 +" miliseg."
           + "\n" + "Suma de los números terminados en 3 o en 5 entre el 1 y el 10000: "+ suma1 +" calculado en "+ n2 +" miliseg."
           + "\n" + "Número de primos menores que 10.000: "+ suma2 +" calculado en "+ n3 +" miliseg."
           + "\n" + "Y el tiempo total de computo ha sido de " + (t1-t0) + " miliseg.");
     }
}