import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.PrintWriter;

public class ServiceTCP extends Thread {
    Socket id;

    public ServiceTCP(Socket s) {
        id = s;
    }

    public void run() {
        try {
            PrintWriter salida = new PrintWriter(id.getOutputStream(), true);
            Scanner entrada = new Scanner(id.getInputStream());
            String textToSend;

            while (true) {
                textToSend = entrada.nextLine();

                if (!textToSend.equals("FIN")) {
                salida.println(textToSend);
            } else {
                salida.println("Presiona ENTER para salir.");
                id.close();
            }
            }
        } catch (Exception e) {
            System.out.println("Error en run(): " + e);
        }
    }

    public static void main(String args[]) throws UnknownHostException, IOException {
        int puerto = 8888;
        ServerSocket ss = new ServerSocket(puerto);
        while (true) {

            Socket s = ss.accept(); // se espera al cliente.
            ServiceTCP Cl = new ServiceTCP(s); // Y se arranca el hilo para atender al cliente en paralelo

            Cl.start();
        } // fin del while
    } // Fin del main
} // Fin del programa
