package ejemplo1;

// Clase Primos que sirve para calcular cuántos primos hay entre dos enteros

import java.util.Date;

public class Primos {
    
    private int x,y;
    private long n=0;
    
    public Primos(int x, int y){
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
    
    public void calcular(){
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
    }
    
    public long cuantos(){
        return n;
    }
}
