package IO.文件流;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class 字节流 {

    //字节流处理 字符文本文件，有非英文字符会出现乱码
    @Test
    public void test1(){
        FileInputStream fr = null;
        try {
            //1.file类实例化
            File file = new File("hello.txt");
            //2.流的实例化
            fr = new FileInputStream(file);

            //3.读操作
            byte[] buf = new byte[5];   //字节流byte[]
            int len;
            while ((len = fr.read(buf)) != -1) {//判断每次读入数组的字符个数，末尾返回-1
               String str= new String(buf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //4.关闭
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //处理非文本文件：图片复制
    @Test
    public void test2(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File src = new File("034.jpg");
            File des = new File("misaka.jpg");

            fis = new FileInputStream(src);
            fos = new FileOutputStream(des);

            byte[] buf =new byte[5];
            int len;
            while ((len=fis.read(buf))!=-1){
                fos.write(buf,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //指定路径下的文件复制:文本也可以，不在内存中读就行
    @Test
    public void copyFile(String src1,String des1){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File src = new File(src1);
            File des = new File(des1);

            fis = new FileInputStream(src);
            fos = new FileOutputStream(des);

            byte[] buf =new byte[10];
            int len;
            while ((len=fis.read(buf))!=-1){
                fos.write(buf,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void testCopyFile(){
        long starTime=System.currentTimeMillis();
        String src="034.jpg";
        String des="misaka.jpg";
        copyFile(src,des);
        long end=System.currentTimeMillis();
        System.out.println((end-starTime)+" ms");
    }
}
