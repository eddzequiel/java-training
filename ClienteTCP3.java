import java.net.*;
import java.net.InetAddress;
import java.io.*;

public class ClienteTCP3
{
    public static void main(String args[]) throws UnknownHostException, IOException {
        int puerto = Integer.parseInt(args[0]);
        String servidor = "www.uv.es" ;

        try{
            InetAddress address = InetAddress.getByName("www.upv.es");

            Socket s = new Socket(servidor, puerto);
            
            System.out.printf("Conectado!\n");
            System.out.println(address);
            
            s.close();

        } catch (UnknownHostException e){
            System.out.printf("Host desconocido.\n");
            System.out.println(e);
        } catch (ConnectException e){
            System.out.println("No se puede conectar.\n");
            System.out.println(e);
        } catch (IOException e) {
            System.out.printf("Fallo al cerrar el socket");
            System.out.println(e);
        }
    }
}
