/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tenis;

/**
 *
 * @author UAH
 */
public class Tenista extends Thread{
    
    private int id;
    private boolean hombre;
    private Pista pista;
    
    Tenista(int id, Pista pista){
        this.pista = pista;
        this.id = id;
        if(esPar(id)){
            this.hombre = true;
        }else{
            this.hombre = false;
        }
    }
    
    public boolean esPar(int id){
        if (id%2 == 0){
            return true;
        }
        return false;
    }
    
    public boolean getSexo(){
        return this.hombre;
    }
    public int IdTenista(){
        return this.id;
    }
    
    public void run(){
        pista.entrar(this);
        pista.salir(this);
    }
}
