package 新特性.java9新特性;

import org.junit.jupiter.api.Test;

import java.io.*;

public class Inputstream的tranferTo {
    @Test
    public void test() {
        try (InputStream is = new FileInputStream("hello_gbk.txt");
             OutputStream os = new FileOutputStream("2hello_gbk.txt")) {
            is.transferTo(os); //把输入流中的数据自动复制到输出流中
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
