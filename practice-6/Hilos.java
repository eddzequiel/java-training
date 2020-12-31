import java.net.Socket;
import java.util.Scanner;
import java.net.Socket;

class Hilos extends Thread {
    int id;
    public Hilos(int i) {
        id = i;
    }
    
    public void run() {
        //codigo del hilo, lo que se servira al cliente
        for (int i = 0; i < 100; i++) {
            System.out.print(id);
            try {sleep(1000);}
            catch (InterruptedException e) {}
        }
    }

    public static void main (String args []) {
        for (int i = 0; i < 3; i++) {
            Hilos h = new Hilos(i);
            h.start();
        }
    }
}
