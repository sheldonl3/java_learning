package IO.处理流;

import org.junit.jupiter.api.Test;

import java.io.*;

public class 转换流 {
    /*
    inputStreamReader:字节输入流转化为字符输入流，
    outputStreamWriter：字符输出流转化为字节输出流
    属于字符流，提供字节和字符间的转换
     */

    //使用inputStreamReader
    @Test
    public void test(){
        InputStreamReader isr = null;//字符集的设置
        try {
            FileInputStream fis = new FileInputStream("hello.txt");
            //字节流转化为字符流
            isr = new InputStreamReader(fis,"UTF-8");

            char[] buf=new char[20];
            int len;
            while (((len=isr.read(buf)))!=-1){
                String str=new String(buf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(isr!=null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //综合使用inputStreamReader 和 outputStreamWriter：转化文本编码 utf->gbk
    @Test
    public void test2(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            File src = new File("hello.txt");
            File des = new File("hello_gbk.txt");

            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(des);

            isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");

            char[] buf = new char[20];
            int len;
            while ((len=isr.read(buf))!=-1){
                osw.write(buf,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(isr!=null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(osw!=null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
