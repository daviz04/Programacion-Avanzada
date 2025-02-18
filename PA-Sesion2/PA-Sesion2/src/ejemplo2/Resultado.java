// Un objeto de la clase Resultado es un BigInteger con un método sumar(int) 
package ejemplo2;
import java.math.BigInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resultado {
    
    private BigInteger suma = new BigInteger("0");
    private final Lock lock = new ReentrantLock();

    public BigInteger getSuma(){
        return suma;
    }

    public void sumar(int n){
        lock.lock();
        try {
            suma = suma.add(BigInteger.valueOf(n));
        } finally {
            lock.unlock();
        }
    }
}
