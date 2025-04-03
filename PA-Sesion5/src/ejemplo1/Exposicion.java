package ejemplo1;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

public class Exposicion
{
    int aforo;
    ListaThreads colaEspera, dentro;
    Semaphore semaforo;
    Semaphore pausa;
    private boolean abierta = true;
    private boolean detenida = false;
    
    public Exposicion(int aforo, JTextField tfEsperan, JTextField tfDentro)
    {
        this.aforo=aforo;
        semaforo=new Semaphore(aforo,true);
        pausa = new Semaphore(0, true);
        colaEspera=new ListaThreads(tfEsperan);
        dentro=new ListaThreads(tfDentro);
    }
    
    public void entrar(Visitante v)
    {
        colaEspera.meter(v);
     while(!abierta){
         try {
             wait();
         } catch (InterruptedException ex) {}
     } 
        try {
            semaforo.acquire();
        } catch (InterruptedException e) {
            return;
        }
        colaEspera.sacar(v);
        dentro.meter(v);
     
    }

    public void salir(Visitante v)
    {
        dentro.sacar(v);
        semaforo.release();
    }
    
    public void mirar(Visitante v)
    {
        try {
            while (detenida) {
                synchronized (this) {
                    wait(); // Se detiene cuando el botón "Detener" es presionado
                }
            }
            Thread.sleep(2000 + (int) (3000 * Math.random()));
        } catch (InterruptedException e) {
        }
    }
    
    public void detener(){
        detenida = true;
    }
    
    public synchronized void reanudar(){
            detenida = false;
            notifyAll();
    }
    
    public void cerrar(){
        abierta = false;
    }
    public synchronized void abrir(){
            abierta = true; 
            pausa.notify();
    }
}
