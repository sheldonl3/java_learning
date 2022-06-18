package 网络;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP {
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = new String("udp using");
        byte[] data = str.getBytes();
        InetAddress localHost = InetAddress.getLocalHost();
        DatagramPacket datagramPacket = new DatagramPacket(data, 0, data.length, localHost, 9090);

        socket.send(datagramPacket);

        socket.close();

    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buf = new byte[100];
        DatagramPacket datagramPacket = new DatagramPacket(buf, 0, buf.length);

        socket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        socket.close();
    }
}
