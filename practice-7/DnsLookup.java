import java.net.InetAddress;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class DnsLookup {
    public static void main(String args[]) throws IOException {
        String host = "";

        if (args.length == 0) {
            Scanner entrada = new Scanner(System.in);
            System.out.println("Inserte el nombre de un host:");
            host = entrada.nextLine();
        } else {
            host = args[0];
        };


    InetAddress inetAddress = InetAddress.getByName(host);
    System.out.println("\nNombre del host: " + host +
                        "\nDireccion IP: " + inetAddress);
    }
}
