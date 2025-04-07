/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tenis;

/**
 *
 * @author UAH
 */
public class Main {
    public static void main(String args[]){
        Pista pista = new Pista();
        for (int i = 0; i < 12; i++){
            Tenista tenista = new Tenista(i, pista);
            tenista.start();
        }
    }
}
