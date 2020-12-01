import java.net.*;
import java.io.*;

public class ClienteTCP2
{
       public static void main(String args[]) throws UnknownHostException, IOException {
        int puerto = 81;
        String servidor = "www.uv.es" ;
        Socket s = new Socket(servidor, puerto);
        System.out.printf("Conectado!\n");
        s.close();
    }
}


