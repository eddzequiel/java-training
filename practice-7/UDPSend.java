import java.net.InetAddress;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPSend {
    public static void main(String args[]) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String message = new String("Eddy Moreno\n");
        try {
            DatagramPacket dp = new DatagramPacket(message.getBytes(), message.getBytes().length,
                    InetAddress.getByName("localhost"), 7777);
            socket.send(dp);
            socket.setSoTimeout(3000);
            socket.receive(dp);
            socket.close();
        } catch (IOException err) {
            System.out.println("Sin errores jeje");
        }
    }
}
