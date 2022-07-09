package 网络;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP {
    //客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");//没有public构造器，不能new对象
            socket = new Socket(inet,8899);
            os = socket.getOutputStream();
            os.write("asd三大阿斯大赛的".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //服务器
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;//传输数据量不确定，所以使用ByteArrayOutputStream，存在一个大数组中，不会有乱马,不使用string
        try {
            //1.创建服务器serverSocket
            serverSocket = new ServerSocket(8899);
            //2.表示接受客户端socket
            socket = serverSocket.accept();
            //3.获取输入流
            is = socket.getInputStream();
            //4.获取数据
            baos = new ByteArrayOutputStream();
            byte[] buf = new byte[5];
            int len;
            while ((len=is.read(buf))!=-1){
                baos.write(buf,0,len);
            }
            System.out.println(baos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //5.关闭
            if(baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
