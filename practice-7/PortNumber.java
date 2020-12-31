import java.net.InetAddress;
import java.util.Scanner;
import java.io.*;
import java.net.DatagramSocket;

public class PortNumber {
    public static void main(String args[]) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        int p = ds.getLocalPort();

    System.out.println("\nPuerto del host: " + Integer.toString(p));
    }
}
