import java.net.*;
import java.io.*;
//(direcciones IP y números de puerto locales y remotos).

public class DatosDeRed
{
    public static void main(String args[]) throws UnknownHostException, IOException {
        int puerto = Integer.parseInt(args[0]);
        String servidor = "www.upv.es" ;

        try{
            Socket s = new Socket(servidor, puerto);
            InetAddress inetAddress = s.getInetAddress();
            InetAddress localAddress = InetAddress.getByName("www.upv.es");
            int port = s.getPort();
            int localPort = s.getLocalPort();
            
            System.out.println("Conectado!");
            System.out.println("Servidor Inet: " + inetAddress);
            System.out.println("Servidor socket: " + localAddress);
            System.out.println("Puerto remoto:" + port);
            System.out.println("Puerto local:" + localPort);
            

            
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
