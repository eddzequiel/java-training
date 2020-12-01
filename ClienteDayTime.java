import java.net.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteDayTime
{
    public static void main(String args[]) throws UnknownHostException, IOException {

        int port = 13;
        String server = "zoltar.redes.upv.es" ;

        try{
            InetAddress address = InetAddress.getByName("www.upv.es");

            Socket s = new Socket(server, port);
            Scanner socketReader = new Scanner(s.getInputStream());

            System.out.printf("Conected!\n");
            
            //is there something to read from socket?
            while (socketReader.hasNext() == true) { 
                System.out.println(socketReader.nextLine()); 
            }

            System.out.println(address);

            s.close();
            System.out.printf("Disconected!\n");

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
/*
import java.net.*;
import java.net.InetAddress;
import java.io.*;
import java.util.Scanner;

public class ClienteDayTime
{
public static void main(String args[]) throws UnknownHostException, IOException {
int puerto = 13;
String servidor = "zoltar.redes.upv.es" ;
try{
Socket s = new Socket(servidor, puerto);

Scanner lee = new Scanner(s.getInputStream());
while(lee.hasNext()){
System.out.println(lee.nextLine());
}

s.close();

} catch (UnknownHostException e){
System.out.printf("Host desconocido.\n");
System.out.println(e);
} catch (ConnectException e){
System.out.println(" No se puede conectar.\n");
System.out.println(e);
} catch (IOException e) {
System.out.printf("Fallo al cerrar el socket");
System.out.println(e);
}
}
}*/
