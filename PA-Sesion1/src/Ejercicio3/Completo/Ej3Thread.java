/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3.Completo;

import java.util.Date;

/**
 *
 * @author UAH
 */
public class Ej3Thread {
    private int x, y, suma = 0, suma1 = 0, suma2 = 0;
    int ultimoDigito;
    long n1 = 0, n2 = 0, n3 = 0;

    public Ej3Thread(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void calcular(){
        calcularA();
        calcularB();
        calcularC();
    }

    public void calcularA() {
        long t0 = (new Date()).getTime();
        for (int i = x; i <= y; i++) {
            if (i % 7 == 0) {
                suma += i;
            }
        long t1 = (new Date()).getTime();
        n1 = t1-t0;    
        }
    }
    
    public void calcularB(){
        long t0 = (new Date()).getTime();
        for (int i = x; i <= y; i++) {
            ultimoDigito = Math.abs(i) % 10;
            if (ultimoDigito == 3 || ultimoDigito == 5) {
                //System.out.println(i);
                //System.out.println(ultimoDigito + "\n");
                suma1 += i;
            }
        }
        long t1 = (new Date()).getTime();
        n2 = t1-t0;
    }
    
    public void calcularC(){
         long t0 = (new Date()).getTime();
        for (int i = x; i <= y; i++) {
             if(esPrimo(i)){
                //System.out.println(i);
                suma2 += i;
            }      
        }
        long t1 = (new Date()).getTime();
        n3 = t1-t0;
    }
    
    
    private boolean esPrimo(int n){    
    if (n%2==0) return false;  
    for(int i=3;i*i<=n;i+=2) {
        if(n%i==0) return false;
    }
    return true;
    }

    public int suma() {
        return suma;
    }
    public int suma1() {
        return suma1;
    }
    public int suma2() {
        return suma2;
    }
    
    public long getN1(){
        return n1;
    }
    
    public long getN2(){
        return n2;
    }
    
    public long getN3(){
        return n3;
    }
}