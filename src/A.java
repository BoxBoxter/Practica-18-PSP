import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        try {
            enviar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void enviar() throws IOException {
        InetAddress ip = InetAddress.getByName("127.0.0.1"); //Ip a la qual volem enviar
        DatagramSocket enviar = new DatagramSocket(); //Cream Objecte DatagramSocket
        System.out.println("Introdueixi el missatge que voleu enviar:");
        Scanner sc = new Scanner(System.in); // Escaner el cual permite personalizar el texto enviado al servidor
        String str = sc.nextLine();
        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000);
        //Se envien bytes aixi que transformam el misatge a un DatagramPacket que es el format que s'ha de enviar
        enviar.send(dp); //Enviam
        enviar.close(); //Tancam
        recibir(); //Pasam a ara noltros escoltar
    }

    private static void recibir() throws IOException {
        //Recibir
        DatagramSocket recibir = new DatagramSocket(3001); //Escolam al port en la direccio que estic
        byte[] buf = new byte[1024]; //Buffer de bytes per llegir
        DatagramPacket mensaje = new DatagramPacket(buf, 1024); // Establim con transformarem el misatge rebut
        recibir.receive(mensaje); // Esperam un misatge
        String str2 = new String(mensaje.getData(), 0, mensaje.getLength()); // Cream un string amb la informacio arribada
        System.out.println(str2);
        recibir.close(); //Tancam
    }
}
