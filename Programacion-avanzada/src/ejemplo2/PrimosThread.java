package ejemplo2;

// Clase PrimosThread sirve para calcular cuántos primos hay entre dos enteros

import java.util.Date;

public class PrimosThread extends Thread {  
    private int x,y;
    long n=0;
    
    public PrimosThread(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    private boolean esPrimo(int n){
        int raiz = (int) Math.sqrt((double) n);
        boolean primo = true;
        int i=2;
        while(primo && i<=raiz)
        {
            if (n % i == 0)
                primo=false;
            i++;
        }
        return primo;
    }
    
    @Override
    public void run(){
        long t0 = (new Date()).getTime();
        for (int i=x; i<=y; i++)
        {
            if(esPrimo(i))
            {
                n++;
            }
        }
        long t1 = (new Date()).getTime();
        n = t1-t0;
        System.out.println("El tiempo que ha tardado ha sido de " + n + "milisegundos");
    }
    
    public long cuantos(){
        return n;
    }
}