package 网络;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class url {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        InputStream inputStream = null;
        HttpsURLConnection urlConnection = null;
        try {
            URL u = new URL("https://r3.hpoi.net.cn/gk/pic/n/2022/06/53762ab7bfc2449ba4c66a0e60ac1b30.jpg");
//            System.out.println(u.getProtocol());
//            System.out.println(u.getFile());
//            System.out.println(u.getHost());
//            System.out.println(u.getQuery());
//            System.out.println(u.getPath());
            urlConnection = (HttpsURLConnection) u.openConnection();
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();

            fos = new FileOutputStream("hpio.jpg");

            byte[] buf = new byte[100];
            int len;
            while ((len = inputStream.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (urlConnection != null) {
                try {
                    urlConnection.disconnect();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
