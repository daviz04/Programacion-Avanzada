/*
 * La clase Buzon tiene que estar protegida con un cerrojo
 * El método enviaMensaje debe esperar si el buzón está lleno
 * El método recibeMensaje debe esperar si el buzón está vacío.
 * Cuando un hilo completa su operación, desbloquea a los que estén esperando
 * para que puedan continuar intentando su acción.
 */
package ejemplo1;
 
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Buzon
{
    private String mensaje;
    private boolean hayMensaje=false;
    private Lock cerrojo = new ReentrantLock();
    private Condition parar = cerrojo.newCondition();

    public void enviaMensaje(String msg)
    {
        try{
        cerrojo.lock();
        while(hayMensaje){
                try{
                    parar.await();
                }catch(Exception e){}
                
        }
        hayMensaje = true;
        mensaje=msg;
        parar.signalAll();
        }catch(Exception e){   
         }finally{
            cerrojo.unlock();
         }
        
    }

    public String recibeMensaje()
    {
        try{
            cerrojo.lock();
            while(!hayMensaje){
                try{
                    parar.await();
                }catch(Exception e){}
            }
            hayMensaje=false;
            parar.signalAll();
            
        }catch(Exception e){
        }finally{
            cerrojo.unlock();
        }  
        return mensaje;
    }
}
