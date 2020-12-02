import java.net.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;


public class ClienteSMTP {
    public static void main(String args[]) throws UnknownHostException, IOException {
        System.setProperty("line.separator", "\r\n");

        int port = 25;
        String server = "smtp.upv.es";

        try {
            Socket ss = new Socket(server, port);
            Scanner socketReader = new Scanner(ss.getInputStream());
            PrintWriter socketWriter = new PrintWriter(ss.getOutputStream(), false);

            System.out.println(socketReader.nextLine());
            socketWriter.println("HELO  upv.es");
            socketWriter.flush();
            System.out.println(socketReader.nextLine());

            ss.close();
            System.out.printf("Desconectado.");

           
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