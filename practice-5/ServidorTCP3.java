import java.net.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class ServidorTCP3 {
    public static void main(String args[]) throws UnknownHostException, IOException {

        int port = 8003;

        try {
            ServerSocket ss = new ServerSocket(port);
            while (!ss.isClosed()) {
                Socket s = ss.accept();
                System.out.println("Se  ha  conectado  un  cliente  al servidor");

                Scanner socketReader = new Scanner(s.getInputStream());
                PrintWriter socketWriter = new PrintWriter(s.getOutputStream(), true);

                socketWriter.println("HTTP/1.0 200 OK");
                socketWriter.println("Content-Type: text/plain");
                socketWriter.println();
                socketWriter.println(socketReader.nextLine());
                String test = socketReader.nextLine();

                while(!test.equals("")){
                    socketWriter.println(test);
                    test = socketReader.nextLine();
                }
                
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