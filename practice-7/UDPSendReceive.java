import java.net.InetAddress;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPSendReceive {
    public static void main(String args[]) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String message = new String("You have received a message.\n");
        try {
            DatagramPacket packageToSend = new DatagramPacket(message.getBytes(), message.getBytes().length,
                    InetAddress.getByName("localhost"), 7777);
            socket.send(packageToSend);
            socket.receive(packageToSend);

            // GET DATA FROM CLIENT
            String clientData = new String(packageToSend.getData(), 0, packageToSend.getLength()); 

            System.out.print("\n" + "Client says: " + clientData);
            socket.close();
        } catch (IOException err) {
            System.out.println("Sin errores jeje");
        }
    }
}
