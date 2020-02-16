import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        try {
            recibir();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void recibir() throws IOException {

        //Recibir
        DatagramSocket recibir = new DatagramSocket(3000);
        byte[] buf = new byte[1024];
        DatagramPacket mensaje = new DatagramPacket(buf, 1024);
        recibir.receive(mensaje);
        recibir.close();
        enviar();

    }

    private static void enviar() throws IOException {
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DatagramSocket enviar = new DatagramSocket();
        String str = "rebut";
        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3001);
        enviar.send(dp);
        enviar.close();
    }


}
