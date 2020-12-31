import java.net.InetAddress;
import java.io.*;
import java.net.DatagramPacket;
import java.util.Date;
import java.net.DatagramSocket;

public class UDPDaytime {
    public static void main(String args[]) throws IOException {

        try {
            DatagramSocket socket = new DatagramSocket();
            String message = new String("You have received a message.\n");
            String clientData = "notNull";
            String nowString;
            Date now;

            DatagramPacket packageToSend = new DatagramPacket(message.getBytes(), message.getBytes().length,
                    InetAddress.getByName("localhost"), 7777);
            
            socket.send(packageToSend);
            socket.receive(packageToSend);
            DatagramPacket packageTime;

            while (!clientData.isEmpty()) {
                now = new Date();
                nowString = now.toString() + "\r\n";
                packageTime = new DatagramPacket(nowString.getBytes(), 
                nowString.getBytes().length, InetAddress.getByName("localhost"), 7777);

                socket.send(packageTime);
                //GET DATA FROM CLIENT
                clientData = new String(packageToSend.getData(), 0, packageToSend.getLength()); 
                socket.receive(packageToSend);
            }

            socket.close();
        } catch (IOException err) {
            System.out.println("Sin errores jeje");
        }
    }
}
