package ejemplo3;

// Pintor es un Thread que pinta un botón con colores al azar
import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
public class Pintor extends Thread {
    
    JButton b;
    Color paleta[] = new Color[5];
    
    public Pintor(JButton b){
        this.b=b;
        paleta[0]=Color.BLACK;
        paleta[1]=Color.RED;
        paleta[2]=Color.GREEN;
        paleta[3]=Color.BLUE;
        paleta[4]=Color.YELLOW;
        start();
    }
    
    public void run(){
          while (true){
            //int i = (int)(5. * Math.random());
            //Primer color
            int numeroAleatorio = ThreadLocalRandom.current().nextInt(2000, 4001); 
            b.setBackground(paleta[0]);
              try {
                  Thread.sleep(numeroAleatorio);
              } catch (InterruptedException ex) {
                  Logger.getLogger(Pintor.class.getName()).log(Level.SEVERE, null, ex);
              }
              
              //Segundo color
            numeroAleatorio = ThreadLocalRandom.current().nextInt(3000, 5001);
            int colores = ThreadLocalRandom.current().nextInt(1, 5);
            b.setBackground(paleta[colores]);
              try {
                  Thread.sleep(numeroAleatorio);
              } catch (InterruptedException ex) {
                  Logger.getLogger(Pintor.class.getName()).log(Level.SEVERE, null, ex);
              }
            
        }
    }
}