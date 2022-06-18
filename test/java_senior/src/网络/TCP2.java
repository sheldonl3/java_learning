package 网络;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//客户端发送数据，服务器保存数据到文件中,并返回成功给客户端
public class TCP2 {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),8899);
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("034.jpg"));

            byte[] buf = new byte[1024];
            int len;
            while ((len=fis.read(buf))!=-1){
                os.write(buf,0,len);
            }
            socket.shutdownOutput();//发送完毕之后，告诉对方停止发送

            //接受反馈
            InputStream is = socket.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (((len=is.read(buf))!=-1)){
                baos.write(buf,0,len);
            }
            System.out.println(baos);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
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

    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket ss = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            serverSocket = new ServerSocket(8899);
            ss = serverSocket.accept();
            is = ss.getInputStream();
            fos = new FileOutputStream("misaka_new.jpg");

            byte[] buf= new byte[1024];
            int len;
            while ((len=is.read(buf))!=-1){
                fos.write(buf,0,len);
            }  //read是阻塞式的，对方socket.shutdownOutput()后才停止循环

            //反馈
            OutputStream os = ss.getOutputStream();
            os.write("收到".getBytes());


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fos!=null){
                try {
                    fos.close();
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
            if(ss!=null){
                try {
                    ss.close();
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
