package IO.处理流;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class 随机读取流 {
    @Test
    public void test1(){
        RandomAccessFile raf1= null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("034.jpg"),"r");
            raf2 = new RandomAccessFile(new File("test.jpg"),"rw");

            byte[] buf = new byte[1024];
            int len;
            while (((len = raf1.read(buf)))!=-1){
                raf2.write(buf,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(raf1!=null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (raf2!=null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //文件指定位置插入
    @Test
    public void test2(){
        RandomAccessFile raf1= null;
        try {
            raf1 = new RandomAccessFile("hello.txt","rw");
            raf1.seek(3);
            //保存插入位置之后的字符到builder
            StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
            byte[] buf = new byte[20];
            int len;
            while ((len= raf1.read(buf))!=-1){
                builder.append(new String(buf,0,len));
            }
            //插入
            raf1.seek(3);
            raf1.write("add".getBytes());
            //还原插入位置之后的字符
            raf1.write(builder.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(raf1!=null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
