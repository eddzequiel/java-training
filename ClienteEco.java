import java.net.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class ClienteEco {
    public static void main(String args[]) throws UnknownHostException, IOException {

        int port = 7;
        String server = "zoltar.redes.upv.es";

        try {
            Socket ss = new Socket(server, port);
            Scanner socketReader = new Scanner(ss.getInputStream());
            PrintWriter socketWriter = new PrintWriter(ss.getOutputStream(), false);
            Scanner inputReader = new Scanner(System.in);

            while (true) {
                // System.out.println("Introduzca texto: ");
                String textToSend = inputReader.nextLine();
                socketWriter.println(textToSend);
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