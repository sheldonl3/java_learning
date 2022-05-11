package 异常处理;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) {
        //TryCatchTest();

        //throws测试
        DoThorwsTest();

    }

    //TryCatch
    public static void TryCatchTest() {
        FileInputStream fis = null;
        try {
            File file = new File("hello.test");
            fis = new FileInputStream(file);
            int data = fis.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fis.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//一定会运行的代码
            try {
                if (fis != null)//如果流文件创建失败，不用关闭
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("退出");
    }

    //throws
    public static void ThorwsTest() throws FileNotFoundException, IOException {
        File file = new File("hello.test");
        FileInputStream fis = new FileInputStream(file);
        int data = fis.read();
        while (data != -1) {
            System.out.print((char) data);
            data = fis.read();
        }
        fis.close();
        System.out.println("推出");
    }

    public static void DoThorwsTest() {
        try {
            ThorwsTest();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("推出...");
        }
    }

}

