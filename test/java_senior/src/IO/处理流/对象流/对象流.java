package IO.处理流.对象流;

import org.junit.jupiter.api.Test;

import java.io.*;

/*
处理，存储对象和基本额数据类型的流
 */
public class 对象流 {
    //写入对象:序列化 ObjectOutputStream
    // 内存->硬盘、网络
    @Test
    public void test(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
            oos.writeObject(new String("为企鹅阿斯顿"));
            oos.flush();

            oos.writeObject(new Person("王牌",23));
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(oos!=null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //反序列化：ObjectInputStream
    // 硬盘、网络->内存
    @Test
    public void  test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.txt"));
            String str = (String) ois.readObject();
            System.out.println(str);

            Person p = (Person) ois.readObject();
            System.out.println(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if(ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
