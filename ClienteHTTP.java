import java.net.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class ClienteHTTP {
    public static void main(String args[]) throws UnknownHostException, IOException {

        int port = 80;
        String server = "www.upv.es";

        try {
            Socket ss = new Socket(server, port);
            Scanner socketReader = new Scanner(ss.getInputStream());
            PrintWriter socketWriter = new PrintWriter(ss.getOutputStream(), false);

            socketWriter.println("GET / HTTP/1.0\r\n\r\n");
           
            socketWriter.flush();
            while (socketReader.hasNext() == true) { 
                System.out.println(socketReader.nextLine()); 
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