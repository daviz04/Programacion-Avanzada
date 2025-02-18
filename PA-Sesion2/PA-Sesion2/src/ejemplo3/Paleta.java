package ejemplo3;

import java.awt.Color;

public class Paleta
{
    private Color [] colores = new Color[4];
    private boolean [] coloresDisponibles = new boolean[4];
    private int numeroFila;
    
    public Paleta()
    {
        colores[0]=Color.red;
        colores[1]=Color.blue;
        colores[2]=Color.green;
        colores[3]=Color.yellow;  
        
        coloresDisponibles[0] = true;
        coloresDisponibles[1] = true;
        coloresDisponibles[2] = true;
        coloresDisponibles[3] = true;     
    }
    
    public boolean estaLibre(int i){  //Método para verificar si el color esta libre
    return coloresDisponibles[i];      
    }
    
    public void liberarColor(int i){ //Método que libera el color deseado
        coloresDisponibles[i] = true;
    }
    
    public int getNumFila(){ //Método para ver el número de fila que querramos liberar en el futuroi
        return this.numeroFila;
    }
    
    public Color tomaColor()
    {     
        int i = (int)(4 * Math.random());  //Elige color al azar
  
        while(!estaLibre(i)){ //Hasta que no este libre el color elegirá otro aleatoriamente
           i = (int)(4 * Math.random());
        }
        numeroFila = i; //Guardo el color que se ha podido utilizar
        coloresDisponibles[i] = false; //Y lo bloqueo
        return colores[i];
    }
}
