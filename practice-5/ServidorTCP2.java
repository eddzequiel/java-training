import java.net.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class ServidorTCP2 {
    public static void main(String args[]) throws UnknownHostException, IOException {

        int port = 7769;

        try {
            ServerSocket ss = new ServerSocket(port);
            while (!ss.isClosed()) {
                Socket s = ss.accept();
                System.out.println("Se  ha  conectado  un  cliente  al servidor");
                                
                System.out.println("Server socket address: " + ss.getLocalPort() + " Server socket port:" + ss.getInetAddress() );
                System.out.println("Socket address: " + s.getInetAddress() + " Server socket port:" + s.getPort());

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