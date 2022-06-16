package IO.文件流;

import org.junit.jupiter.api.Test;

import java.io.*;

public class 字符流 {
    //将txt读取到程序，并打印
    @Test
    public void test1() {
        //1.文件类
        FileReader fr = null;
        try {
            File file = new File(("hello.txt"));
            //2.提供文件流
            fr = new FileReader(file);//字符流不能处理字节文件
            //3.读
            //方式一：
//        int data = fr.read();
//        while (data!=-1){
//            System.out.print((char) data);
//            data=fr.read();
//        }
            //方式二：
            int data;
            while ((data = fr.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //4.关闭
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //read()操作升级，1次读取多个字符
    @Test
    public void test2() throws IOException {
        FileReader fr = null;
        try {
            //1.file类实例化
            File file = new File("hello.txt");
            //2.流的实例化
            fr = new FileReader(file);

            //3.读操作
            char[] buf = new char[5];   //字节流byte[]
            int len;
            while ((len = fr.read(buf)) != -1) {//判断每次读入数组的字符个数，末尾返回-1
                for (int i = 0; i < len; i++) {//每次读了几个就输出几个
                    System.out.print(buf[i]);
                }
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

    //写数据:文件不存在时候自动创建，存在则可以选择在原文件上覆盖、追加
    @Test
    public void test3() {
        FileWriter fw = null;
        try {
            //1.提供目的文件
            File file = new File("hello.txt");
            //2.流对象
            fw = new FileWriter(file,true);
            //3.写
            fw.write("i have a dream\n");
            fw.write("weresr sdd");
            //4.关闭
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fw!=null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //读写一起：从一个文件读，然后写到另一个文件
    @Test
    public void testReaderAndWriter(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.file类实例化，包括读和写
            File srcfile = new File("hello.txt");
            File copyfile = new File("copy.txt");
            //2.读写流
            fr = new FileReader(srcfile);
            fw = new FileWriter(copyfile);

            //3.读写
            char[] buf=new char[5];
            int len;   //记录每次读入的字符数
            while ((len=fr.read(buf))!=-1){
                fw.write(buf,0,len);//读几个写几个
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //4.关闭,2个流没有先后顺序
            try {
                if(fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fw!=null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
