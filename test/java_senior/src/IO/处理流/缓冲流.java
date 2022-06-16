package IO.处理流;

import org.junit.jupiter.api.Test;

import java.io.*;

//提高读取速度
public class 缓冲流 {
    //缓冲字节流，非文本文件复制
    @Test
    public void test1() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.file类实例化
            File srcfile = new File("034.jpg");
            File desfile = new File("misaka.jpg");

            //2.造流
            //2.1 造文件流
            FileInputStream fis = new FileInputStream(srcfile);
            FileOutputStream fos = new FileOutputStream(desfile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制操作
            byte[] buffer = new byte[10];
            int len;
            while ((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //4.关闭 前关闭外层（缓冲流）,内层的会自动关闭，可以省略
            if(bis!=null)
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            if(bos!=null)
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
    //        fos.close();
    //        fis.close();
        }
    }

    //缓冲流文件复制函数 :有缓冲区，速度快
    @Test
    public void copyFile(String src,String des) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.file类实例化
            File srcfile = new File(src);
            File desfile = new File(des);

            //2.造流
            //2.1 造文件流
            FileInputStream fis = new FileInputStream(srcfile);
            FileOutputStream fos = new FileOutputStream(desfile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制操作
            byte[] buffer = new byte[10];
            int len;
            while ((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //4.关闭 前关闭外层（缓冲流）,内层的会自动关闭，可以省略
            if(bis!=null)
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            if(bos!=null)
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            //        fos.close();
            //        fis.close();
        }
    }

    @Test
    public void testCopy(){
        long starTime=System.currentTimeMillis();
        String src="034.jpg";
        String des="misaka.jpg";
        copyFile(src,des);
        long end=System.currentTimeMillis();
        System.out.println((end-starTime)+" ms");
    }

    //字符缓冲流
    @Test
    public void test3(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello1.txt")));
            //方法一：
//            char[] buf= new char[10];
//            int len;
//            while ((len=br.read(buf))!=-1){
//                bw.write(buf,0,len);
//            }
            //方法二：
            String data;
            while ((data=br.readLine())!=null){
                bw.write(data);//data没有换行
                bw.newLine();//进行换行
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
