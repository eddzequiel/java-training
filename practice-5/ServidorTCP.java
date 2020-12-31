import java.net.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class ServidorTCP {
    public static void main(String args[]) throws UnknownHostException, IOException {

        int port = 7790;

        try {
            ServerSocket ss = new ServerSocket(port);
            while (!ss.isClosed()) {
                Socket s = ss.accept();
                System.out.println("Se  ha  conectado  un  cliente  al servidor");

                Scanner socketReader = new Scanner(s.getInputStream());
                PrintWriter socketWriter = new PrintWriter(s.getOutputStream(), true);
                
                socketWriter.println(socketReader.nextLine());
                socketWriter.println("Presiona ENTER para salir.");

                // String textToSend = inputReader.nextLine();
                // socketWriter.println(textToSend);
                // socketWriter.flush();
                // System.out.println(socketReader.nextLine());

                s.close();
            }

        } catch (UnknownHostException e) {
            System.out.printf("Host desconocido.\n");
            System.out.println(e);
        } catch (ConnectException e) {
            System.out.println("No se puede conectar.\n");
            System.out.println(e);
        } catch (IOException e) {
            System.out.printf("Fallo al cerrar el socket");
            System.out.println(e);
        }
    }
}