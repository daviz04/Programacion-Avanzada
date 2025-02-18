package ejemplo3;
// Pintor es un hilo que hace que el botón cambie de color siguiendo la secuencia:
// se pinta de negro durante un tiempo aleatorio que varía entre un mínimo de 2 y un máximo de 4 segundos.
// A continuación obtiene un color al azar entre rojo, verde, azul y amarillo y pinta con ese color
// durante un tiempo aleatorio entre 3 y 5 segundos, y vuelve a empezar el ciclo.
import java.awt.Color;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JButton;

public class Pintor extends Thread
{    
    private JButton b;
    private Paleta p;
    private Color negro = Color.black;
    private final Lock lock = new ReentrantLock();
    
    public Pintor(JButton b, Paleta p)
    {
        this.b=b;
        this.p=p;
    }
    
    public void run()
    {
        long tiempoEnNegro = 0;
        long tiempoEnColor = 0;
        
        while (true)
        {
            lock.lock(); //Bloqueo del hilo para que no haya condiciones de carrera
            try{
            tiempoEnNegro = (long) 2000 + (int)((4000-2000)*Math.random());
            tiempoEnColor = (long) 3000 + (int)((5000-3000)*Math.random());
            
            b.setBackground(negro);  //Pinta el botón de negro
            try
            {
                sleep(tiempoEnNegro); // Espera entre 2 y 4 segundos
                //System.out.println("Tiempo en negro: "+tiempoEnNegro);
            } catch (InterruptedException e){}
            
            b.setBackground(p.tomaColor());   //Pinta el botón con el color aleatorio
            try
            {
                //Coge el color que esta siendo usado para liberarlo al finalizar su ejecución
                int i = p.getNumFila();
                sleep(tiempoEnColor); //Espera entre 3 y 5 segundo
                p.liberarColor(i);
                
            } catch (InterruptedException e){}
            }finally{
                lock.unlock();
            }
        }
    }
}